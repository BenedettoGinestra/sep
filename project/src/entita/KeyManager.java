package entita;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeyManager implements KeyListener, Runnable {
	
	private boolean[] keys;
	public boolean up, down, left, right,space,p;
	
	public KeyManager(){
		keys = new boolean[256];
                new Thread(this).start();
	}
	


	@Override
	public void keyPressed(KeyEvent e) {
            System.out.println("pressed");
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("Ciao");
	}
        
        public static void main(String[] args) {
            KeyManager km  = new KeyManager();
            while(true) {
                System.out.println(km.p);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(KeyManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    @Override
    public void run() {
        while(true) {
            up = keys[KeyEvent.VK_W];
            down = keys[KeyEvent.VK_S];
	    left = keys[KeyEvent.VK_A];
	    right = keys[KeyEvent.VK_D];
            space = keys[KeyEvent.VK_SPACE];
            p = keys[KeyEvent.VK_P];
        }
     }

}
