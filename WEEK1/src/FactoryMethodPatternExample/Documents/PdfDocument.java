package FactoryMethodPatternExample.Documents;

public class PdfDocument implements Document{
    @Override
    public void documentType() {
        System.out.println("I am Pdf Document");
    }
}
