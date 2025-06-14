package AdapterPatternExample.Adapters;

import AdapterPatternExample.Adaptee.StripeGateway;
import AdapterPatternExample.PaymentProcessor;

public class StripeGatewayAdapter implements PaymentProcessor {
    StripeGateway stripe = new StripeGateway();
    @Override
    public void processPayment(double amount) {
        double amountInDollars = amount / 83;
        stripe.sendPayment(amountInDollars);
    }
}
