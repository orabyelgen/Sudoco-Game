package soudocko;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.TimerTask;
import javax.swing.*;

public class Play_ extends javax.swing.JFrame {

    private JTextField textfieldarr[][];
    private JPanel textfpanel, textpanelarr[];
    private int sec, min;
    private static int helpcounter;
    private String arr[][] = new String[9][9], arrtest[][] = new String[9][9], name;

    public Play_() {
        name = JOptionPane.showInputDialog(null, "Please Enter your name.");
        initComponents();
        setTitle("play");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        containerp.setSize(700, 700);
        helpcounter = 0; // >> hep counter is zero
        checkresult.setSelected(true);
        String arr[][] //a solved sedouko 
                = {
                    {"8", "1", "6", "4", "5", "2", "9", "3", "7"},
                    {"4", "9", "2", "3", "6", "7", "5", "8", "1"},
                    {"7", "5", "3", "8", "9", "1", "2", "4", "6"},
                    {"1", "4", "5", "9", "7", "3", "6", "2", "8"},
                    {"3", "7", "8", "5", "2", "6", "1", "9", "4"},
                    {"6", "2", "9", "1", "4", "8", "3", "7", "5"},
                    {"2", "3", "1", "6", "8", "4", "7", "5", "9"},
                    {"5", "8", "7", "2", "1", "9", "4", "6", "3"},
                    {"9", "6", "4", "7", "3", "5", "8", "1", "2"}
                };

        replace(arr, "row");
        replace(arr, "col");
        solution(arr);
        String arrtest[][]
                = {
                    {arr[0][0], arr[0][1], arr[0][2], arr[1][0], arr[1][1], arr[1][2], arr[2][0], arr[2][1], arr[2][2]},
                    {arr[0][3], arr[0][4], arr[0][5], arr[1][3], arr[1][4], arr[1][5], arr[2][3], arr[2][4], arr[2][5]},
                    {arr[0][6], arr[0][7], arr[0][8], arr[1][6], arr[1][7], arr[1][8], arr[2][6], arr[2][7], arr[2][8]},
                    {arr[3][0], arr[3][1], arr[3][2], arr[4][0], arr[4][1], arr[4][2], arr[5][0], arr[5][1], arr[5][2]},
                    {arr[3][3], arr[3][4], arr[3][5], arr[4][3], arr[4][4], arr[4][5], arr[5][3], arr[5][4], arr[5][5]},
                    {arr[3][6], arr[3][7], arr[3][8], arr[4][6], arr[4][7], arr[4][8], arr[5][6], arr[5][7], arr[5][8]},
                    {arr[6][0], arr[6][1], arr[6][2], arr[7][0], arr[7][1], arr[7][2], arr[8][0], arr[8][1], arr[8][2]},
                    {arr[6][3], arr[6][4], arr[6][5], arr[7][3], arr[7][4], arr[7][5], arr[8][3], arr[8][4], arr[8][5]},
                    {arr[6][6], arr[6][7], arr[6][8], arr[7][6], arr[7][7], arr[7][8], arr[8][6], arr[8][7], arr[8][8]},};

        draw(arrtest);
         //randominputs();
        timer(Setting.getlevel(), arrtest);
    }

    public void draw(String[][] arr) {

        int d = 0;
        textpanelarr = new JPanel[9];
        for (int i = 0; i < textpanelarr.length; i++, d++) {
            textpanelarr[i] = new JPanel();
            textpanelarr[i].setBackground(Color.BLACK);
            textpanelarr[i].setLayout(new GridLayout(3, 3));
            if (d % 3 == 0) {
                d = 0;
            }

            textpanelarr[i].setBounds((d * 125), (i / 3) * (125), 120, 120);
            Gamep2.add(textpanelarr[i]);
        }

        textfieldarr = new JTextField[9][9];

        for (int i = 0; i < textfieldarr.length; i++) {  //to draw sodoucko shape 

            for (int j = 0; j < textfieldarr[i].length; j++) {
                textfieldarr[i][j] = new JTextField(1);
                textfieldarr[i][j].setText(arr[i][j]); // to talk avalue from solved soducko
                textfieldarr[i][j].setFont(new Font("Courier", Font.BOLD, 20));
                textfieldarr[i][j].setHorizontalAlignment(JTextField.CENTER);
                textpanelarr[i].add(textfieldarr[i][j]);
            }
        }
        // to store asolved soducko 
        for (int i = 0; i < textfieldarr.length; i++) {
            for (int j = 0; j < textfieldarr[i].length; j++) {
                this.arr[i][j] = textfieldarr[i][j].getText();  //  << solved 
            }
        }
    }

    public void replace(String arr[][], String s) // to replace  " s "  randomly
    {
        String[] temp = new String[9];
        int groub = (int) (Math.random() * 9); // number of groubs that will shifted
        int x = 0, y = 0, z = 0, w = 0;
        String kind = s;
        if (groub < 5) {
            groub = 2;
        } else if (groub< 8) {
            groub = 5;
        } else {
            groub= 8;
        }

        for (int grow = 0; grow < 3; grow++) //to replace groub of " s "  # 3 " s" with #3  " s "
        {
            for (int i = 0; i < groub; i++) {
                for (int j = 0; j < arr[i].length; j++)// swap to finish replace
                {
                    if (kind.equals("row")) { // to deal with rows
                        x = i;
                        y = j;
                        z = i + 1;
                        w = j;

                    } else if (kind.equals("col")) {// to deal with colms
                        x = j;
                        y = i;
                        z = j;
                        w = i + 1;
                    }
                    temp[j] = arr[x][y];
                    arr[x][y] = arr[z][w];
                    arr[z][w] = temp[j];

                }
            }
        }

        for (int a = 0; a < (int) (Math.random() * 9); a++) {
            int row1 = (int) (Math.random() * 3); // to replace  one to one  >> first  of agroup
            int row2 = (int) (Math.random() * 3);  // to replace one to one  >> second  of agroup
            int groubnum = (int) (Math.random() * 9);  //select agroup >> 
            groubnum = groubnum % 3;  //to strt num from first "s" of agroub
            groubnum = groubnum * 3; //>>

            for (int j = 0; j < arr.length; j++) // swap to finish replace
            {
                if (kind.equals("row")) { // to deal with rows
                    x = row1 + groubnum;
                    z = row2 + groubnum;
                    y = j;
                    w = j;
                } else if (kind.equals("col")) {//to deal with colms
                    x = j;
                    z = j;
                    y = row1 + groubnum;
                    w = row2 + groubnum;
                }
                temp[j] = arr[x][y];
                arr[x][y] = arr[z][w];
                arr[z][w] = temp[j];

            }
        }
    }

    public void solution(String arr[][]) {   //to do asolved soudoko but difrent shape and change numper places randomly
        int random = (int) (Math.random() * 9); //random number
        for (int i = 0; i < arr.length; i++) //add arandom number to all arr index to have anew solved soducko
        {
            for (int j = 0; j < arr[i].length; j++) {
                int num = Integer.parseInt(arr[i][j]);
                num += random;
                if (num > 9) // if array index value bigger than 9 we have it is reminder
                {
                    num = (num % 9);
                }

                arr[i][j] = "" + num;
            }
        }
    }
    //timer method

    public void timer(String kindlevel, String[][] arr) {
        java.util.Timer timer = new java.util.Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                DecimalFormat form = new DecimalFormat("00");
                sec++;
                sectimer.setText(form.format(sec)); //to set label of seconds increased
                if ((sec % 3) == 0) {
                    for (int i = 0; i < textfieldarr.length; i++) { // return color of textfield tht is red to white
                        for (int j = 0; j < textfieldarr[i].length; j++) {
                            String arrstr = textfieldarr[i][j].getText();

                            if (arrstr.equals(arr[i][j])) {
                                continue;
                            } else {
                                textfieldarr[i][j].setBackground(Color.WHITE);
                            }
                        }
                    }
                }

                if (sec == 59) {
                    sec = 0;
                    min++; // icrease min timer after 60 sec 

                    mintimer.setText(form.format(min)); // to set label of min increse
                    if ((min == 5 && kindlevel == "easy") || (min == 5 && kindlevel == "normal") || (min == 5 && kindlevel == "hard")) // limmited playey dependeded on gamelevel
                    {
                        int x = JOptionPane.showConfirmDialog(null, "GAME OVER !  ARE YOU WANT TO RETRY ?");

                        if (x == 0) {
                            dispose();
                            Play_ player = new Play_();  // new game 
                            player.setVisible(true);

                        } else if (x == 1) // main menue
                        {

                            Game player = new Game();
                            player.setVisible(true);
                            dispose();
                        } else {

                            Play_ player = new Play_(); // new game
                            player.setVisible(true);
                            dispose();
                        }
                    }

                }
            }

        };
        timer.scheduleAtFixedRate(task, 1000, 1000);

    }

    public void randominputs() {
        int level = 3;
        if (Setting.getlevel().equals("easy")) // to select shape of level player will play
        {
            level = 3;
        } else if (Setting.getlevel().equals("normal")) {
            level = 2;
        } else if (Setting.getlevel().equals("hard")) {
            level = 1;
        }

        for (int i = 0; i < textfieldarr.length; i++) // to delete numbers from solved soudocko randomlly
        {
            for (int j = 0; j < textfieldarr[i].length; j += level) {
                int x = (int) (Math.random() * 9);  //random raw
                int y = (int) (Math.random() * 9); //random colm
                textfieldarr[x][y].setText("");  //delete number on showing 
            }

        }

        for (int i = 0; i < textfieldarr.length; i++) { // to editable randomly text inbut that have areal value
            for (int j = 0; j < textfieldarr[i].length; j++) {
                String text = textfieldarr[i][j].getText();
                if (text.equals("")) {
                    textfieldarr[i][j].setEditable(true);
                } else {
                    textfieldarr[i][j].setEditable(false);
                }
            }
        }
    }

    public void help(String num) {

        for (int i = 0; i < textfieldarr.length; i++) {
            if (helpcounter > 5) // mazimam use of help
            {
                resultl.setText("Sorry you used your maximum times of help");
                i = 10;
                break;
            }
            for (int j = 0; j < textfieldarr[i].length; j++) {
                String textf = textfieldarr[i][j].getText();
                String texts = arr[i][j];
                if (texts.equals(num) && textf.equals("")) {
                    textfieldarr[i][j].setBackground(Color.GREEN);
                    textfieldarr[i][j].setText(num);
                    helpcounter++;
                    i = 10;
                    break;
                }
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        containerp = new javax.swing.JPanel();
        Gamep = new javax.swing.JPanel();
        Gamep2 = new javax.swing.JPanel();
        timerp = new javax.swing.JPanel();
        sectimer = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mintimer = new javax.swing.JLabel();
        help1p = new javax.swing.JPanel();
        help5 = new javax.swing.JButton();
        help7 = new javax.swing.JButton();
        help8 = new javax.swing.JButton();
        help9 = new javax.swing.JButton();
        help6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        help3 = new javax.swing.JButton();
        help1 = new javax.swing.JButton();
        help2 = new javax.swing.JButton();
        help4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        testb = new javax.swing.JButton();
        resultl = new javax.swing.JLabel();
        change = new javax.swing.JButton();
        rSetting = new javax.swing.JButton();
        Menue = new javax.swing.JButton();
        checkresult = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Gamep.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Gamep2.setBackground(new java.awt.Color(0, 102, 0));

        javax.swing.GroupLayout Gamep2Layout = new javax.swing.GroupLayout(Gamep2);
        Gamep2.setLayout(Gamep2Layout);
        Gamep2Layout.setHorizontalGroup(
            Gamep2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );
        Gamep2Layout.setVerticalGroup(
            Gamep2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout GamepLayout = new javax.swing.GroupLayout(Gamep);
        Gamep.setLayout(GamepLayout);
        GamepLayout.setHorizontalGroup(
            GamepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GamepLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Gamep2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        GamepLayout.setVerticalGroup(
            GamepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GamepLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Gamep2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        timerp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        sectimer.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        sectimer.setForeground(new java.awt.Color(0, 102, 102));
        sectimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sectimer.setText("00");
        sectimer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText(":");

        mintimer.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        mintimer.setForeground(new java.awt.Color(0, 102, 102));
        mintimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mintimer.setText("00");
        mintimer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout timerpLayout = new javax.swing.GroupLayout(timerp);
        timerp.setLayout(timerpLayout);
        timerpLayout.setHorizontalGroup(
            timerpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, timerpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mintimer, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sectimer, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );
        timerpLayout.setVerticalGroup(
            timerpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sectimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, timerpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addGap(7, 7, 7))
            .addComponent(mintimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        help1p.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        help5.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        help5.setForeground(new java.awt.Color(0, 102, 102));
        help5.setText("5");
        help5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                help5ActionPerformed(evt);
            }
        });

        help7.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        help7.setForeground(new java.awt.Color(0, 102, 102));
        help7.setText("7");
        help7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                help7ActionPerformed(evt);
            }
        });

        help8.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        help8.setForeground(new java.awt.Color(0, 102, 102));
        help8.setText("8");
        help8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                help8ActionPerformed(evt);
            }
        });

        help9.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        help9.setForeground(new java.awt.Color(0, 102, 102));
        help9.setText("9");
        help9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                help9ActionPerformed(evt);
            }
        });

        help6.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        help6.setForeground(new java.awt.Color(0, 102, 102));
        help6.setText("6");
        help6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                help6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout help1pLayout = new javax.swing.GroupLayout(help1p);
        help1p.setLayout(help1pLayout);
        help1pLayout.setHorizontalGroup(
            help1pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(help1pLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(help1pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(help6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(help7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(help8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(help9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(help5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        help1pLayout.setVerticalGroup(
            help1pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(help1pLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(help5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(help6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(help7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(help8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(help9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("HELP");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        help3.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        help3.setForeground(new java.awt.Color(0, 102, 102));
        help3.setText("3");
        help3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                help3ActionPerformed(evt);
            }
        });

        help1.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        help1.setForeground(new java.awt.Color(0, 102, 102));
        help1.setText("1");
        help1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                help1ActionPerformed(evt);
            }
        });

        help2.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        help2.setForeground(new java.awt.Color(0, 102, 102));
        help2.setText("2");
        help2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                help2ActionPerformed(evt);
            }
        });

        help4.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        help4.setForeground(new java.awt.Color(0, 102, 102));
        help4.setText("4");
        help4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                help4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(help1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(help4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(help2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(help3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(help1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(help2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(help3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(help4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        testb.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        testb.setForeground(new java.awt.Color(255, 51, 255));
        testb.setText("TEST");
        testb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        testb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testbActionPerformed(evt);
            }
        });

        resultl.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        resultl.setForeground(new java.awt.Color(0, 0, 204));
        resultl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultl.setText("result");
        resultl.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        change.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        change.setForeground(new java.awt.Color(0, 102, 102));
        change.setText("CHANGE");
        change.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(resultl, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(testb, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(resultl, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(testb, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        rSetting.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        rSetting.setForeground(new java.awt.Color(0, 102, 102));
        rSetting.setText("setting");
        rSetting.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSettingActionPerformed(evt);
            }
        });

        Menue.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        Menue.setForeground(new java.awt.Color(0, 102, 102));
        Menue.setText("menue");
        Menue.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Menue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenueActionPerformed(evt);
            }
        });

        checkresult.setText("show result");
        checkresult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkresultActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containerpLayout = new javax.swing.GroupLayout(containerp);
        containerp.setLayout(containerpLayout);
        containerpLayout.setHorizontalGroup(
            containerpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerpLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Menue, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(timerp, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(rSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(containerpLayout.createSequentialGroup()
                .addGroup(containerpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerpLayout.createSequentialGroup()
                        .addGroup(containerpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(containerpLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(checkresult)
                                .addGap(41, 41, 41))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerpLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(Gamep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(help1p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        containerpLayout.setVerticalGroup(
            containerpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerpLayout.createSequentialGroup()
                .addGroup(containerpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerpLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(containerpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Menue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerpLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(timerp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(containerpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(help1p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(containerpLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(checkresult))
                    .addComponent(Gamep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(containerp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void help3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_help3ActionPerformed
        help("3");
    }//GEN-LAST:event_help3ActionPerformed

    private void help1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_help1ActionPerformed
        help("1");
    }//GEN-LAST:event_help1ActionPerformed

    private void help5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_help5ActionPerformed
        help("5");
    }//GEN-LAST:event_help5ActionPerformed

    private void help8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_help8ActionPerformed
        help("8");
    }//GEN-LAST:event_help8ActionPerformed

    private void help6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_help6ActionPerformed
        help("6");
    }//GEN-LAST:event_help6ActionPerformed

    private void changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActionPerformed
        Play_ player = new Play_();
        player.setVisible(true);
        dispose();
    }//GEN-LAST:event_changeActionPerformed
    public int testresult() {
        int returnnum = -1;

        //to select ablock that have mistakes
        for (int i = 0; i < textfieldarr.length; i++) {
            for (int j = 0; j < textfieldarr[i].length; j++) {
                String arrstr = textfieldarr[i][j].getText();

                if (arrstr.equals(this.arr[i][j])) {
                    continue;
                } else {
                    returnnum = i;
                    break; // that mean he found amistake lock so he break and retutn a then number of  block of mistake
                }
            }
            if (returnnum > -1) {
                break;  // to break from this loop because he found a mistake
            }
        }
        for (int i = 0; i < textfieldarr.length; i++) { // to set empaty textfield with red coler that mean it is value are rong
            for (int j = 0; j < textfieldarr[i].length; j++) {
                String arrstr = textfieldarr[i][j].getText();

                if (arrstr.equals(this.arr[i][j])) {
                    continue;
                } else {
                    textfieldarr[i][j].setBackground(Color.red);
                }  // made an err text red color   " timer will made it white again "
            }
        }

        return returnnum;
    }

    private void testbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testbActionPerformed

        if (testresult() > -1) {
            resultl.setText("Thiere is a mistake  !");
        } else if (testresult() == -1) {
            resultl.setText("Congratulation. you win. \n your time is " + min + "  : " + sec);

            String highscore = Highscores.readtime();
            DecimalFormat form = new DecimalFormat("00");

            if ((Integer.parseInt(highscore.substring(0, 2)) >= min)) {
                if ((Integer.parseInt(highscore.substring(3, 5)) > sec)) {
                    Highscores.writedata(name, (form.format(min) + ":" + form.format(sec)), Setting.getlevel());
                }
            }

            int anothergame = JOptionPane.showConfirmDialog(null, "Congratulation you win . \n are you want to play another game?");
            if (anothergame == 0) {
                dispose();
                Play_ player = new Play_();
                player.setVisible(true);
            } else {
                Game player = new Game();
                player.setVisible(true);
                dispose();
            }
        }
    }//GEN-LAST:event_testbActionPerformed

    private void rSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSettingActionPerformed
        Setting player = new Setting();
        player.setVisible(true);
        dispose();
    }//GEN-LAST:event_rSettingActionPerformed

    private void help2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_help2ActionPerformed
        help("2");
    }//GEN-LAST:event_help2ActionPerformed

    private void help4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_help4ActionPerformed
        help("4");
    }//GEN-LAST:event_help4ActionPerformed

    private void help7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_help7ActionPerformed
        help("7");
    }//GEN-LAST:event_help7ActionPerformed

    private void help9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_help9ActionPerformed
        help("9");
    }//GEN-LAST:event_help9ActionPerformed

    private void MenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenueActionPerformed
        Game player = new Game();
        player.setVisible(true);
        dispose();
    }//GEN-LAST:event_MenueActionPerformed

    private void checkresultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkresultActionPerformed
        if (checkresult.isSelected()) {
            setSize(710, 710);
            setLocationRelativeTo(null);
        } else {

            setSize(710, 600);
            setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_checkresultActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Play_().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Gamep;
    private javax.swing.JPanel Gamep2;
    private javax.swing.JButton Menue;
    private javax.swing.JButton change;
    private javax.swing.JCheckBox checkresult;
    private javax.swing.JPanel containerp;
    private javax.swing.JButton help1;
    private javax.swing.JPanel help1p;
    private javax.swing.JButton help2;
    private javax.swing.JButton help3;
    private javax.swing.JButton help4;
    private javax.swing.JButton help5;
    private javax.swing.JButton help6;
    private javax.swing.JButton help7;
    private javax.swing.JButton help8;
    private javax.swing.JButton help9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel mintimer;
    private javax.swing.JButton rSetting;
    private javax.swing.JLabel resultl;
    private javax.swing.JLabel sectimer;
    private javax.swing.JButton testb;
    private javax.swing.JPanel timerp;
    // End of variables declaration//GEN-END:variables
}
