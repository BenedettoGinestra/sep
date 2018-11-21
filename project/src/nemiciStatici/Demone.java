package nemiciStatici;

import avvio.Game;
import avvio.Handler;
import java.awt.Graphics;
import world.Assets;
import world.tiles.Tile;


public class Demone extends StaticEntity {

	public Demone(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
                
                bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 20;
		bounds.height = (int) (height - height / 1.5f);
	}
        
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.demone, (int) (x), (int) (y), width, height, null);
	}

}
