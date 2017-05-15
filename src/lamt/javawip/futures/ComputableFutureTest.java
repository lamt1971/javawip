package lamt.javawip.futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComputableFutureTest {

    public static void main(String[] args) {
        ExecutorService executor = null;
        ExecutorService resultExecutor = null;
        try{
            //Executor Service with fixed pool
            executor = Executors.newFixedThreadPool(100);
            resultExecutor = Executors.newFixedThreadPool(100);
            //Load up Callable and submit to executor service.... which returns a Future
            for(int i=0; i<100;i++){
                final int index = i;
                //supplyAsynch - asynchronous action to be performed. 
                CompletableFuture.supplyAsync(()-> ComputableFutureTest.doWork(index), executor);
                //thenAcceptAsynch - asynchronous consumer of result                 
                CompletableFuture.supplyAsync(()-> ComputableFutureTest.doWork(index), executor)
                        .thenAcceptAsync((returnedResult)->{System.out.println("Result completion + " + returnedResult);}, resultExecutor);
            }
            
            System.out.println("Collate the Futures results...");
            
        }finally{
            System.out.println("finally");
            if (executor!=null){
                executor.shutdown();
            }
        }
    }
    
    
    public static String doWork(int id){
        System.out.println("doing work for id " + id);
        ComputableFutureTest.delay();
        String outMessage = "doing work for id " + id;
        System.out.println(outMessage + " completed.");
        return outMessage;
    }
    
    public static void delay(){
        try{
            int delay = (int)Math.random()*2000;
            Thread.sleep(delay);
            return;
        }catch (InterruptedException e) {
            return;
        }
    }
}
