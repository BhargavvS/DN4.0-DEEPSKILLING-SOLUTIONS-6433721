package DecoratorPatternExample;

public class SlackNotifierDecorator extends NotifierDecorator{
    SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public String send() {
        return notifier.send() + ", Slack Notification";
    }
}
