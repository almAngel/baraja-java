package objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Deck {

	// FIXED SIZE
	private static final int size = 48;

	// ALL CARDS
	public static Map<Integer, Card> body = new HashMap<Integer, Card>();

	// GIVEN CARDS
	private static List<Card> stack = new ArrayList<Card>();

	public static void shuffle() {
		List<Integer> sortPosition = new ArrayList<Integer>();
		Map<Integer, Card> result = new HashMap<Integer, Card>();
		int rn = 0;

		/*
		 * LA RAZÓN POR LA QUE SE GENERAN LAS POSICIONES ALEATORIAS ANTES ES PORQUE ES
		 * MÁS EFICIENTE PARA LA MÁQUINA HACERLO POR PARTES QUE MOVER UNA A UNA
		 */

		// Fill random position array until array's size equals fixed size (48)
		while (sortPosition.size() < size) {
			rn = (int) Math.round(Math.random() * 47) + 1;
			if (!sortPosition.contains(rn)) {
				sortPosition.add(rn);
			}
		}

		// Make new deck with our new arrangement
		if (Deck.body.size() > 0) {
			for (int i = 0; i < sortPosition.size(); i++) {
				result.put(i + 1, Deck.body.get(sortPosition.get(i)));
			}
		} else {
			System.out.println("\nERROR: COULD NOT RE-SHUFFLE OUR DECK. NOT ENOUGH CARDS INSIDE IT");
		}

		// Assign new content
		body = result;
	}

	// Give card on top of the deck, then move it to the stack
	public static Card giveOnTop() {
		Card result = null;

		// Get last card
		result = Deck.body.get(Deck.body.size());
		Deck.body.remove(Deck.body.size());
		Deck.stack.add(result);

		System.out.println("GIVEN CARD:\n" + result + "\n");

		return result;
	}

	public static void available() {
		System.out.println("Available cards: " + Deck.body.size() + "\n");
	}

	public static void stackSize() {
		System.out.println("Stack size: " + Deck.stack.size() + "\n");
	}

	// Returns {quantity} cards from the top of the deck, then move them to the
	// stack
	public static List<Card> giveFromTop(int quantity) {
		List<Card> result = new ArrayList<Card>();

		if (Deck.body.size() >= quantity) {
			while (result.size() < quantity) {
				int i = Deck.body.size();
				
				// Add
				result.add(Deck.body.get(i));

				// Remove from deck
				Deck.body.remove(i);
			}

			System.out.println("GIVEN " + quantity + ":");

			result.forEach(item -> {
				System.out.println(item);
			});

			Deck.stack.addAll(result);

		} else {
			System.out.println("\nERROR: NOT ENOUGH CARDS INSIDE OUR DECK TO RETURN REQUESTED VALUES \n");
		}

		return result;
	}

	// Fill our deck body, which contains every card
	public static void fill(List<List<Card>> cards) {
		Map<Integer, Card> result = new HashMap<Integer, Card>();

		if (cards.size() > 0) {
			int aux = 0;
			for (int i = 0; i < cards.size(); i++) {
				if (cards.get(i).size() > 0) {
					for (int j = 0; j < 12; j++) {
						aux++;
						result.put(aux, cards.get(i).get(j));
					}
				} else {
					System.out.println("\nERROR: NO CARDS INSIDE " + i + " CARD SET");
				}
			}
		} else {
			System.out.println("\nERROR: NO CARDS FOR FILLING OUR DECK \n");
		}

		Deck.body = result;
	}

	public static void showStack() {
		if (Deck.stack.size() > 0) {
			System.out.println("\nSTACK: ");
			Deck.stack.forEach(item -> {
				System.out.println(item);
			});
			System.out.println("----------------------------------------------------END OF STACK\n");
		} else {
			System.out.println("\nERROR: NO CARDS ON STACK \n");
		}
	}

	public static void showDeck() {
		if (Deck.body.size() > 0) {
			System.out.println("\nDECK: ");
			Deck.body.entrySet().forEach(item -> {
				System.out.println(item);
			});
			System.out.println("----------------------------------------------------END OF DECK\n");
		} else {
			System.out.println("\nERROR: NO CARDS ON DECK \n");
		}
	}
}