package core;

import java.util.ArrayList;
import java.util.List;

import enums.CardType;
import objects.Card;
import objects.Deck;

public class Main {

	// TEST
	public static void main(String[] args) {

		// Bastos set
		List<Card> cb = Card.generate(CardType.BASTO);
		// Copas set
		List<Card> cc = Card.generate(CardType.COPA);
		// Espadas set
		List<Card> ce = Card.generate(CardType.ESPADA);
		// Oro set
		List<Card> co = Card.generate(CardType.ORO);

		List<List<Card>> cards = new ArrayList<List<Card>>();

		cards.add(cb);
		cards.add(cc);
		cards.add(ce);
		cards.add(co);

		// Fill deck
		Deck.fill(cards);

		// Shuffle deck
		Deck.shuffle();

		// Print deck
		Deck.showDeck();

		// Get the card on top of the deck
		Deck.giveOnTop();

		// Get X cards taking them from top of the deck
		Deck.giveFromTop(49);

		// Print stack (given cards)
		Deck.showStack();

		// Show available count in our deck
		Deck.available();
		
		// Show all cards remaining inside our deck
		Deck.showDeck();

		// Show all cards inside the pile of given cards
		Deck.stackSize();
	}

}
