import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class CreateRentalLocationForm extends JFrame {

    private JTextField locationIdField;
    private JTextField centreNameField;
    private JTextField addressField;
    private JTextField pincodeField;

    public CreateRentalLocationForm() {
        setTitle("Create Rental Location");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(5, 2));

        JLabel locationIdLabel = new JLabel("Location ID:");
        locationIdField = new JTextField();
        add(locationIdLabel);
        add(locationIdField);

        JLabel centreNameLabel = new JLabel("Centre Name:");
        centreNameField = new JTextField();
        add(centreNameLabel);
        add(centreNameField);

        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField();
        add(addressLabel);
        add(addressField);

        JLabel pincodeLabel = new JLabel("Pincode:");
        pincodeField = new JTextField();
        add(pincodeLabel);
        add(pincodeField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle API request
                String apiUrl = "http://localhost:8080/createRentalLocation";
                String requestBody = "locationId=" + locationIdField.getText() +
                        "&centreName=" + centreNameField.getText() +
                        "&address=" + addressField.getText() +
                        "&pincode=" + pincodeField.getText();

                try {
                    URL url = new URL(apiUrl);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    conn.setDoOutput(true);

                    try (OutputStream os = conn.getOutputStream()) {
                        byte[] input = requestBody.getBytes(StandardCharsets.UTF_8);
                        os.write(input, 0, input.length);
                    }

                    int responseCode = conn.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        JOptionPane.showMessageDialog(null, "Rental location created successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error creating rental location");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error creating rental location");
                }
            }
        });
        add(submitButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CreateRentalLocationForm();
        });
    }
}
