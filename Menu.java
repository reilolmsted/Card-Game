import java.util.Scanner;

public class Menu {
    public void menu() {
        Scanner input = new Scanner(System.in);
        boolean exitMenu = false;

        System.out.println("Welcome to War.");
        System.out.println("Please Select from one of the Following Options.");
        System.out.println();

        while (!exitMenu) {
            System.out.println("Enter \"d\" " + "to look at the rules of War");
            System.out.println("Enter \"p\" " + "to go to War");
            System.out.println("Enter \"r\" " + "to retreat from your War");

            String userMenu = input.next();
            String letter = userMenu.toLowerCase();

            switch (letter) {
                case "d":
                    System.out.println("Welcome to War");
                    System.out.println("For this game, you will be playing against the computer");
                    System.out.println("The deck will be split evenly between you and the computer.");
                    System.out.println("You and the computer will flip the top card of the deck at the same time");
                    System.out.println("The player who flips the card with the highest value wins the round");
                    System.out.println("If both cards are of equal value, both players draw 4 cards from the top of the deck and play a fifth");
                    System.out.println("The player who has the highest card value wins all of the cards, unless there is another draw.");
                    System.out.println("If there is another draw, then both players repeat the the process for a draw.");
                    System.out.println("The player who collects all of the cards is victorious");
                    System.out.println("Would you like to go to war?: ");
                    System.out.println("Enter 'y' for yes, 'n' for no");
                    break;
                case "p":
                    //warGame();
                    break;
                case "r":
                    exitMenu = true;
                    System.out.println("You retreated. You have failed your country.");
                    break;

                default:
                    userMenu = "Invalid Entry";
                    System.out.println("Invalid Entry, Please Try Again");
                    break;
            } // end switch statement
        } // end while loop
    }
}
