package bankmanagement;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class PinChange extends JFrame implements ActionListener{
    
   JLabel text , pinText , RePinText;
   JButton change ,back;
   JPasswordField PinTextField , RePinTextField;
   String pin;
   
    
    PinChange(String pin) {
    
        this.pin = pin;
        setLayout(null);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850,680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 680);
        add(image);
        
        
        text = new JLabel("LET'S CHANGE YOUR PIN");
        text.setBounds(220,210,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        
        pinText = new JLabel("Your New Pin");
        pinText.setBounds(150,236,700,35);
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System",Font.BOLD,16));
        image.add(pinText);
        
         PinTextField = new JPasswordField();
        PinTextField.setFont(new Font("Raleway",Font.BOLD,22));
        PinTextField.setBounds(300,246,180,22);
        image.add(PinTextField);
        
        RePinText = new JLabel("Confirm pin");
        RePinText.setBounds(150,285,700,35);
        RePinText.setForeground(Color.WHITE);
        RePinText.setFont(new Font("System",Font.BOLD,16));
        image.add(RePinText);
        
           RePinTextField = new JPasswordField();
        RePinTextField.setFont(new Font("Raleway",Font.BOLD,22));
        RePinTextField.setBounds(300,290,180,22);
        image.add(RePinTextField);

              
        
      change = new JButton("CHANGE");
     change.setBounds(340,340,130,30);
     change.addActionListener(this);
     image.add(change);

     back = new JButton("Back");
     back.setBounds(340,375,130,30);
     back.addActionListener(this);
     image.add(back);

        
         setSize(850,850);
       setLocation(300,0);
       setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae)
    { if(ae.getSource() == change) {
       try{
           String npin = PinTextField.getText();
           String repin = RePinTextField.getText();
           
           if (!npin.equals(repin)) {
               JOptionPane.showMessageDialog(null,"DOES NOT MATCH");
               return ;
           }
           
           if (npin.equals(""))
           {
               JOptionPane.showMessageDialog(null,"Please enter pin");
               return ;
           }
           
           if (repin.equals("")) {
               JOptionPane.showMessageDialog(null,"Please confirm by entering");
               return ;
           }
           
           Conn conn = new Conn();
            String q1 = "update bank set pin = '"+repin+"' where pin = '"+pin+"' ";
                String q2 = "update login set pin = '"+repin+"' where pin = '"+pin+"' ";
                String q3 = "update signupthree set pin = '"+repin+"' where pin = '"+pin+"' ";

           conn.s.executeUpdate(q1);
           conn.s.executeUpdate(q2);
           conn.s.executeUpdate(q3);
           
            JOptionPane.showMessageDialog(null,"Pin changed successfully");

           setVisible(false);
           new Transactions(repin).setVisible(true);
           
           
       } catch (Exception e) {
           e.printStackTrace();
    } 
    
  }  else {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }
    }
    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}
