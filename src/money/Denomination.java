package money;

import javax.swing.*;
import java.awt.*;

public record Denomination(String name, double amt, String form, String img) {
    public Image getImage() {
        // Load the image from the path stored in 'img'
        ImageIcon icon = new ImageIcon(getClass().getResource(img));
        return icon.getImage();  // Return the Image object
    }
}