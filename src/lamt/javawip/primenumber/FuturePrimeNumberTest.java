package lamt.javawip.primenumber;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FuturePrimeNumberTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LocalTime now = LocalTime.now();
        System.out.println("Get All futureGetAllPrimeNumbers");
        FuturePrimeNumberTest.futureGetAllPrimeNumbers(2000);
        System.out.println("Get All futureGetAllPrimeNumbers Time taken : " + Duration.between(now, LocalTime.now()).toMillis());

        now = LocalTime.now();
        System.out.println("Get Classic All Primes");
        List<Integer> result =  FuturePrimeNumberTest.classicGetAllPrimeNumbers(2000);
        System.out.println("Get All classicGetAllPrimeNumbers Time taken : " + Duration.between(now, LocalTime.now()).toMillis());
    }


    public static List<Integer> classicGetAllPrimeNumbers(int input){      
//      System.out.println("classicGetAllPrimeNumbers input=" + input);
      List<Integer> result = new ArrayList<>();
      for(int i=2; i < input;i++){
          if (classicPrimeNumber(i)){
              result.add(i);
          }
      }
      return result;
    }
    
    
    public static boolean classicPrimeNumber(int input){      
//        System.out.println("classicPrimeNumber input=" + input);
        try {
            Thread.sleep(5L);
        } catch (InterruptedException e) {
        }
        
        if (input < 2){
            return false;
        }else{
            if (input < 3){
                return true;
                }
            int range = input/2;
            for(int i=2; i < range;i++){
                if (input % i==0){
                    return false;
                }
            }
        }

        return true;
      }

    
    public static void futureGetAllPrimeNumbers(int input){      
//      System.out.println("futureGetAllParallelPrimeNumbers input=" + input);
      ExecutorService executor = null;
      try{
          //Executor Service with fixed pool
          executor = Executors.newFixedThreadPool(1000);
          //Double Ended Queue to hold Futures. 
          Deque<Future<PrimeResultDTO>> futures = new ArrayDeque<>();
          //Load up Callable and submit to executor service.... which returns a Future
          for(int i=0; i<input;i++){
              Future<PrimeResultDTO> result = executor.submit(new PrimeCallableImpl(i));
              futures.add(result);
          }
          
//          System.out.println("Collate the Futures results...");
          
          //Pop first item from Double ended futures queue and check if completed...if not push it back onto the queue.
          //Do until all queue is empty as futures would have completed. 
          PrimeResultDTO dto = null;
          while(!futures.isEmpty()){
              Future<PrimeResultDTO> future = futures.pop();
              if (future==null){
                 break;
              }
              
              try {
                  //future completed, retrieve result
                  if (future.isDone()){
                      dto = future.get();
                      if (dto.isPrimeNumber()){
//                          System.out.println(dto.getInput() + " is a prime number");                                                    
                      }
                  }else{
                      //put back in the queue
                      futures.push(future);
                  }
              } catch (InterruptedException | ExecutionException e) {
                  e.printStackTrace();
              }
          }
      }finally{
          if (executor!=null){
              executor.shutdown();
          }
      }
    }
}
