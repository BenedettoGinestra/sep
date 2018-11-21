package nemiciStatici;

import avvio.Game;
import avvio.Handler;
import entita.Entity;



public abstract class StaticEntity extends Entity {
	
	public StaticEntity(Handler handler, float x, float y, int width, int height){
		super(handler,x, y, width, height);
	}

}
