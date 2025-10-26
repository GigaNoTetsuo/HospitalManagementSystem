package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

public class details extends JFrame implements ActionListener{
    JTextField addname;//tfname,tf_fname,tfid,tfcnic,tfemail,tfcell,tfaddress,tfpms,tfdob;
    JButton search,cancel,update;
    JLabel lblhid,tfpms,tfname,tf_fname,tfcnic,tfemail,dcdob,tfqual,tfspecs,tfaddress,tfcell;
    JComboBox category,type;
    JTable tab;
   // JDateChooser dcdob;
    
    details(){
        setLayout(null);
        setSize(700,500);
        setLocation(350,150);

        JLabel head=new JLabel("USER DETAILS");
        head.setBounds(250,10,300,30);
        head.setFont(new Font("tahoma",Font.BOLD,22));
        add(head);
        
         
        
        JLabel catg=new JLabel("Category: ");
        catg.setBounds(20,70,80,20);
        catg.setFont(new Font("tahoma",Font.BOLD,15));
        add(catg);
        String[] cat={"Select Category","Doctor","Receptionist","Pharmacy Staff"};
        category=new JComboBox(cat);
        category.setBounds(100,70,120,20);
        add(category);
        
        JLabel txt=new JLabel("Select by: ");
        txt.setBounds(250,65,90,30);
        txt.setFont(new Font("tahoma",Font.BOLD,15));
        add(txt);
        
        String[] types={"--Select Type--","Username","Hospital ID"};
        type=new JComboBox(types);
        type.setBounds(330,70,110,20);
        add(type);
        
        addname=new JTextField();
        addname.setBounds(440,71,120,20);
        add(addname);
        
        tab=new JTable();
        
        category.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                   if(category.getSelectedItem()=="Doctor"){
                    try{
                        Conn c=new Conn();
                        ResultSet rs=c.s.executeQuery("select *from doctor");
                        tab.setModel(DbUtils.resultSetToTableModel(rs));
                    }catch(Exception e){
                        e.printStackTrace();
                    };
                   }else if(category.getSelectedItem()=="Receptionist"){
                    try{
                        Conn c=new Conn();
                        ResultSet rs=c.s.executeQuery("select *from receptionist");
                        tab.setModel(DbUtils.resultSetToTableModel(rs));
                    }catch(Exception e){
                        e.printStackTrace();
                    };
                   }else if(category.getSelectedItem()=="Pharmacy Staff"){
                    try{
                        Conn c=new Conn();
                        ResultSet rs=c.s.executeQuery("select *from pharmacist");
                        tab.setModel(DbUtils.resultSetToTableModel(rs));
                    }catch(Exception e){
                        e.printStackTrace();
                    };
                   }
            }
        });

            
        JScrollPane scroll=new JScrollPane(tab);
        scroll.setBounds(0,100,900,300);
        add(scroll);
        
       
        search=new JButton("SEARCH");
        search.setBackground(Color.BLUE);
        search.setForeground(Color.white);
        search.setBounds(570,70,100,20);
        search.setFont(new Font("times new roman",Font.BOLD,16));
        search.addActionListener(this);
        add(search);
        
        cancel=new JButton("CANCEL");
        cancel.setBackground(new Color(120,20,40));
        cancel.setForeground(Color.white);
        cancel.setBounds(450,450,100,30);
        cancel.setFont(new Font("times new roman",Font.BOLD,16));
        cancel.addActionListener(this);
        add(cancel);
       
        update=new JButton("UPDATE");
        update.setBackground(new Color(120,20,40));
        update.setForeground(Color.white);
        update.setBounds(250,450,100,30);
        update.setFont(new Font("times new roman",Font.BOLD,16));
        update.addActionListener(this);
        add(update);
        
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            if(category.getSelectedItem()=="Select Category"){
                JOptionPane.showMessageDialog(null, "Please Select Category First");
            }else if(category.getSelectedItem()=="Doctor"){
                
            try{
            Conn c=new Conn();
            String query="select *from doctor where name='"+addname.getText()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lblhid.setText(rs.getString("id"));
                tfpms.setText(rs.getString("pms"));
                tfname.setText(rs.getString("name"));
                tf_fname.setText(rs.getString("Father_Name"));
                tfcell.setText(rs.getString("cell"));
                tfcnic.setText(rs.getString("cnic"));
                tfemail.setText(rs.getString("email"));
                dcdob.setText(rs.getString("dob"));
                tfqual.setText(rs.getString("qualifications"));
                tfspecs.setText(rs.getString("specialization"));
                tfaddress.setText(rs.getString("address"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
         }else if(category.getSelectedItem()=="Receptionist"){
            try{
            Conn c=new Conn();
            
            String query="select *from receptionist where name='"+addname.getText()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lblhid.setText(rs.getString("id"));
                tfpms.setText(rs.getString("pms"));
                tfname.setText(rs.getString("name"));
                tf_fname.setText(rs.getString("Father_Name"));
                tfcell.setText(rs.getString("cell"));
                tfcnic.setText(rs.getString("cnic"));
                tfemail.setText(rs.getString("email"));
                dcdob.setText(rs.getString("dob"));
                tfqual.setText(rs.getString("qualifications"));
                tfspecs.setText(rs.getString("specialization"));
                tfaddress.setText(rs.getString("address"));
             
            }
            }catch(Exception e){
            e.printStackTrace();
        }
         }else if(category.getSelectedItem()=="Pharmacy Staff"){
             try{
            Conn c=new Conn();
            
            String query="select *from pharmacist where name='"+addname.getText()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lblhid.setText(rs.getString("id"));
                tfpms.setText(rs.getString("pms"));
                tfname.setText(rs.getString("name"));
                tf_fname.setText(rs.getString("Father_Name"));
                tfcell.setText(rs.getString("cell"));
                tfcnic.setText(rs.getString("cnic"));
                tfemail.setText(rs.getString("email"));
                dcdob.setText(rs.getString("dob"));
                tfqual.setText(rs.getString("qualifications"));
                tfspecs.setText(rs.getString("specialization"));
                tfaddress.setText(rs.getString("address"));
             
            }
            }catch(Exception e){
            e.printStackTrace();
        }
             
         } 
        }else if(ae.getSource()==cancel){
           setVisible(false);
        }else if(ae.getSource()==update){
            new updatedetails();
            setVisible(false);
        }
        
    }
        
    
    public static void main(String[] args) {
        new details();
    }
}
