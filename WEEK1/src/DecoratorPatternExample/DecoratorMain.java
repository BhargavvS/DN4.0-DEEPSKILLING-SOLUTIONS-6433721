package DecoratorPatternExample;

public class DecoratorMain {
    public static void main(String[] args) {

        // Send Notification Through Email
        Notifier myNotifir = new EmailNotifier();
        System.out.println(myNotifir.send());

        // Now semding Notification through email and sms
        myNotifir = new SMSNotifierDecorator(myNotifir);
        System.out.println(myNotifir.send());

        // Now semding Notification through email , sms and  slack
        myNotifir = new SlackNotifierDecorator(myNotifir);
        System.out.println(myNotifir.send());

    }
}
