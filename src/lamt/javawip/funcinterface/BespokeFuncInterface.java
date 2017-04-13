package lamt.javawip.funcinterface;
@FunctionalInterface
public interface BespokeFuncInterface {

    int execute(int input);
    
    default void defaultExecute(int input){
        System.out.println("Default ...");
        int result = execute(input);
        System.out.println("Default after executing...result = " + result);
    }
    
}
