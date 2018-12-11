package lesson17_18.patterns.command;

public class ProcessCommand extends Command {

    public ProcessCommand(TextProcessor processor) {
        super(processor);
    }

    @Override
    String name() {
        return "ProcessCommand";
    }

    @Override
    boolean execute() {
        System.out.println("Реализация ProcessCommand");
        return true;
    }
}
