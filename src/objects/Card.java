package objects;

import java.util.ArrayList;
import java.util.List;

import enums.CardAssociation;
import enums.CardType;

public class Card {

	int value;
	CardType type;
	CardAssociation association;

	Card() {
	}

	Card(int v, CardType t, CardAssociation a) {
		this.value = v;
		this.type = t;
		this.association = a;
	}

	public static List<Card> generate(CardType t) {
		List<Card> cardList = new ArrayList<Card>();
		
		for (int i = 1; i <= 12; i++) {
			
			if(i == 1) {
				cardList.add(new Card(i, t, CardAssociation.AS));
			} else if(i == 10) {
				cardList.add(new Card(i, t, CardAssociation.SOTA));
			} else if(i == 11) {
				cardList.add(new Card(i, t, CardAssociation.CABALLO));
			} else if(i == 12) {
				cardList.add(new Card(i, t, CardAssociation.REY));
			} else {
				cardList.add(new Card(i, t, CardAssociation.COMMON));
			}
		}
		
		return cardList;
	}

	@Override
	public String toString() {
		return "Card [value=" + value + ", type=" + type + ", association=" + association + "]";
	}

}
