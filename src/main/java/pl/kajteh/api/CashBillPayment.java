package pl.kajteh.api;

import lombok.Getter;
import lombok.NonNull;
import pl.kajteh.api.data.CashBillAmountData;
import pl.kajteh.api.data.CashBillPersonalData;

import java.util.Map;

@Getter
public class CashBillPayment {
    @NonNull private final String title;
    @NonNull private final CashBillAmountData amount;
    private String description;
    private String additionalData;
    private String returnUrl;
    private String negativeReturnUrl;
    private String paymentChannel;
    private String languageCode = "pl";
    private CashBillPersonalData personalData;
    private String referer;
    private Map<String, String> options;

    public CashBillPayment(@NonNull String title, @NonNull CashBillAmountData amount) {
        this.title = title;
        this.amount = amount;
    }

    public CashBillPayment setDescription(@NonNull String description) {
        this.description = description;
        return this;
    }

    public CashBillPayment setAdditionalData(@NonNull String additionalData) {
        this.additionalData = additionalData;
        return this;
    }

    public CashBillPayment setReturnUrl(@NonNull String returnUrl) {
        this.returnUrl = returnUrl;
        return this;
    }

    public CashBillPayment setNegativeReturnUrl(@NonNull String negativeReturnUrl) {
        this.negativeReturnUrl = negativeReturnUrl;
        return this;
    }

    public CashBillPayment setPaymentChannel(@NonNull String paymentChannel) {
        this.paymentChannel = paymentChannel;
        return this;
    }

    public CashBillPayment setLanguageCode(@NonNull String languageCode) {
        this.languageCode = languageCode;
        return this;
    }

    public CashBillPayment setPersonalData(@NonNull CashBillPersonalData personalData) {
        this.personalData = personalData;
        return this;
    }

    public CashBillPayment setReferer(@NonNull String referer) {
        this.referer = referer;
        return this;
    }

    public CashBillPayment setOptions(@NonNull Map<String, String> options) {
        this.options = options;
        return this;
    }
}
