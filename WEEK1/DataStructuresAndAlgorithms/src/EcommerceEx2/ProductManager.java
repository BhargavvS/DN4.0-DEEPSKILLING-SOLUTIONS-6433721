package EcommerceEx2;

import java.util.*;

public class ProductManager {
    public static Product linearSearch(List<Product> products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search in sorted ArrayList (by productName)
    public static Product binarySearch(List<Product> products, String targetName) {
        int left = 0, right = products.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comp = products.get(mid).productName.compareToIgnoreCase(targetName);

            if (comp == 0) return products.get(mid);
            else if (comp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();

        // Adding products to the ArrayList
        productList.add(new Product(1, "Laptop", "Electronics"));
        productList.add(new Product(2, "Shoes", "Fashion"));
        productList.add(new Product(3, "Smartphone", "Electronics"));
        productList.add(new Product(4, "Book", "Education"));

        productList.sort(Comparator.comparing(p -> p.productName.toLowerCase()));

        Product foundLinear = linearSearch(productList, "SmartPhone");
        Product foundBinary = binarySearch(productList, "Smartphone");

        System.out.println("Linear: " + (foundLinear != null ? foundLinear.productName + " found" : "Not Found"));
        System.out.println("Binary: " + (foundBinary != null ? foundBinary.productName + " found " :  "Not Found"));
    }
}
