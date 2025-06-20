package FinancialForecastEx7;

public class ForcastValue{

    public static double SumOfGrowthRate(double[] growthRates){
        double sum = 0;
        for(int i=0;i<growthRates.length;i++) {
            sum += growthRates[i];
        }

        return sum;
    }

    public static double predictValue(int year, double initialValue, double[] growthRates) {
        // Base case
        if (year == 0) {
            return initialValue;
        }

        // Recursive case using current year's growth rate
        return predictValue(year - 1, initialValue, growthRates) * (1 + growthRates[year - 1]);
    }

    public static void main(String[] args) {
        double initialValue = 10000;
        double[] growthRates = {0.05, 0.04, 0.06, 0.03, 0.07}; // 5 years
        int targetYear = 5;

        double predicted = predictValue(targetYear, initialValue, growthRates);
        double totalGrowthRate = SumOfGrowthRate(growthRates);
        double totalRevenue = totalGrowthRate * initialValue;
        double predictedGrowthRate = (predicted - totalGrowthRate) / totalGrowthRate * 100;

        System.out.println("Predicted Growth Rate = " + predictedGrowthRate + "%");
        System.out.printf("Predicted value after %d years: ₹%.2f\n", targetYear, predicted);
    }
}
