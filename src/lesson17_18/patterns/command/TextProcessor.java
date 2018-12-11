package lesson17_18.patterns.command;

//Добавить команды Repeat and Cancel

import java.util.Scanner;

public class TextProcessor {

    private CommandHistory history = new CommandHistory();
//    private
    private void executeCommand(Command command){
        if (command.execute()) {
            history.addCommand(command);
        }
    }

    public void start() {
        //Место под мега-свич и цикл считывания

        Scanner in = new Scanner(System.in);
        while (true) {
//            if (in.nextLine().equals("process")) {
//                executeCommand(new ProcessCommand(this));
//            }
            switch (in.nextLine()){
                case "process":
                    executeCommand(new ProcessCommand(this));
                    break;
                case "exit":
                    executeCommand(new ExitCommand(this));
                    break;

            }
        }
    }

}
