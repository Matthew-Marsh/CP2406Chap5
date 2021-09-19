import textio.TextIO;

public class Exercise4 {
    public static void main(String[] args) {
        Deck deck;
        Card card;
        deck = new Deck(false);
        BlackjackHand hand;
        int randomNumber;
        boolean playing = true;

        while (playing) {
            deck.shuffle();
            randomNumber = (int) (Math.random() * 5) + 2;
            hand = new BlackjackHand();
            System.out.println("Your cards:");
            for (int i = 1; i <= randomNumber; i++) {
                card = deck.dealCard();
                hand.addCard(card);
                System.out.println(card);
            }
            System.out.printf("Card total: %d%n", hand.getBlackjackValue());
            System.out.println("Play again? Y/N");
            playing = TextIO.getBoolean();
        }
    }
}
