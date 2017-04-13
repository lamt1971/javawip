package lamt.javawip.lamdathread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class ThreadingTest {

    public static void main(String[] args) {
        ThreadingTest test = new ThreadingTest();
        test.startRunnables();
    }

    public void startRunnables(){
        Runnable runnable = () -> {
            try{
                System.out.println("Runnable running..." +  Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Runnable completed..." +  Thread.currentThread().getName());
            }catch(InterruptedException ie){
                System.out.println("Runnable interupted..." +  Thread.currentThread().getName());
                return;
            }
        };
        
        Queue<Thread> queue = new LinkedList<>();
        
        queue.add(new Thread(runnable));
        queue.add(new Thread(runnable));
        queue.add(new Thread(runnable));
        queue.add(new Thread(runnable));
        queue.add(new Thread(runnable));
        queue.add(new Thread(runnable));
        queue.add(new Thread(runnable));
        queue.add(new Thread(runnable));
        queue.add(new Thread(runnable));

        queue.forEach(thread -> thread.start());
        queue.forEach(thread -> thread.interrupt());
     
    }
    
}
