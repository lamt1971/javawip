package lamt.javawip.funcinterface;

public class FuncInterfaceTest {

    public static void main(String[] args) {
        BespokeFuncInterface testAdd = (int input) -> {
            System.out.println("TEST");
            return input + 5;
        };
        BespokeFuncInterface testMult = (int input) -> {
            System.out.println("TEST");
            return input * 5;
        };
        
        BespokeFuncInterface testSub = (int input) -> {
            System.out.println("TEST");
            return input - 5;
        };

        
        testAdd.defaultExecute(20);
        testMult.defaultExecute(20);
        testSub.defaultExecute(20);
        
    }

 
    
}
