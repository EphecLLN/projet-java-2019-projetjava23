package model;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

import controller.Controller;
import sockets.ListenClient;
import view.ConsoleView;
import view.Gui;
import view.View;

public class Main {
	public static Game g;
	public static Controller controller;
	public static View vue;
	public static Gui frame;
	public static Timer timer;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Game g = new Game(0, LocalDateTime.now());
		Main.g = g;

		Player p1 = new Player(0, "joel");
		Player p2 = new Player(1, "nadia");
		Player p3 = new Player(2, "adele");
		Player p4 = new Player(3, "joacyn");
		Player p5 = new Player(4, "cedric");

		Main.buildDeck(g);
		g.getPlayers().add(p1);
		g.getPlayers().add(p2);
		g.getPlayers().add(p3);
		g.getPlayers().add(p4);
		g.getPlayers().add(p5);

		Main.distrbute(g);
		g.builLink();

		controller = new Controller(p1);
		vue = new ConsoleView(p1, controller);
		controller.addView(vue);
		frame = new Gui(p1, controller);
		frame.setVisible(true);

		timer = new Timer();
		// timer.start();

		// connexion du client

		Thread listenClient = null;
		try {
			Socket socket = new Socket(InetAddress.getLocalHost(), 2023);
			listenClient = new Thread(new ListenClient(socket));
			listenClient.start();

		} catch (UnknownHostException e) {

		} catch (IOException e) {

		}

	}

	public static String now() {
		return "[" + LocalTime.now() + "] ";
	}

	/**
	 * <u><b>Méthode utilitaire</u></b>
	 * <hr>
	 * <i>Facilite l'utilisation de l'output de la console</i>
	 * <hr>
	 * <br>
	 * 
	 * @param text
	 */
	public static void print(String text) {
		System.out.println(text);
	}

	/**
	 * <u><b>Méthode d'initialisation</u></b>
	 * <hr>
	 * 
	 * <i>Permet de distribuer les cartes créees entre les joueurs.</i>
	 * <hr>
	 * <br>
	 * 
	 * @param g
	 */
	public static void distrbute(Game g) {

		int cardNumber = 80 / g.getPlayers().size();

		for (int i = 0; i < g.getPlayers().size(); i++) {

			while (g.getPlayers().get(i).getCardslnHand().size() < cardNumber) {
				Random r = new Random();
				int select = r.nextInt(g.getDeck().size());
				Card c = g.getDeck().get(select);
				g.getPlayers().get(i).getCardslnHand().add(c);
				g.getDeck().remove(select);
			}
		}
		g.getTrash().addAll(g.getDeck());
		g.getDeck().clear();
	}

	/**
	 * <u><b>Méthode d'initialisation</u></b>
	 * <hr>
	 * 
	 * <i>Appelée lorsque le jeu est lancé, elle permet de créer les cartes</i>
	 * <hr>
	 * <br>
	 * 
	 * @param g <i> Partie où les cartes seront ajoutées</i>
	 */
	public static void buildDeck(Game g) {

		// creer les 72 cartes normales

		for (int i = 0; i < Color.getColorList().size(); i++) {

			for (int y = 0; y < Symbol.getSymbolList().size(); y++) {
				Card c = new NormalCard(g.getDeck().size(), Symbol.getSymbolList().get(y), Color.getColorList().get(i));

				g.getDeck().add(c);

			}
		}
		// creer les 8 cartes spéciaux
		for (int i = 0; i < 2; i++) {
			Card c = new SpecialCard(g.getDeck().size(), "MULTI_COLOR", "Multi couleur", Image.image1);
			g.getDeck().add(c);
		}
		for (int i = 0; i < 3; i++) {
			Card c = new SpecialCard(g.getDeck().size(), "INTERIOR", "Flèches intérieures", Image.image1);
			g.getDeck().add(c);
		}
		for (int i = 0; i < 3; i++) {
			Card c = new SpecialCard(g.getDeck().size(), "EXTERIOR", "Flèches extérieures", Image.image1);
			g.getDeck().add(c);
		}

	}
}
