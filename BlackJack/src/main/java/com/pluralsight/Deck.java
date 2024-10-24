package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    public ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts","Spades","Diamonds","Clubs"};
        String[] values = {"2","3","4","5","6","7","8",
                "9","10","J","Q","K","A"};

        for(String suit: suits) {
            for(String value: values){
                Card card = new Card(suit, value);
                cards.add(card);
            }
        }
    }

    public Card deal() {
        return cards.isEmpty() ? null : cards.remove(0);
    }

    public int getSize() {
        return cards.size();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }


}
