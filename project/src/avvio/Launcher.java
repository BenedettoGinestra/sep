package avvio;

import entita.Player;
import design.Menu;


public class Launcher {


	public static void main(String[] args){
                // c' era Game game=new Game(); e game.start();
                Menu menu = new Menu();
                menu.setSize(832, 640);
                menu.setLocation(300, 40);
                menu.setVisible(true);
		
	}
	
}
