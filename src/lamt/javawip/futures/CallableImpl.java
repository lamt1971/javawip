package lamt.javawip.futures;

import java.util.concurrent.Callable;

public class CallableImpl implements Callable<ResultDTO> {

    private ResultDTO result; 
    
    
    public CallableImpl(String name) {
        super();
        result = new ResultDTO(name);
    }

    
    @Override
    public ResultDTO call() throws Exception {
        System.out.println("Starting call..." + result.getName());
        long sleepTime = (long)(Math.random()*10000); 
        System.out.println("sleeptime : " + sleepTime);
        Thread.sleep(sleepTime);
        result.setCompleted(true);
        result.setName((result.getName() + "-RETURNED"));
        return result;
    }

}
