package com.company;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;
import java.util.logging.Logger;

//Create a new class called Dealer
public class Dealer {

    //declared instantiate
    private Deck deck;

    public Player getPlayer() {
        return player;
    }

    public Player getHouse() {
        return house;
    }

    private Player player;
    private Player house;

    Scanner scanner = new Scanner(System.in);
    boolean hitOption = true;

    //no argument constructor
    public Dealer() {
        Logger logger = java.util.logging.Logger.getLogger(this.getClass().getName());
        logger.info("Running Game");
        reset();
    }

    private void initializePlayerTotalValues() {
        player.initialize();
        house.initialize();
    }

    public void playGame() {

        initializePlayerTotalValues();


        boolean haveAWinner = false;

        dealCards();
        haveAWinner = checkForBlackJack();

        // Did we have a winner in the initial deal?
        if (haveAWinner) {
            return;
        }

        player.reportScore();
        house.reportScore();


        while (player.getScore() < 21) {

            int hitOption = 0;
            System.out.println("Would you like to hit? 1. or Stay 2");
            hitOption = scanner.nextInt();
            if (hitOption == 1) {

                player.takeCard(deck.getTopCard());
                player.reportScore();

            } else if (hitOption == 2) {
                System.out.println("The player stays!");
                break;
            }

            if (player.getScore() == 21) {
                System.out.println("The Player has a Blackjack! The player won!");
                return;
            } else if (player.getScore() > 21) {
                System.out.println("The player has over 21! The player lost!");
                return;
            }

        }


        while (house.getScore() <= 16) {
            System.out.println("The House Hits");
            house.takeCard(deck.getTopCard());
            house.reportScore();

            if (house.getScore() == 21) {
                System.out.println("The Dealer has a Blackjack! The dealer won");
                return;
            } else if (house.getScore() > 21) {
                System.out.println("The house has over 21! The house lost!");
                return;
            }
        }

        System.out.println("The House Stays");

        if (player.getScore() >= house.getScore()) {
            System.out.println("Player wins!");
        } else if (house.getScore() > player.getScore()) {
            System.out.println("House wins.");
        }
    }

    public void dealCards() {
        for (int i = 0; i < 2; i++) {
            Card topCard = deck.getTopCard();
            player.takeCard(topCard);

            Card houseTopCard = deck.getTopCard();
            house.takeCard(houseTopCard);

        }
    }

    public void showPlayerHand() {
        player.showCards();
    }

    public void showHouseHand() {
        house.showCards();
    }

    public void shuffle() {
        deck.shuffle();
    }

    public boolean checkForBlackJack() {
        Boolean haveAWinner = false;

        if (player.getScore() == 21 && house.getScore() == 21) {
            System.out.println("The Player and Dealer have a Blackjack! The house wins!");
            haveAWinner = true;
        } else if (player.getScore() == 21) {
            System.out.println("The player has a BlackJack! The player won!");
            haveAWinner = true;
        } else if (house.getScore() == 21) {
            System.out.println("The dealer has a Blackjack! The dealer won");
            haveAWinner = true;
        }
        return haveAWinner;
    }


    public void reset() {
        house = new Player("House");
        player = new Player("Player");
        deck = new Deck();
        deck.buildDeck();
        shuffle();
    }


    public boolean checkForBust() {
        Boolean haveAWinner = false;

        if (player.getScore() > 21 && house.getScore() > 21) {
            System.out.println("The Player and Dealer bust");
            haveAWinner = false;
        } else if (player.getScore() > 21) {
            System.out.println("The player has bust");
            haveAWinner = false;
        } else if (house.getScore() > 21) {
            System.out.println("The dealer has bust");
            haveAWinner = false;
        }
        return haveAWinner;
    }
}