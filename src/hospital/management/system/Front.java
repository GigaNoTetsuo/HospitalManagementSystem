package hospital.management.system;
import javax.swing.*;
import java.awt.*;

public class Front extends JFrame implements Runnable{
    Thread t;
    Front(){
        
        ImageIcon hms=new ImageIcon(ClassLoader.getSystemResource("icons/hms2.jpg"));
        Image sc=hms.getImage().getScaledInstance(1200, 650, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(sc);
        JLabel image=new JLabel(i3);
        add(image);
        
        t=new Thread(this);
        t.start();
       
        int x=1;
        for(int i=2;i<=700;i+=4,x+=1){
            
        setLocation(500-((i+x)/2),450-((i+x)/2));
        setSize(i+3*x,i);
        
        try{
            Thread.sleep(5);
        }catch(Exception e) {};
        setVisible(true);
        }
       
        JProgressBar p=new JProgressBar();
        p.setBounds(3,640,1250,20);
        p.setValue(0);
        p.setForeground(Color.red);
        
        image.add(p);
        
        int a=0;
        try{
        while( a<=1000){
        p.setValue(a);
        Thread.sleep(10);
        a+=1;
    }
        }catch(Exception e){};
    }
    public void run(){
        try{
            Thread.sleep(7000);
            setVisible(false);
            new homepage();
        }catch(Exception e) {};
    }
    
    public static void main(String[] args) {
        Front s=new Front();
        //new homepage();
    }
}
