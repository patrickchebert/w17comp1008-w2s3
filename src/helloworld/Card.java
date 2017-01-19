/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

/**
 *
 * @author patrickhebert
 */
public class Card {
    private String faceName, suit;
    private int faceValue;
    
    public Card(String faceName, String suit, int faceValue){
        this.faceName = faceName;
        setSuit(suit);
        setFaceValue(faceValue);
    }
    
    // This method will validate that the argument is a valid suit
    private void setSuit(String suit){
        if (suit.equalsIgnoreCase("hearts") || suit.equalsIgnoreCase("diamonds") 
                || suit.equalsIgnoreCase("spades")  || suit.equalsIgnoreCase("clubs"))
            this.suit = suit;
            else
            throw new IllegalArgumentException("Suit must be hearts, diamonds, spades or clubs");
            
    }
    private void setFaceValue(int value)
    {
        if (value >=2 && value <=14)
            faceValue = value;
        else
            throw new IllegalArgumentException("card must have a value between 2-14");
    }
    
    // This method will return a String to represent the card
    
    @Override
    public String toString()
    {
        return faceName + " of " + suit;
    }

    public String getFaceName() {
        return faceName;
    }

    public String getSuit() {
        return suit;
    }

    public int getFaceValue() {
        return faceValue;
    }
    
    
        
}
