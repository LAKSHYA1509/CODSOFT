
package bankmanagement;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {
    String pin;
    JButton b1;

   MiniStatement(String pin) {
       this.pin=pin;
       
       setLayout(null);
       
       
       JLabel text = new JLabel();
       add(text);
       
       JLabel bank = new JLabel ("CASHILY");
       bank.setBounds(150,20,100,30);
       add(bank);
       
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
       add(card);
       
        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);

       try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pin+"'");
            while(rs.next()){
                card.setText("Card Number:    " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){}
        	 
        try{
            int balance = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pin+"'");
            while(rs.next()){
                text.setText(text.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            l4.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setLayout(null);
        b1 = new JButton("Exit");
        add(b1);
        
        b1.addActionListener(this);
        
        text.setBounds(20, 140, 400, 200);
        b1.setBounds(20, 500, 100, 25);
    
      
       
       setTitle ("Your Reciept");
       setSize(400,600);
       setLocation(35,35);
       setVisible(true);
       getContentPane().setBackground(Color.WHITE);
       
   }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    public static void main(String args[]) {
        new MiniStatement("").setVisible(true);
       
    }
}
