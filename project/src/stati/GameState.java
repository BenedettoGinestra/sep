package stati;

import avvio.Game;
import avvio.Handler;
import entita.Player;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import nemiciStatici.Angelo;
import nemiciStatici.Demone;
import nemiciStatici.NemicoGenerico;
import world.World;


public class GameState extends State {
	
	private Player player;
	private World world;
        //private World world2;
        private Demone demone1;
        private Demone demone2;
	private NemicoGenerico nemico;
        private Angelo angelo;
        
        
	public GameState(Handler handler){
		super(handler);
                
                world = new World(handler,"src/res/heaven.txt");//cambia qui per caricare inferno e paradiso                
                
                handler.setWorld(world);
		player = new Player(handler, 130, 300);
                // o semplicemente fare due world
                // nemici per l'inferno
                //demone1=new Demone(game, 500, 100);
                //demone2=new Demone(game, 500, 500);
                //nemico=new NemicoGenerico(game, 400, 300);
                //nemici per il paradiso
                angelo = new Angelo(handler, 400, 300);
	}
	
	@Override
	public void tick() {
		
		player.tick();
                //demone1.tick();
                //demone2.tick();
                //nemico.tick();
                //angelo.tick();
                
                handler.getWorld().tick();
                
	}

	@Override
	public void render(Graphics g) {
            
                handler.getWorld().render(g);
             
                
		player.render(g);
                //demone1.render(g);
                //demone2.render(g);
                //nemico.render(g);
                angelo.render(g);
        }
        public World getWorld(){
            return world;
        }

}
