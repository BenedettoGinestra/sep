package stati;

import avvio.Game;
import avvio.Handler;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import world.Assets;
import static world.tiles.Tile.TILEHEIGHT;
import static world.tiles.Tile.TILEWIDTH;


public class MenuState extends State {

	public MenuState(Handler handler){
		super(handler);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
                g.drawImage(Assets.magma, 0, 0, TILEWIDTH, TILEHEIGHT, null);

                //JOptionPane.showInputDialog("svsvs");
                //Menu m= new Menu();
                //m.setVisible(true);
	}
	
}
