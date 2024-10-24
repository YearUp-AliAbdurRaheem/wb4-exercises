package com.pluralsight;

import com.pluralsight.utils.Console;

public class Main {
    public static void main(String[] args) {


        Deck deck = new Deck();
        deck.shuffle();

        Hand dealerHand = new Hand();
        Hand playerHand = new Hand();

        System.out.println("Welcome to BlackJack!");
        String playerName = Console.PromptForString("Enter your name: ");

        System.out.println("Dealing cards, 2 per player.");

        Card dealerCard1 = deck.deal();
        Card dealerCard2 = deck.deal();

        Card playerCard1 = deck.deal();
        Card playerCard2 = deck.deal();

//        dealerCard1.flip();
//        System.out.println(dealerCard1.getValue() + " of " + dealerCard1.getSuit());

        dealerHand.dealCard(dealerCard1);
        dealerHand.dealCard(dealerCard2);

        dealerHand.displayHand();



    }
}