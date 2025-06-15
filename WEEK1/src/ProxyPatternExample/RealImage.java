package ProxyPatternExample;

public class RealImage implements Image{

    private String filename;
    RealImage(String filename) {
        this.filename = filename;
        loadFromTheServer();
    }

    public void loadFromTheServer() {
        System.out.println("Loading Image from the server : " + filename);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException  e) {
            System.out.println("error :" + e);
        }
    }
    @Override
    public void display() {
        System.out.println("Displaying Image : " + filename);
    }
}
