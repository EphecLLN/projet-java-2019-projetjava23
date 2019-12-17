package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import model.Main;

public class Server {

	private static ListenServer scanner;
	private static Thread scan;

	public static void main(String[] args) {
		// socket du serveur

		ServerSocket socket;

		try { // creation du nouveau socket
			socket = new ServerSocket(2023);

			// creation du nouveau thread pour la recolte d'information

			Thread t = new Thread(new Connexion(socket));
			t.start();
			scanner = new ListenServer(socket);
			Server.setScanner(scanner);
			Main.print("Serveur lancé");
			Main.print("Attente de la connexion des joueurs");

			scan = new Thread(scanner);
			Server.setScan(scan);
		} catch (IOException e) {
		}
	}

	/**
	 * @return the scanner
	 */
	public static ListenServer getScanner() {
		return scanner;
	}

	/**
	 * @param scanner the scanner to set
	 */
	public static void setScanner(ListenServer scanner) {
		Server.scanner = scanner;
	}

	/**
	 * @return the scan
	 */
	public static Thread getScan() {
		return scan;
	}

	/**
	 * @param scan the scan to set
	 */
	public static void setScan(Thread scan) {
		Server.scan = scan;
	}

}

class Connexion implements Runnable {

	private ServerSocket server;
	private Socket client;
	private int playerNum = 1;
	private BufferedReader in = null;
	private PrintWriter out = null;

	public Connexion(ServerSocket server) {

		this.server = server;
	}

	@Override
	public void run() {
		try {
			while (true) {
				client = server.accept();
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				out = new PrintWriter(client.getOutputStream());

				if (playerNum == 1) {
					Server.getScan().start();

				}

				this.initialization(playerNum);
				Server.getScanner().getSocketClientList().add(client);
				Main.print("Client connecté (" + playerNum + ")");

				if (playerNum == 5) {
					Server.getScanner().initIn();
					Server.getScanner().initOut();
					Main.print(Server.getScanner().getSocketClientList().size() + "");
					Main.print(Server.getScanner().getIn().size() + "");
					Main.print(Server.getScanner().getOut().size() + "");
					// Server.getScanner().start("0", "start");

				}
				playerNum++;

			}
		} catch (IOException e) {

		}
	}

	public void initialization(int number) {

		int nb = number - 1;
		out.println("" + nb);
		out.println("Vous êtes assigné au joueur " + number);
		out.flush();
	}

}
