package money;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RegisterPanel extends JPanel {
    private final Register register = new Register(); // Register object to perform the logic
    private final JTextField inputField = new JTextField(20); // User input field
    private final JButton submitButton = new JButton("Get Change"); // Button to submit input
    private final PursePanel pursePanel = new PursePanel(); // Panel to display the Purse content

    public RegisterPanel() {
        setLayout(new BorderLayout());

        // Create the input panel for user input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.setBackground(new Color(255, 0, 0)); // RED background for contrast
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around the input panel

        // Create and style the input label
        JLabel inputLabel = new JLabel("Enter Amount:");
        inputLabel.setFont(new Font("Times New Roman", Font.BOLD, 14)); // Times New Roman, bold

        // Style the input field
        inputField.setFont(new Font("Times New Roman", Font.PLAIN, 14)); // Times New Roman, plain

        // Style the submit button
        submitButton.setFont(new Font("Times New Roman", Font.BOLD, 14)); // Times New Roman, bold

        // Add components to the input panel
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);
        inputPanel.add(submitButton);

        // Add ActionListener to the submit button
        submitButton.addActionListener(new InputListener());

        // Add the input panel and the PursePanel to the RegisterPanel
        add(inputPanel, BorderLayout.NORTH);
        pursePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2)); // Add a border to the purse panel
        add(pursePanel, BorderLayout.CENTER);
    }

    // ActionListener to handle user input
    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Parse the input amount
                double amount = Double.parseDouble(inputField.getText());

                if (amount <= 0) {
                    // If the amount is less than or equal to zero, show "Empty Purse"
                    pursePanel.setPurse(new Purse()); // Set an empty purse
                    JOptionPane.showMessageDialog(RegisterPanel.this, "Empty Purse");
                } else {
                    // Generate the change and update the purse panel
                    Purse purse = register.makeChange(amount);
                    pursePanel.setPurse(purse);
                }
            } catch (NumberFormatException ex) {
                // Show error if the input is not a valid number
                JOptionPane.showMessageDialog(RegisterPanel.this, "Please enter a valid number!");
            }
        }
    }
}
