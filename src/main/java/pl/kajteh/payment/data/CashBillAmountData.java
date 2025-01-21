package pl.kajteh.payment.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CashBillAmountData {
    private final double value;
    private final String currencyCode;
}
