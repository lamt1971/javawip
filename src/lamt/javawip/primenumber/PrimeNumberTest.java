package lamt.javawip.primenumber;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumberTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LocalTime now = LocalTime.now();
        System.out.println("is classic Prime = " + PrimeNumberTest.classicPrimeNumber(-2));
        System.out.println("Time taken : " + Duration.between(now, LocalTime.now()).toMillis());
        System.out.println("is classic Prime = " + PrimeNumberTest.classicPrimeNumber(0));
        System.out.println("Time taken : " + Duration.between(now, LocalTime.now()).toMillis());
        System.out.println("is classic Prime = " + PrimeNumberTest.classicPrimeNumber(1));
        System.out.println("Time taken : " + Duration.between(now, LocalTime.now()).toMillis());
        System.out.println("is classic Prime = " + PrimeNumberTest.classicPrimeNumber(2));
        System.out.println("Time taken : " + Duration.between(now, LocalTime.now()).toMillis());
        System.out.println("is classic Prime = " + PrimeNumberTest.classicPrimeNumber(3));
        System.out.println("Time taken : " + Duration.between(now, LocalTime.now()).toMillis());
        System.out.println("is classic Prime = " + PrimeNumberTest.classicPrimeNumber(-1999));
        System.out.println("Time taken : " + Duration.between(now, LocalTime.now()).toMillis());
        System.out.println("is classic Prime = " + PrimeNumberTest.classicPrimeNumber(1999));
        System.out.println("Time taken : " + Duration.between(now, LocalTime.now()).toMillis());

        
        now = LocalTime.now();
        System.out.println("is lambda Prime = " + PrimeNumberTest.lambdaPrimeNumber(-2));
        System.out.println("Time taken : " + Duration.between(now, LocalTime.now()).toMillis());
        System.out.println("is lambda Prime = " + PrimeNumberTest.lambdaPrimeNumber(0));
        System.out.println("Time taken : " + Duration.between(now, LocalTime.now()).toMillis());
        System.out.println("is lambda Prime = " + PrimeNumberTest.lambdaPrimeNumber(1));
        System.out.println("Time taken : " + Duration.between(now, LocalTime.now()).toMillis());
        System.out.println("is lambda Prime = " + PrimeNumberTest.lambdaPrimeNumber(2));
        System.out.println("Time taken : " + Duration.between(now, LocalTime.now()).toMillis());
        System.out.println("is lambda Prime = " + PrimeNumberTest.lambdaPrimeNumber(3));
        System.out.println("Time taken : " + Duration.between(now, LocalTime.now()).toMillis());
        System.out.println("is lambda Prime = " + PrimeNumberTest.lambdaPrimeNumber(-1999));
        System.out.println("Time taken : " + Duration.between(now, LocalTime.now()).toMillis());
        System.out.println("is lambda Prime = " + PrimeNumberTest.lambdaPrimeNumber(1999));
        System.out.println("Time taken : " + Duration.between(now, LocalTime.now()).toMillis());
        
/*        now = LocalTime.now();
        System.out.println("Get Classic All Primes");
        List<Integer> result =  PrimeNumberTest.classicGetAllPrimeNumbers(100000);
        System.out.println("Time taken : " + Duration.between(now, LocalTime.now()).toMillis());
        result.forEach((prime) -> {System.out.println("prime number : " + prime);});
        
        now = LocalTime.now();
        System.out.println("Get Lambda All Primes");
        result =  PrimeNumberTest.lambdaGetAllPrimeNumbers(100000);
        System.out.println("Time taken : " + Duration.between(now, LocalTime.now()).toMillis());
        result.forEach((prime) -> {System.out.println("prime number : " + prime);});
        
        now = LocalTime.now();
        System.out.println("Get Lambda All Parallel Primes");
        result =  PrimeNumberTest.lambdaGetAllParallelPrimeNumbers(100000);
        System.out.println("Time taken : " + Duration.between(now, LocalTime.now()).toMillis());
        result.forEach((prime) -> {System.out.println("prime number : " + prime);});
*/    }


    public static boolean classicPrimeNumber(int input){      
      System.out.println("classicPrimeNumber input=" + input);
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

    public static boolean lambdaPrimeNumber(int input){      
        System.out.println("lambdaPrimeNumber input=" + input);
        if (input < 2){
            return false;
        }
        if (input == 2){
            return true;
        }
        int range = input/2;        
        return IntStream.range(2, range).noneMatch((index) -> {
                return input % index==0;
                });
    }
        

    public static List<Integer> classicGetAllPrimeNumbers(int input){      
      System.out.println("classicGetAllPrimeNumbers input=" + input);
      List<Integer> result = new ArrayList<>();
      for(int i=2; i < input;i++){
          if (classicPrimeNumber(i)){
              result.add(i);
          }
      }
      return result;
    }


    public static List<Integer> lambdaGetAllPrimeNumbers(int input){      
      System.out.println("lambdaGetAllPrimeNumbers input=" + input);
      List<Integer> result = new ArrayList<>();
      result = IntStream.range(2, input).filter((intInput) -> {return lambdaPrimeNumber(intInput);}).boxed().collect(Collectors.toList());
      return result;
    }

    public static List<Integer> lambdaGetAllParallelPrimeNumbers(int input){      
      System.out.println("lambdaGetAllParallelPrimeNumbers input=" + input);
      List<Integer> result = new ArrayList<>();
      result = IntStream.range(2, input).parallel().filter((intInput) -> {return lambdaPrimeNumber(intInput);}).boxed().collect(Collectors.toList());
      return result;
    }

}
