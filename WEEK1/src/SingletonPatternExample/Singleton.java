package SingletonPatternExample;

public class Singleton {
    public static void main(String[] args) {
        Logger logger1 = Logger.getLoggerInstance();
        logger1.logMessage("First log");

        Logger logger2 = Logger.getLoggerInstance();
        logger2.logMessage("Second log");

        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same (singleton verified).");
        } else {
            System.out.println("Logger instances are different (singleton failed).");
        }
    }
}

class Logger{
    private static Logger log = new Logger();

     private Logger() {
         System.out.println("Logger Instance is created");
     }

     public static Logger getLoggerInstance() {
        return log;
     }

     public void logMessage(String message) {
         System.out.println("Log Message : " + message);
     }
}
