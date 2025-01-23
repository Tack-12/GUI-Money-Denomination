package money;
import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse = new Purse(); // Initialize with an empty purse

    public void setPurse(Purse purse) {
        if (purse == null) {
            throw new IllegalArgumentException("Purse cannot be null");
        }
        this.purse = purse;
        repaint(); // Redraw the panel when the purse is updated
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set up font and starting position for drawing text
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        int y = 20; // Start drawing text 20 pixels down from the top

        // Draw title
        g.drawString("Purse Contents:", 10, y);
        y += 20; // Move down for the next line

        // Check if purse is empty
        if (purse.getCash() == null || purse.getCash().isEmpty()) {
            g.drawString("The purse is empty.", 10, y);
            return; // Exit if there are no contents
        }

        // Iterate over the purse's contents and display them
        for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
            Denomination denomination = entry.getKey();
            int count = entry.getValue();

            // Skip null denominations
            if (denomination == null) continue;

            // Draw the denomination's name and count
            g.drawString(denomination.name() + ": " + count, 10, y);
            y += 20; // Move down for the next line

            // Load and draw the image for this denomination
            Image image = denomination.getImage(); // Assumes this method is implemented in Denomination
            int imageX = 150; // X position for the image
            int imageY = y - 15; // Align image with text


            if (image != null) {
                g.drawImage(image, imageX, imageY, 40, 40, this); // Draw the image (40x40 size)
            } else {
                g.drawString("[Image Missing]", imageX, imageY + 20);
            }
        }

        // Draw the total value of the purse
        y += 20; // Move down
        g.drawString("Total Value: $" + String.format("%.2f", purse.getValue()), 10, y);
    }
}
