package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DealerTest {

    Dealer dealer = new Dealer();

    @BeforeEach
    public void setUp() {
        dealer.shuffle();
        dealer.reset();
    }

    @Test
    public void dealCards_givenStandardDeck_eachHandHasTwoCards() {
        dealer.dealCards();
        System.out.print("Expects deal cards to deal two cards to each hand : ");
        Assertions.assertEquals(2, dealer.getPlayer().getHand().size());
        Assertions.assertEquals(2, dealer.getHouse().getHand().size());
    }

    @Test
    public void checkForBlackJack_twoCardsGivenTotalingTwentyOneToPlayer_returnsTrue() {
        System.out.print("Expect player 21 to declare blackjack : ");
        Card card1 = new Card("Hearts", "Ace", 11);
        Card card2 = new Card("Diamonds", "10", 10);
        dealer.getPlayer().takeCard(card1);
        dealer.getPlayer().takeCard(card2);
        Assertions.assertTrue(dealer.checkForBlackJack());
    }

    @Test
    public void checkForBlackJack_twoCardsGivenTotalingTwentyOneToHouse_returnsTrue() {
        System.out.print("Expect house to have 21 to declare blackjack : ");
        Card card1 = new Card("Clubs", "Ace", 11);
        Card card2 = new Card("Spades", "10", 10);
        dealer.getPlayer().takeCard(card1);
        dealer.getPlayer().takeCard(card2);
        Assertions.assertTrue(dealer.checkForBlackJack());
    }

    @Test
    public void checkForBust_twoCardsGivenGreaterThanTwentyOneToPlayer_returnstrue() {

        System.out.print("Expect to declare bust: ");
        Card card1 = new Card("Hearts", "Ace", 11);
        Card card2 = new Card("Diamonds", "Ace", 11);
        dealer.getPlayer().takeCard(card1);
        dealer.getPlayer().takeCard(card2);
        Assertions.assertTrue(dealer.checkForBust());
    }

    @Test
    public void checkForBust_twoCardsGivenGreaterThanTwentyOneToHouse_returnstrue() {

        System.out.print("Expect to declare bust: ");
        Card card1 = new Card("Hearts", "Ace", 11);
        Card card2 = new Card("Diamonds", "Ace", 11);
        dealer.getHouse().takeCard(card1);
        dealer.getHouse().takeCard(card2);
        Assertions.assertTrue(dealer.checkForBust());
    }



    // public void testIndividualCardTotals();
    @Test
    public void checkForIndividualCardTotals_eachCardInDeck_returnstrue() {
        Deck deck = new Deck();

        deck.buildDeck();
        Boolean hasCorrectValue = true;
        int value = 0;

        List<Card> builtdeck = new ArrayList<>();
        for (Card card : deck.cards) {
            card.getRank();
            if (card.getRank() == "Jack" || card.getRank() == "Queen" || card.getRank() == "King") {
                hasCorrectValue = card.getValue() == 10;

            } else if (card.getRank() == "Ace") {
                hasCorrectValue = card.getValue() == 11;

            } else hasCorrectValue = card.getValue() == Integer.parseInt(card.getRank());
//if rank is "ace" values 11v convert to number
            //else king queen jack is 10
            //else rank.twoint == value - convert string to an int
            //allranks=value boolean = true
            //else --- false
            Assertions.assertTrue(hasCorrectValue);

        }
    }
}



