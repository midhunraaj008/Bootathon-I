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
import javax.swing.table.DefaultTableModel;

public class ViewTutor implements ActionListener {
    JFrame frame;
    JLabel ltitle,lselectdp,lselectyr,lselectid;
    JTextField tid;
    JComboBox cyear,cdepartment;
    JButton back,bsave,bsearch;
    Connection con = Sqlconn.getconnection();

    public ViewTutor(){
        frame = new JFrame("VIEW TUTOR");
        ImageIcon icon = new ImageIcon("E:\\Photo\\ski.jpg");
        frame.setIconImage(icon.getImage());
        frame.setResizable(false);
        ltitle = new JLabel("     VIEW TUTOR DETAILS");
        frame.add(ltitle);
        ltitle.setFont(new Font("Times New Roman",Font.BOLD,25));
        ltitle.setOpaque(true);
        ltitle.setBackground(new Color(0xE28A3F));
        ltitle.setBounds(0,20,800,30);

        lselectdp = new JLabel("Select by Department");
        frame.add(lselectdp);
        lselectdp.setFont(new Font("Times New Roman",Font.BOLD,20));
        lselectdp.setBounds(60, 80, 200, 20);
        
        String department[] = {"","MECH","ECE","EEE","ICE","CIVIL","IT","CSE"};
        cdepartment = new JComboBox(department);
        frame.add(cdepartment);
        cdepartment.setFont(new Font("Times New Roman",Font.BOLD,20));
        cdepartment.setBounds(270,80,200,20);
        
        lselectyr = new JLabel("Select by Year");
        frame.add(lselectyr);
        lselectyr.setFont(new Font("Times New Roman",Font.BOLD,20));
        lselectyr.setBounds(60, 120, 200, 20);
        
        
       
        String year[] = {"","I","II","III","IV"};
        cyear = new JComboBox(year);
        frame.add(cyear);
        cyear.setFont(new Font("Times New Roman",Font.BOLD,20));
        cyear.setBounds(270,120,200,20);
        
        lselectid = new JLabel("View by id");
        frame.add(lselectid);
        lselectid.setFont(new Font("Times New Roman",Font.BOLD,20));
        lselectid.setBounds(60, 160, 200, 20);
        
        tid = new JTextField();
        frame.add(tid);
        tid.setFont(new Font("Times New Roman",Font.BOLD,20));
        tid.setBounds(270,160,200,25);

        
        bsearch = new JButton("Search");
        frame.add(bsearch);
        bsearch.setFont(new Font("Times New Roman",Font.BOLD,20));
        bsearch.setBounds(540, 100, 100, 20);
        bsearch.addActionListener(this);
      
        back = new JButton("Back");
        frame.add(back);
        back.setFont(new Font("Times New Roman",Font.BOLD,20));
        back.setBounds(540,140,100,20);
        back.addActionListener(this);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        
        
    
 }
  void increment(int i)
  {
         if (i < 1) {

                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

            }

                 if (i == 1) {

                System.out.println(i + " Record Found");

            } else {

                System.out.println(i + " Records Found");

            }
  }
   
   

public void actionPerformed(ActionEvent ae) {

     if (ae.getSource().equals(bsearch)) {
             
         String dept=(String) cdepartment.getItemAt(cdepartment.getSelectedIndex());
         
         String year=(String) cyear.getItemAt(cyear.getSelectedIndex());;
         String id=tid.getText();
        String name="";
        String sect="";
        String mail="";
        String contact="";  
        if(dept.equals("") && year.equals("") && id.equals(""))
        {
            
             JFrame f1;    
             f1=new JFrame("View tutor details");    
      
    String[] columnNames = {"ID","NAME","DEPT","YEAR","SECTION","MAIL","CONTACT"};
    DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(columnNames);
    
    
    JTable table=new JTable();   
     table.setModel(model);
     table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
     table.setFillsViewportHeight(true);
     table.setBounds(30,40,200,300);          
    JScrollPane scroll=new JScrollPane(table);    
    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    f1.add(scroll);          
    
    f1.setSize(800,600);    
    f1.setVisible(true);  
    f1.setLocationRelativeTo(null);
    //f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
             try {
                 PreparedStatement  prst1 = con.prepareStatement("select * from tutor");
                 
                 ResultSet rs = prst1.executeQuery();
                 int i=0;
                  while (rs.next()) {
                      
                       id = rs.getString("id");
                       name = rs.getString("name");
                       dept = rs.getString("department");
                       year = rs.getString("year");
                       sect = rs.getString("section");
                       mail = rs.getString("mailid");
                       contact = rs.getString("contact");
                

                model.addRow(new Object[]{id, name, dept, year,sect,mail,contact});

                i++;
                      System.out.println("");

            } 
                 increment(i);
             } catch (SQLException ex) {
                 Logger.getLogger(ViewTutor.class.getName()).log(Level.SEVERE, null, ex);
             }
        
        
        }
        else if(dept!="")
        {
            cyear.setSelectedIndex(0);
            JFrame f;    
             f=new JFrame("View tutor details");    
      
    String[] columnNames = {"ID","NAME","DEPT","YEAR","SECTION","MAIL","CONTACT"};
    DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(columnNames);
    
    
    JTable table=new JTable();   
     table.setModel(model);
     table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
     table.setFillsViewportHeight(true);
     table.setBounds(30,40,200,300);          
    JScrollPane scroll=new JScrollPane(table);    
    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    f.add(scroll);          
    
    f.setSize(800,600);    
    f.setVisible(true);  
    f.setLocationRelativeTo(null);
   // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
             try {
                 PreparedStatement  prst1 = con.prepareStatement("select * from tutor where department=?");
                 prst1.setString(1, dept);
                 ResultSet rs = prst1.executeQuery();
                 int i=0;
                  while (rs.next()) {
                      
                       id = rs.getString("id");
                       name = rs.getString("name");
                       dept = rs.getString("department");
                       year = rs.getString("year");
                       sect = rs.getString("section");
                       mail = rs.getString("mailid");
                       contact = rs.getString("contact");
                

                model.addRow(new Object[]{id, name, dept, year,sect,mail,contact});

                i++;

            } 
              increment(i);   
             } catch (SQLException ex) {
                 Logger.getLogger(ViewTutor.class.getName()).log(Level.SEVERE, null, ex);
             }
        
        
        }
        else if(year!="")
               {
                   
                JFrame f3;    
             f3=new JFrame("View tutor details");    
      
    String[] columnNames = {"ID","NAME","DEPT","YEAR","SECTION","MAIL","CONTACT"};
    DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(columnNames);
    
    
    JTable table=new JTable();   
     table.setModel(model);
     table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
     table.setFillsViewportHeight(true);
     table.setBounds(30,40,200,300);          
    JScrollPane scroll=new JScrollPane(table);    
    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    f3.add(scroll);          
    
    f3.setSize(800,600);    
    f3.setVisible(true);  
    f3.setLocationRelativeTo(null);
   // f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
             try {
                 PreparedStatement  prst1 = con.prepareStatement("select * from tutor where year=?");
                 prst1.setString(1, year);
                 ResultSet rs = prst1.executeQuery();
                 int i=0;
                  while (rs.next()) {
                      
                       id = rs.getString("id");
                       name = rs.getString("name");
                       dept = rs.getString("department");
                       year = rs.getString("year");
                       sect = rs.getString("section");
                       mail = rs.getString("mailid");
                       contact = rs.getString("contact");
                       model.addRow(new Object[]{id, name, dept, year,sect,mail,contact});
                       i++;

                       } 
                 increment(i);
             } catch (SQLException ex) {
                 Logger.getLogger(ViewTutor.class.getName()).log(Level.SEVERE, null, ex);
             }
        
        
               }
            
     else
     {
        JFrame f;    
             f=new JFrame("View tutor details");    
      
    String[] columnNames = {"ID","NAME","DEPT","YEAR","SECTION","MAIL","CONTACT"};
    DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(columnNames);
    
    
    JTable table=new JTable();   
     table.setModel(model);
     table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
     table.setFillsViewportHeight(true);
     table.setBounds(30,40,200,300);          
    JScrollPane scroll=new JScrollPane(table);    
    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    f.add(scroll);          
    
    f.setSize(800,600);    
    f.setVisible(true);  
    f.setLocationRelativeTo(null);
   // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
             try {
                 PreparedStatement  prst1=(PreparedStatement)con.prepareStatement("select * from tutor where id=?");
                 prst1.setString(1, id);
                 ResultSet rs = prst1.executeQuery();
                 int i=0;
                  while (rs.next()) {
                      
                       id = rs.getString("id");
                       name = rs.getString("name");
                       dept = rs.getString("department");
                       year = rs.getString("year");
                       sect = rs.getString("section");
                       mail = rs.getString("mailid");
                       contact = rs.getString("contact");
                

                model.addRow(new Object[]{id, name, dept, year,sect,mail,contact});

                i++;

            } 
                   increment(i);
             } catch (SQLException ex) {
                 Logger.getLogger(ViewTutor.class.getName()).log(Level.SEVERE, null, ex);
             }
     }
         
     }
        if(ae.getSource().equals(back)){
            frame.dispose();
            new AdminPage();
        }

 }
}

  
  