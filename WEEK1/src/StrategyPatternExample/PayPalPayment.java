package StrategyPatternExample;

public class PayPalPayment implements PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("paying the money through Pay pal card");
        System.out.println("Payment is Successful through pay pal card");
    }
}
