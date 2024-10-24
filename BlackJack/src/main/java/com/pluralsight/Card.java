package com.pluralsight;

public class Card {
    private String suit;
    private String value;
    private boolean isFaceUp;


    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.isFaceUp = false;
    }

    public String getSuit() {
        return  isFaceUp ? suit : "#";
    }


    public String getValue() {
        return isFaceUp ? value : "#";
    }

    public int getPointValue() throws Exception {
        if (!isFaceUp) {
            throw new Exception("Can't get the value of a face down card.");
        }
        return switch (value.toLowerCase()) {
            case "2" -> 2;
            case "3" -> 3;
            case "4" -> 4;
            case "5" -> 5;
            case "6" -> 6;
            case "7" -> 7;
            case "8" -> 8;
            case "9" -> 9;
            case "10", "j", "q", "k" -> 10;
            case "a" -> 11;

            default -> throw new IllegalStateException("Unexpected value: " + value.toLowerCase());
        };
    }

    public boolean isFaceUp() {
        return this.isFaceUp;
    }

    public void flip() {
        isFaceUp = !isFaceUp;
    }

    public void displayCard() {
        System.out.println(this.value + " of " + this.suit);
    }


}
