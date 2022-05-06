package com.company;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        runGame();

    }

    public static void runGame() {

	/*Make a class named “Card”. Give it two string properties: one named “suit” and one
named “rank”. Make a setter method for each property.
Add to “Card” a method named “describeCard” which prints to the screen the card’s suit
and rank.
Declare and initialize an array of strings named “suits”. Put a string in the array for each
suit (“spades”, “diamonds”, etc.).
Declare and initialize an empty array list of cards named “oneOfEachSuit”.
Use a loop of your choice to iterate over (traverse) “suits”. For each string in “suits”:
● Instantiate the “Card” class.
● Set the card’s suit to the string from “suits”.
● Add the card to “oneOfEachSuit”.*/
        System.out.println("Welcome to Blackjack");

        Dealer dealer = new Dealer();
        Scanner scanner = new Scanner(System.in);
        boolean keepPlaying = true;

        while (keepPlaying) {
            int playOption = 0;
            System.out.println("Would you like to play? 1. Yes or 2 No");
            playOption = scanner.nextInt();
            if (playOption == 1) {
//call methods to start game  initialDeal() -showCards() describeCard()
                dealer.playGame();

                System.out.println("Player hand");
                dealer.showPlayerHand();

                System.out.println("House hand");
                dealer.showHouseHand();

            } else if (playOption == 2) {
                System.out.println("Thanks for playing BlackJack.");
                break;
            } else {
                System.out.println("Invalid option. 1) Yes 2) No");
            }

        }
    }

//total for hand value
    //work telling people if they get a blackjack
    //tell people if they bust
    //ask if they want a hit or stay
    //house do it automatically
    //method hit (user types in what they want to do)

}



