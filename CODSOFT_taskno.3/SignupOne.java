
package bankmanagement;


import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import com.toedter.calendar.JDateChooser;
public class SignupOne extends JFrame implements ActionListener {

  long random;
  JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
  JButton next;
  JRadioButton male,female,married,notmarried;
  JDateChooser dateChooser;

    SignupOne() {

        setLayout(null);

        Random ran = new Random();
        long random = Math.abs(ran.nextLong()%9000l)+1000l;

        JLabel formno = new JLabel("APPLICATION FORM NO: " + random );
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

         JLabel personDetails = new JLabel("page 1 : Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);

         JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextField = new JTextField(); 
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,180,200,30);
        add(fname);

          fnameTextField = new JTextField(); 
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,180,400,30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date Of birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,220,200,30);
        add(dob);

         dateChooser = new JDateChooser();
        dateChooser.setBounds(300,220,400,30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);


        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,260,200,30);
        add(gender);

          male = new JRadioButton("Male");
         male.setBounds(300,260,60,30);
         male.setBackground(Color.CYAN);
         add(male);

          female = new JRadioButton("Female");
         female.setBounds(450,260,110,30);
         female.setBackground(Color.CYAN);
         add(female);

         ButtonGroup bothgender = new ButtonGroup();
         bothgender.add(male);
         bothgender.add(female);

          JLabel email = new JLabel("E-Mail Address :");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,300,200,30);
        add(email);

         emailTextField = new JTextField(); 
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,300,400,30);
        add(emailTextField);

          JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,340,200,30);
        add(marital);

          married = new JRadioButton("Married");
         married.setBounds(300,340,70,30);
         married.setBackground(Color.CYAN);
         add(married);

          notmarried = new JRadioButton("Not married");
         notmarried.setBounds(450,340,120,30);
         notmarried.setBackground(Color.CYAN);
         add(notmarried);

         
         ButtonGroup bothperson = new ButtonGroup();
         bothperson.add(married);
         bothperson.add(notmarried);


          JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,380,200,30);
        add(address);

         addressTextField = new JTextField(); 
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,380,400,30);
        add(addressTextField);

          JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,420,200,30);
        add(city);

         cityTextField = new JTextField(); 
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,420,400,30);
        add(cityTextField);

         JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,460,200,30);
        add(state);

         stateTextField = new JTextField(); 
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,460,400,30);
        add(stateTextField);

         JLabel pinc = new JLabel("Pin Code:");
        pinc.setFont(new Font("Raleway",Font.BOLD,20));
        pinc.setBounds(100,500,200,30);
        add(pinc);

         pinTextField = new JTextField(); 
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,500,400,30);
        add(pinTextField);

         next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,560,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.CYAN );

        setSize(850,900);
        setLocation(350,30);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
      String formno = "" + random;
      String name = nameTextField.getText();
      String fname = fnameTextField.getText();
      String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
      String gender = null;
      
      if (male.isSelected()) {
          gender = "Male";
      } else if (female.isSelected()) {
          gender = "Female";
      }
      
      String email = emailTextField.getText();
      String marital = null;
      
      if (married.isSelected()) {
          marital = "Married";
      } else if (notmarried.isSelected()) {
          marital = "Not Married";
      }
  
      String address = addressTextField.getText();
      String city = cityTextField.getText();
      String state = stateTextField.getText();
      String pin = pinTextField.getText();
  
      try {
      if (name.equals("")) {
          JOptionPane.showMessageDialog(null, "Name is Required");
      } else {
          Conn c = new Conn();
          String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
          c.s.executeUpdate(query);
          
          setVisible(false);
          new SignupTwo(formno).setVisible(true);
          c.close();
      }
  } catch (Exception e) {
     e.printStackTrace();
  }
  
    }
    
    public static void main(String[] args) {
        new SignupOne().setVisible(true);
    }
}
