package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
    public class AdminCredentials implements ActionListener
    {
        JFrame frame;
        JLabel ltitle,lusername,luser,lpass,lpassword;
        JTextField tusername,p1;
        JButton bdisplay,bupdate,back,bclear;


        public AdminCredentials()
        {
            frame = new JFrame("ADMIN CREDENTIALS");
            ltitle = new JLabel("HI ADMIN");
            frame.add(ltitle);
            frame.setResizable(false);
            ImageIcon icon = new ImageIcon("E:\\photo\\ski.jpg");
            frame.setIconImage(icon.getImage());
            ltitle.setFont(new Font("Times New Roman",Font.BOLD,32));
            ltitle.setOpaque(true);
            ltitle.setBackground(new Color(0xE28A3F));
            ltitle.setBounds(0,20,800,60);



            ImageIcon userIcon = new ImageIcon(new ImageIcon("E:\\photo\\us.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
            lusername = new JLabel();
            lusername.setIcon(userIcon);
            frame.add(lusername);
            lusername.setFont(new Font("Times New Roman",Font.BOLD,20));
            lusername.setBounds(120,100,300,200);

            luser = new JLabel("USERNAME");
            frame.add(luser);
            luser.setFont(new Font("Times New Roman",Font.BOLD,20));
            luser.setBounds(200,180,300,20);

            tusername = new JTextField();
            frame.add(tusername);
            tusername.setFont(new Font("Times New Roman",Font.BOLD,20));
            tusername.setBounds(200,210,360,30);

            ImageIcon imageIcon = new ImageIcon(new ImageIcon("E:\\photo\\ps.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            lpass = new JLabel();
            lpass.setIcon(imageIcon);
            frame.add(lpass);
            lpass.setFont(new Font("Times New Roman",Font.BOLD,20));
            lpass.setBounds(120,185,300,200);

            lpassword = new JLabel("PASSWORD");
            frame.add(lpassword);
            lpassword.setFont(new Font("Times New Roman",Font.BOLD,20));
            lpassword.setBounds(200,260,300,20);

            p1 = new JTextField();
            frame.add(p1);
            p1.setFont(new Font("Times New Roman",Font.BOLD,20));
            p1.setBounds(200,290,360,30);


            bdisplay = new JButton("DISPLAY");
            frame.add(bdisplay);
            bdisplay.setFont(new Font("Times New Roman",Font.BOLD,20));
            bdisplay.setBounds(100,380,150,20);
            bdisplay.addActionListener(this);


            bupdate = new JButton("UPDATE");
            frame.add(bupdate);
            bupdate.setFont(new Font("Times New Roman",Font.BOLD,20));
            bupdate.setBounds(300,380,150,20);
            bupdate.addActionListener(this);

            back = new JButton("BACK");
            frame.add(back);
            back.setFont(new Font("Times New Roman",Font.BOLD,20));
            back.setBounds(500,380,150,20);
            back.addActionListener(this);

            bclear = new JButton("CLEAR");
            frame.add(bclear);
            bclear.setFont(new Font("Times New Roman",Font.BOLD,20));
            bclear.setBounds(300,420,150,20);
            bclear.addActionListener(this);



            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //frame.getContentPane().setBackground(Color.GRAY);
            frame.setSize(800,600);
            frame.setLocationRelativeTo(null);
            frame.setLayout(null);
            frame.setVisible(true);
        }

        public void clearform()
        {
            tusername.setText("");
            p1.setText("");
        }



        @Override
        public void actionPerformed(ActionEvent ae)
        {
            Connection con = Sqlconn.getconnection();
            if(ae.getSource()==bdisplay)
            {
                try
                {
                    PreparedStatement ps = con.prepareStatement("select * from `admin`");

                    ResultSet rs = ps.executeQuery();

                    while(rs.next())
                    {
                        tusername.setText(rs.getString(2));
                        p1.setText(rs.getString(3));
                    }
                }
                catch (SQLException ex)
                {
                    Logger.getLogger(AdminCredentials.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


            if(ae.getSource()==bupdate)
            {
                try
                {
                    String username=tusername.getText();
                    String password=p1.getText();
                    String id = "1";
                    PreparedStatement prs=con.prepareStatement("UPDATE `admin` SET `username`=? ,`password`=? WHERE username=?");
                    prs.setString(1, username);
                    prs.setString(2, password);
                    prs.setString(3,username);
                    int answer = JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO SAVE CHANGES??",
                            "Confirm Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
                    switch(answer)
                    {
                        case JOptionPane.YES_OPTION:
                        {
                            prs.executeUpdate();
                            JOptionPane.showMessageDialog(null,"CREDENTIALS UPDATED");
                            break;
                        }
                        case JOptionPane.NO_OPTION:
                        {
                            break;
                        }
                        case JOptionPane.CANCEL_OPTION:
                        {
                            new AdminCredentials();
                            break;
                        }
                    }
                }
                catch (SQLException ex)
                {
                    Logger.getLogger(AdminCredentials.class.getName()).log(Level.SEVERE, null, ex);
                }

            }



            if(ae.getSource()==back)
            {
                frame.dispose();
                new AdminPage();
            }


            if(ae.getSource()==bclear)
            {
                clearform();
            }
        }
    }



