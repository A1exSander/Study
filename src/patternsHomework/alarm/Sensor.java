package patternsHomework.alarm;

import java.util.List;

import java.util.ArrayList;

public class Sensor {
    private List<Alarm> alarms = new ArrayList<>();

    public void addAlarm(Alarm alarm){
        alarms.add(alarm);
    }

    public void notifyAll(int temp) {
        for (Alarm alarm: alarms) {
            alarm.tempChanged(temp);
        }
    }

    public void changeTemp(int temp){
        System.out.println("Текущая температура: " + temp);
        notifyAll(temp);
    }
}
