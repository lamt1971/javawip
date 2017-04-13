package lamt.javawip.funcinterface.strategy;

@FunctionalInterface
public interface TaxCalculationStrategy {

    Double additionalTax(Double taxAmount);
    
    
    default Double calculateTax(){
        Double tax = Math.random();
        System.out.println("initial tax=" + tax.doubleValue());
        Double totalTax = additionalTax(tax);
        System.out.println("total tax=" + totalTax.doubleValue());
        return totalTax;
    }
    
    
    
    
}
