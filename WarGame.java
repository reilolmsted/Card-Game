// Programmer : Reilly Olmsted & Aaron Vadnais
// Class: CS &145
// Date: 04/20/2023
// Assignment: Lab4
// Card Game
// This program will create the card game "War" and allow the user to play against the computer.

import java.util.*;

public class WarGame {

    public void menu() {
        Scanner input = new Scanner(System.in);
        boolean exitMenu = false;

        System.out.println("Welcome to War.");
        System.out.println("Please Select from one of the Following Options.");
        System.out.println();

        while (!exitMenu) {
            System.out.println("Enter \"d\" " + "to Look at the Rules of War");
            System.out.println("Enter \"p\" " + "to go to War");
            System.out.println("Enter \"r\" " + "to Exit the Game");

            String userMenu = input.next();
            String letter = userMenu.toLowerCase();

            switch (letter) {
                case "d":
                    System.out.println("Rules of War");
                    System.out.println();
                    System.out.println("For this game, you will be playing against the computer.");
                    System.out.println("The deck will be split evenly between you and the computer and when ready,");
                    System.out.println("you will flip the top card of the deck at the same time.");
                    System.out.println("The player that flips the card with the highest value wins the round");
                    System.out.println("If both cards are of equal value, both players remove 4 cards from the top of the deck ");
                    System.out.println("and then play a fifth. The player who has the highest card value wins all of the cards placed down");
                    System.out.println("If there is another draw, then both players repeat the the process for a draw.");
                    System.out.println("The player who collects all of the cards is victorious");
                    System.out.println();
                    System.out.println("Would you like to go to war?");
                    System.out.println();
                    break;
                case "p":
                    warGame();
                    break;
                case "r":
                    exitMenu = true;
                    System.out.println("Exiting the menu. Come back soon.");
                    break;

                default:
                    userMenu = "Invalid Entry";
                    System.out.println("Invalid Entry, Please Try Again");
                    break;
            } // end switch statement
        } // end while loop
    }

    public void warGame(){ //This contains the code for the game itself
        Scanner input = new Scanner(System.in);
        Cards c = new Cards();
        String playGame;
        int i = -1;
        do{
            try {
                System.out.println("Players draw a card from your deck!");
                int y = c.playerHand.peek();
                int x= c.computerHand.peek();
                int k = y + 1; //player
                int z = x + 1; //computer
                System.out.println(c.computerHand + " computer hand");
                System.out.println(c.playerHand + " player hand");
                i++;
                if(x < 10 && y < 10) {
                    System.out.println("Computers card is: " + z);
                    System.out.println("Your card is: " + k);
                }else{
                    switch (y){
                        case 11:
                            System.out.println("Your card is the Queen");
                            break;
                        case 10:
                            System.out.println("Your card is the Jack");
                            break;
                        case 12:
                            System.out.println("Your card is the King");
                            break;
                        case 13:
                            System.out.println("You have the ACE!");
                            break;
                        default:System.out.println("players card is: " + k);
                            break;
                    }switch(x){
                        case 11:
                            System.out.println("Computers card is the Queen");
                            break;
                        case 10:
                            System.out.println("Computers card is the Jack");
                            break;
                        case 12:
                            System.out.println("Computers card is the King");
                            break;
                        case 13:
                            System.out.println("Computer has the ACE!");
                            break;
                        default:System.out.println("Computers card is: " + z);
                            break;
                    }
                }

                int cpuCard = c.computerHand.peek();
                int userCard = c.playerHand.peek();
                if (userCard < cpuCard) {
                    int addCard = c.playerHand.pop();
                    c.computerHand.push(addCard);
                    Collections.shuffle(c.computerHand);
                    System.out.println("Press any key to continue");
                    System.out.println("Press 'r' to resign");
                    playGame = input.next();

                } else if (userCard > cpuCard) {
                    int addCard = c.computerHand.pop();
                    c.playerHand.push(addCard);
                    Collections.shuffle(c.playerHand);
                    System.out.println("Press any key to continue");
                    System.out.println("Press 'r' to resign");
                    playGame = input.next();

                } else {
                    System.out.println("It's a draw! Pull 3 cards and read the 4th.");
                    int pCard1 = c.playerHand.pop();
                    int pCard2 = c.playerHand.pop();
                    int pCard3 = c.playerHand.pop();
                    int pCard4 = c.playerHand.pop();
                    int cCard1 = c.computerHand.pop();
                    int cCard2 = c.computerHand.pop();
                    int cCard3 = c.computerHand.pop();
                    int cCard4 = c.computerHand.pop();
                    cpuCard = c.computerHand.peek();
                    userCard = c.playerHand.peek();
                    System.out.println("Press any key to continue");
                    System.out.println("Press 'r' to resign");
                    playGame = input.next();
                    if (cpuCard < userCard) {
                        c.playerHand.push(pCard1);
                        c.playerHand.push(pCard2);
                        c.playerHand.push(pCard3);
                        c.playerHand.push(pCard4);
                        c.playerHand.push(cCard1);
                        c.playerHand.push(cCard2);
                        c.playerHand.push(cCard3);
                        c.playerHand.push(cCard4);
                        Collections.shuffle(c.playerHand);
                    } else if (cpuCard > userCard) {
                        c.computerHand.push(pCard1);
                        c.computerHand.push(pCard2);
                        c.computerHand.push(pCard3);
                        c.computerHand.push(pCard4);
                        c.computerHand.push(cCard1);
                        c.computerHand.push(cCard2);
                        c.computerHand.push(cCard3);
                        c.computerHand.push(cCard4);
                        Collections.shuffle(c.computerHand);
                    } else {
                        System.out.println("It's another draw! Pull 3 cards and read the 4th.");
                        int pCard5 = c.playerHand.pop();
                        int pCard6 = c.playerHand.pop();
                        int pCard7 = c.playerHand.pop();
                        int pCard8 = c.playerHand.pop();
                        int cCard5 = c.computerHand.pop();
                        int cCard6 = c.computerHand.pop();
                        int cCard7 = c.computerHand.pop();
                        int cCard8 = c.computerHand.pop();
                        cpuCard = c.computerHand.peek();
                        userCard = c.playerHand.peek();
                        System.out.println("Press any key to continue");
                        System.out.println("Press 'r' to resign");
                        playGame = input.next();
                        if (cpuCard < userCard) {
                            c.playerHand.push(pCard1);
                            c.playerHand.push(pCard2);
                            c.playerHand.push(pCard3);
                            c.playerHand.push(pCard4);
                            c.playerHand.push(pCard5);
                            c.playerHand.push(pCard6);
                            c.playerHand.push(pCard7);
                            c.playerHand.push(pCard8);
                            c.playerHand.push(cCard1);
                            c.playerHand.push(cCard2);
                            c.playerHand.push(cCard3);
                            c.playerHand.push(cCard4);
                            c.playerHand.push(cCard5);
                            c.playerHand.push(cCard6);
                            c.playerHand.push(cCard7);
                            c.playerHand.push(cCard8);
                            Collections.shuffle(c.playerHand);
                        } else if (cpuCard > userCard) {
                            c.computerHand.push(pCard1);
                            c.computerHand.push(pCard2);
                            c.computerHand.push(pCard3);
                            c.computerHand.push(pCard4);
                            c.computerHand.push(pCard5);
                            c.computerHand.push(pCard6);
                            c.computerHand.push(pCard7);
                            c.computerHand.push(pCard8);
                            c.computerHand.push(cCard1);
                            c.computerHand.push(cCard2);
                            c.computerHand.push(cCard3);
                            c.computerHand.push(cCard4);
                            c.computerHand.push(cCard5);
                            c.computerHand.push(cCard6);
                            c.computerHand.push(cCard7);
                            c.computerHand.push(cCard8);

                            Collections.shuffle(c.computerHand);
                        } else {

                            System.out.println("Another draw?? Re-shuffling the deck...");
                            c.playerHand.push(pCard1);
                            c.playerHand.push(pCard2);
                            c.playerHand.push(pCard3);
                            c.playerHand.push(pCard4);
                            c.playerHand.push(pCard5);
                            c.playerHand.push(pCard6);
                            c.playerHand.push(pCard7);
                            c.playerHand.push(pCard8);
                            c.computerHand.push(cCard1);
                            c.computerHand.push(cCard2);
                            c.computerHand.push(cCard3);
                            c.computerHand.push(cCard4);
                            c.computerHand.push(cCard5);
                            c.computerHand.push(cCard6);
                            c.computerHand.push(cCard7);
                            c.computerHand.push(cCard8);

                            Collections.shuffle(c.computerHand);
                            Collections.shuffle(c.playerHand);
                        }
                    }
                }//end of all else statements

            }catch(Exception EmptyStackException){
                break;}

        }while(!playGame.equals("r"));
        System.out.println("Good Game!");
        System.out.println();
        if (c.computerHand.isEmpty())
        {
            System.out.println("You won!!");
            System.out.println("the game lasted " + i + " rounds");
        }else if(c.playerHand.isEmpty()){
            System.out.println("Sorry, you lost");
            System.out.println("better luck next time.");
            System.out.println();
            System.out.println("the game lasted " + i + " rounds");
        }
    }

} // end of class