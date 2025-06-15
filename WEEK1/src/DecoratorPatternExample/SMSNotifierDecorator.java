package DecoratorPatternExample;

public class SMSNotifierDecorator extends NotifierDecorator {
    SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public String send() {
        return notifier.send() + ", SMS Notification";
    }
}
