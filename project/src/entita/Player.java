package entita;

import avvio.Game;
import avvio.Handler;
import design.PauseMenu;
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import stati.GameState;
import world.Assets;
import world.World;



public class Player extends Creature {

    private World world2;

	
	public Player(Handler handler, float x, float y) {
		super(handler,x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
                world2=new World(handler,"src/res/hell.txt");
	}

	public void tick() {
		getInput();
		move();
                ceckworld();
                // ora per non far andare fuori dalla mappa,ma da migliorare
                // con collision detection sul magma
//                if(x<=0)
//                    x=0;
//                if(x>=game.width-32)
//                    x=game.width-32;
//                if(y<=0)
//                    y=0;
//                if(y>=game.height-32)
//                    y=game.height-32;
                 
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
                    
			xMove = speed;
                        
                if(handler.getKeyManager().space)
			flag = true;
                if(handler.getKeyManager().p){
                    
                    //PauseMenu pause = new PauseMenu();
                    
                    System.out.println("Player Paused");
                    handler.getGame().pause();
                    try {
                        Thread.sleep(10000);
                        //pause.setLocation(300,110);
                        //pause.setVisible(true);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                
                
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
        }

   private void ceckworld() {
               // System.out.println("verifico se hai premuto:");
               // System.out.println(flag);
                if(flag){
                   // System.out.println(handler.getWorld());
                    //devo riposizionare player vicino alle scale
                    
                    handler.setWorld(world2);
                    
                }
    }

}
