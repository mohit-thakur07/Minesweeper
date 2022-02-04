package minesweeper;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
import java.util.*;
import javax.swing.ImageIcon;

public class Minesweeper extends javax.swing.JFrame {

    int bomb;
    boolean flag;
    StartTime thread;

    public Minesweeper() {
        bomb = 0;
        flag = true;
        
        numIcon = new ImageIcon[9];
        
        numIcon[0] = new ImageIcon(getClass().getResource("/icons/0.png"));
        numIcon[1] = new ImageIcon(getClass().getResource("/icons/1.png"));
        numIcon[2] = new ImageIcon(getClass().getResource("/icons/2.png"));
        numIcon[3] = new ImageIcon(getClass().getResource("/icons/3.png"));
        numIcon[4] = new ImageIcon(getClass().getResource("/icons/4.png"));
        numIcon[5] = new ImageIcon(getClass().getResource("/icons/5.png"));
        numIcon[6] = new ImageIcon(getClass().getResource("/icons/6.png"));
        numIcon[7] = new ImageIcon(getClass().getResource("/icons/7.png"));
        numIcon[8] = new ImageIcon(getClass().getResource("/icons/8.png"));
        
        blastIcon = new ImageIcon(getClass().getResource("/icons/blast.png"));
        mineIcon = new ImageIcon(getClass().getResource("/icons/mine.png"));
        flagIcon = new ImageIcon(getClass().getResource("/icons/flag.png"));
        crossFlagIcon = new ImageIcon(getClass().getResource("/icons/Cflag.png"));
        sadIcon = new ImageIcon(getClass().getResource("/icons/sad.png"));
        normalIcon = new ImageIcon(getClass().getResource("/icons/normal.png"));
        smileIcon = new ImageIcon(getClass().getResource("/icons/smiley.png"));

        initcomponents();
    }

    private void initcomponents() {

        //Initializing..........
        button = new Layout[144];
        for (int i = 0; i < 144; i++) {
            button[i] = new Layout();
        }
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDialog1 = new javax.swing.JDialog();
        jTextField3 = new javax.swing.JTextField();
        jDialog2 = new javax.swing.JDialog();
        jTextField4 = new javax.swing.JTextField();

        jDialog1.setTitle("Status");
        jDialog1.setBackground(new java.awt.Color(0, 0, 0));
        jDialog1.setResizable(false);
        jDialog1.setSize(new java.awt.Dimension(400, 300));

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(0, 0, 0));
        jTextField3.setFont(new java.awt.Font("Bauhaus 93", 1, 48)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 51, 51));
        jTextField3.setText("You Loss!!!!!!!!");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        jDialog2.setTitle("Status");
        jDialog2.setResizable(false);
        jDialog2.setSize(new java.awt.Dimension(400, 300));

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(0, 0, 0));
        jTextField4.setFont(new java.awt.Font("Bauhaus 93", 1, 48)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 51, 51));
        jTextField4.setText("You Win!!!!!!!!");

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
                jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
                jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Minesweeper");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField1.setEditable(false);
        jTextField1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 51, 51));
        jTextField1.setText("0");
        jTextField1.setToolTipText("");
        jTextField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextField2.setEditable(false);
        jTextField2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextField2.setBackground(new java.awt.Color(0, 0, 0));
        jTextField2.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 51, 51));
        jTextField2.setText("0  :  0  :  0");
        jTextField2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setIcon(smileIcon); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jDialog1.setVisible(false);
                    jDialog2.setVisible(false);
                    jDialog1.dispose();
                    jDialog2.dispose();
                    setVisible(false);
                    dispose();
                    main(new String[1]);
                }
            });
        jLabel2.setText("Hint: Always start from topmost left....");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel2)))
                        .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jLabel2))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        for (int i = 0; i < 144; i++) {
            button[i].setIcon(normalIcon);
            button[i].addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    ActionRight(evt);
                }
            });
            button[i].addActionListener((java.awt.event.ActionEvent evt) -> {
                ActionLeft(evt);
            });
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(button[-1 + 25], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 26], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 27], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 28], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 29], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 30], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 31], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 32], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 33], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 34], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 35], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 36], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(button[-1 + 13], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 14], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 15], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 16], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 17], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 18], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 19], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 20], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 21], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 22], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 23], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(button[-1 + 24], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(button[-1 + 1], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(button[-1 + 2], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(button[-1 + 3], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(button[-1 + 4], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(button[-1 + 5], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(button[-1 + 6], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(button[-1 + 7], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(button[-1 + 8], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(button[-1 + 9], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(button[-1 + 10], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(button[-1 + 11], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(button[-1 + 12], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(button[-1 + 37], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 38], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 39], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 40], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 41], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 42], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 43], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 44], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 45], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 46], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 47], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 48], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(button[-1 + 49], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 50], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 51], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 52], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 53], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 54], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 55], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 56], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 57], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 58], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 59], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 60], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(button[-1 + 61], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 62], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 63], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 64], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 65], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 66], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 67], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 68], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 69], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 70], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 71], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 72], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(button[-1 + 73], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 74], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 75], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 76], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 77], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 78], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 79], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 80], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 81], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 82], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 83], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 84], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(button[-1 + 85], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 86], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 87], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 88], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 89], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 90], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 91], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 92], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 93], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 94], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 95], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 96], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(button[-1 + 97], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 98], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 99], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 100], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 101], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 102], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 103], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 104], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 105], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 106], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 107], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 108], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(button[-1 + 109], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 110], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 111], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 112], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 113], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 114], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 115], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 116], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 117], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 118], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 119], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 120], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(button[-1 + 121], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 122], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 123], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 124], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 125], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 126], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 127], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 128], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 129], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 130], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 131], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 132], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(button[-1 + 133], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 134], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 135], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 136], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 137], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 138], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 139], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 140], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 141], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 142], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 143], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(button[-1 + 144], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(button[-1 + 8], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 7], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 6], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 5], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 4], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 3], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 2], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 1], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 9], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 12], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 11], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 10], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(button[-1 + 24], javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 23], javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 22], javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 20], javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 19], javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 18], javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 17], javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 16], javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 15], javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 14], javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 13], javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 21], javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(button[-1 + 36], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 35], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 34], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 33], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 32], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 31], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 30], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 29], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 28], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 27], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 26], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 25], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(button[-1 + 48], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 47], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 46], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 45], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 44], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 43], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 42], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 41], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 40], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 39], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 38], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 37], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(button[-1 + 60], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 59], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 58], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 57], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 56], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 55], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 54], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 53], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 52], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 51], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 50], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 49], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(button[-1 + 72], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 71], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 70], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 69], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 68], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 67], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 66], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 65], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 64], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 63], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 62], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 61], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(button[-1 + 84], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 83], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 82], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 81], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 80], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 79], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 78], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 77], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 76], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 75], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 74], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 73], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(button[-1 + 96], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 95], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 94], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 93], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 92], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 91], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 90], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 89], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 88], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 87], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 86], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 85], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(button[-1 + 108], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 107], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 106], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 105], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 104], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 103], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 102], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 101], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 100], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 99], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 98], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 97], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(button[-1 + 120], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 119], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 118], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 117], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 116], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 115], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 114], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 113], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 112], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 111], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 110], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 109], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(button[-1 + 132], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 131], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 130], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 129], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 128], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 127], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 126], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 125], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 124], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 123], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 122], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 121], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(button[-1 + 144], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 143], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 142], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 141], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 140], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 139], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 138], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 137], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 136], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 135], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 134], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button[-1 + 133], javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0))
        );

        pack();
    }

    void ActionLeft(java.awt.event.ActionEvent evt) {
        if (flag) {
            thread = new StartTime(jTextField2);
            thread.start();
        }
        flag = false; // Ab ghadi dobara nahi chalu hogi. Hahaha....

        Layout temp;
        temp = (Layout) evt.getSource();

        temp.realFlag = -1;
        temp.setEnabled(false);

        if (temp.set == 1) {
            temp.setDisabledSelectedIcon(blastIcon);
            boom();
        } else if (temp.val == 0) {
            temp.setDisabledSelectedIcon(numIcon[0]);
            space(temp.id); //REDUCING THE HARD WORK. WHOOOOO!
        } else if (temp.val == 1) {
            temp.setDisabledSelectedIcon(numIcon[1]);
        } else if (temp.val == 2) {
            temp.setDisabledSelectedIcon(numIcon[2]);
        } else if (temp.val == 3) {
            temp.setDisabledSelectedIcon(numIcon[3]);
        } else if (temp.val == 4) {
            temp.setDisabledSelectedIcon(numIcon[4]);
        } else if (temp.val == 5) {
            temp.setDisabledSelectedIcon(numIcon[5]);
        } else if (temp.val == 6) {
            temp.setDisabledSelectedIcon(numIcon[6]);
        } else if (temp.val == 7) {
            temp.setDisabledSelectedIcon(numIcon[7]);
        } else if (temp.val == 8) {
            temp.setDisabledSelectedIcon(numIcon[8]);
        }        
        wooh();
    }

    void ActionRight(java.awt.event.MouseEvent evt) {
        if (flag) {
            thread = new StartTime(jTextField2);
            thread.start();
        }
        flag = false; // Ab ghadi dobara nahi chalu hogi. Hahaha....

        Layout temp;
        temp = (Layout) evt.getSource();

        if (javax.swing.SwingUtilities.isRightMouseButton(evt)) {
            if (temp.realFlag == 0) {
                temp.realFlag = 1;
                temp.setDisabledIcon(flagIcon);
                temp.setEnabled(false);
                bomb = bomb - 1;
                jTextField1.setText(Integer.toString(bomb));
            } else if (temp.realFlag == 1) {
                temp.realFlag = 0;
                temp.setEnabled(true);
                bomb = bomb + 1;
                jTextField1.setText(Integer.toString(bomb));
            }
        }
    }

    void space(int ID) { // Bahut khatarnak kam h bhai....         

        boolean f[] = new boolean[8];
        
        if (ID == 0) {
            button[1].doClick();
            button[12].doClick();
            button[13].doClick();
        } else if (ID == 11) {
            button[10].doClick();
            button[22].doClick();
            button[23].doClick();
        } else if (ID == 132) {
            button[120].doClick();
            button[121].doClick();
            button[133].doClick();
        } else if (ID == 143) {
            button[130].doClick();
            button[131].doClick();
            button[142].doClick();
        } else if (ID >= 1 & ID < 11) {
            if (button[ID - 1].realFlag != -1) {                
                f[3] = true;
            }
            if (button[ID + 1].realFlag != -1) {                
                f[4] = true;
            }
            if (button[ID + 11].realFlag != -1) {                
                f[5] = true;
            }
            if (button[ID + 12].realFlag != -1) {                
                f[6] = true;
            }
            if (button[ID + 13].realFlag != -1) {               
                f[7] = true;
            }
        } else if (ID % 12 == 0 & ID < 132) {
            if (button[ID - 12].realFlag != -1) {                
                f[1] = true;
            }
            if (button[ID - 11].realFlag != -1) {               
                f[2] = true;
            }
            if (button[ID + 1].realFlag != -1) {               
                f[4] = true;                
            }
            if (button[ID + 12].realFlag != -1) {
                f[6] = true;
            }
            if (button[ID + 13].realFlag != -1) {
                f[7] = true;
            }
        } else if (ID % 12 == 11 & ID < 143) {
            if (button[ID - 1].realFlag != -1) {
                f[3] = true;
            }
            if (button[ID - 13].realFlag != -1) {
                f[0] = true;
            }
            if (button[ID - 12].realFlag != -1) {
                f[1] = true;
            }
            if (button[ID + 11].realFlag != -1) {
                f[5] = true;
            }
            if (button[ID + 12].realFlag != -1) {
                f[6] = true;
            }
        } else if (ID >= 133 & ID < 143) {
            if (button[ID - 1].realFlag != -1) {
                f[3] = true;
            }
            if (button[ID + 1].realFlag != -1) {
                f[4] = true;
            }
            if (button[ID - 11].realFlag != -1) {
                f[2] = true;
            }
            if (button[ID - 12].realFlag != -1) {
                f[1] = true;
            }
            if (button[ID - 13].realFlag != -1) {
                f[0] = true;
            }
        } else {
            if (button[ID - 13].realFlag != -1) {
                f[0] = true;
            }
            if (button[ID - 12].realFlag != -1) {
                f[1] = true;
            }
            if (button[ID - 11].realFlag != -1) {
                f[2] = true;
            }
            if (button[ID - 1].realFlag != -1) {
                f[3] = true;
            }
            if (button[ID + 1].realFlag != -1) {
                f[4] = true;
            }
            if (button[ID + 11].realFlag != -1) {
                f[5] = true;
            }
            if (button[ID + 12].realFlag != -1) {
                f[6] = true;
            }
            if (button[ID + 13].realFlag != -1) {
                f[7] = true;
            }
        }
        
        if(f[0]){
            button[ID - 13].realFlag = -1;
            button[ID - 13].setEnabled(false);

            if (button[ID - 13].val == 0) {
                button[ID - 13].setDisabledIcon(numIcon[0]);
                space(button[ID - 13].id); //REDUCING THE HARD WORK. WHOOOOO!
            } else if (button[ID - 13].val == 1) {
                button[ID - 13].setDisabledIcon(numIcon[1]);
            } else if (button[ID - 13].val == 2) {
                button[ID - 13].setDisabledIcon(numIcon[2]);
            } else if (button[ID - 13].val == 3) {
                button[ID - 13].setDisabledIcon(numIcon[3]);
            } else if (button[ID - 13].val == 4) {
                button[ID - 13].setDisabledIcon(numIcon[4]);
            } else if (button[ID - 13].val == 5) {
                button[ID - 13].setDisabledIcon(numIcon[5]);
            } else if (button[ID - 13].val == 6) {
                button[ID - 13].setDisabledIcon(numIcon[6]);
            } else if (button[ID - 13].val == 7) {
                button[ID - 13].setDisabledIcon(numIcon[7]);
            } else if (button[ID - 13].val == 8) {
                button[ID - 13].setDisabledIcon(numIcon[8]);
            }        
            wooh();
        }
        if(f[1]){
            button[ID - 12].realFlag = -1;
            button[ID - 12].setEnabled(false);

            if (button[ID - 12].val == 0) {
                button[ID - 12].setDisabledIcon(numIcon[0]);
                space(button[ID - 12].id); //REDUCING THE HARD WORK. WHOOOOO!
            } else if (button[ID - 12].val == 1) {
                button[ID - 12].setDisabledIcon(numIcon[1]);
            } else if (button[ID - 12].val == 2) {
                button[ID - 12].setDisabledIcon(numIcon[2]);
            } else if (button[ID - 12].val == 3) {
                button[ID - 12].setDisabledIcon(numIcon[3]);
            } else if (button[ID - 12].val == 4) {
                button[ID - 12].setDisabledIcon(numIcon[4]);
            } else if (button[ID - 12].val == 5) {
                button[ID - 12].setDisabledIcon(numIcon[5]);
            } else if (button[ID - 12].val == 6) {
                button[ID - 12].setDisabledIcon(numIcon[6]);
            } else if (button[ID - 12].val == 7) {
                button[ID - 12].setDisabledIcon(numIcon[7]);
            } else if (button[ID - 12].val == 8) {
                button[ID - 12].setDisabledIcon(numIcon[8]);
            }        
            wooh();
        }
        if(f[2]){
            button[ID - 11].realFlag = -1;
            button[ID - 11].setEnabled(false);

            if (button[ID - 11].val == 0) {
                button[ID - 11].setDisabledIcon(numIcon[0]);
                space(button[ID - 11].id); //REDUCING THE HARD WORK. WHOOOOO!
            } else if (button[ID - 11].val == 1) {
                button[ID - 11].setDisabledIcon(numIcon[1]);
            } else if (button[ID - 11].val == 2) {
                button[ID - 11].setDisabledIcon(numIcon[2]);
            } else if (button[ID - 11].val == 3) {
                button[ID - 11].setDisabledIcon(numIcon[3]);
            } else if (button[ID - 11].val == 4) {
                button[ID - 11].setDisabledIcon(numIcon[4]);
            } else if (button[ID - 11].val == 5) {
                button[ID - 11].setDisabledIcon(numIcon[5]);
            } else if (button[ID - 11].val == 6) {
                button[ID - 11].setDisabledIcon(numIcon[6]);
            } else if (button[ID - 11].val == 7) {
                button[ID - 11].setDisabledIcon(numIcon[7]);
            } else if (button[ID - 11].val == 8) {
                button[ID - 11].setDisabledIcon(numIcon[8]);
            }        
            wooh();
        }
        if(f[3]){
            button[ID - 1].realFlag = -1;
            button[ID - 1].setEnabled(false);

            if (button[ID - 1].val == 0) {
                button[ID - 1].setDisabledIcon(numIcon[0]);
                space(button[ID - 1].id); //REDUCING THE HARD WORK. WHOOOOO!
            } else if (button[ID - 1].val == 1) {
                button[ID - 1].setDisabledIcon(numIcon[1]);
            } else if (button[ID - 1].val == 2) {
                button[ID - 1].setDisabledIcon(numIcon[2]);
            } else if (button[ID - 1].val == 3) {
                button[ID - 1].setDisabledIcon(numIcon[3]);
            } else if (button[ID - 1].val == 4) {
                button[ID - 1].setDisabledIcon(numIcon[4]);
            } else if (button[ID - 1].val == 5) {
                button[ID - 1].setDisabledIcon(numIcon[5]);
            } else if (button[ID - 1].val == 6) {
                button[ID - 1].setDisabledIcon(numIcon[6]);
            } else if (button[ID - 1].val == 7) {
                button[ID - 1].setDisabledIcon(numIcon[7]);
            } else if (button[ID - 1].val == 8) {
                button[ID - 1].setDisabledIcon(numIcon[8]);
            }        
            wooh();
        }
        if(f[4]){
            button[ID + 1].realFlag = -1;
            button[ID + 1].setEnabled(false);

            if (button[ID + 1].val == 0) {
                button[ID + 1].setDisabledIcon(numIcon[0]);
                space(button[ID + 1].id); //REDUCING THE HARD WORK. WHOOOOO!
            } else if (button[ID + 1].val == 1) {
                button[ID + 1].setDisabledIcon(numIcon[1]);
            } else if (button[ID + 1].val == 2) {
                button[ID + 1].setDisabledIcon(numIcon[2]);
            } else if (button[ID + 1].val == 3) {
                button[ID + 1].setDisabledIcon(numIcon[3]);
            } else if (button[ID + 1].val == 4) {
                button[ID + 1].setDisabledIcon(numIcon[4]);
            } else if (button[ID + 1].val == 5) {
                button[ID + 1].setDisabledIcon(numIcon[5]);
            } else if (button[ID + 1].val == 6) {
                button[ID + 1].setDisabledIcon(numIcon[6]);
            } else if (button[ID + 1].val == 7) {
                button[ID + 1].setDisabledIcon(numIcon[7]);
            } else if (button[ID + 1].val == 8) {
                button[ID + 1].setDisabledIcon(numIcon[8]);
            }        
            wooh();
        }
        if(f[5]){
            button[ID + 11].realFlag = -1;
            button[ID + 11].setEnabled(false);

            if (button[ID + 11].val == 0) {
                button[ID + 11].setDisabledIcon(numIcon[0]);
                space(button[ID + 11].id); //REDUCING THE HARD WORK. WHOOOOO!
            } else if (button[ID + 11].val == 1) {
                button[ID + 11].setDisabledIcon(numIcon[1]);
            } else if (button[ID + 11].val == 2) {
                button[ID + 11].setDisabledIcon(numIcon[2]);
            } else if (button[ID + 11].val == 3) {
                button[ID + 11].setDisabledIcon(numIcon[3]);
            } else if (button[ID + 11].val == 4) {
                button[ID + 11].setDisabledIcon(numIcon[4]);
            } else if (button[ID + 11].val == 5) {
                button[ID + 11].setDisabledIcon(numIcon[5]);
            } else if (button[ID + 11].val == 6) {
                button[ID + 11].setDisabledIcon(numIcon[6]);
            } else if (button[ID + 11].val == 7) {
                button[ID + 11].setDisabledIcon(numIcon[7]);
            } else if (button[ID + 11].val == 8) {
                button[ID + 11].setDisabledIcon(numIcon[8]);
            }        
            wooh();
        }
        if(f[6]){
            button[ID + 12].realFlag = -1;
            button[ID + 12].setEnabled(false);

            if (button[ID + 12].val == 0) {
                button[ID + 12].setDisabledIcon(numIcon[0]);
                space(button[ID + 12].id); //REDUCING THE HARD WORK. WHOOOOO!
            } else if (button[ID + 12].val == 1) {
                button[ID + 12].setDisabledIcon(numIcon[1]);
            } else if (button[ID + 12].val == 2) {
                button[ID + 12].setDisabledIcon(numIcon[2]);
            } else if (button[ID + 12].val == 3) {
                button[ID + 12].setDisabledIcon(numIcon[3]);
            } else if (button[ID + 12].val == 4) {
                button[ID + 12].setDisabledIcon(numIcon[4]);
            } else if (button[ID + 12].val == 5) {
                button[ID + 12].setDisabledIcon(numIcon[5]);
            } else if (button[ID + 12].val == 6) {
                button[ID + 12].setDisabledIcon(numIcon[6]);
            } else if (button[ID + 12].val == 7) {
                button[ID + 12].setDisabledIcon(numIcon[7]);
            } else if (button[ID + 12].val == 8) {
                button[ID + 12].setDisabledIcon(numIcon[8]);
            }        
            wooh();
        }
        if(f[7]){
            button[ID + 13].realFlag = -1;
            button[ID + 13].setEnabled(false);

            if (button[ID + 13].val == 0) {
                button[ID + 13].setDisabledIcon(numIcon[0]);
                space(button[ID + 13].id); //REDUCING THE HARD WORK. WHOOOOO!
            } else if (button[ID + 13].val == 1) {
                button[ID + 13].setDisabledIcon(numIcon[1]);
            } else if (button[ID + 13].val == 2) {
                button[ID + 13].setDisabledIcon(numIcon[2]);
            } else if (button[ID + 13].val == 3) {
                button[ID + 13].setDisabledIcon(numIcon[3]);
            } else if (button[ID + 13].val == 4) {
                button[ID + 13].setDisabledIcon(numIcon[4]);
            } else if (button[ID + 13].val == 5) {
                button[ID + 13].setDisabledIcon(numIcon[5]);
            } else if (button[ID + 13].val == 6) {
                button[ID + 13].setDisabledIcon(numIcon[6]);
            } else if (button[ID + 13].val == 7) {
                button[ID + 13].setDisabledIcon(numIcon[7]);
            } else if (button[ID + 13].val == 8) {
                button[ID + 13].setDisabledIcon(numIcon[8]);
            }        
            wooh();
        }
        
    }

    void wooh() {// Let's See....
        boolean f = true;

        for (int i = 0; i < 144; i++) {
            if ((button[i].realFlag == -1 & button[i].set == 1) | (button[i].realFlag != -1 & button[i].set == 0)) {//if((button[i].set != button[i].realFlag & button[i].set == 1) | (button[i].realFlag != -1 & button[i].set != 1)){
                f = false;
                break;
            }
        }

        if (f) {
            jDialog2.setVisible(true); // Abe jit  gaya saale....
            Watch.runTimer = false;
            for (int i = 0; i < 144; i++) {
                if (button[i].realFlag != -1) {
                    button[i].setDisabledIcon(flagIcon);
                    button[i].setEnabled(false);
                    if (button[i].realFlag == 0) {
                        bomb--;
                    }
                    button[i].realFlag = -1;
                }
                jTextField1.setText(Integer.toString(bomb));
            }
        }
    }

    void boom() {//BAD LUCK!
        for (int i = 0; i < 144; i++) {
            if (button[i].realFlag == 1) {
                if (button[i].set == 0) {
                    button[i].setDisabledIcon(crossFlagIcon);
                    button[i].setEnabled(false);
                }
                button[i].realFlag = -1;
            } else if (button[i].realFlag == 0) {
                if (button[i].set == 0) {
                    if (button[i].val == 0) {
                        button[i].setDisabledIcon(numIcon[0]);
                    } else if (button[i].val == 1) {
                        button[i].setDisabledIcon(numIcon[1]);
                    } else if (button[i].val == 2) {
                        button[i].setDisabledIcon(numIcon[2]);
                    } else if (button[i].val == 3) {
                        button[i].setDisabledIcon(numIcon[3]);
                    } else if (button[i].val == 4) {
                        button[i].setDisabledIcon(numIcon[4]);
                    } else if (button[i].val == 5) {
                        button[i].setDisabledIcon(numIcon[5]);
                    } else if (button[i].val == 6) {
                        button[i].setDisabledIcon(numIcon[6]);
                    } else if (button[i].val == 7) {
                        button[i].setDisabledIcon(numIcon[7]);
                    } else if (button[i].val == 8) {
                        button[i].setDisabledIcon(numIcon[8]);
                    }
                    button[i].setEnabled(false);
                    button[i].realFlag = -1;
                } else if (button[i].set == 1) {
                    button[i].setDisabledIcon(mineIcon);
                    button[i].setEnabled(false);
                }
            }
        }

        Watch.runTimer = false;
        jLabel1.setIcon(sadIcon);
        jDialog1.setVisible(true); // Tu jitne layak he hi nahi!!!!!!!!!
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            Minesweeper game = new Minesweeper();
            game.setVisible(true);
            game.setLocation(800, 300); //mujhe kaha avtarit hona h?
            game.jDialog1.setLocation(400, 300);
            game.jDialog2.setLocation(400, 300);
            
            Random rnd = new Random();
            
            //Sabko Voter ID milega, Nahi to desh nikala to jaroor milega
            for (int i = 0; i < 144; i++) {
                game.button[i].id = i;
            }
            
            //THE  ENEMY: Planting bombs everywhere, 'BE CAREFUL'
            
            game.button[0].set = 0;
            while (game.bomb != 10) {
                game.bomb = 0;
                for (int i = 1; i < 72; i++) {
                    game.button[i].set = rnd.nextInt(2) * rnd.nextInt(2) * rnd.nextInt(2);
                    game.bomb = game.bomb + game.button[i].set;
                }
                //System.out.println(game.bomb);
            }
            while (game.bomb != 20) {
                game.bomb = 10;
                for (int i = 72; i < 144; i++) {
                    game.button[i].set = rnd.nextInt(2) * rnd.nextInt(2) * rnd.nextInt(2);
                    game.bomb = game.bomb + game.button[i].set;
                }
                //System.out.println(game.bomb);
            }
            
            //Use this to increaase the difficulty of the game by making some changes in above two while loops
            /*while(game.bomb != 30){
                game.bomb = 20;
                for(int i = 96; i < 144; i++){
                    game.button[i].set = rnd.nextInt(2) * rnd.nextInt(2) * rnd.nextInt(2);
                    game.bomb += game.button[i].set;
                }
            }*/
            
            //Hardest minesweeper possible
            //baith k tukke lagao
            /*for(int i = 0; i < 144; i++){
                game.button[i].set = 1;
            }
            
            int pos = (rnd.nextInt(144) * rnd.nextInt(144) * rnd.nextInt(144)) % 144;
            
            System.out.println(pos);
            
            game.button[pos].set = 0;
            game.bomb = 143;*/
            
            if (game.button[0].set == 0) {
                game.button[0].val = game.button[1].set + game.button[12].set + game.button[13].set;
            }
            
            for (int i = 1; i < 11; i++) {
                if (game.button[i].set == 0) {
                    game.button[i].val = game.button[i - 1].set + game.button[i + 1].set + game.button[i + 11].set + game.button[i + 12].set + game.button[i + 13].set;
                }
            }
            
            if (game.button[11].set == 0) {
                game.button[11].val = game.button[10].set + game.button[22].set + game.button[23].set;
            }
            
            for (int j = 12; j < 132; j += 12) {
                if (game.button[j].set == 0) {
                    /*set[j + 12] = rnd.nextInt(2);
                    set[j + 13] = rnd.nextInt(2);*/
                    game.button[j].val = game.button[j - 12].set + game.button[j - 11].set + game.button[j + 1].set + game.button[j + 12].set + game.button[j + 13].set;
                }
                
                for (int i = j + 1; i < j + 11; i++) {
                    if (game.button[i].set == 0) {
                        /*set[i + 13] = rnd.nextInt(2);*/
                        game.button[i].val = game.button[i - 1].set + game.button[i + 1].set + game.button[i + 11].set + game.button[i + 12].set + game.button[i + 13].set + game.button[i - 11].set + game.button[i - 12].set + game.button[i - 13].set;
                    }
                }
                
                if (game.button[j + 11].set == 0) {
                    game.button[j + 11].val = game.button[j + 10].set + game.button[j + 23].set + game.button[j + 22].set + game.button[j - 1].set + game.button[j - 2].set;
                }
            }
            
            if (game.button[132].set == 0) {
                game.button[132].val = game.button[120].set + game.button[121].set + game.button[133].set;
            }
            
            for (int i = 133; i < 143; i++) {
                if (game.button[i].set == 0) {
                    game.button[i].val = game.button[i - 1].set + game.button[i + 1].set + game.button[i - 11].set + game.button[i - 12].set + game.button[i - 13].set;
                }
            }
            
            if (game.button[143].set == 0) {
                game.button[143].val = game.button[130].set + game.button[131].set + game.button[142].set;
            }
            
            game.jTextField1.setText(Integer.toString(game.bomb));
        });
    }

    private Layout button[];
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    
    private final ImageIcon numIcon[], blastIcon, mineIcon, flagIcon, crossFlagIcon, sadIcon, normalIcon, smileIcon;
}

class Layout extends javax.swing.JToggleButton {

    int val, set, realFlag, id;

    public Layout() {
        val = 0;
        set = 0;
        realFlag = 0;
        id = 0;
    }
}

class StartTime extends Thread {

    javax.swing.JTextField j;

    public StartTime(javax.swing.JTextField j1) {
        j = j1;
    }

    @Override
    public void run() {
        new Watch(j);
    }
}