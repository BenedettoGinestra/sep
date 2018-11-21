package world.tiles;

import world.Assets;


public class MagmaTile extends Tile {

	public MagmaTile(int id) {
		super(Assets.magma, id);
	}
        @Override
        public boolean isSolid(){
		return true;
	}
}
