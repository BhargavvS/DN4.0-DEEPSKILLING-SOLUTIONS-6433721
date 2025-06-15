package DecoratorPatternExample;

public class EmailNotifier implements Notifier{
    @Override
    public String send() {
        return "Hey this is a Email Notification";
    }
}
