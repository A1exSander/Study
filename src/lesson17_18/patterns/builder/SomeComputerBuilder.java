package lesson17_18.patterns.builder;

public class SomeComputerBuilder extends ComputerBuilder {

    @Override
    public void buildDisplay() {
        computer.setDisplay("LG TX1086");
    }

    @Override
    public void buildSystemBlock() {
        computer.setSystemBlock("ATX Razer RZ108");

    }

    @Override
    public void buildManipulators() {
        computer.setManipulators("Giraffes and Elephants");

    }
}
