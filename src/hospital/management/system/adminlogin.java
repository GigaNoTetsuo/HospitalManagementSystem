package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class adminlogin extends JFrame implements ActionListener{
    
    JButton login,cancel;
    JTextField tfname;
    JPasswordField tfpass;
    JLabel lname,lpass;
    
    adminlogin(){
        getContentPane().setBackground(Color.lightGray);
        setLayout(null);
        
        JLabel admlog=new JLabel("ADMIN LOGIN PORTAL");
        admlog.setBounds(150,20,600,20);
        admlog.setFont(new Font("tahoma",Font.BOLD,22));
        admlog.setForeground(Color.BLACK);
        add(admlog);
        
        JLabel name=new JLabel("Username");
        name.setBounds(250,110,100,20);
        name.setFont(new Font("tahoma",Font.BOLD,16));
        add(name);
        
        JLabel pass=new JLabel("Password");
        pass.setBounds(250,180,100,20);
        pass.setFont(new Font("tahoma",Font.BOLD,16));
        add(pass);
        
        tfname=new JTextField("");
        tfname.setBounds(380, 110, 180, 20);
        add(tfname);
        
//        lname=new JLabel();
//        lname.setBounds(380,135,180,20);
//        add(lname);
        
        tfpass=new JPasswordField("");
        tfpass.setBounds(380, 180, 180, 20);
        add(tfpass);
        
        ImageIcon hms=new ImageIcon(ClassLoader.getSystemResource("icons/icon2.jpg"));
        Image sc=hms.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(sc);
        JLabel image=new JLabel(i3);
        image.setBounds(40,80,150,150);
        add(image);
        
        login=new JButton("LOGIN");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.setBounds(280,250,100,30);
        login.setFont(new Font("times new roman",Font.BOLD,15));
        login.addActionListener(this);
        add(login);
       
        cancel=new JButton("CANCEL");
        cancel.setBackground(new Color(120,20,40));
        cancel.setForeground(Color.white);
        cancel.setBounds(420,250,100,30);
        cancel.setFont(new Font("times new roman",Font.BOLD,15));
        cancel.addActionListener(this);
        add(cancel);
        
        
        JPanel panel=new JPanel(){
            protected void paintComponent(Graphics g){
                g.setColor(getBackground());
                g.fillRect(0, 0,getWidth(),getHeight());
                super.paintComponent(g);
            }};
        panel.setOpaque(true);
        panel.setBackground(new Color(20,20,80,80));
        panel.setBounds(0,5, 600, 50);
        add(panel);
        
        
        setSize(600,300);
        setLocation(350,200);
        setUndecorated(true);
        setVisible(true);
    }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == login){
                String username=tfname.getText();
                String password=tfpass.getText();
                
                String query="select * from login where username='"+username+"'and password='"+password+"'";
                
                try{
                    Conn c=new Conn();
                    ResultSet rs=c.s.executeQuery(query);
                    
                    if(rs.next()){
                        setVisible(false);
                        new adminportal();
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid Details!!! Please Enter Correct Details");
                        tfname.setText("");
                        tfpass.setText("");
                        //lname.setText("invalid");
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                
            }else if(ae.getSource()==cancel){
                setVisible(false);
            }
        }
    
    public static void main(String[] args) {
        new adminlogin();
    }
}
