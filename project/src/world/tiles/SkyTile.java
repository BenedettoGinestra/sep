package world.tiles;

import world.Assets;


public class SkyTile extends Tile {

	public SkyTile(int id) {
		super(Assets.sky, id);
	}
        @Override
        public boolean isSolid(){
		return true;
	}
}
