package hospital.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

public class adminportal extends JFrame implements ActionListener{
    
    JButton doctor,pharma,patient,cmpln,acct,staff,update,logout,details,add;

    adminportal(){
        
        
        //getContentPane().setBackground(new Color(15,28,54));
        setLayout(null);
        
        JLabel heads=new JLabel("  ADMIN PORTAL ");
        heads.setBounds(440,10,290,50);
        heads.setFont(new Font("times new roman",Font.BOLD,30));
        heads.setForeground(Color.WHITE);
        heads.setBackground(Color.BLACK);
        heads.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        add(heads);
        
        
   //Button To ADD Doctor
        ImageIcon hms4=new ImageIcon(ClassLoader.getSystemResource("icons/doc.jpg"));
        Image sc4=hms4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        Icon phar=new ImageIcon(sc4);
        doctor=new JButton(" ADD DOCTOR   ",phar);
        doctor.setBounds(70,130,250,100);
        doctor.setFont(new Font("tahoma",Font.BOLD,20));
        doctor.addActionListener(this);
        add(doctor);
        
   //Button To Add Staff
        ImageIcon hms5=new ImageIcon(ClassLoader.getSystemResource("icons/icon6.jpg"));
        Image sc5=hms5.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        Icon phrma=new ImageIcon(sc5);
        staff=new JButton("  ADD STAFF",phrma);
        staff.setFont(new Font("tahoma",Font.BOLD,20));
        staff.setBounds(70,240,250,100);
        staff.addActionListener(this);
        add(staff);
    
   //Button to view/update details     
        ImageIcon hms7=new ImageIcon(ClassLoader.getSystemResource("icons/doc.jpg"));
        Image sc7=hms7.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        Icon det=new ImageIcon(sc7);
        add=new JButton("VIEW/UPDATE USER DETAILS",det);
        add.setBounds(70,350,250,100);
        add.setFont(new Font("tahoma",Font.BOLD,16));
        add.addActionListener(this);
        add(add);
    
    //view Patient Details    
        ImageIcon hms6=new ImageIcon(ClassLoader.getSystemResource("icons/icon6.jpg"));
        Image sc6=hms6.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        Icon phrmac=new ImageIcon(sc6);
        patient=new JButton("     PATIENTS",phrmac);
        patient.setFont(new Font("tahoma",Font.BOLD,20));
        patient.setBounds(330,130,250,100);
        patient.addActionListener(this);
        add(patient);
      
   //Pharmacy Details     
        ImageIcon hms1=new ImageIcon(ClassLoader.getSystemResource("icons/phrm.jpg"));
        Image sc1=hms1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        Icon pharm=new ImageIcon(sc1);
        pharma=new JButton("    PHARMACY   ",pharm);
        pharma.setBounds(330,240,250,100);
        pharma.setFont(new Font("tahoma",Font.BOLD,20));
        pharma.addActionListener(this);
        add(pharma);
      
   //Acct Sec     
        ImageIcon hms3=new ImageIcon(ClassLoader.getSystemResource("icons/accts.jpg"));
        Image sc3=hms3.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        Icon phrm=new ImageIcon(sc3);
        acct=new JButton("    ACCOUNTS   ",phrm);
        acct.setFont(new Font("tahoma",Font.BOLD,20));
        acct.setBounds(330,350,250,100);
        acct.addActionListener(this);
        add(acct);
    
   //Complaints     
        ImageIcon hms2=new ImageIcon(ClassLoader.getSystemResource("icons/icon6.jpg"));
        Image sc2=hms2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        Icon phr=new ImageIcon(sc2);
        cmpln=new JButton("  COMPLAINTS",phr);
        cmpln.setFont(new Font("tahoma",Font.BOLD,20));
        cmpln.setBounds(180,470,250,100);
        cmpln .addActionListener(this);
        add(cmpln);
        
        
    //logout Buttton    
        logout=new JButton("Logout");
        logout.setBounds(1000,630,150,30);
        logout.setBackground(Color.MAGENTA);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("tahoma",Font.BOLD,15));
        logout.addActionListener(this);
        add(logout);
        

    //Button Background Panel    
        JPanel panel=new JPanel(){
            protected void paintComponent(Graphics g){
                g.setColor(getBackground());
                g.fillRect(0, 0,getWidth(),getHeight());
                super.paintComponent(g);
            }};
        panel.setOpaque(true);
        panel.setBackground(new Color(120,20,40,50));
        panel.setBounds(10, 70, 650, 580);
        add(panel);
        
        
      
        
        ImageIcon hms=new ImageIcon(ClassLoader.getSystemResource("icons/h.jpg"));
        Image sc=hms.getImage().getScaledInstance(1200, 680, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(sc);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 1200, 680);
        add(image);
        
        setSize(1200,700);
        setLocation(100,30);
        setVisible(true);

        
    }
    
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==doctor){
            new registration();
        }else if(ae.getSource()==pharma){
            
        }else if(ae.getSource()==patient){
            
        }else if(ae.getSource()==cmpln){
            
        }else if(ae.getSource()==acct){
            new salary();
        }else if(ae.getSource()==add){
            new updatedetails();
        }
        else if(ae.getSource()==staff){
            new registration();
        }
        else if(ae.getSource()==logout){
            setVisible(false);
            new homepage();
        }
    }
    
    public static void main(String[] args) {
        new adminportal();
    }
}
