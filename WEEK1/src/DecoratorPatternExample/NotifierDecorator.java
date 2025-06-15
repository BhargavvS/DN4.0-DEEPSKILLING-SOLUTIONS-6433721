package DecoratorPatternExample;

public class NotifierDecorator implements Notifier{
    Notifier notifier;

    NotifierDecorator(Notifier notifier){
        this.notifier = notifier;
    }
    @Override
    public String send() {
        return notifier.send();
    }
}
