
package soudocko;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Game extends javax.swing.JFrame 
{
    private JLabel background;
     JProgressBar pb;
     int i=0;
     int num =0;
    public Game() 
    {
        initComponents();
        //loading();
        setSize(700, 700);
        setTitle("sudoko game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        container.setSize(700, 700);
        String urlimage = new File("sd2.jpg").toURI().toString();
        urlimage = urlimage .substring(5);
        
        background = new JLabel(new ImageIcon(urlimage));
        background.setBounds(0, 0,700, 700);
        container.add(background);
    }
    public void loading()
    {
        pb = new JProgressBar(0,1000);
        pb.setValue(0);
        pb.setBounds(10, 10, 560, 20);
        pb.setStringPainted(true);
        this.add(pb);
        add(pb);
        this.setLayout(null);
        this.setSize(600, 80);
        this.setTitle("Loading");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
       this.setVisible(true);
        counts();
    }
     public void counts()
    {
        while(i<=1000)
        {
            pb.setValue(i);
            i = i+ 10;
            
            try {
                Thread.sleep(30);
               
            } catch (InterruptedException ex) {
               
            }
            
        }
        dispose();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        setting = new javax.swing.JButton();
        play4 = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        scores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setting.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        setting.setForeground(new java.awt.Color(0, 102, 102));
        setting.setText("Setting");
        setting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingActionPerformed(evt);
            }
        });

        play4.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        play4.setForeground(new java.awt.Color(0, 102, 102));
        play4.setText("Play");
        play4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                play4ActionPerformed(evt);
            }
        });

        exit.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 51, 51));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        scores.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        scores.setForeground(new java.awt.Color(0, 102, 102));
        scores.setText("Topscore");
        scores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(setting, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(play4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addComponent(scores, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(play4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 517, Short.MAX_VALUE)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scores, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setting, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    // if user want to exit
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Are You Sure that Exit ! ");
            if (x == 0) {
                System.exit(0);
            }
    }//GEN-LAST:event_exitActionPerformed

    private void play4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_play4ActionPerformed
        Play_ player = new Play_();
         player.setVisible(true);
         dispose();
    }//GEN-LAST:event_play4ActionPerformed

    private void scoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoresActionPerformed
        Highscores player = new Highscores();
         player.setVisible(true);
         dispose();
    }//GEN-LAST:event_scoresActionPerformed

    private void settingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingActionPerformed
       Setting player = new Setting();
       player.setVisible(true);
       
         dispose();
    }//GEN-LAST:event_settingActionPerformed

    
    public static void main(String args[]) 
    {
       
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JButton exit;
    private javax.swing.JButton play4;
    private javax.swing.JButton scores;
    private javax.swing.JButton setting;
    // End of variables declaration//GEN-END:variables
}
