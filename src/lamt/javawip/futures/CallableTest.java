package lamt.javawip.futures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {

    public static void main(String[] args) {
        ExecutorService executor = null;
        try{
            //Executor Service with fixed pool
            executor = Executors.newFixedThreadPool(3);
            //Double Ended Queue to hold Futures. 
            Deque<Future<ResultDTO>> futures = new ArrayDeque<>();
            //Load up Callable and submit to executor service.... which returns a Future
            for(int i=0; i<30;i++){
                Future<ResultDTO> result = executor.submit(new CallableImpl("callable_" + i));
                futures.add(result);
            }
            
            System.out.println("Collate the Futures results...");
            
            //Pop first item from Double ended futures queue and check if completed...if not push it back onto the queue.
            //Do until all queue is empty as futures would have completed. 
            while(!futures.isEmpty()){
                Future<ResultDTO> future = futures.pop();
                if (future==null){
                   break;
                }
                
                try {
                    if (future.isDone()){
                        System.out.println("Future completed..." + future.get().getName());                          
                    }else{
                        System.out.println("Future not yet completed..." + future.get().getName());                          
                        futures.push(future);
                    }
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }finally{
            executor.shutdown();
        }
    }
    
}
