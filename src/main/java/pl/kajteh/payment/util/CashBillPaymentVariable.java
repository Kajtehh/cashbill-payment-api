package pl.kajteh.payment.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.MediaType;

public class CashBillPaymentVariable {

    public static final String TRANSACTION_STATUS_CHANGED_COMMAND = "transactionStatusChanged";

    public static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public static final MediaType MEDIA_TYPE = MediaType.get("application/json; charset=utf-8");
}
