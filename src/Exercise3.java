public class Exercise3 {
    public static void main(String[] args) {
        PairOfDice diceRoll = new PairOfDice(1, 2);
        int numberOfRolls;

        System.out.println("Dice Value        Mean        Standard Dev.      Max");
        System.out.println("-----------------------------------------------------");
        for (int rollValue = 2; rollValue <= 12; rollValue++) {
            StatCalc rollStats;
            rollStats = new StatCalc();
            for (int i = 0; i < 10000; i++) {
                numberOfRolls = 0;
                diceRoll.roll();
                while (diceRoll.getRollTotal() != rollValue) {
                    numberOfRolls++;
                    diceRoll.roll();
                }
                rollStats.enter(numberOfRolls);
            }
            System.out.printf("%5d %17.2f %16.2f %11.0f%n", rollValue, rollStats.getMean(), rollStats.getStandardDeviation(), rollStats.getMax());
        }

        System.out.println("Thanks for using the Dice Stats program!");
    }
}
