
package soudocko;

import java.io.File;
import javax.swing.*;


public class Setting extends javax.swing.JFrame
{

   private static String kindlevel = "easy";
   private JLabel mainpanelphoto;

    public Setting() 
    {
        initComponents();
        setSize(700, 700);
        setTitle("settig");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        mainpanel.setSize(700, 700);
        String urlimage = new File("ice.jpg").toURI().toString();
        urlimage = urlimage .substring(5);
        mainpanelphoto = new JLabel(new ImageIcon(urlimage));
        mainpanelphoto.setBounds(0, 0,700, 700);
        mainpanel.add(mainpanelphoto);
      
        if(Setting.kindlevel.equals("easy"))
        {
            kindlevellabel.setText("Your state is easy.");
        }else if(Setting.kindlevel.equals("normal"))
        {
            kindlevellabel.setText("Your state is normal.");
        }else if(Setting.kindlevel.equals("hard"))
        {
            kindlevellabel.setText("Your state is hard.");
        }
    }
    public void setlevel(String level)
    {
        this.kindlevel = level;
    }
    public static String getlevel()
    {
        return Setting.kindlevel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        Settinglabel = new javax.swing.JLabel();
        hard = new javax.swing.JButton();
        Normal = new javax.swing.JButton();
        kindlevellabel = new javax.swing.JLabel();
        returntomainmenue = new javax.swing.JButton();
        gotoplay = new javax.swing.JButton();
        easy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Settinglabel.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        Settinglabel.setForeground(new java.awt.Color(0, 102, 102));
        Settinglabel.setText("Level  :");

        hard.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        hard.setForeground(new java.awt.Color(0, 102, 102));
        hard.setText("Hard");
        hard.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        hard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hardActionPerformed(evt);
            }
        });

        Normal.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        Normal.setForeground(new java.awt.Color(0, 102, 102));
        Normal.setText("NORMal");
        Normal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Normal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NormalActionPerformed(evt);
            }
        });

        kindlevellabel.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        kindlevellabel.setForeground(new java.awt.Color(0, 102, 102));
        kindlevellabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kindlevellabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        returntomainmenue.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        returntomainmenue.setForeground(new java.awt.Color(0, 102, 102));
        returntomainmenue.setText(" menue");
        returntomainmenue.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        returntomainmenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returntomainmenueActionPerformed(evt);
            }
        });

        gotoplay.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        gotoplay.setForeground(new java.awt.Color(0, 102, 102));
        gotoplay.setText("Go to play");
        gotoplay.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gotoplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gotoplayActionPerformed(evt);
            }
        });

        easy.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        easy.setForeground(new java.awt.Color(0, 102, 102));
        easy.setText("Easy");
        easy.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        easy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                easyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(Settinglabel)
                .addContainerGap(552, Short.MAX_VALUE))
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(kindlevellabel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(mainpanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(Normal, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainpanelLayout.createSequentialGroup()
                            .addGap(286, 286, 286)
                            .addComponent(hard, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(returntomainmenue, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gotoplay, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainpanelLayout.createSequentialGroup()
                    .addGap(284, 284, 284)
                    .addComponent(easy, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(285, Short.MAX_VALUE)))
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(Settinglabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addComponent(Normal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(hard, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(kindlevellabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returntomainmenue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gotoplay, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
            .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainpanelLayout.createSequentialGroup()
                    .addGap(134, 134, 134)
                    .addComponent(easy, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(520, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NormalActionPerformed
        kindlevel = "normal";
        kindlevellabel.setText("Your state is NORMAL.");
    }//GEN-LAST:event_NormalActionPerformed

    private void hardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hardActionPerformed
        kindlevel = "hard";
        kindlevellabel.setText("Your state is HARD.");
    }//GEN-LAST:event_hardActionPerformed

    private void gotoplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gotoplayActionPerformed
        Play_ player = new Play_();
         player.setVisible(true);
         dispose();
    }//GEN-LAST:event_gotoplayActionPerformed

    private void returntomainmenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returntomainmenueActionPerformed
        Game player = new Game();
         player.setVisible(true);
         dispose();
    }//GEN-LAST:event_returntomainmenueActionPerformed

    private void easyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_easyActionPerformed
        kindlevel = "easy";
        kindlevellabel.setText("Your state is EASY.");
    }//GEN-LAST:event_easyActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Setting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Normal;
    private javax.swing.JLabel Settinglabel;
    private javax.swing.JButton easy;
    private javax.swing.JButton gotoplay;
    private javax.swing.JButton hard;
    private javax.swing.JLabel kindlevellabel;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JButton returntomainmenue;
    // End of variables declaration//GEN-END:variables
}
