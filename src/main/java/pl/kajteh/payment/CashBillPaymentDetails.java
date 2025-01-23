package pl.kajteh.payment;

import pl.kajteh.payment.data.CashBillAmountData;
import pl.kajteh.payment.data.CashBillPersonalData;

public class CashBillPaymentDetails {
    private String id;
    private String paymentChannel;
    private CashBillAmountData amount;
    private CashBillAmountData requestedAmount;
    private String title;
    private String description;
    private CashBillPersonalData personalData;
    private String additionalData;
    private String status;

    public String getDescription() {
        return this.description;
    }

    public String getId() {
        return this.id;
    }

    public String getPaymentChannel() {
        return this.paymentChannel;
    }

    public CashBillAmountData getAmount() {
        return this.amount;
    }

    public CashBillAmountData getRequestedAmount() {
        return this.requestedAmount;
    }

    public String getTitle() {
        return this.title;
    }

    public CashBillPersonalData getPersonalData() {
        return this.personalData;
    }

    public String getAdditionalData() {
        return this.additionalData;
    }

    public String getStatus() {
        return this.status;
    }

    public CashBillPaymentDetails setDescription(String description) {
        this.description = description;
        return this;
    }

    public CashBillPaymentDetails setId(String id) {
        this.id = id;
        return this;
    }

    public CashBillPaymentDetails setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
        return this;
    }

    public CashBillPaymentDetails setAmount(CashBillAmountData amount) {
        this.amount = amount;
        return this;
    }

    public CashBillPaymentDetails setRequestedAmount(CashBillAmountData requestedAmount) {
        this.requestedAmount = requestedAmount;
        return this;
    }

    public CashBillPaymentDetails setTitle(String title) {
        this.title = title;
        return this;
    }

    public CashBillPaymentDetails setPersonalData(CashBillPersonalData personalData) {
        this.personalData = personalData;
        return this;
    }

    public CashBillPaymentDetails setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
        return this;
    }

    public CashBillPaymentDetails setStatus(String status) {
        this.status = status;
        return this;
    }
}
