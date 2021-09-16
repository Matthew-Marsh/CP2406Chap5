public class PairOfDice {
    private int die1;
    private int die2;

    public PairOfDice() {
        roll();
    }

    public PairOfDice(int val1, int val2) {
        die1 = val1;
        die2 = val2;
    }

    public void roll() {
        die1 = (int) (Math.random() * 6) + 1;
        die2 = (int) (Math.random() * 6) + 1;
    }

    public int getFirstDie() {
        return die1;
    }

    public int getSecondDie() {
        return die2;
    }

    public int getRollTotal() {
        return die1 + die2;
    }

    public String toString() {
        return "First die is: " + die1 + " and second die is: " + die2;
    }
}
