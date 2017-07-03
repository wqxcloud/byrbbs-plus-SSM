import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ryder on 2017/7/2.
 */
public class TestRunnable implements Runnable {
    private ConcurrentLinkedQueue<Integer> tickets = new ConcurrentLinkedQueue<>();

    public void add(int a) {
        tickets.offer(a);
    }

    public void run() {
        while (!tickets.isEmpty()) {
            Integer ticket = tickets.poll();
            if (ticket!=null) {
                String name = Thread.currentThread().getName();
                System.out.println(name + "正在卖票 " + ticket);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        TestRunnable t = new TestRunnable();
        for(int i=10;i>0;i--)
            t.add(i);
//        new Thread(t, "1号窗口").start();
//        new Thread(t, "2号窗口").start();
//        new Thread(t, "3号窗口").start();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        fixedThreadPool.execute(new Thread(t, "1号窗口") );
        fixedThreadPool.execute(new Thread(t, "2号窗口") );
        fixedThreadPool.execute(new Thread(t, "3号窗口") );
        fixedThreadPool.shutdown();


    }

}
