package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class registration extends JFrame implements ActionListener{
    JLabel lblhid;
    JButton add,cancel,update,logout,details;
    JTextField tfname,tf_fname,tfid,tfcnic,tfemail,tfcell,tfaddress,tfpms,tfdob;
    JComboBox tfqual,tfspecs,tfpost,tfgender;
    JDateChooser dcdob;
    
    Random ran=new Random();
    long first4=Math.abs(ran.nextLong()%9000L+1000L);
    
    registration(){
        setLayout(null);
        setSize(720,400);
        setLocation(350,150);

        JLabel head=new JLabel("NEW USER DETALIS");
        head.setBounds(250,15,300,30);
        //head.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
        head.setFont(new Font("tahoma",Font.BOLD,23));
        add(head);
        
        
        JLabel lblid=new JLabel("Hospital ID");
        lblid.setBounds(20,60,130,20);
        lblid.setFont(new Font("tahoma",Font.BOLD,16));
        add(lblid);
        lblhid=new JLabel();
        lblhid.setBounds(140, 60, 180, 20);
        lblhid.setFont(new Font("tahoma",Font.BOLD,16));
        add(lblhid);
        
        
        JLabel lblpms=new JLabel("PMS #(for doctors)");
        lblpms.setBounds(340,60,130,20);
        lblpms.setFont(new Font("tahoma",Font.BOLD,15));
        add(lblpms);
        tfpms=new JTextField("");
        tfpms.setBounds(490, 60, 180, 20);
        add(tfpms);
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(20,90,130,20);
        lblname.setFont(new Font("tahoma",Font.BOLD,16));
        add(lblname);
        tfname=new JTextField();
        tfname.setBounds(140, 90, 180, 20);
        add(tfname);
        
        JLabel lblfname=new JLabel("Father Name");
        lblfname.setBounds(340,90,130,20);
        lblfname.setFont(new Font("tahoma",Font.BOLD,16));
        add(lblfname);
        tf_fname=new JTextField();
        tf_fname.setBounds(490, 90, 180, 20);
        add(tf_fname);
        
        JLabel lblcnic=new JLabel("CNIC No.");
        lblcnic.setBounds(20,120,130,20);
        lblcnic.setFont(new Font("tahoma",Font.BOLD,16));
        add(lblcnic);
        tfcnic=new JTextField();
        tfcnic.setBounds(140, 120, 180, 20);
        add(tfcnic);
        
        JLabel lbldob=new JLabel("D.O.B");
        lbldob.setBounds(340,120,130,20);
        lbldob.setFont(new Font("tahoma",Font.BOLD,16));
        add(lbldob);
        dcdob=new JDateChooser();
        dcdob.setBounds(490, 120, 180, 20);
        add(dcdob);

        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(20,150,130,20);
        lblemail.setFont(new Font("tahoma",Font.BOLD,16));
        add(lblemail);
        tfemail=new JTextField();
        tfemail.setBounds(140, 150, 180, 20);
        add(tfemail);
        
        JLabel lblcell=new JLabel("Cell No.");
        lblcell.setBounds(340,150,130,20);
        lblcell.setFont(new Font("tahoma",Font.BOLD,16));
        add(lblcell);
        tfcell=new JTextField();
        tfcell.setBounds(490, 150, 180, 20);
        add(tfcell);
        
        JLabel lblqual=new JLabel("Qualifications");
        lblqual.setBounds(340,210,130,20);
        lblqual.setFont(new Font("tahoma",Font.BOLD,16));
        add(lblqual);
        String[]qualif={"--Select Qualification--","MBBS","BDS","DPT"};
        tfqual=new JComboBox(qualif);
        tfqual.setBounds(490, 210, 180, 20);
        add(tfqual);
        
        JLabel lblspecs=new JLabel("Specialization");
        lblspecs.setBounds(340,180,130,20);
        lblspecs.setFont(new Font("tahoma",Font.BOLD,16));
        add(lblspecs);
        String[] special={"--Select Specialization--","Medical Specialist","ENT","Eye Specialist","Surgical Specialist"};
        tfspecs=new JComboBox(special);
        tfspecs.setBounds(490, 180, 180, 20);
        add(tfspecs);
        
        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(20,210,130,20);
        lblgender.setFont(new Font("tahoma",Font.BOLD,16));
        add(lblgender);
        String[] gend={"Male","Female"};
        tfgender=new JComboBox(gend);
        tfgender.setBounds(140,210,180,20);
        add(tfgender);
        
        JLabel lblpost=new JLabel("Post");
        lblpost.setBounds(20,180,130,20);
        lblpost.setFont(new Font("tahoma",Font.BOLD,16));
        add(lblpost);
        String[] post={"---Select Post---","Doctor","Receptionist","Pharmacy Staff","Laboratory Staff"};
        tfpost=new JComboBox(post);
        tfpost.setBounds(140, 180, 180, 20);
        add(tfpost);
        
        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(20,240,130,20);
        lbladdress.setFont(new Font("tahoma",Font.BOLD,16));
        add(lbladdress);
        tfaddress=new JTextField();
        tfaddress.setBounds(140, 240, 530, 20);
        add(tfaddress);
          
        
 //doctorddddddddd       
        add=new JButton("ADD");
        add.setBounds(200,280,100,30);
        add.setBackground(new Color(120,20,40));
        add.setForeground(Color.WHITE);
        add.setFont(new Font("tahoma",Font.BOLD,15));
        add.addActionListener(this);
        add(add);
        
        
        cancel=new JButton("CANCEL");
        cancel.setBackground(new Color(120,20,40));
        cancel.setForeground(Color.white);
        cancel.setBounds(420,280,100,30);
        cancel.setFont(new Font("times new roman",Font.BOLD,15));
        cancel.addActionListener(this);
        add(cancel);
       
        
       
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            
            String name=tfname.getText();
            String fname=tf_fname.getText();
            //String pms=tfpms.getText();
            String cell=tfcell.getText();
            String cnic=tfcnic.getText();
            String email=tfemail.getText();
            String qual=(String)tfqual.getSelectedItem();
            String specs=(String)tfspecs.getSelectedItem();
            String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address=tfaddress.getText();
            String gender=(String)tfgender.getSelectedItem();
            String post=(String)tfpost.getSelectedItem();

            if(tfpost.getSelectedItem()=="Doctor"){
                String pms=tfpms.getText();
               
                lblhid.setText("D-000"+first4);
                String hid=lblhid.getText();
                
                
                String query1="insert into doctor values('"+hid+"','"+pms+"','"+name+"','"+fname+"','"+cell+"','"+email+"','"+cnic+"','"+qual+"','"+specs+"','"+dob+"','"+address+"','"+gender+"','"+post+"')";
            
                try{
                    Conn c=new Conn();
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "New Doctor Registered Successfully\n User ID is "+hid);
                }catch(Exception e){
                       e.printStackTrace();
                       }
            }else if(tfpost.getSelectedItem()=="Receptionist"){
                lblhid.setText("R-000"+first4);
                String hid=lblhid.getText();
                String pms="N/A";
                 String query2="insert into receptionist values('"+hid+"','"+pms+"','"+name+"','"+fname+"','"+cell+"','"+email+"','"+cnic+"','"+qual+"','"+specs+"','"+dob+"','"+address+"','"+gender+"','"+post+"')";
            
                try{
                    Conn c=new Conn();
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "New Receptionist Registered Successfully\n User ID is "+hid);
                }catch(Exception e){
                    e.printStackTrace();
                }
                
            }else if(tfpost.getSelectedItem()=="Pharmacy Staff"){
                lblhid.setText("P-000"+first4);
                String hid=lblhid.getText();
                String pms="N/A";
                 String query3="insert into pharmacist values('"+hid+"','"+pms+"','"+name+"','"+fname+"','"+cell+"','"+email+"','"+cnic+"','"+qual+"','"+specs+"','"+dob+"','"+address+"','"+gender+"','"+post+"')";
            
            try{
                Conn c=new Conn();
                c.s.executeUpdate(query3);
               JOptionPane.showMessageDialog(null, "New Pharmacist Registered Successfully\n User ID is "+hid);
            }catch(Exception e){
                e.printStackTrace();
            }
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            //new homepage();
        }
    }
    
    public static void main(String[] args) {
        new registration();
    }
}
