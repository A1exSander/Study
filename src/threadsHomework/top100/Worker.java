package threadsHomework.top100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable {

    BlockingQueue<String> queue;
    BlockingQueue<Map<String, Integer>> localMapsQueue;
    private Map<String, Integer> localMap = new HashMap<>();
    private HashSet<String> words = new HashSet<>();


    public Worker(BlockingQueue queue, BlockingQueue localMapsQueue) {
        this.queue = queue;
        this.localMapsQueue = localMapsQueue;
    }

    @Override
    public void run() {

        String line = null;

        try {

            while (!(line = queue.take()).equals("STOP")){
                String[] splitLine = line.toLowerCase().replaceAll("\\pP", " ").trim().split("\\s");

                for(String s : splitLine) {
                    if(s.equals(""))
                        continue;
                    localMap.merge(s, 1, (oldVal, newVal)-> oldVal + newVal);
                }

            }


            localMapsQueue.put(localMap);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
