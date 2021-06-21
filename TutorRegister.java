package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.awt.Color;
import java.sql.*;


public class TutorRegister implements ActionListener {
    JFrame frame;
    JLabel ltitle,lname,lid,ldeparment,lyear,lsection,ldob,lmailid,lcontact,lhand,ldetail,ldetail1;
    JTextArea tname,tid,tcontact,tmailid,tdob;
    JComboBox cdepartment,cyear,csection;
    JButton bsave, back,bedit,bdel,bsearch,bclear;
    Connection con = Sqlconn.getconnection();


    public TutorRegister(){
        frame = new JFrame("REGISTER");
        ImageIcon icon = new ImageIcon("E:\\Photo\\ski.jpg");
        frame.setIconImage(icon.getImage());
        frame.setResizable(false);

        ltitle = new JLabel("TUTOR REGISTER");
        frame.add(ltitle);
        ltitle.setFont(new Font("Times New Roman",Font.BOLD,32));
        ltitle.setOpaque(true);
        ltitle.setBackground(new Color(0xE28A3F));
        ltitle.setBounds(0,20,800,60);

        lid = new JLabel("ID");
        frame.add(lid);
        lid.setFont(new Font("Times New Roman",Font.BOLD,20));
        lid.setBounds(80,100,100,20);

        tid = new JTextArea();
        frame.add(tid);
        tid.setFont(new Font("Times New Roman",Font.BOLD,20));
        tid.setBounds(300,100,250,25);

        bsearch = new JButton("SEARCH");
        frame.add(bsearch);
        bsearch.setFont(new Font("Times New Roman",Font.BOLD,15));
        bsearch.setBounds(570,100,100,20);
        bsearch.addActionListener(this);

        ldetail=new JLabel("(Enter ID To Search,");
        frame.add(ldetail);
        ldetail.setFont(new Font("Arial",Font.ITALIC,15));
        ldetail.setForeground(new Color(102,102,102));
        ldetail.setBounds(570,120,200,20);

        ldetail1=new JLabel("Update/delete)");
        frame.add(ldetail1);
        ldetail1.setFont(new Font("Arial",Font.ITALIC,15));
        ldetail1.setForeground(new Color(102,102,102));
        ldetail1.setBounds(570,140,200,20);


        lname = new JLabel("NAME");
        frame.add(lname);
        lname.setFont(new Font("Times New Roman",Font.BOLD,20));
        lname.setBounds(80,140,100,20);

        tname = new JTextArea();
        frame.add(tname);
        tname.setFont(new Font("Times New Roman",Font.BOLD,20));
        tname.setBounds(300,140,250,25);



        ldeparment = new JLabel("DEPARTMENT");
        frame.add(ldeparment);
        ldeparment.setFont(new Font("Times New Roman",Font.BOLD,20));
        ldeparment.setBounds(80,180,150,20);

        String department[] = {"","MECH","ECE","EEE","ICE","CIVIL","IT","CSE"};
        cdepartment = new JComboBox(department);
        frame.add(cdepartment);
        cdepartment.setFont(new Font("Times New Roman",Font.BOLD,20));
        cdepartment.setBounds(300,180,200,20);

        lhand = new JLabel("CLASS HANDLED");
        frame.add(lhand);
        lhand.setFont(new Font("Times New Roman",Font.BOLD,20));
        lhand.setBounds(80,220,200,20);

        lyear = new JLabel("YEAR");
        frame.add(lyear);
        lyear.setFont(new Font("Times New Roman",Font.BOLD,20));
        lyear.setBounds(380,220,100,20);

        String year[] = {"","I","II","III","IV"};
        cyear = new JComboBox(year);
        frame.add(cyear);
        cyear.setFont(new Font("Times New Roman",Font.BOLD,20));
        cyear.setBounds(300,220,70,20);

        lsection = new JLabel("SECTION");
        frame.add(lsection);
        lsection.setFont(new Font("Times New Roman",Font.BOLD,20));
        lsection.setBounds(520,220,100,20);

        String section[] = {"","A","B","C"};
        csection = new JComboBox(section);
        frame.add(csection);
        csection.setFont(new Font("Times New Roman",Font.BOLD,20));
        csection.setBounds(440,220,70,20);


        lmailid = new JLabel("MAIL-ID");
        frame.add(lmailid);
        lmailid.setFont(new Font("Times New Roman",Font.BOLD,20));
        lmailid.setBounds(80,260,100,20);

        tmailid = new JTextArea();
        frame.add(tmailid);
        tmailid.setFont(new Font("Times New Roman",Font.BOLD,20));
        tmailid.setBounds(300,260,250,25);

        lcontact = new JLabel("CONTACT");
        frame.add(lcontact);
        lcontact.setFont(new Font("Times New Roman",Font.BOLD,20));
        lcontact.setBounds(80,300,100,20);

        tcontact = new JTextArea();
        frame.add(tcontact);
        tcontact.setFont(new Font("Times New Roman",Font.BOLD,20));
        tcontact.setBounds(300,300,250,25);


        bsave = new JButton("SAVE");
        frame.add(bsave);
        bsave.setFont(new Font("Times New Roman",Font.BOLD,20));
        bsave.setBounds(80,420,150,20);
        bsave.addActionListener(this);

        back = new JButton("BACK");
        frame.add(back);
        back.setFont(new Font("Times New Roman",Font.BOLD,20));
        back.setBounds(580,420,150,20);
        back.addActionListener(this);

        bedit = new JButton("UPDATE");
        frame.add(bedit);
        bedit.setFont(new Font("Times New Roman",Font.BOLD,20));
        bedit.setBounds(250,420,150,20);
        bedit.addActionListener(this);

        bdel = new JButton("DELETE");
        frame.add(bdel);
        bdel.setFont(new Font("Times New Roman",Font.BOLD,20));
        bdel.setBounds(420,420,150,20);
        bdel.addActionListener(this);

        bclear = new JButton("CLEAR");
        frame.add(bclear);
        bclear.setFont(new Font("Times New Roman",Font.BOLD,20));
        bclear.setBounds(330,460,150,20);
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
        tid.setText("");
        tname.setText("");
        tmailid.setText("");
        tcontact.setText("");
        cyear.setSelectedIndex(0);
        cdepartment.setSelectedIndex(0);
        csection.setSelectedIndex(0);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //int id =Integer.parseInt( tid.getText());
        String id =tid.getText();
        String name=tname.getText();
        String mail=tmailid.getText();
        //BigInteger contact=new BigInteger(tcontact.getText());
        String contact =tcontact.getText();
        String year=(String) cyear.getItemAt(cyear.getSelectedIndex());
        String section =(String) csection.getItemAt(csection.getSelectedIndex());
        String department=(String) cdepartment.getItemAt(cdepartment.getSelectedIndex());

        String NAME_REGEX ="^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
        Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);

        String ID_REGEX = "^[a-zA-Z0-9_]+$";
        Pattern ID_PATTERN =Pattern.compile(ID_REGEX);

        String CONTACT_REGEX = "^\\D?(\\d{3})\\D?\\D?(\\d{3})\\D?(\\d{4})$";
        Pattern CONTACT_PATTERN = Pattern.compile(CONTACT_REGEX);


        String MAIL_REGEX ="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*"+"@skct.edu.in";
        String MAIL_REGEX1 ="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*"+"@skcet.edu.in";

        Pattern MAIL_PATTERN = Pattern.compile(MAIL_REGEX);
        Pattern MAIL_PATTERN1 = Pattern.compile(MAIL_REGEX1);



        if(e.getSource().equals(bsave))
        {    int flag=0;
            if (ID_PATTERN.matcher(id).matches() && NAME_PATTERN.matcher(name).matches() &&

                    (MAIL_PATTERN.matcher(mail).matches() || MAIL_PATTERN1.matcher(mail).matches()) &&

                    CONTACT_PATTERN.matcher(contact).matches() )
            {
                JOptionPane.showMessageDialog(null,"TUTOR ACCOUNT CREATED SUCCESSFULLY");
                flag=1;
            }
            else
            {
                JOptionPane.showMessageDialog(null,"INVALID CREDENTIALS!!!TRY AGAIN");

            }
            if(flag==1){
                try {
                    PreparedStatement pstmt=con.prepareStatement("INSERT INTO `tutor`(`id`, `name`, `department`, `year`, `section`, `mailid`, `contact`,`password`,`classname`) VALUES (?,?,?,?,?,?,?,?,?)");
                    pstmt.setString(1, id);
                    pstmt.setString(2, name);
                    pstmt.setString(3, department);
                    pstmt.setString(4, year);
                    pstmt.setString(5, section);
                    pstmt.setString(6, mail);
                    pstmt.setString(7, contact);
                    pstmt.setString(8, contact);
                    String tablename = year+"_"+department+"_"+section;
                    pstmt.setString(9, tablename);
                    pstmt.executeUpdate();

                    PreparedStatement prstmt = con.prepareStatement("create table "+tablename+" (regno varchar(10) NOT NULL,name varchar(30),gender varchar(6),department varchar(6),year varchar(4),section varchar(1),mode varchar(10),mailid varchar(30),contact varchar(10),password varchar(10),primary key(regno))");
                    prstmt.executeUpdate();
                    String tabname=tablename+"_att";
                    PreparedStatement preestmt=con.prepareStatement("create table "+tabname+" (Att_Date date)");
                    preestmt.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }

        if(e.getSource().equals(back)){
            frame.dispose();
            new AdminPage();
        }
        if(e.getSource().equals(bsearch)){

            try {

                PreparedStatement ps=(PreparedStatement)con.prepareStatement("select * from `tutor` where `id`=?");
                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();

                while(rs.next())
                {
                    tname.setText(rs.getString(2));
                    cdepartment.setSelectedItem(rs.getObject(3));
                    cyear.setSelectedItem(rs.getObject(4));
                    csection.setSelectedItem(rs.getObject(5));
                    tmailid.setText(rs.getString(6));
                    tcontact.setText(rs.getString(7));
                }
                if(tname.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"NO RECORD");
                    clearform();
                }

            } catch (SQLException ex) {

                System.out.println(ex);
            }
        }
        if(e.getSource().equals(bdel))
        {
            PreparedStatement prs,prs1,prs2;
            String tablename1 = year+ "_"+department+ "_"+section;
            String tabname1   = tablename1+"_att";
            try {
                prs = (PreparedStatement)con.prepareStatement("DELETE FROM `tutor` WHERE `id`=?");
                prs.setString(1, id);
                int answer = JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO DELETE ??",
                        "Confirm Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
                switch(answer)
                {
                    case JOptionPane.YES_OPTION:
                    {
                        prs.executeUpdate();

                        prs1= (PreparedStatement)con.prepareStatement("DROP TABLE "+tablename1+"");
                        prs1.executeUpdate();
                        prs2= (PreparedStatement)con.prepareStatement("DROP TABLE "+tabname1+"");
                        prs2.executeUpdate();
                        JOptionPane.showMessageDialog(null,"RECORD DELETED");
                        clearform();
                        break;
                    }
                    case JOptionPane.NO_OPTION:
                    {
                        clearform();
                        break;
                    }
                    case JOptionPane.CANCEL_OPTION:
                    {
                        new AdminPage();
                        break;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(TutorRegister.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if(e.getSource().equals(bedit))
        {
            int flag=0;
            if (ID_PATTERN.matcher(id).matches() && NAME_PATTERN.matcher(name).matches() &&

                    (MAIL_PATTERN.matcher(mail).matches() || MAIL_PATTERN1.matcher(mail).matches()) &&

                    CONTACT_PATTERN.matcher(contact).matches() )
            {
                JOptionPane.showMessageDialog(null,"RECORD UPDATED");
                flag=1;
            }
            else
            {
                JOptionPane.showMessageDialog(null,"INVALID CREDENTIALS!!!TRY AGAIN");

            }
            if(flag==1){
                PreparedStatement prepstmt;
                try {

                    prepstmt = (PreparedStatement)con.prepareStatement("UPDATE `tutor` SET `name`=?,`mailid`=?,`contact`=?,`password`=? WHERE `id`=?");
                    prepstmt.setString(1, name);
                    prepstmt.setString(2, mail);
                    prepstmt.setString(3, contact);
                    prepstmt.setString(4, contact);
                    prepstmt.setString(5, id);
                    prepstmt.executeUpdate();


                }
                catch (SQLException ex) {
                    Logger.getLogger(TutorRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if(e.getSource().equals(bclear)){
            clearform();
        }
    }
}