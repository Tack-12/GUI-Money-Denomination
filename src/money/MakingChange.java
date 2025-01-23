package money;

    import javax.swing.*;

    public class MakingChange {
        public static void main(String[] args) {
            JFrame frame = new JFrame("Making Change");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new RegisterPanel());
            frame.setSize(400, 300);
            frame.setVisible(true);

        }
    }

