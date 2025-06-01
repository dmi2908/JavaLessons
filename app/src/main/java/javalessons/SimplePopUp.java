import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SimplePopUp extends JFrame {
    static int width = 250, height = 90;
    static String titleString = "Enter Name";
    static String resultString = "Enter Name";

    public SimplePopUp() {
        createGUI();
    }
    public void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        resultString = JOptionPane.showInputDialog(getParent(),titleString, titleString, JOptionPane.QUESTION_MESSAGE);
        if (resultString != null) {
            JOptionPane.showMessageDialog(getParent(), resultString);
        }
        setVisible(true);
    }
    public static void main(String[] args) {
        new SimplePopUp();
    }
}