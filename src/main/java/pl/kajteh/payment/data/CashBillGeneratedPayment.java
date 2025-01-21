package pl.kajteh.payment.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CashBillGeneratedPayment {
    private final String id;
    private final String redirectUrl;
}
