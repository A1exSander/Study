package lesson17_18.patterns.command;

import java.util.Stack;

public class CommandHistory {
    private Stack<Command> history = new Stack<>();
    // Хранилище истории команд
    public void addCommand(Command command){
        history.push(command);
    }

    public Command deleteCommand (){
        return history.pop();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }
}
