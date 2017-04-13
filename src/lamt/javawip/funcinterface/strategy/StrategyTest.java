package lamt.javawip.funcinterface.strategy;

public class StrategyTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        TaxCalculationStrategy flatRate15 = (Double input) -> {
            return Double.valueOf(input.doubleValue() * 0.15d);
        };
        flatRate15.calculateTax();
        TaxCalculationStrategy flatRate20 = (Double input) -> {
            return Double.valueOf(input.doubleValue() * 0.20d + input.doubleValue());
        };
        flatRate20.calculateTax();
        TaxCalculationStrategy flatRate25 = (Double input) -> {
            return Double.valueOf(input.doubleValue() * 0.25d + input.doubleValue());
        };
        flatRate25.calculateTax();
        TaxCalculationStrategy flatRate30 = (Double input) -> {
            return Double.valueOf(input.doubleValue() * 0.30d + input.doubleValue());
        };
        flatRate30.calculateTax();
         
    }

    
    
}
