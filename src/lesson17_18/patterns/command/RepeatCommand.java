package lesson17_18.patterns.command;

public class RepeatCommand extends Command {

    public RepeatCommand(TextProcessor processor) {
        super(processor);
    }

    @Override
    String name() {
        return null;
    }

    @Override
    boolean execute() {
        return false;
    }
}
