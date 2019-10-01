package core;

import java.util.ArrayList;
import java.util.List;

import enums.CardType;
import objects.Card;
import objects.Deck;

public class Main {

	public static void main(String[] args) {
		//Bastos set
		List<Card> cb = Card.generate(CardType.BASTO);
		//Copas set
		List<Card> cc = Card.generate(CardType.COPA);
		//Espadas set
		List<Card> ce = Card.generate(CardType.ESPADA);
		//Oro set
		List<Card> co = Card.generate(CardType.ORO);

		List<List<Card>> cards = new ArrayList<List<Card>>();
		cards.add(cb);
		cards.add(cc);
		cards.add(ce);
		cards.add(co);
		
		//Fill deck
		Deck.fill(cards);
		
		Deck.sort();
		
		System.out.println(Deck.getOnTop());
		
	}

}
