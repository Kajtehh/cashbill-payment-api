package pl.kajteh.payment;

public class CashBillPaymentException extends Exception {

    public CashBillPaymentException(String message) {
        super(message);
    }

    public CashBillPaymentException(String message, Throwable cause) {
        super(message, cause);
    }
}
