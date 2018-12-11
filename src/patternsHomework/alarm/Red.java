package patternsHomework.alarm;

public class Red implements Alarm {
    private int prevTemp;
    @Override
    public void tempChanged(int temp) {
        if (temp>=600 && prevTemp<600) System.out.println("Red Alarm!");
        prevTemp = temp;
    }
}
