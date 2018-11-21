package nemiciStatici;

import avvio.Game;
import avvio.Handler;
import java.awt.Graphics;
import world.Assets;
import world.tiles.Tile;


public class NemicoGenerico extends StaticEntity {

	public NemicoGenerico(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
	}
        
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.nemico, (int) (x), (int) (y), width, height, null);
	}

}
