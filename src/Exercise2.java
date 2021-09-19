import textio.TextIO;

public class Exercise2 {

    public static void main(String[] args) {
        StatCalc calc;
        calc = new StatCalc();
        double number;

        System.out.println("Welcome to Stat Calc program.");
        System.out.println("Please enter numbers (enter 0 when finished.");
        number = TextIO.getDouble();
        while (number != 0) {
            calc.enter(number);
            number = TextIO.getDouble();
        }
        System.out.println("Results are:");
        System.out.printf("Number of numbers: %d%n", calc.getCount());
        System.out.printf("Sum of numbers: %.2f%n", calc.getSum());
        System.out.printf("Mean of numbers: %.2f%n", calc.getMean());
        System.out.printf("Standard Deviation: %.2f%n", calc.getStandardDeviation());
        System.out.printf("Maximum Number: %.2f%n", calc.getMax());
        System.out.printf("Minimum Number: %.2f%n", calc.getMin());
        System.out.println("Thanks for using the Stat Calc program!");
    }


}
