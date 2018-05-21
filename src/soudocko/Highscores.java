
package soudocko;

import java.io.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class Highscores extends javax.swing.JFrame 
{
    private JLabel  mainpanelphoto;
    
    public Highscores() 
    {
        initComponents();
        setSize(700, 700);
        setTitle("Scores");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        scorespanel.setSize(700, 700);
        String urlimage = new File("pen.jpg").toURI().toString();
        urlimage = urlimage .substring(5);
        mainpanelphoto = new JLabel(new ImageIcon(urlimage));
        mainpanelphoto.setBounds(0, 0,700, 700);
        scorespanel.add(mainpanelphoto);
        
        readWritedata();
    }

    public static void writedata(String name,String time ,String level)
    {
        try
        {
            String urlt = new File("time.txt").toURI().toString();
            urlt =  urlt.substring(5);
            PrintWriter timef = new PrintWriter(urlt);
            timef.println(time);
            timef.close();
            
            String urln = new File("name.txt").toURI().toString();
            urln  =  urln.substring(5);
            PrintWriter namef = new PrintWriter( urln );
            namef.println(name);
            namef.close();
            
            String urll = new File("level.txt").toURI().toString();
            urll  =  urll.substring(5);
            PrintWriter levelf = new PrintWriter( urll);
            levelf.println(level);
            levelf.close();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"eror2");
        }
    }
    public static String readtime()
    {
        String str ,rstr = ""; DecimalFormat form = new DecimalFormat("00");
         try
        {
            String urlt = new File("time.txt").toURI().toString();
            urlt =  urlt.substring(5);
            FileReader fr = new FileReader(urlt);
            BufferedReader read = new BufferedReader(fr);
            
            while((str = read.readLine()) != null)
            {
               rstr= rstr+str;
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
      
         if(Setting.getlevel().equals("easy"))
              rstr = form.format(Integer.parseInt( rstr.substring(0,2) ) / 3 ) + ":" + form.format(Integer.parseInt( rstr.substring(3,5) ) / 3) ;
         else if (Setting.getlevel().equals("normal"))
             rstr = form.format(Integer.parseInt( rstr.substring(0,2) ) / 2 ) + ":" + form.format(Integer.parseInt( rstr.substring(3,5) ) / 2) ;
    
        return rstr;
    }
    
     public static void readWritedata()
    {
        
         try
        {
           
            String str ,rstr = "";
             String urlt = new File("time.txt").toURI().toString();
            urlt =  urlt.substring(5);
            FileReader frt = new FileReader(urlt);
            BufferedReader readt = new BufferedReader(frt);
            
            while((str = readt.readLine()) != null)
            {
               rstr= rstr+str;
            }
             playertime.setText(rstr);
             rstr = "";
             String urln = new File("name.txt").toURI().toString();
            urln  =  urln.substring(5);
             FileReader frn = new FileReader(urln);
            BufferedReader readn = new BufferedReader(frn);
            
            while((str = readn.readLine()) != null)
            {
               rstr= rstr+str;
            }
             playernamel.setText(rstr);
             rstr = "";
             String urll = new File("level.txt").toURI().toString();
            urll  =  urll.substring(5);
              FileReader frl = new FileReader(urll);
            BufferedReader readl = new BufferedReader(frl);
            
            while((str = readl.readLine()) != null)
            {
               rstr= rstr+str;
            }
             playerlevel.setText(rstr);
             rstr = "";
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        containerpanel = new javax.swing.JPanel();
        scorespanel = new javax.swing.JPanel();
        playernamepanel = new javax.swing.JLabel();
        playertime = new javax.swing.JLabel();
        playernamepanel2 = new javax.swing.JLabel();
        playernamel = new javax.swing.JLabel();
        playerlevel = new javax.swing.JLabel();
        playernamepanel3 = new javax.swing.JLabel();
        returntomainmenue = new javax.swing.JButton();
        gotoplay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scorespanel.setForeground(new java.awt.Color(0, 51, 51));

        playernamepanel.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        playernamepanel.setForeground(new java.awt.Color(204, 204, 255));
        playernamepanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playernamepanel.setText("Name:");

        playertime.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        playertime.setForeground(new java.awt.Color(204, 204, 255));
        playertime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playertime.setText("  ");

        playernamepanel2.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        playernamepanel2.setForeground(new java.awt.Color(204, 204, 255));
        playernamepanel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playernamepanel2.setText("Level:");

        playernamel.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        playernamel.setForeground(new java.awt.Color(204, 204, 255));
        playernamel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        playerlevel.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        playerlevel.setForeground(new java.awt.Color(204, 204, 255));
        playerlevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        playernamepanel3.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        playernamepanel3.setForeground(new java.awt.Color(204, 204, 255));
        playernamepanel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playernamepanel3.setText("Time:");

        returntomainmenue.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        returntomainmenue.setForeground(new java.awt.Color(0, 102, 153));
        returntomainmenue.setText("menue");
        returntomainmenue.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        returntomainmenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returntomainmenueActionPerformed(evt);
            }
        });

        gotoplay.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        gotoplay.setForeground(new java.awt.Color(0, 102, 102));
        gotoplay.setText("Go to play");
        gotoplay.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gotoplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gotoplayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout scorespanelLayout = new javax.swing.GroupLayout(scorespanel);
        scorespanel.setLayout(scorespanelLayout);
        scorespanelLayout.setHorizontalGroup(
            scorespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scorespanelLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(scorespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(playernamepanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playernamepanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playernamepanel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(scorespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(playertime, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(playernamel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playerlevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scorespanelLayout.createSequentialGroup()
                .addGap(0, 114, Short.MAX_VALUE)
                .addComponent(returntomainmenue, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(gotoplay, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
        scorespanelLayout.setVerticalGroup(
            scorespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scorespanelLayout.createSequentialGroup()
                .addGroup(scorespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(scorespanelLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(playernamel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(playerlevel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(scorespanelLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(playernamepanel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(playernamepanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132)
                        .addComponent(playernamepanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(playertime, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(scorespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gotoplay, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returntomainmenue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout containerpanelLayout = new javax.swing.GroupLayout(containerpanel);
        containerpanel.setLayout(containerpanelLayout);
        containerpanelLayout.setHorizontalGroup(
            containerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scorespanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        containerpanelLayout.setVerticalGroup(
            containerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scorespanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Highscores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel containerpanel;
    private javax.swing.JButton gotoplay;
    private static javax.swing.JLabel playerlevel;
    private static javax.swing.JLabel playernamel;
    private javax.swing.JLabel playernamepanel;
    private javax.swing.JLabel playernamepanel2;
    private javax.swing.JLabel playernamepanel3;
    private static javax.swing.JLabel playertime;
    private javax.swing.JButton returntomainmenue;
    private javax.swing.JPanel scorespanel;
    // End of variables declaration//GEN-END:variables
}
