package model;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
	 // créer les 72 cartes normales 
		
		Game g = new Game(0, null, null, null, null, null, new ArrayList<Card>());
		for(int i = 0; i < Color.getColorList().size(); i++) {
			
			for(int y = 0; y < Symbol.getSymbolList().size(); y++) {
				Card c = new NormalCard(g.getDeck().size(), Symbol.getSymbolList().get(y), Color.getColorList().get(i));
				
				g.getDeck().add(c);
				
			}
		}
		
		for(int i = 0;i < 2; i ++) {
			Card c = new SpecialCard(g.getDeck().size(), "MULTI_COLOR", "Multi couleur", Image.image1);
			g.getDeck().add(c);
		}
		for(int i = 0;i < 3; i ++) {
			Card c = new SpecialCard(g.getDeck().size(), "INTERIOR", "Flèches intérieures", Image.image1);
			g.getDeck().add(c);
		}
		for(int i = 0;i < 3; i ++) {
			Card c = new SpecialCard(g.getDeck().size(), "EXTERIOR", "Flèches extérieures", Image.image1);
			g.getDeck().add(c);
		}
		
		//System.out.println(g.getDeck().size());
		//System.out.println(g.getDeck().toString());
	}

}
