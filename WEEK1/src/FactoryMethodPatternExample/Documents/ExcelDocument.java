package FactoryMethodPatternExample.Documents;

public class ExcelDocument  implements Document{
    @Override
    public void documentType() {
        System.out.println("I am Excel Document");
    }
}
