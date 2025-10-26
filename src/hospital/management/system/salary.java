package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class salary extends JFrame implements ActionListener{
    JComboBox category,type;
    JTextField addname,tfpms;
    JButton search,cancel,print;
    JLabel hid,name,salary,tfhid,tfname,tfsalary;
    JTextArea slip;
    
    salary(){
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(400,520);
        setLocation(450,150);
        setBackground(Color.yellow);
        
        JLabel head=new JLabel("SALARY DETAILS");
        head.setBounds(80,10,300,30);
        head.setFont(new Font("tahoma",Font.BOLD,22));
        add(head);
        
        JLabel catg=new JLabel("Category: ");
        catg.setBounds(30,70,80,20);
        catg.setFont(new Font("tahoma",Font.BOLD,15));
        add(catg);
        
        String[] cat={"Select Category","Doctor","Receptionist","Pharmacy Staff"};
        category=new JComboBox(cat);
        category.setBounds(120,70,140,20);
        add(category);
        
        JLabel txt=new JLabel("Search by: ");
        txt.setBounds(30,100,120,20);
        txt.setFont(new Font("tahoma",Font.BOLD,15));
        add(txt);
        
        String[] types={"--Select Type--","Username","Hospital ID"};
        type=new JComboBox(types);
        type.setBounds(120,100,140,20);
        add(type);
        
        addname=new JTextField();
        addname.setBounds(120,130,120,20);
        add(addname);
        
        slip=new JTextArea();
        slip.setBounds(20,170,360,290);
        slip.setLineWrap(true);
        slip.setFont(new Font("tahoma",Font.BOLD,15));
        JScrollPane sc=new JScrollPane(slip);
        add(slip);
        add(sc);
        slip.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        
        search=new JButton("SEARCH");
        search.setBackground(Color.BLUE);
        search.setForeground(Color.white);
        search.setBounds(280,70,100,20);
        search.setFont(new Font("times new roman",Font.BOLD,16));
        search.addActionListener(this);
        add(search);
        
        cancel=new JButton("CANCEL");
        cancel.setBackground(new Color(120,20,40));
        cancel.setForeground(Color.white);
        cancel.setBounds(220,470,100,30);
        cancel.setFont(new Font("times new roman",Font.BOLD,16));
        cancel.addActionListener(this);
        add(cancel);
        
        print=new JButton("PRINT");
        print.setBackground(new Color(120,20,40));
        print.setForeground(Color.white);
        print.setBounds(70,470,100,30);
        print.setFont(new Font("times new roman",Font.BOLD,16));
        print.addActionListener(this);
        add(print);
        
        setUndecorated(true);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==search){
            String id="",salary="",name="";
            double salry = 0;
            if(category.getSelectedItem()=="Select Category"){
                JOptionPane.showMessageDialog(null, "Please Select Category First");
            }else if(category.getSelectedItem()=="Doctor"){
                
            try{
            Conn c=new Conn();
            String query="select *from doctor where name='"+addname.getText()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                id=rs.getString("id");
                name=rs.getString("name");
                salary="150000";
                salry=Double.parseDouble(salary);
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
                id=rs.getString("id");
                name=rs.getString("name");
                salary="70000";
                salry=Double.parseDouble(salary);
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
                id=rs.getString("id");
                name=rs.getString("name");
                salary="90000";
                salry=Double.parseDouble(salary);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
             
         } 
            
                double incometax=(0.05*salry);
                double deduct=(0.1*salry);
                double total=salry-(incometax+deduct);
           Date obj=new Date();
           String date=obj.toString();
           slip.setText("   *********************************\n"+"   \t         SALARY SLIP   \n"+"   *********************************");
           slip.setText(slip.getText()+"\n    Date   :     "+date);
           slip.setText(slip.getText()+"\n\n    Hospital ID: "+id);
           slip.setText(slip.getText()+"\n    Name   :     "+name);
           slip.setText(slip.getText()+"\n\n    Basic Salary :Rs. "+salary);
           slip.setText(slip.getText()+"\n    Income Tax   :Rs. "+incometax);
           slip.setText(slip.getText()+"\n    Deductions    :Rs. "+deduct);
           slip.setText(slip.getText()+"\n\n___________________________________");
           slip.setText(slip.getText()+"\n    Total   :     Rs. "+total);
           slip.setText(slip.getText()+"\n_____________________________________");
           
        }else if(ae.getSource()==cancel){
            setVisible(false);
        }else if(ae.getSource()==print){
            try {
                slip.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
            
        } 
     }

    public static void main(String[] args) {
        new salary();
    }
}
