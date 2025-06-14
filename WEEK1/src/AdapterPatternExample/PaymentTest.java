package AdapterPatternExample;

import AdapterPatternExample.Adapters.RazorpayGatewayAdapter;
import AdapterPatternExample.Adapters.StripeGatewayAdapter;

public class PaymentTest {
    public static void main(String[] args) {

        RazorpayGatewayAdapter razorpayGatewayAdapter = new RazorpayGatewayAdapter();
        razorpayGatewayAdapter.processPayment(1000.00);

        StripeGatewayAdapter stripeGatewayAdapter = new StripeGatewayAdapter();
        stripeGatewayAdapter.processPayment(1000.00);
    }
}
