import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class AddCarForm extends JFrame {

    private JTextField licensePlateNumberField;
    private JTextField makeField;
    private JTextField modelField;
    private JTextField yearOfManufactureField;
    private JTextField mileageField;
    private JTextField numberOfSeatsField;
    private JTextField carStatusField;
    private JTextField carLocationIdField;
    private JTextField costPerKMField;
    private JTextField imageField;

    public AddCarForm() {
        setTitle("Add Car Form");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(12, 2));

        JLabel licensePlateNumberLabel = new JLabel("License Plate Number:");
        licensePlateNumberField = new JTextField();
        add(licensePlateNumberLabel);
        add(licensePlateNumberField);

        JLabel makeLabel = new JLabel("Make:");
        makeField = new JTextField();
        add(makeLabel);
        add(makeField);

        JLabel modelLabel = new JLabel("Model:");
        modelField = new JTextField();
        add(modelLabel);
        add(modelField);

        JLabel yearOfManufactureLabel = new JLabel("Year of Manufacture:");
        yearOfManufactureField = new JTextField();
        add(yearOfManufactureLabel);
        add(yearOfManufactureField);

        JLabel mileageLabel = new JLabel("Mileage:");
        mileageField = new JTextField();
        add(mileageLabel);
        add(mileageField);

        JLabel numberOfSeatsLabel = new JLabel("Number of Seats:");
        numberOfSeatsField = new JTextField();
        add(numberOfSeatsLabel);
        add(numberOfSeatsField);

        JLabel carStatusLabel = new JLabel("Car Status:");
        carStatusField = new JTextField();
        add(carStatusLabel);
        add(carStatusField);

        JLabel carLocationIdLabel = new JLabel("Car Location ID:");
        carLocationIdField = new JTextField();
        add(carLocationIdLabel);
        add(carLocationIdField);

        JLabel costPerKMLabel = new JLabel("Cost Per KM:");
        costPerKMField = new JTextField();
        add(costPerKMLabel);
        add(costPerKMField);

        JLabel imageLabel = new JLabel("Image URL:");
        imageField = new JTextField();
        add(imageLabel);
        add(imageField);

        JButton addCarButton = new JButton("Add Car");
        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle API request
                String apiUrl = "http://localhost:8080/carrentals/addCar";
                String requestBody = "licensePlateNumber=" + licensePlateNumberField.getText() +
                        "&make=" + makeField.getText() +
                        "&model=" + modelField.getText() +
                        "&yearOfManufacture=" + yearOfManufactureField.getText() +
                        "&mileage=" + mileageField.getText() +
                        "&numberOfSeats=" + numberOfSeatsField.getText() +
                        "&carStatus=" + carStatusField.getText() +
                        "&carLocationId=" + carLocationIdField.getText() +
                        "&costPerKM=" + costPerKMField.getText() +
                        "&image=" + imageField.getText();

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
                        JOptionPane.showMessageDialog(null, "Car added successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error adding car");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error adding car");
                }
            }
        });
        add(addCarButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AddCarForm();
        });
    }
}
