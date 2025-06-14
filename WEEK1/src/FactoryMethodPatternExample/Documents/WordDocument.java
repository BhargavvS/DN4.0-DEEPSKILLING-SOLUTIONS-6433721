package FactoryMethodPatternExample.Documents;

public class WordDocument implements Document{
    @Override
    public void documentType() {
        System.out.println("I am a Word Document");
    }
}
