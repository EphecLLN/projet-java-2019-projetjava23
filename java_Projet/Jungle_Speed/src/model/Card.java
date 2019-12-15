package model;

public class Card {
	private int idCard;

	public Card(int idCard) {
		super();
		this.idCard = idCard;
	}

	public int getIdCard() {
		return idCard;
	}

	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}
	
	public static final Card CARTE_1 = new NormalCard(0, Symbol.symbol1, Color.JAUNE);
	
	
	
	

}
