package AdapterPatternExample.Adapters;

import AdapterPatternExample.Adaptee.RazorpayGateway;
import AdapterPatternExample.PaymentProcessor;

public class RazorpayGatewayAdapter implements PaymentProcessor {
    private RazorpayGateway razorpay = new RazorpayGateway();

    @Override
    public void processPayment(double amount) {
        razorpay.makePayment(amount);
    }
}
