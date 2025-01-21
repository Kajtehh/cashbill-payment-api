# CashBill Payments API Java Library

## Setup:
```java
final CashBillShop shop = new CashBillShop("shopId", "secretKey");

/* Optional CashBillShop setters */

shop.setTest(true);               // Enables the test mode (default is false)
shop.setClient(new OkHttpClient()); // Sets a custom OkHttpClient (default is new OkHttpClient())
```

## Examples:

## Create payment:
```java
try {
    final CashBillGeneratedPayment generatedPayment = shop.createPayment(
        new CashBillPayment("Title", new CashBillAmountData(100.0)) // ALL SETTERS ARE OPTIONAL
            // Create a new CashBillPayment object with a title and amount (All setters are optional)
            .setPaymentChannel("paysafecard")     // Set the payment channel to 'paysafecard'
            .setDescription("Lorem ipsum dolor sit amet consectetur adipisicing.") // Set the description of the payment
            .setAdditionalData("additional data") // Set additional data for the payment
            .setReturnUrl("https://kajteh.pl/success") // Set the return URL for successful payment
            .setNegativeReturnUrl("https://kajteh.pl/failed") // Set the return URL for failed payment
            .setLanguageCode("pl")                 // default is pl (Set the language code for the payment, default is 'pl')
            .setPersonalData(new CashBillPersonalData()) // Set the personal data associated with the payment. Refer to the provided link for available setters for CashBillPersonalData
            .setReferer("referer")
    );

    System.out.println(generatedPayment.getRedirectUrl()); // prints generated payment's redirect url
    System.out.println(generatedPayment.getId());          // prints generated payment's id
} catch (CashBillPaymentException e) {
    e.printStackTrace();
}
```
## Get transaction info:
```java
try {
    final CashBillPaymentDetails paymentDetails = shop.getTransactionInfo("orderId");
    
    System.out.println(paymentDetails.getStatus()); // prints status of that transaction
    
    // you can found other getters here https://github.com/Kajtehh/cashbill-payment-api/blob/master/src/main/java/pl/kajteh/api/data/CashBillPaymentDetails.java
} catch (CashBillPaymentException e) {
    e.printStackTrace();
}
```
