package pl.kajteh.payment.data;

public class CashBillAmountData {
    private final double value;
    private final String currencyCode;

    public CashBillAmountData(double value, String currencyCode) {
        this.value = value;
        this.currencyCode = currencyCode;
    }

    public CashBillAmountData(double value) {
        this.value = value;
        this.currencyCode = "PLN";
    }

    public double getValue() {
        return this.value;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }
}
