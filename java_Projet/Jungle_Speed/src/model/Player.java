package model;

import java.util.ArrayList;

public class Player {

	private   int idPlayer;
	private String name;
	private ArrayList <Card> cardslnHand = new ArrayList<Card>();
	private ArrayList <Card> cardslnFront = new ArrayList<Card>();
	
	
	
	public Player(int idPlayer, String name, ArrayList<Card> cardslnHand, ArrayList<Card> cardslnFront) {
		super();
		this.idPlayer = idPlayer;
		this.name = name;
		this.cardslnHand = cardslnHand;
		this.cardslnFront = cardslnFront;
	}

	public Player(int idPlayer, String name, Card[] cardslnHand, Card[] cardslnFront) {
		super();
		this.idPlayer = idPlayer;
		this.name = name;
		
		for(int i = 0; i < cardslnHand.length; i++) {
			this.cardslnHand.add(cardslnHand[i]);
		}
		for(int i = 0; i < cardslnFront.length; i++) {
			this.cardslnFront.add(cardslnFront[i]);
		}
	}


	public int getIdPlayer() {
		return idPlayer;
	}



	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public ArrayList<Card> getCardslnHand() {
		return cardslnHand;
	}



	public void setCardslnHand(ArrayList<Card> cardslnHand) {
		this.cardslnHand = cardslnHand;
	}



	public ArrayList<Card> getCardslnFront() {
		return cardslnFront;
	}



	public void setCardslnFront(ArrayList<Card> cardslnFront) {
		this.cardslnFront = cardslnFront;
	}



	public Player() {
		// TODO Auto-generated constructor stub
	}

}
