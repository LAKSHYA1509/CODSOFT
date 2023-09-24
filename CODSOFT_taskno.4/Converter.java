// import org.json.JSONObject;
// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.net.HttpURLConnection;
// import java.net.URL;

// public class Converter extends JFrame implements ActionListener {
//     private JComboBox<String> from, to;
//     private JButton convert, clear, exit;
//     private JTextField fromCu, ToCu;
   
//     Converter() {
//         setLayout(null);

//         JLabel text = new JLabel("Choose the Currency you want to convert");
//         text.setBounds(200, 40, 400, 40);
//         text.setFont(new Font("Osward", Font.BOLD, 20));
//         add(text);

//         String fromCurrency[] = {"INR", "USD", "PKR", "EUR", "JPY"};
//         from = new JComboBox<>(fromCurrency);
//         from.setBounds(120, 120, 200, 30);
//         from.setBackground(Color.WHITE);
//         add(from);

//         String toCurrency[] = {"INR", "USD", "PKR", "EUR", "JPY"};
//         to = new JComboBox<>(toCurrency);
//         to.setBounds(430, 120, 200, 30);
//         to.setBackground(Color.WHITE);
//         add(to);

//         fromCu = new JTextField();
//         fromCu.setBounds(120, 200, 200, 30);
//         fromCu.setBackground(Color.LIGHT_GRAY);
//         add(fromCu);

//         ToCu = new JTextField();
//         ToCu.setBounds(430, 200, 200, 30);
//         ToCu.setBackground(Color.LIGHT_GRAY);
//         add(ToCu);

//         convert = new JButton("Convert");
//         convert.setBounds(110, 290, 120, 30);
//         convert.setBackground(Color.DARK_GRAY);
//         convert.setForeground(Color.WHITE);
//         convert.addActionListener(this);
//         add(convert);

//         clear = new JButton("Clear");
//         clear.setBounds(320, 290, 120, 30);
//         clear.setBackground(Color.DARK_GRAY);
//         clear.setForeground(Color.WHITE);
//         clear.addActionListener(this);
//         add(clear);

//         exit = new JButton("Exit");
//         exit.setBounds(530, 290, 120, 30);
//         exit.setBackground(Color.DARK_GRAY);
//         exit.setForeground(Color.WHITE);
//         exit.addActionListener(this);
//         add(exit);

//         getContentPane().setBackground(Color.WHITE);
//         setSize(800, 400);
//         setVisible(true);
//         setTitle("Conversion");
//         setLocation(350, 120);
//     }

//     @Override
//     public void actionPerformed(ActionEvent ae) {
//         if (ae.getSource() == clear) {
//             fromCu.setText("");
//             ToCu.setText("");
//         } else if (ae.getSource() == exit) {
//             setVisible(false);
//         } else if (ae.getSource() == convert) {
//             performConversion();
//         }
//     }

//     private void performConversion() {
//         String baseCurrency = from.getSelectedItem().toString();
//         String targetCurrency = to.getSelectedItem().toString();
//         double amountToConvert;
    
//         try {
//             amountToConvert = Double.parseDouble(fromCu.getText());
    
//             // Construct the URL for fetching exchange rates
//             String apiUrl = baseUrl + "&currencies=" + targetCurrency;
//             URL url = new URL(apiUrl);
    
//             // Send an HTTP GET request to the API
//             HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//             connection.setRequestMethod("GET");
    
//             // Read the API response
//             BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//             StringBuilder response = new StringBuilder();
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 response.append(line);
//             }
//             reader.close();
    
//             // Parse the JSON response
//             JSONObject jsonResponse = new JSONObject(response.toString());
//             System.out.println("JSON Response: " + response.toString());
//             JSONObject rates = jsonResponse.getJSONObject("rates");
//             double exchangeRate = rates.getDouble(targetCurrency);
    
//             // Calculate the converted amount
//             double convertedAmount = amountToConvert * exchangeRate;
    
//             // Display the converted amount in ToCu
//             ToCu.setText(String.format("%.2f %s", convertedAmount, targetCurrency));
    
//         } catch (NumberFormatException e) {
//             JOptionPane.showMessageDialog(this, "Please enter a valid numeric amount.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
//         }  catch (Exception e) {
//             e.printStackTrace(); // Print the stack trace for debugging
//             JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//         }
//     }
    
//     public static void main(String[] args) {
//         new Converter().setVisible(true);
//     }
//   }

import org.json.JSONObject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Converter extends JFrame implements ActionListener {
    private JComboBox<String> from, to;
    private JButton convert, clear, exit;
    private JTextField fromCu, ToCu;

    private final String apiKey = "fca_live_mnrPn4FHd7u98SWqI2quBd9E4ZYnHMxuRL6CCIBt";
    private final String baseUrl = "https://api.freecurrencyapi.com/v1/latest?apikey=" + apiKey;

    Converter() {
        setLayout(null);

        JLabel text = new JLabel("Choose the Currency you want to convert");
        text.setBounds(200, 40, 400, 40);
        text.setFont(new Font("Osward", Font.BOLD, 20));
        add(text);

        String fromCurrency[] = {"INR", "USD", "AUD", "EUR", "JPY"};
        from = new JComboBox<>(fromCurrency);
        from.setBounds(120, 120, 200, 30);
        from.setBackground(Color.WHITE);
        add(from);

        String toCurrency[] = {"INR", "USD", "AUD", "EUR", "JPY"};
        to = new JComboBox<>(toCurrency);
        to.setBounds(430, 120, 200, 30);
        to.setBackground(Color.WHITE);
        add(to);

        fromCu = new JTextField();
        fromCu.setBounds(120, 200, 200, 30);
        fromCu.setBackground(Color.LIGHT_GRAY);
        add(fromCu);

        ToCu = new JTextField();
        ToCu.setBounds(430, 200, 200, 30);
        ToCu.setBackground(Color.LIGHT_GRAY);
        add(ToCu);

        convert = new JButton("Convert");
        convert.setBounds(110, 290, 120, 30);
        convert.setBackground(Color.DARK_GRAY);
        convert.setForeground(Color.WHITE);
        convert.addActionListener(this);
        add(convert);

        clear = new JButton("Clear");
        clear.setBounds(320, 290, 120, 30);
        clear.setBackground(Color.DARK_GRAY);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        exit = new JButton("Exit");
        exit.setBounds(530, 290, 120, 30);
        exit.setBackground(Color.DARK_GRAY);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);

        getContentPane().setBackground(Color.WHITE);
        setSize(800, 400);
        setVisible(true);
        setTitle("Conversion");
        setLocation(350, 120);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            fromCu.setText("");
            ToCu.setText("");
        } else if (ae.getSource() == exit) {
            setVisible(false);
        } else if (ae.getSource() == convert) {
            performConversion();
        }
    }

    private void performConversion() {
        String baseCurrency = from.getSelectedItem().toString();
        String targetCurrency = to.getSelectedItem().toString();
        double amountToConvert;
    
        try {
            amountToConvert = Double.parseDouble(fromCu.getText());
    
            String apiUrl = baseUrl + "&currencies=" + targetCurrency;
            URL url = new URL(apiUrl);
    
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
    
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
    
            JSONObject jsonResponse = new JSONObject(response.toString());
            System.out.println("JSON Response: " + response.toString());
            JSONObject data = jsonResponse.getJSONObject("data");
            double exchangeRate = data.getDouble(targetCurrency);
    
            double convertedAmount = amountToConvert * exchangeRate;
    
            ToCu.setText(String.format("%.2f %s", convertedAmount, targetCurrency));
    
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric amount.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace(); 
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        new Converter().setVisible(true);
    }
}
