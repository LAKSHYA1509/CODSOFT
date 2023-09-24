
package bankmanagement;
import java.sql.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

 
public class SignupTwo extends JFrame implements ActionListener {
  JLabel name,fname,dob,gender,email,panNo,adhaarNo,marital,senior,existingaccount;
  JTextField adhaarNoTextField,panNoTextField;
  JButton next;
  JRadioButton ayes,ano,syes,sno;
  JComboBox religion,category,occupation,education,income;
  String formno;

    SignupTwo(String formno) {
       
        this.formno=formno;
        setLayout(null);

       setTitle("NEW ACCOUNT APPLICATION - FORM PAGE 2");
        
     
         JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

          name = new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion [] = {"Hindu","Muslim","Sikh","Christian","Other"};
         religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
       
        
         fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,180,200,30);
        add(fname);
        
        
        String valCategory [] =  {"General","OBC","SC","ST","Other"};
         category = new JComboBox(valCategory);
         category.setBounds(300,180,400,30);
          category.setBackground(Color.WHITE);
        add(category);
        
       
         dob = new JLabel("Income");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,220,200,30);
        add(dob);

          String incomeCategory [] =  {"Null","<1.5 lakhs","<2.5 lakhs","<5 lakhs","more than 10 lakhs"};
         income = new JComboBox(incomeCategory);
         income.setBounds(300,220,400,30);
          income.setBackground(Color.WHITE);
        add(income);
       

         gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,260,200,30);
        add(gender);
        
        
           email = new JLabel("Qualification :");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,285,200,30);
        add(email);

        
          String educationValues [] =  {"Non-Graduation","Graduation","Post Graduation","Doctorate","Others"};
         education = new JComboBox(educationValues);
         education.setBounds(300,270,400,30);
          education.setBackground(Color.WHITE);
        add(education);
        
        
           marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,340,200,30);
        add(marital);

           String OccupationValues [] =  {"Salaried","Self-Employed","Bussiness","Student","Retired"};
         occupation = new JComboBox(OccupationValues);
         occupation.setBounds(300,340,400,30);
          occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
           panNo = new JLabel("Pan no.:");
        panNo.setFont(new Font("Raleway",Font.BOLD,20));
        panNo.setBounds(100,380,200,30);
        add(panNo);

         panNoTextField = new JTextField(); 
        panNoTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panNoTextField.setBounds(300,380,400,30);
        add(panNoTextField);

           adhaarNo = new JLabel("aadhaar no.:");
        adhaarNo.setFont(new Font("Raleway",Font.BOLD,20));
        adhaarNo.setBounds(100,420,200,30);
        add(adhaarNo);

          adhaarNoTextField = new JTextField(); 
        adhaarNoTextField.setFont(new Font("Raleway",Font.BOLD,14));
        adhaarNoTextField.setBounds(300,420,400,30);
        add(adhaarNoTextField);

          senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,460,200,30);
        add(senior);

       syes = new JRadioButton("yes");
         syes.setBounds(300,460,70,30);
         syes.setBackground(Color.CYAN);
         add(syes);

          sno = new JRadioButton("no");
         sno.setBounds(450,460,120,30);
         sno.setBackground(Color.CYAN);
         add(sno);

         
         ButtonGroup bothperson = new ButtonGroup();
         bothperson.add(syes);
         bothperson.add(sno);


          existingaccount = new JLabel("Existing account:");
        existingaccount.setFont(new Font("Raleway",Font.BOLD,20));
        existingaccount.setBounds(100,500,200,30);
        add(existingaccount);

        
         ayes = new JRadioButton("yes");
         ayes.setBounds(300,500,70,30);
         ayes.setBackground(Color.CYAN);
         add(ayes);

          ano = new JRadioButton("no");
         ano.setBounds(450,500,120,30);
         ano.setBackground(Color.CYAN);
         add(ano);

         
         ButtonGroup bothaccounts = new ButtonGroup();
         bothaccounts.add(ayes);
         bothaccounts.add(ano);
         
         
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

  @Override
  public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String span = panNoTextField.getText();
        String saadhaar = adhaarNoTextField.getText();
        
        
        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }

        String sexisting = null;
        if (ayes.isSelected()) {
            sexisting = "yes";
        } else if (ano.isSelected()) {
            sexisting = "no";
        }

       

        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + saadhaar + "','" + seniorcitizen + "','" + sexisting + "')";
            c.s.executeUpdate(query);
            
           setVisible(false);
           new Signup3(formno).setVisible(true);
            c.close();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error storing data:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
         catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     
    public static void main(String[] args) {
        new SignupTwo("").setVisible(true);
    }
}


