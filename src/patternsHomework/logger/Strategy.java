package patternsHomework.logger;

public class Strategy {
    private ILogger logger;

    public Strategy(ILogger logger) {
        this.logger = logger;
    }

    public void write (String message){
        logger.write(message);
    }

}
