package lamt.javawip.futures;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComputableFutureTest {

    public static void main(String[] args) {
        
        testComputableFutureWithAllCompleteCheck();
        System.out.println("==================================================================");
        System.out.println("==================================================================");
        System.out.println("==================================================================");
        testComputableFutureWithCompleteAction();
    }
    
    public static void testComputableFutureWithAllCompleteCheck(){
        ExecutorService executor = null;
        try{
            //Executor Service with fixed pool
            executor = Executors.newFixedThreadPool(10);
            List<CompletableFuture<String>> futures = new ArrayList<>();
            List<CompletableFuture<Void>> futuresVoid = new ArrayList<>();
            //Load up Callable and submit to executor service.... which returns a Future
            for(int i=0; i<100;i++){
                final int index = i;

                //supplyAsynch - asynchronous action to be performed. 
                futures.add(CompletableFuture.supplyAsync(()-> ComputableFutureTest.doWork(index), executor));
            }
            
            
            CompletableFuture<Void> completed = CompletableFuture.allOf(
                                futures.toArray(new CompletableFuture[futures.size()]
                                ));
            System.out.println("Collate the Futures results...");
            while(!completed.isDone()){
                
            }
            System.out.println("Completed DONE!!!!...");
            
            
        }finally{
            System.out.println("finally");
            if (executor!=null){
                executor.shutdown();
            }
        }        
    }

    
    
    public static void testComputableFutureWithCompleteAction(){
        ExecutorService executor = null;
        ExecutorService resultExecutor = null;
        try{
            //Executor Service with fixed pool
            executor = Executors.newFixedThreadPool(10);
            resultExecutor = Executors.newFixedThreadPool(10);
            List<CompletableFuture<String>> futures = new ArrayList<>();
            List<CompletableFuture<Void>> futuresVoid = new ArrayList<>();
            //Load up Callable and submit to executor service.... which returns a Future
            for(int i=0; i<100;i++){
                final int index = i;

                //thenAcceptAsynch - asynchronous consumer of result                 
                futuresVoid.add(CompletableFuture.supplyAsync(()-> ComputableFutureTest.doWork(index), executor)
                        .thenAcceptAsync((returnedResult)->{System.out.println("Result completion + " + returnedResult);}, resultExecutor));                
            }
                       
            System.out.println("Completed DONE!!!!...");
            
            
        }finally{
            System.out.println("finally");
            if (executor!=null){
                executor.shutdown();
            }
            if (resultExecutor!=null){
                resultExecutor.shutdown();
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
            double delay = Math.random()*1000;
//            System.out.println("sleeping for :" + delay);
            Thread.sleep((int)delay);
            return;
        }catch (InterruptedException e) {
            return;
        }
    }
}
