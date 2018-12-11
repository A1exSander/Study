package lesson17_18.patterns.command;

abstract public class Command {
    protected TextProcessor processor;
    public Command(TextProcessor processor) {
        this.processor = processor;
    }

    abstract String name();

    abstract boolean execute();


}
