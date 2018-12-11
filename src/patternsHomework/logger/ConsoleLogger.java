package patternsHomework.logger;

public class ConsoleLogger implements ILogger{
    private String message;

    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
