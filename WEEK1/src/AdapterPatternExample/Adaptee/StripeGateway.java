package AdapterPatternExample.Adaptee;

public class StripeGateway {
    public void sendPayment(double amountInDollars) {
        System.out.println("Processing $" + amountInDollars + " through Stripe.");
    }
}
