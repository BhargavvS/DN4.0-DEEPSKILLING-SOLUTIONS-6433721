package StrategyPatternExample;

public class CreditCardPayment implements PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("paying the money through Credit card");
        System.out.println("Payment is Successful through Credit card");
    }
}
