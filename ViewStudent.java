package com.company;

import javax.swing.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

    public class ViewStudent {
        JFrame f1;

        Connection con;
        PreparedStatement pst = null;
        ResultSet rs = null;

        public ViewStudent(){

            con = Sqlconn.getconnection();

            f1 = new JFrame("View Student details");

            String[] columnNames = {"Regno","Name","Gender","Department","Year","Section","Mode","MailID","Contact"};
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


            try {
                pst = con.prepareStatement("select * from iii_cse_b");
                rs = pst.executeQuery();
                while (rs.next()) {

                    String regno = rs.getString("Regno");
                    String name = rs.getString("Name");
                    String gender = rs.getString("Gender");
                    String dept = rs.getString("Department");
                    String year = rs.getString("Year");
                    String section = rs.getString("Section");
                    String dh = rs.getString("Mode");
                    String mail = rs.getString("MailID");
                    String contact = rs.getString("Contact");

                    model.addRow(new Object[]{regno, name, gender, dept, year,section,dh,mail,contact});

                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
