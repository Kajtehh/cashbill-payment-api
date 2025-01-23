package pl.kajteh.payment;

import pl.kajteh.payment.data.CashBillAmountData;
import pl.kajteh.payment.data.CashBillPersonalData;

import java.util.Map;

public class CashBillPayment {
    private final String title;
    private final CashBillAmountData amount;
    private String description;
    private String additionalData;
    private String returnUrl;
    private String negativeReturnUrl;
    private String paymentChannel;
    private String languageCode = "pl";
    private CashBillPersonalData personalData;
    private String referer;
    private Map<String, String> options;

    public CashBillPayment(String title, CashBillAmountData amount) {
        this.title = title;
        this.amount = amount;
    }

    public CashBillPayment(String title, double value) {
        this(title, new CashBillAmountData(value));
    }

    public CashBillPayment(String title, double value, String currencyCode) {
        this(title, new CashBillAmountData(value, currencyCode));
    }

    public String getReferer() {
        return this.referer;
    }

    public CashBillPayment setReferer(String referer) {
        this.referer = referer;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public CashBillAmountData getAmount() {
        return this.amount;
    }

    public String getDescription() {
        return this.description;
    }

    public CashBillPayment setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAdditionalData() {
        return this.additionalData;
    }

    public CashBillPayment setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
        return this;
    }

    public String getReturnUrl() {
        return this.returnUrl;
    }

    public CashBillPayment setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
        return this;
    }

    public String getNegativeReturnUrl() {
        return this.negativeReturnUrl;
    }

    public CashBillPayment setNegativeReturnUrl(String negativeReturnUrl) {
        this.negativeReturnUrl = negativeReturnUrl;
        return this;
    }

    public String getPaymentChannel() {
        return this.paymentChannel;
    }

    public CashBillPayment setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
        return this;
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public CashBillPayment setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
        return this;
    }

    public CashBillPersonalData getPersonalData() {
        return this.personalData;
    }

    public CashBillPayment setPersonalData(CashBillPersonalData personalData) {
        this.personalData = personalData;
        return this;
    }

    public Map<String, String> getOptions() {
        return this.options;
    }

    public CashBillPayment setOptions(Map<String, String> options) {
        this.options = options;
        return this;
    }
}
