package threadsHomework.top100;

//Используя блокирующие очереди сосчитать топ слов как из предыдущего задания. Вариантом решения может быть:
//main создает потоки Worker, которые ждут строки из очереди на методе take().
//Далее main читает с диска и добавляет строки в очереди, последними строками будут стоп-строки.
//
//Worker'ы при получении стоп-строки добавляют свою внутреннюю мапу в следующую очередь и завершают свою работу.
//
//main же ждет мапы со всех воркеров на второй очереди и результат собирает в результирующую мапу.
//
//В итоге, не должно быть нигде явной синхронизации и использованы две блокирующие очереди


import java.io.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {


        List<Thread> threads = new ArrayList<>();
        int workersCount = Runtime.getRuntime().availableProcessors();

        BlockingQueue<String> lines = new ArrayBlockingQueue<>(10, true);
        BlockingQueue<Map<String, Integer>> localMapsQueue = new ArrayBlockingQueue<>(workersCount, true);
        Map<String, Integer> finalMap = new HashMap<>();

       Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла");
       String path = scanner.nextLine();




        for(int i = 0;i < workersCount; i++) {
            threads.add(new Thread(new Worker(lines, localMapsQueue)));
        }

        for(Thread t : threads) {
            t.start();
        }


        try (BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(path)))){

            String line;
            while ((line = buff.readLine()) != null) {
                lines.put(line);
            }

            for (int i = 0; i < workersCount; i++) lines.put("STOP");

            for (Thread t : threads) t.join();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        for(Map<String, Integer> map : localMapsQueue) {
            for (Map.Entry entry : map.entrySet()) {
                finalMap.merge(entry.getKey().toString(), (Integer) entry.getValue(), (oldVal, newVal) -> oldVal + newVal);
            }
        }

        finalMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(100).forEach(System.out::println);

    }
}
