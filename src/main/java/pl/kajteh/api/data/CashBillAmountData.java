package pl.kajteh.api.data;

import lombok.Getter;

@Getter
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
}
