package world;

import avvio.Handler;
import java.awt.Graphics;
import world.tiles.Tile;


public class World {
        private Handler handler;
	private int width, height; // dimensioni mappa
	private int[][] tiles; // matrice per posizionare le tiles tramite i loro ID (int)
        private int spawnX;
        private int spawnY;
	// path del file dove risiede il world
	public World(Handler handler,String path){
                this.handler=handler;
		loadWorld(path);
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
            
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
                                // converto coordinate in pixel
				getTile(x, y).render(g, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT);
			}
		}
	}
	// facciamo ritornare tile,se non lo trova ritorna rock,per non lasciare buchi nella canvas
	public Tile getTile(int x, int y){

                // tiles[x][y] prendo l'elemento(ID) e vedo che tile è
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.magmaTile; // default tile
		return t;
	}
	// prendo percorso e carico il file dentro la matrice delle posizioni
	private void loadWorld(String path){
                // carico contenuto file come stringhe
		String file = Utils.loadFileAsString(path);
                // \\s+-->spit della matrice di stringhe in caratteri individuali 
                // separati da uno spazio bianco o carattere di new line \n
                // e metto nel vettore tokens
		String[] tokens = file.split("\\s+");
                // leggo il primo numero del file.txt cioè il numero di colonne
                // che indica la larghezza della mappa
		width = Utils.parseInt(tokens[0]);
                // analogamente l'altezza
		height = Utils.parseInt(tokens[1]);
                // da dove costruire la mappa
                spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
                
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
                                // ora tutto leggo tutto dal vettore tiles,+4 perche i primi quattro posti
                                // li abbiamo letti precedentemente
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
}
