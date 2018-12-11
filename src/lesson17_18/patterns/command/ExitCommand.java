package lesson17_18.patterns.command;

public class ExitCommand extends Command{

    public ExitCommand(TextProcessor processor) {
        super(processor);
    }

    @Override
    String name() {
        return "ExitCommand";
    }

    @Override
    boolean execute() {
        System.out.println("Реализация ExitCommand");
        System.exit(0);
        return true;
    }
}
