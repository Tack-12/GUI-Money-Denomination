package money;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public record Denomination(String name, double amt, String form, String img) {
    // Get the image associated with this denomination
    public Image getImage() {
        try {
            // Load the image from the /images/ directory in the classpath
            return new ImageIcon(Objects.requireNonNull(getClass().getResource(img))).getImage();
        } catch (NullPointerException e) {
            System.err.println("Image not found for " + name);
            return null; // Return null if the image is missing
        }
    }
}