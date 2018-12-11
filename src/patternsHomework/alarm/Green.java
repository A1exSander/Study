package patternsHomework.alarm;

public class Green implements Alarm{
    private int prevTemp;
    @Override
    public void tempChanged(int temp) {
        if (temp>=100 && prevTemp<100) System.out.println("Green Alarm!");
        prevTemp = temp;
    }
}
