package model;

public class NormalCard extends Card {

	private Symbol symbol;
	private Color color;
	
	
	
	public NormalCard(int idCard, Symbol symbol, Color color) {
		super(idCard);
		this.symbol = symbol;
		this.color = color;
	}



	public Symbol getSymbol() {
		return symbol;
	}



	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}



	public Color getColor() {
		return color;
	}



	public void setColor(Color color) {
		this.color = color;
	}



}
