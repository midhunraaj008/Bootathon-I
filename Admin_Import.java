package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_Import implements ActionListener {

    JFrame frame;
    JLabel ldepartment,lyear,lsection,l_title;
    JComboBox cdepartment,cyear,csection;
    JButton b_select;
    String tablename,dept,year,section;

    public Admin_Import()
    {
        frame = new JFrame("Select Class");
        frame.setResizable(false);

        l_title = new JLabel("   Class");
        frame.add(l_title);
        l_title.setFont(new Font("Times New Roman",Font.BOLD,32));
        l_title.setOpaque(true);
        l_title.setBackground(new Color(0xE28A3F));
        l_title.setBounds(0,50,800,60);

        ldepartment = new JLabel("DEPARTMENT");
        frame.add(ldepartment);
        ldepartment.setFont(new Font("Times New Roman",Font.BOLD,20));
        ldepartment.setBounds(150,200,170,20);

        String department[] = {"","MECH","ECE","EEE","ICE","CIVIL","IT","CSE"};
        cdepartment = new JComboBox(department);
        frame.add(cdepartment);
        cdepartment.setFont(new Font("Times New Roman",Font.BOLD,20));
        cdepartment.setBounds(400,200,170,20);

        lyear = new JLabel("YEAR");
        frame.add(lyear);
        lyear.setFont(new Font("Times New Roman",Font.BOLD,20));
        lyear.setBounds(150,250,170,20);

        String year[] = {"","I","II","III","IV"};
        cyear = new JComboBox(year);
        frame.add(cyear);
        cyear.setFont(new Font("Times New Roman",Font.BOLD,20));
        cyear.setBounds(400,250,170,20);

        lsection = new JLabel("SECTION");
        frame.add(lsection);
        lsection.setFont(new Font("Times New Roman",Font.BOLD,20));
        lsection.setBounds(150,300,170,20);

        String section[] = {"","A","B","C"};
        csection = new JComboBox(section);
        frame.add(csection);
        csection.setFont(new Font("Times New Roman",Font.BOLD,20));
        csection.setBounds(400,300,170,20);

        b_select = new JButton("SELECT");
        frame.add(b_select);
        b_select.setFont(new Font("Times New Roman",Font.BOLD,15));
        b_select.setBounds(425,400,100,20);
        b_select.addActionListener(this);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(b_select)) {

            dept = cdepartment.getSelectedItem().toString();
            year = cyear.getSelectedItem().toString();
            section = csection.getSelectedItem().toString();
            tablename = year + "_" + dept + "_" + section;

            new datafromcsv(tablename,tablename+"_att");
            frame.dispose();

        }
    }


}
