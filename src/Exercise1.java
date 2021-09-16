public class Exercise1 {
    public static void main(String[] args) {
        PairOfDice diceRoll = new PairOfDice(1, 2);
        int numberOfRolls = 0;

//      Count how many rolls it would take to get a double.
        while (diceRoll.getFirstDie() != diceRoll.getSecondDie()) {
            diceRoll.roll();
            System.out.println(diceRoll);
            numberOfRolls++;
        }
        System.out.printf("It took %d rolls to get doubles.%n", numberOfRolls);

//      Count how many rolls it would take to get a total of 2.
        numberOfRolls = 1;
        diceRoll.roll();
        System.out.println(diceRoll);
        while (diceRoll.getRollTotal() != 2) {
            diceRoll.roll();
            numberOfRolls++;
            System.out.println(diceRoll);
        }
        System.out.printf("It took %d rolls to get a total of 2.", numberOfRolls);
    }
}
