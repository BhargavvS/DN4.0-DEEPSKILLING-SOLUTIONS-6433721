package AdapterPatternExample.Adaptee;

public class RazorpayGateway {
    public void makePayment(double amount) {
        System.out.println("Processing ₹" + amount + " through Razorpay.");
    }
}
