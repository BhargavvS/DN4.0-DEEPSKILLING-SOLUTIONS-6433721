package FactoryMethodPatternExample;


import FactoryMethodPatternExample.Documents.Document;
import FactoryMethodPatternExample.Documents.DocumentFactory;

public class FactoryMain {
    public static void main(String[] args) {
        DocumentFactory docFac = new DocumentFactory();
       Document doc1=  docFac.createDocument("DF");
       doc1.documentType();

        Document doc2=  docFac.createDocument("PF");
        doc2.documentType();

        Document doc3=  docFac.createDocument(" ");
        doc3.documentType();
    }
}
