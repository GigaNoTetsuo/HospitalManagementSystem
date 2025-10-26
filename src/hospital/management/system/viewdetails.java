package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

public class viewdetails extends JFrame implements ActionListener{
    JTextField addname;//tfname,tf_fname,tfid,tfcnic,tfemail,tfcell,tfaddress,tfpms,tfdob;
    JButton search,cancel,update;
    JLabel lblhid,tfpms,tfname,tf_fname,tfcnic,tfemail,dcdob,tfqual,tfspecs,tfaddress,tfcell;
    JComboBox category,type;
   // JDateChooser dcdob;
    
    viewdetails(){
        setLayout(null);
        setSize(700,400);
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
        
        JLabel lblpms=new JLabel("PMS #");
        lblpms.setBounds(330,120,100,20);
        lblpms.setFont(new Font("tahoma",Font.BOLD,16));
        add(lblpms);
       
        tfpms=new JLabel();
        tfpms.setBounds(450, 120, 180, 20);
        tfpms.setFont(new Font("tahoma",Font.BOLD,15));
        tfpms.setForeground(Color.red);
        add(tfpms);
        
        JLabel lblid=new JLabel("Hospital ID");
        lblid.setBounds(20,120,100,20);
        lblid.setFont(new Font("tahoma",Font.BOLD,16));
        add(lblid);
        
        lblhid=new JLabel();
        lblhid.setBounds(140, 120, 180, 20);
        lblhid.setFont(new Font("tahoma",Font.BOLD,16));
        lblhid.setForeground(Color.red);
        add(lblhid);
        
        JLabel lblname=new JLabel("Username");
        lblname.setBounds(20,150,100,20);
        lblname.setFont(new Font("tahoma",Font.BOLD,16));
        add(lblname);
        
        tfname=new JLabel();
        tfname.setBounds(140, 150, 180, 20);
        tfname.setFont(new Font("tahoma",Font.BOLD,16));
        tfname.setForeground(Color.red);
        add(tfname);
        
        JLabel lblfname=new JLabel("Father Name");
        lblfname.setBounds(330,150,130,20);
        lblfname.setFont(new Font("tahoma",Font.BOLD,16));
        add(lblfname);
        
        tf_fname=new JLabel();
        tf_fname.setBounds(450, 150, 180, 20);
        tf_fname.setFont(new Font("tahoma",Font.BOLD,16));
        tf_fname.setForeground(Color.red);
        add(tf_fname);
        
        JLabel lblcnic=new JLabel("CNIC No.");
        lblcnic.setBounds(20,180,100,20);
        lblcnic.setFont(new Font("tahoma",Font.BOLD,16));
        add(lblcnic);
        
        tfcnic=new JLabel();
        tfcnic.setBounds(140, 180, 180, 20);
        tfcnic.setFont(new Font("tahoma",Font.BOLD,16));
        tfcnic.setForeground(Color.red);
        add(tfcnic);
        
        JLabel lbldob=new JLabel("D.O.B");
        lbldob.setBounds(330,180,100,20);
        lbldob.setFont(new Font("tahoma",Font.BOLD,16));
        add(lbldob);
        
        dcdob=new JLabel();
        dcdob.setBounds(450, 180, 180, 20);
        dcdob.setFont(new Font("tahoma",Font.BOLD,16));
        dcdob.setForeground(Color.red);
        add(dcdob);

        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(20,210,100,20);
        lblemail.setFont(new Font("tahoma",Font.BOLD,16));
        add(lblemail);
        
        tfemail=new JLabel();
        tfemail.setBounds(140, 210, 180, 20);
        tfemail.setFont(new Font("tahoma",Font.BOLD,16));
        tfemail.setForeground(Color.red);
        add(tfemail);
        
        JLabel lblcell=new JLabel("Cell No.");
        lblcell.setBounds(330,210,130,20);
        lblcell.setFont(new Font("tahoma",Font.BOLD,16));
        add(lblcell);
        
        tfcell=new JLabel();
        tfcell.setBounds(450, 210, 180, 20);
        tfcell.setFont(new Font("tahoma",Font.BOLD,16));
        tfcell.setForeground(Color.red);
        add(tfcell);
        
        JLabel lblqual=new JLabel("Qualifications");
        lblqual.setBounds(330,240,130,20);
        lblqual.setFont(new Font("tahoma",Font.BOLD,16));
        add(lblqual);
        
        tfqual=new JLabel();
        tfqual.setBounds(450, 240, 180, 20);
        tfqual.setFont(new Font("tahoma",Font.BOLD,16));
        tfqual.setForeground(Color.red);
        add(tfqual);
        
        JLabel lblspecs=new JLabel("Specialization");
        lblspecs.setBounds(20,240,130,20);
        lblspecs.setFont(new Font("tahoma",Font.BOLD,16));
        add(lblspecs);
        
        tfspecs=new JLabel();
        tfspecs.setBounds(140, 240, 180, 20);
        tfspecs.setFont(new Font("tahoma",Font.BOLD,16));
        tfspecs.setForeground(Color.red);
        add(tfspecs);
        
        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(20,270,130,20);
        lbladdress.setFont(new Font("tahoma",Font.BOLD,16));
        add(lbladdress);
        
        tfaddress=new JLabel();
        tfaddress.setBounds(140, 270, 490, 20);
        tfaddress.setFont(new Font("tahoma",Font.BOLD,16));
        tfaddress.setForeground(Color.red);
        add(tfaddress);

        
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
        cancel.setBounds(450,310,100,30);
        cancel.setFont(new Font("times new roman",Font.BOLD,16));
        cancel.addActionListener(this);
        add(cancel);
       
        update=new JButton("UPDATE");
        update.setBackground(new Color(120,20,40));
        update.setForeground(Color.white);
        update.setBounds(250,310,100,30);
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
        }
        
    }
     
    
    public static void main(String[] args) {
        new viewdetails();
    }
}
