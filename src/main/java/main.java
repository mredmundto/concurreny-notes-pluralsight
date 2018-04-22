public class main {

    public static void main(String args[]){
        System.out.println("hello world");
        Runnable task = () -> System.out.println(Thread.currentThread().getName());
        Thread thread = new Thread(task);
        thread.start();
    }
}
