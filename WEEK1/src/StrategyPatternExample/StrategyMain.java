package StrategyPatternExample;

public class StrategyMain {
    public static void main(String[] args) {

        PaymentContext paymentContext = new PaymentContext();
        paymentContext.setPaymentStrategy(new CreditCardPayment());
        paymentContext.pay();

        System.out.println();

        paymentContext.setPaymentStrategy(new PayPalPayment());
        paymentContext.pay();

    }
}
