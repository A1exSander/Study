package lesson17_18.patterns.command;

public class CancelCommand extends Command {

    public CancelCommand(TextProcessor processor) {
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
