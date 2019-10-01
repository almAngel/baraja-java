package enums;

public enum CardAssociation {
	COMMON(0),
	AS(1),
	SOTA(10),
	CABALLO(11),
	REY(12);
	
	int index;
	
	CardAssociation(int i) {
		this.index = i;
	}
	
	public static CardAssociation getAssociationByIndex(int i) {
		return CardAssociation.values()[i];
	}
}
