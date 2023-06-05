import java.util.*;

public class Cards {

    WarGame c = new WarGame();
    public Stack<Integer> computerHand = new Stack<Integer>();
    public Stack<Integer> playerHand = new Stack<Integer>();
    ArrayList<Integer> cardValues = new ArrayList<Integer>();

    public Cards() { //constructor method
        populateCards();
        Collections.shuffle(this.cardValues);
        distributeCards();
    }

    private void populateCards() {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                this.cardValues.add(j);
            }
        }
    }

    public void distributeCards() { //shuffles and distributes cards
        List<Integer> player = this.cardValues.subList(0, 26);
        List<Integer> computer = this.cardValues.subList(26, 52);

        this.computerHand.addAll(computer);
        this.playerHand.addAll(player);

    }
}

