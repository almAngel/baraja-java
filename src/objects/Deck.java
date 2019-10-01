package objects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Deck {
	
	static Map<Integer, Card> body = new HashMap<Integer, Card>();
	
	public static void sort() {
		int[] sortPosition = new int[48];
		Map<Integer, Card> result = new HashMap<Integer, Card>();
		
		for(int i = 0; i < sortPosition.length; i++) {
			sortPosition[i] = (int)Math.round(Math.random() * 48) + 1;
		}

		for (int i = 0; i < sortPosition.length; i++) {
			result.put(sortPosition[i], Deck.body.get(i));
		}
		
		result.entrySet().forEach(entry -> {
			System.out.println(entry);
		});
		
	}
	
	public static Card getOnTop() {
		Card result = null;
		
		result = Deck.body.get(Deck.body.size());
		
		return result;
	}
	
	public static void fill(List<List<Card>> cards) {
		Map<Integer, Card> result = new HashMap<Integer, Card>();
		
		int aux = 0;
		for (int i = 0; i < cards.size(); i++) {
			for(int j = 0; j < 12; j++) {
				aux++;
				result.put(aux, cards.get(i).get(j));
			}
		}
		
		Deck.body = result;
	}
	
}