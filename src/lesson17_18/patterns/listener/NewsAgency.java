package lesson17_18.patterns.listener;


import java.util.List;
import java.util.ArrayList;

public class NewsAgency {
    private List<Listener> listeners = new ArrayList<>();

    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();

        newsAgency.addListener(new Listener() {
            @Override
            public void publish(String str) {
                System.out.println("listener 1: " + str);
            }
        });

        newsAgency.addListener(new Listener() {
            @Override
            public void publish(String str) {
                System.out.println("listener 2: " + str);
            }
        });

        newsAgency.newMessage("some changes");
    }

    public void addListener (Listener listener) {
        listeners.add(listener);
    }

    public void deleteListener(Listener listener){
        listeners.remove(listener);
    }

    public void newMessage(String mess) {
        System.out.println("Message " + mess);
        notifyListeners(mess);
    }

    private void notifyListeners(String mess) {
        for (Listener listener: listeners) {
            listener.publish(mess);
        }
    }
}
