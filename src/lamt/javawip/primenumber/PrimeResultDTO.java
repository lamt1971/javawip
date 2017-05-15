package lamt.javawip.primenumber;

public class PrimeResultDTO {

    public int input;
    public boolean primeNumber;
    
    public PrimeResultDTO(int input) {
        super();
        this.input = input;
    }

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public boolean isPrimeNumber() {
        return primeNumber;
    }

    public void setPrimeNumber(boolean primeNumber) {
        this.primeNumber = primeNumber;
    }

    
}
