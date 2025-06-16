package StrategyPatternExample;

public class PaymentContext implements PaymentStrategy {
    PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }


    @Override
    public void pay() {
        paymentStrategy.pay();
    }
}
