/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import java.util.*;

/**
 *
 * @author patrickhebert
 */
public class GameOfWar {

    private ArrayList<Card> p1Hand;
    private ArrayList<Card> p2Hand;

    // This is the constructor
    public GameOfWar() {
        p1Hand = new ArrayList<>();
        p2Hand = new ArrayList<>();

        DeckOfCards theDeck = new DeckOfCards();

        theDeck.shuffle();

        dealCards(theDeck);
    }

    /**
     * This method will deal all the cards in the deck equally divided between
     * each player.
     */

    private void dealCards(DeckOfCards theDeck) {
        for (int cardNum = 0; cardNum < 52; cardNum++) {
            if (cardNum % 2 == 0) {
                p1Hand.add(theDeck.dealTopCard());
            } else {
                p2Hand.add(theDeck.dealTopCard());
            }
        }
    }

    public void playTheGame() {
        while (!p1Hand.isEmpty() && !p2Hand.isEmpty()) {
            playHand();

        }
        if (p1Hand.isEmpty()) {
            System.out.println("Player 2 Wins!!");
        } else if (p2Hand.isEmpty()) {
            System.out.println("Player 1 Wins!!");
        }

    }

    private void playHand() {
        if (p1Hand.isEmpty() || p2Hand.isEmpty()) {
            return;
        }
        Card p1Card = p1Hand.remove(0);
        Card p2Card = p2Hand.remove(0);

        if (p1Card.getFaceValue() > p2Card.getFaceValue()) {
            p1Hand.add(p1Card);
            p2Hand.add(p2Card);
        } else if (p2Card.getFaceValue() > p1Card.getFaceValue()) {
            p1Hand.add(p1Card);
            p2Hand.add(p2Card);
        } else {
            ArrayList<Card> warPile = new ArrayList<>();
            warPile.add(p1Card);
            warPile.add(p2Card);
            playWarHand(warPile);
        }
    }

    /**
     * This method simulates playing a War hand
     */
    private void playWarHand(ArrayList<Card> warPile) {
        if (p1Hand.size() < 3) {
            p2Hand.addAll(p1Hand);
            p1Hand.clear();
            p2Hand.addAll(warPile);
            return;
        } else if (p2Hand.size() < 3) {
            p1Hand.addAll(p1Hand);
            p2Hand.clear();
            p1Hand.addAll(warPile);
            return;
        }

        warPile.add(p1Hand.remove(0));
        warPile.add(p1Hand.remove(0));
        Card p1Card = p1Hand.remove(0);

        warPile.add(p2Hand.remove(0));
        warPile.add(p2Hand.remove(0));
        Card p2Card = p2Hand.remove(0);
        
        if (p1Card.getFaceValue() > p2Card.getFaceValue())
        {
            p1Hand.addAll(warPile);
            p1Hand.add(p1Card);
            p1Hand.add(p2Card);
            
        }
        else if (p2Card.getFaceValue() > p1Card.getFaceValue())
        {
            p2Hand.addAll(warPile);
            p2Hand.add(p1Card);
            p2Hand.add(p2Card);
            
        }
        
        else
        {
            warPile.add(p1Card);
            warPile.add(p2Card);
            playWarHand(warPile);
        }

    }
}
