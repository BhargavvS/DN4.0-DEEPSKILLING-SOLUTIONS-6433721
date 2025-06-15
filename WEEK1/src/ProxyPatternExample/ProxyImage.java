package ProxyPatternExample;

import java.util.HashMap;
import java.util.Map;

public class ProxyImage implements Image{
   private static Map<String , RealImage> ImageCache = new HashMap<>();
    private String filename;

    ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        RealImage realImage = ImageCache.get(filename);
        if(realImage == null) {
            System.out.println("Image is not Cached .Loading Lazyly ... ");
            realImage = new RealImage(filename);
            realImage.display();
            ImageCache.put(filename,realImage);
        } else  {
            System.out.println("Displaying Image loaded from the cache : " + filename);
        }
    }
}
