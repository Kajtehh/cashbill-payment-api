package pl.kajteh.payment.data;

public class CashBillGeneratedPayment {
    private final String id;
    private final String redirectUrl;

    public CashBillGeneratedPayment(String id, String redirectUrl) {
        this.id = id;
        this.redirectUrl = redirectUrl;
    }

    public String getId() {
        return this.id;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }
}
