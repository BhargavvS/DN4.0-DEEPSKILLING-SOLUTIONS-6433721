package FactoryMethodPatternExample.Documents;

public class DocumentFactory {
    public Document  createDocument(String str) {
        if(str.equals("DF")) {
            return new WordDocument();
        } else if(str.equals("PF")) {
            return new PdfDocument();
        }

        return new ExcelDocument();
    }
}
