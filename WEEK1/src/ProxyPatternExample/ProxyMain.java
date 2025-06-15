package ProxyPatternExample;

public class ProxyMain {
    public static void main(String[] args) {
        Image proxyImage1 = new ProxyImage("Image1.jpg");
        Image proxyImage2 = new ProxyImage("Image2.jpg");
        Image proxyImage3 = new ProxyImage("Image1.jpg");

        proxyImage1.display();
        System.out.println();

        proxyImage2.display();
        System.out.println();

        proxyImage3.display();
    }
}
