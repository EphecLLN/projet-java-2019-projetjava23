package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Game {

	private int idGame;
	private ArrayList <Player> players = new ArrayList <Player>();
	private ArrayList <Turn> turns = new ArrayList <Turn>();
	
	private LocalDateTime startedAt ;
	private LocalDateTime endAt ;
	private Player winnerPlayer;
	private ArrayList <Card> deck = new ArrayList<Card>();
	
	
	public Game(int idGame, ArrayList<Player> players, ArrayList<Turn> turns, LocalDateTime startedAt,
			LocalDateTime endAt, Player winnerPlayer, ArrayList<Card> deck) {
		super();
		this.idGame = idGame;
		this.players = players;
		this.turns = turns;
		this.startedAt = startedAt;
		this.endAt = endAt;
		this.winnerPlayer = winnerPlayer;
		this.deck = deck;
	}


	public int getIdGame() {
		return idGame;
	}


	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}


	public ArrayList<Player> getPlayers() {
		return players;
	}


	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}


	public ArrayList<Turn> getTurns() {
		return turns;
	}


	public void setTurns(ArrayList<Turn> turns) {
		this.turns = turns;
	}


	public LocalDateTime getStartedAt() {
		return startedAt;
	}


	public void setStartedAt(LocalDateTime startedAt) {
		this.startedAt = startedAt;
	}


	public LocalDateTime getEndAt() {
		return endAt;
	}


	public void setEndAt(LocalDateTime endAt) {
		this.endAt = endAt;
	}


	public Player getWinnerPlayer() {
		return winnerPlayer;
	}


	public void setWinnerPlayer(Player winnerPlayer) {
		this.winnerPlayer = winnerPlayer;
	}


	public ArrayList<Card> getDeck() {
		return deck;
	}


	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}
	
	
	
	
	
	
}
