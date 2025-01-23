package money;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
        private final Register register = new Register();
        private final JTextField input = new JTextField(10);
        private final PursePanel changePanel = new PursePanel();

        public RegisterPanel() {
            setLayout(new BorderLayout());
            JPanel inputPanel = new JPanel();
            inputPanel.add(new JLabel("Enter Amount:"));
            inputPanel.add(input);

            input.addActionListener(new InputListener());

            add(inputPanel, BorderLayout.NORTH);
            add(changePanel, BorderLayout.CENTER);
        }

        private class InputListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(input.getText());
                    Purse purse = register.makeChange(amount);
                    changePanel.setPurse(purse);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(RegisterPanel.this, "Invalid input. Please enter a valid number.");
                }
            }
        }
    }


