import textio.TextIO;

public class Exercise5 {


    public static void main(String[] args) {
        int bet;
        int playerMoney = 100;
        boolean playing = true;

        while (playing) {
            bet = MakeBet(playerMoney);
            boolean win = PlayGame();
            if (win) {
                playerMoney = playerMoney + bet;
            } else {
                playerMoney = playerMoney - bet;
            }
            System.out.println("You now have $" + playerMoney);
            if (playerMoney > 0) {
                System.out.println("Would you like to play again? Y/N");
                playing = TextIO.getBoolean();
            } else {
                System.out.println("You have run out of money.");
                playing = false;
            }
        }
        System.out.println("Thanks for playing.");
    }

    private static int MakeBet(int money) {
        System.out.println("You have $" + money);
        System.out.println("How much would you like to bet?");
        int betAmount = TextIO.getInt();
        while (betAmount > money || betAmount < 0) {
            System.out.println("Invalid Betting Amount.");
            System.out.println("How much would you like to bet?");
            betAmount = TextIO.getInt();
        }
        return betAmount;
    }

    private static boolean PlayGame() {
        Deck deck = new Deck(false);
        Card card;
        BlackjackHand dealerHand = new BlackjackHand();
        BlackjackHand playerHand = new BlackjackHand();

        deck.shuffle();
        dealerHand.addCard( deck.dealCard());
        dealerHand.addCard( deck.dealCard());
        playerHand.addCard( deck.dealCard());
        playerHand.addCard( deck.dealCard());

        System.out.println("Dealer has: " + dealerHand.getCard(0) + " and " + dealerHand.getCard(1));
        System.out.println("Player has: " + playerHand.getCard(0) + " and " + playerHand.getCard(1));
        if (dealerHand.getBlackjackValue() == 21) {
            System.out.println("Dealer got a 21, dealer wins.");
            return false;
        }
        if (playerHand.getBlackjackValue() == 21) {
            System.out.println("Player got a 21, player wins.");
            return true;
        }

        System.out.println("Your hand is worth " + playerHand.getBlackjackValue());
        while (true) {
            char userChoice;
            System.out.println("(H)it or (S)tand");
            userChoice = Character.toUpperCase(TextIO.getChar());
            while (userChoice != 'H' && userChoice != 'S') {
                System.out.println("Invalid choice, input 'H' or 'S'");
                userChoice = Character.toUpperCase(TextIO.getChar());
            }
            if (userChoice == 'S') {
                break;
            }
            card = deck.dealCard();
            playerHand.addCard(card);
            System.out.println("Player hits.");
            System.out.println("New card is: " + card);
            System.out.println("Your new card worth is: " + playerHand.getBlackjackValue());

            if (playerHand.getBlackjackValue() > 21) {
                System.out.println("You busted and lost.");
                return false;
            }
        }
        System.out.println("Player stands.");
        System.out.println("Dealer's hand is worth: " + dealerHand.getBlackjackValue());
        while (dealerHand.getBlackjackValue() <= 16) {
            dealerHand.addCard( deck.dealCard());
            System.out.println("Dealer deals themself a card, total is now: " + dealerHand.getBlackjackValue());
        }
        if (dealerHand.getBlackjackValue() > 21) {
            System.out.println("Dealer buested. Player wins.");
            return true;
        } else if (dealerHand.getBlackjackValue() > playerHand.getBlackjackValue()) {
            System.out.println("Dealer has higher hand value without going over 21. Dealer wins.");
            return false;
        } else if (dealerHand.getBlackjackValue() == playerHand.getBlackjackValue()) {
            System.out.println("Player wins on a tie with Dealer.");
            return true;
        } else {
            System.out.println("Player has higher value than Dealer. Player wins.");
            return true;
        }
    }
}
