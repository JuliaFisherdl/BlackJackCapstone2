package com.company;

//make a public class card
public class Card {

    /* Make a class named “Card”. Give it two string properties: one named “suit” and
    one named “rank”. */
    private final String suit;
    private final String rank;
    private final int value;

    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

    // Add to “Card” a method named “describeCard” which prints to the screen the card’s suit
    // and rank.
    public void describeCard() {
        System.out.println(rank + " " + suit + " " + value);
    }

}



