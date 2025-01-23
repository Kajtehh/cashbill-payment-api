# CashBill Payments API Java Library

## Installation

### Maven
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

```xml
<dependency>
    <groupId>com.github.Kajtehh</groupId>
    <artifactId>cashbill-payments</artifactId>
    <version>1.0.1-SNAPSHOT</version>
</dependency>
```

### Gradle

```gradle
maven { url 'https://jitpack.io' }
```

```gradle
implementation 'com.github.Kajtehh:cashbill-payments:1.0.1-SNAPSHOT'
```

## How to use it

### Define a Payment Processor

```java
final CashBillPaymentProcessor paymentProcessor = new CashBillPaymentProcessor(
        "shopId", // Shop ID
        "secretKey", // Secret key
        true // test mode default false
);
```

### Create a payment
```java
final CashBillPayment payment = new CashBillPayment(
        "Test Payment", // Title
        999.9 // Amount to pay
);

payment.setDescription("description");
payment.setPaymentChannel("payment channel");
// more optional setters https://github.com/Kajtehh/cashbill-payments/blob/master/src/main/java/pl/kajteh/payment/CashBillPayment.java#L11

try {
    final CashBillGeneratedPayment generatedPayment = paymentProcessor.createPayment(payment);

    System.out.println(generatedPayment.getId()); // prints generated payment id
    System.out.println(generatedPayment.getRedirectUrl()); // prints generated payment url
} catch (CashBillPaymentException e) {
    e.printStackTrace();
}
```

**Example Output**
```
TEST_authbd3h
https://paytest.cashbill.pl/pl/payment/eyJpZCI6IlRFU1RfYXV0aGJkM2giLCJwYyI6IiIsInRva2VuIjoiMjIyZDhkNDU3YWZiY2RhNWM1ZjNhMDY2MDI1NGIyZjVkZjc2ZmY0MyJ9
```

### Get the Payment Details
```java
try {
    final CashBillPaymentDetails paymentDetails = paymentProcessor.getPaymentDetails("TEST_authbd3h");

    System.out.println(paymentDetails.getTitle());
    System.out.println(paymentDetails.getStatus());
} catch (CashBillPaymentException e) {
    e.printStackTrace();
}
```

**Example Output**
```
Test Payment
PositiveFinish
```

### Handle Payment Change
```java
try {
    final CashBillPaymentDetails paymentDetails = this.paymentProcessor.processPaymentStatusChange(cmd, sign, args);

    System.out.println(paymentDetails.getTitle());
    System.out.println(paymentDetails.getStatus());
} catch (CashBillPaymentException e) {
    e.printStackTrace();
}
```

More info here: https://api.cashbill.pl/category/api/payment-gateway


## Example Project

### https://github.com/Kajtehh/itemshop-backend
