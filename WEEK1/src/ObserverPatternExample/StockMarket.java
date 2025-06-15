package ObserverPatternExample;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock{

    private static final List<Observer> observers = new ArrayList<>();
    private double stockPrice;

    public void register(Observer observer) {
        System.out.println("Registered successfully : " + observer );
        observers.add(observer);
    }


    public void deregister(Observer observer) {
        if(observers.contains(observer)) {
            System.out.println("DeRegistered successfully : " + observer);
            observers.remove(observer);
        } else {
            System.out.println(observer + "doesn't exist");
        }
    }

    @Override
    public void Notify() {
        for (Observer observer  : observers) {
            observer.update(stockPrice);
        }
    }

    public void setStockPrice(double newPrice) {
        System.out.println("\nStock price updated to: ₹" + newPrice);
        this.stockPrice = newPrice;
        Notify();
    }
}
