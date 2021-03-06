/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import avvio.Game;
import avvio.Handler;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import stati.GameState;

/**
 *
 * @author donatellapasquale
 */
public class PauseMenu
        extends javax.swing.JFrame
        implements Runnable {

    private GameState gamestate;

    private Thread thread;
    private Boolean running;
    
    private Object obj = new Object();
    private Game game;
    public PauseMenu(Game game) {
        initComponents();
        button1.setBackground(new Color(0, 0, 0, 0));
        button2.setBackground(new Color(0, 0, 0, 0));
        thread = new Thread(this);
        running = true;
        this.game = game;

        new Thread(this).start();
        System.out.println("Thread start pause");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(600, 350));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Luminari", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pause Menu");
        jLabel1.setEnabled(false);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        button1.setBackground(new java.awt.Color(255, 255, 255));
        button1.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        button1.setForeground(java.awt.Color.red);
        button1.setLabel("Resume");
        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button1MouseClicked(evt);
            }
        });
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        getContentPane().add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 120, 60));

        button2.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        button2.setForeground(java.awt.Color.red);
        button2.setLabel("Exit");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        getContentPane().add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 120, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/sfondoPausa.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
            running = false;
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // JButton exit = new JButton();
        //  this.setVisible(false);

    }//GEN-LAST:event_button2ActionPerformed

    private void button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseClicked
            synchronized(obj) { running = false; obj.notifyAll();}
        System.out.println("clicked");
    }//GEN-LAST:event_button1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        
        synchronized(obj)
        {
            while (running) {
                try {obj.wait();} catch(Exception ex) {}
        }

            game.resume();
            this.dispose();
    }
        }

    public PauseMenu getThread() {
        return this;
    }
}


