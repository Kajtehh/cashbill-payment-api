package pl.kajteh.payment;

import com.google.gson.JsonObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import pl.kajteh.payment.data.CashBillGeneratedPayment;
import pl.kajteh.payment.util.CashBillPaymentUtil;

import java.io.IOException;
import java.util.Objects;

import static pl.kajteh.payment.util.CashBillPaymentVariable.*;

public class CashBillPaymentProcessor {
    private final String shopId;
    private final String secretKey;
    private final OkHttpClient client;
    private boolean test;

    public CashBillPaymentProcessor(String shopId, String secretKey, boolean test, OkHttpClient client) {
        this.shopId = shopId;
        this.secretKey = secretKey;
        this.test = test;
        this.client = client;
    }

    public CashBillPaymentProcessor(String shopId, String secretKey, boolean test) {
        this(shopId, secretKey, test, new OkHttpClient());
    }

    public CashBillPaymentProcessor(String shopId, String secretKey) {
        this(shopId, secretKey, false);
    }

    /**
     * Creates a payment based on the provided payment details.
     *
     * @param payment The CashBillPayment object containing payment details.
     * @return A CashBillGeneratedPayment object representing the generated payment.
     * @throws CashBillPaymentException if there's an issue with payment creation.
     */
    public CashBillGeneratedPayment createPayment(CashBillPayment payment) throws CashBillPaymentException {
        try {
            final JsonObject jsonObject = GSON.toJsonTree(payment).getAsJsonObject();

            jsonObject.addProperty("sign", CashBillPaymentUtil.generatePaymentSignature(payment, this.secretKey));

            final String json = GSON.toJson(jsonObject);

            final RequestBody requestBody = RequestBody.create(json, MEDIA_TYPE);
            final Request request = new Request.Builder()
                    .url(CashBillPaymentUtil.getPaymentUrl(this.shopId, this.test))
                    .post(requestBody)
                    .build();

            final Response response = this.client.newCall(request).execute();

            final String body = Objects.requireNonNull(response.body()).string();

            if(!response.isSuccessful()) {
                throw new CashBillPaymentException("Payment creation failed with code: " + response.code() + " and body: " + body);
            }

            return GSON.fromJson(body, CashBillGeneratedPayment.class);
        } catch (IOException e) {
            throw new CashBillPaymentException("Payment creation failed", e);
        }
    }

    /**
     * Retrieves transaction information for the provided orderId.
     *
     * @param orderId The orderId for which transaction information is to be retrieved.
     * @return A CashBillPaymentDetails object containing transaction information.
     * @throws CashBillPaymentException if there's an issue retrieving transaction information.
     */
    public CashBillPaymentDetails getPaymentDetails(String orderId) throws CashBillPaymentException {
        try {
            final Request request = new Request.Builder()
                    .url(CashBillPaymentUtil.getTransactionInfoUrl(this.shopId, this.secretKey, this.test, orderId))
                    .get()
                    .build();

            final Response response = this.client.newCall(request).execute();
            final String body = Objects.requireNonNull(response.body()).string();

            if(!response.isSuccessful()) {
                throw new CashBillPaymentException("Transaction info failed with code: " + response.code() + " and body: " + body);
            }

            return GSON.fromJson(body, CashBillPaymentDetails.class);
        } catch (IOException e) {
            throw new CashBillPaymentException("Failed to retrieve transaction info", e);
        }
    }

    /**
     * Retrieves payment details based on a status change notification.
     *
     * @param cmd  The command of the notification.
     * @param sign The signature for validation.
     * @param args The arguments from the notification.
     * @return CashBillPaymentDetails object for the relevant order.
     * @throws CashBillPaymentException if the signature is invalid or arguments are missing.
     */
    public CashBillPaymentDetails processPaymentStatusChange(String cmd, String sign, String args) throws CashBillPaymentException {
        final String correctSignature = CashBillPaymentUtil.generatePaymentNotificationSignature(cmd, args, this.secretKey);

        if(!cmd.equals(TRANSACTION_STATUS_CHANGED_COMMAND) || !sign.equals(correctSignature))
            throw new CashBillPaymentException("Invalid signature or command");

        if (args == null || args.isEmpty()) {
            throw new CashBillPaymentException("Arguments are missing");
        }

        final String orderId = args.split(",")[0];

        return this.getPaymentDetails(orderId);
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public boolean isTest() {
        return this.test;
    }
}
