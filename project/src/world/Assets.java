package world;


import java.awt.image.BufferedImage;


public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage player,nemico,demone,angelo,cloud0,
                cloud1,cloud2,cloud3,cloud4,sky,grass,
                stone, tree,dirt,magma,stairs,fontanaRossa,rocciaFuoco;

	public static void init(){
            
		SpriteSheet sheetHell = new SpriteSheet(ImageLoader.loadImage("/res/hell.png"));
                SpriteSheet sheetHeaven = new SpriteSheet(ImageLoader.loadImage("/res/heaven.png"));
                SpriteSheet sheetSky = new SpriteSheet(ImageLoader.loadImage("/res/h.png"));

                SpriteSheet sheetDante = new SpriteSheet(ImageLoader.loadImage("/res/dante.png"));
                
                // giocatore
                player = sheetDante.crop(0, 0, 24, 32);
                
                
	        //tiles per paradiso,i primi 4 sono gli angoli della nuvola
                cloud1 = sheetHeaven.crop(0, 0, width, height);
                cloud2 = sheetHeaven.crop(0 , height, width, height);
                cloud3 = sheetHeaven.crop(width , 0, width, height);//angolo in alto a sinistra
                cloud4 = sheetHeaven.crop(width , height, width, height);
                // nuvola centrale
                cloud0 = sheetSky.crop(0, height, width*2, height*2);
		grass = sheetHell.crop(width * 4, 0, width, height);
                sky = sheetSky.crop(0, 0, width/2, height/2);
                
		// inferno
                stone = sheetHell.crop(width * 3, 0, width, height);
		tree = sheetHell.crop(0, height, width, height);
                
                magma = sheetHell.crop(width * 7, height*9, width, height);
                dirt = sheetHell.crop(width * 6, height*2, width, height);
                stairs =sheetHell.crop(width * 2, height * 3, width, height);
                fontanaRossa=sheetHell.crop(0, 0, width, height);
                rocciaFuoco =sheetHell.crop(width * 3, height * 2, width, height);
                
                
                // nemici
                demone =sheetHell.crop(width*1, height*5, width, height);
                nemico =sheetHell.crop(width*6, height*4, width, height);
                angelo =sheetHell.crop(width*3, height*4, width, height);
                
	}
	
}
