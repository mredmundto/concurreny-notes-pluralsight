import java.util.concurrent.*;

public class main2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException{

//        // Using Runnable and Executor service
//        Runnable task = () -> System.out.println("I am in thread" + Thread.currentThread().getName());
//
//        new Thread(task).start();
//
////        ExecutorService service = Executors.newSingleThreadExecutor();
//        ExecutorService service = Executors.newFixedThreadPool(4);
//
//        for (int i = 0; i < 10; i++){
////            new Thread(task).start();
//            service.execute(task);
//        }
//
//        service.shutdown();

        // Using Callable and Future

        Callable<String> task = () -> {
            Thread.sleep(300);
            return "I am in thread" + Thread.currentThread().getName();
        };

        ExecutorService executor = Executors.newFixedThreadPool(4);

        try {
            for (int i = 0; i < 10; i ++){
                Future<String> future = executor.submit(task);
                System.out.println("I get:" + future.get(1000, TimeUnit.MILLISECONDS));
            }
        }finally{
            executor.shutdown();
        }



    }
}
