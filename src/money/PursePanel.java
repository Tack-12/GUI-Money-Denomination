package money;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse = new Purse();

    public PursePanel() {
        // Set a light yellow background for the panel
        setBackground(new Color(255, 255, 200)); // Light yellow
    }

    public void setPurse(Purse purse) {
        this.purse = purse;
        repaint(); // Redraw the panel when the purse is updated
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Clear the panel before drawing

        // Set the font to Times New Roman, bold
        Font font = new Font("Times New Roman", Font.BOLD, 22);
        g.setFont(font);

        int y = 20; // Start drawing from the top
        int imageSizex = 80; // Set a smaller size for individual coin images
        int imageSizey = 60;
        int imageSpacing = 90; // Spacing between images in a row

        for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
            Denomination denomination = entry.getKey();
            int count = entry.getValue();

            // Draw the denomination name and count
            g.drawString(denomination.name() + ": " + count, 10, y);

            // Get the image for the denomination
            Image image;
            try {
                image = Toolkit.getDefaultToolkit().getImage("src/images/"+denomination.img()+".png");
            } catch (Exception e) {
                image = null;
            }

            if (image != null) {
                // Draw the images based on the count
                for (int i = 0; i < count; i++) {
                    int x = 150 + (i % 8) * imageSpacing; // Arrange images in rows (8 per row)
                    int rowOffset = (i / 8) * imageSizex; // Move to the next row if needed
                    g.drawImage(image, x, y + rowOffset, imageSizex, imageSizey, this);
                }
            } else {
                g.drawString("[Image Missing]", 150, y);
            }

            y += (count / 5 + 1) * imageSizey + 10; // Move down for the next denomination
        }

        // Draw total value
        g.drawString("Total Value: $" + String.format("%.2f", purse.getValue()), 10, y + 20);
    }
}
