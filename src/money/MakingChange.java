package money;

    import javax.swing.*;
    import java.util.Scanner;

public class MakingChange {
        public static void main(String[] args) {

            //GUI
            JFrame frame = new JFrame("Making Change");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new RegisterPanel());
            frame.setSize(900, 900);
            frame.setVisible(true);
        }
    }


