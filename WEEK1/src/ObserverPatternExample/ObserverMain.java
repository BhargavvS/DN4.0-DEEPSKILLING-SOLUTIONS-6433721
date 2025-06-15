package ObserverPatternExample;

public class ObserverMain {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("Groww");
        Observer webApp = new WebApp("MoneyControl");

        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        stockMarket.setStockPrice(1025.50);
        stockMarket.setStockPrice(1033.75);

        // Remove an observer and update again
        stockMarket.deregister(webApp);
        stockMarket.setStockPrice(1010.00);
    }
}
