package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage implements ActionListener {
  JFrame frame;
    JLabel ltitle,ladmin,ltutor,lstudent,latt,lvstudent,lvtutor;
    JButton badmin,btutor,bstudent,batt,bvstudent,bvtutor,back;
        String name = "ADMIN";

    public AdminPage()
    {
        frame = new JFrame("ADMIN PORTAL");//Frame gets created
        frame.setResizable(false);
        
        
        ltitle = new JLabel("   WELCOME "+name);
        frame.add(ltitle);
        ImageIcon icon = new ImageIcon("E:\\photo\\ski.jpg");
        frame.setIconImage(icon.getImage());
        ltitle.setFont(new Font("Times New Roman",Font.BOLD,20));
        ltitle.setOpaque(true);
        ltitle.setBackground(new Color(0xE28A3F));
        ltitle.setBounds(0,50,800,60);

        ImageIcon admin = new ImageIcon(new ImageIcon("E:\\photo\\admin.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
        badmin = new JButton();
        badmin.setIcon(admin);
        frame.add(badmin);
        badmin.setFont(new Font("Times New Roman",Font.BOLD,15));
        badmin.setBounds(100,250,120,120);
        badmin.addActionListener(this);

        ladmin = new JLabel("ADMIN CREDENTIALS");
        frame.add(ladmin);
        ladmin.setFont(new Font("Times New Roman",Font.BOLD,15));
        ladmin.setBounds(80,390,200,20);

       
        ImageIcon tutor = new ImageIcon(new ImageIcon("E:\\photo\\tutor.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
        btutor = new JButton();
        btutor.setIcon(tutor);
        frame.add(btutor);
        btutor.setFont(new Font("Times New Roman",Font.BOLD,15));
        btutor.setBounds(325,150,120,120);
        btutor.addActionListener(this);            


        ltutor = new JLabel("TUTOR CREDENTIALS");
        frame.add(ltutor);
        ltutor.setFont(new Font("Times New Roman",Font.BOLD,15));
        ltutor.setBounds(315,290,200,20);

        ImageIcon student = new ImageIcon(new ImageIcon("E:\\photo\\pic1.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
        bstudent = new JButton();
        bstudent.setIcon(student);
        frame.add(bstudent);
        bstudent.setFont(new Font("Times New Roman",Font.BOLD,15));
        bstudent.setBounds(550,150,120,120);
        bstudent.addActionListener(this);

        lstudent = new JLabel("STUDENT CREDENTIALS");
        frame.add(lstudent);
        lstudent.setFont(new Font("Times New Roman",Font.BOLD,15));
        lstudent.setBounds(555,290,200,20);
       
        ImageIcon viewstudent = new ImageIcon(new ImageIcon("E:\\photo\\viewstudent.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
        bvstudent = new JButton();
        bvstudent.setIcon(viewstudent);
        frame.add(bvstudent);
        bvstudent.setFont(new Font("Times New Roman",Font.BOLD,15));
        bvstudent.setBounds(550,360,120,120);
        bvstudent.addActionListener(this);
       
       
        lvstudent = new JLabel("VIEW STUDENT DETAILS");
        frame.add(lvstudent);
        lvstudent.setFont(new Font("Times New Roman",Font.BOLD,15));
        lvstudent.setBounds(550,500,200,20);
       
        ImageIcon viewtutor = new ImageIcon(new ImageIcon("E:\\photo\\teacher.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
        bvtutor = new JButton();
        bvtutor.setIcon(viewtutor);
        frame.add(bvtutor);
        bvtutor.setFont(new Font("Times New Roman",Font.BOLD,15));
        bvtutor.setBounds(325,360,120,120);
        bvtutor.addActionListener(this);
       
         lvtutor = new JLabel("VIEW TUTOR DETAILS");
        frame.add(lvtutor);
        lvtutor.setFont(new Font("Times New Roman",Font.BOLD,15));
        lvtutor.setBounds(315,500,200,20);

       // ImageIcon logout = new ImageIcon(new ImageIcon("E:\\Photos\\log.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
        back = new JButton("LOGOUT");
       // b7.setIcon(logout);
        frame.add(back);
        back.setFont(new Font("Times New Roman",Font.BOLD,15));
        back.setBounds(650,10,100,30);
        back.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().setBackground(Color.GRAY);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(badmin)){
            frame.dispose();
            new AdminCredentials();
        }
        if(e.getSource().equals(bstudent)){
            frame.dispose();
            new admin_StudentRegister();
        }
        if(e.getSource().equals(btutor)){
            frame.dispose();
            new TutorRegister();
        }
        if(e.getSource().equals(bvtutor)){
            frame.dispose();
            new ViewTutor();
        }
         if(e.getSource().equals(bvstudent)){
            new ViewStudent();
        }
         if(e.getSource().equals(back)){
            frame.dispose();
            new AdminLogin();
        }
    }
}