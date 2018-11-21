package world.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//STATIC STUFF HERE
	//una volta tagliate le tile dal file,non serve piu rileggere da file,sono già disponibili nel vettore
        // basta cambiare i numeri del file txt
	public static Tile[] tiles = new Tile[256];
        
        // tile per inferno
        public static Tile grassTile = new GrassTile(1);
	public static Tile rockTile = new RockTile(2);
        public static Tile magmaTile = new MagmaTile(3);
        public static Tile dirtTile = new DirtTile(4);
        public static Tile stairsTile = new StairsTile(5);
        public static Tile fontanaRossaTile = new FontanaRossaTile(6);
	public static Tile rocciaFuocoTile = new RocciaFuocoTile(7);
        // tile per paradiso
	public static Tile cloudTile0 = new Cloud0(10);
        public static Tile cloudTile1 = new Cloud1(11);
        public static Tile cloudTile2 = new Cloud2(12);
        public static Tile cloudTile3 = new Cloud3(13);
        public static Tile cloudTile4 = new Cloud4(14);
        public static Tile sky = new SkyTile(9);
	//CLASS
	
	public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public int getId(){
		return id;
	}
	
}
