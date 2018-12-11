package patternsHomework.alarm;

public class Yellow implements Alarm {
    private int prevTemp;
    @Override
    public void tempChanged(int temp) {
        if (temp>=300 && prevTemp<300) System.out.println("Yellow Alarm!");
        prevTemp = temp;
    }
}
