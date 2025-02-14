package pl.kajteh.payment.util;

import org.apache.commons.codec.digest.DigestUtils;
import pl.kajteh.payment.CashBillPayment;
import pl.kajteh.payment.data.CashBillPersonalData;

import java.util.Map;

public class CashBillPaymentUtil {

    public static String generatePaymentSignature(CashBillPayment payment, String secretKey) {
        final StringBuilder sb = new StringBuilder();

        appendNonNull(sb, payment.getTitle());
        appendNonNull(sb, payment.getAmount().getValue());
        appendNonNull(sb, payment.getAmount().getCurrencyCode());
        appendNonNull(sb, payment.getReturnUrl());
        appendNonNull(sb, payment.getDescription());
        appendNonNull(sb, payment.getNegativeReturnUrl());
        appendNonNull(sb, payment.getAdditionalData());
        appendNonNull(sb, payment.getPaymentChannel());
        appendNonNull(sb, payment.getLanguageCode());
        appendNonNull(sb, payment.getReferer());

        if (payment.getPersonalData() != null) {
            final CashBillPersonalData personalData = payment.getPersonalData();

            appendNonNull(sb, personalData.getFirstName());
            appendNonNull(sb, personalData.getSurname());
            appendNonNull(sb, personalData.getEmail());
            appendNonNull(sb, personalData.getCountry());
            appendNonNull(sb, personalData.getCity());
            appendNonNull(sb, personalData.getPostcode());
            appendNonNull(sb, personalData.getStreet());
            appendNonNull(sb, personalData.getHouse());
            appendNonNull(sb, personalData.getFlat());
            appendNonNull(sb, personalData.getIp());
        }

        if (payment.getOptions() != null) {
            final StringBuilder mapBuilder = new StringBuilder();

            for (Map.Entry<String, String> entry : payment.getOptions().entrySet()) {
                appendNonNull(mapBuilder, entry.getKey());
                appendNonNull(mapBuilder, entry.getValue());
            }
            appendNonNull(sb, mapBuilder.toString());
        }

        sb.append(secretKey);

        return DigestUtils.sha1Hex(sb.toString());
    }

    public static String generatePaymentNotificationSignature(String cmd, String args, String secretKey) {
        final String data = cmd + args + secretKey;

        return DigestUtils.md5Hex(data.getBytes()).toLowerCase();
    }

    public static String getPaymentUrl(String shopId, boolean test) {
        return "https://pay.cashbill.pl/:ws/rest/payment/:shopId"
                .replace(":shopId", shopId)
                .replace(":ws", test ? "testws" : "ws");
    }

    public static String getTransactionInfoUrl(String shopId, String secretKey, boolean test, String orderId) {
        return "https://pay.cashbill.pl/:ws/rest/payment/:shopId/:orderId?sign=:sign"
                .replace(":shopId", shopId)
                .replace(":orderId", orderId)
                .replace(":ws", test ? "testws" : "ws")
                .replace(":sign", DigestUtils.sha1Hex(orderId + secretKey));
    }

    private static <T> void appendNonNull(StringBuilder sb, T value) {
        if (value != null) {
            sb.append(value);
        }
    }
}
