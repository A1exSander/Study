import java.util.concurrent.*;

public class Tst {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);



        Future<Integer> res = service.submit(new SomeClass());

        try {
            Integer integer = res.get(10, TimeUnit.MILLISECONDS);
            System.out.println("Integer " + integer);
        } catch (InterruptedException | TimeoutException | ExecutionException e) {
            res.cancel(true);
            e.printStackTrace();
        }

        service.shutdown();
        service.awaitTermination(2, TimeUnit.SECONDS);

    }

    public static class SomeClass implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return 123;
        }
    }
}
