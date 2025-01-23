package money;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse = new Purse();

    public void setPurse(Purse purse) {
        this.purse = purse;
        repaint();  // Redraw the panel when the purse is updated
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set up font and starting position for drawing text
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        int y = 20;  // Start drawing text 20 pixels down from the top

        // Draw title
        g.drawString("Purse Contents:", 10, y);
        y += 20;  // Move down for next line

        // Iterate over the denominations and display their name and count
        for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
            Denomination denomination = entry.getKey();
            int count = entry.getValue();

            // Draw the denomination and its count on the panel
            g.drawString(denomination.name() + ": " + count, 10, y);
            y += 20;  // Move down for next line
        }

        // Optionally, you can also draw the total value of the purse
        g.drawString("Total Value: $" + String.format("%.2f", purse.getValue()), 10, y);
    }
}
