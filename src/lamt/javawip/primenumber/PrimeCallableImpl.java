package lamt.javawip.primenumber;

import java.util.concurrent.Callable;

public class PrimeCallableImpl implements Callable<PrimeResultDTO> {

    private PrimeResultDTO dto; 
    
    public PrimeCallableImpl(int num) {
        super();
        dto = new PrimeResultDTO(num);
    }

    
    @Override
    public PrimeResultDTO call() throws Exception {
//        System.out.println("Starting call..." + dto.getInput());
        try {
            Thread.sleep(5L);
        } catch (InterruptedException e) {
        }
        
        int input = dto.getInput();
        if (input < 2){
            dto.setPrimeNumber(false);
            return dto;
        }else{
            if (input < 3){
                dto.setPrimeNumber(true);
                return dto;
            }
            int range = input/2;
            for(int i=2; i < range;i++){
                if (input % i==0){
                    dto.setPrimeNumber(false);
                    return dto;
                }
            }
        }
        dto.setPrimeNumber(true);
        return dto;
    }

}
