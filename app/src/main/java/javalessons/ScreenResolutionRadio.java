import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Locale;

public class ScreenResolutionRadio extends JFrame {
    static int width = 250, height = 90;
    static String title   = "Выберите разрешение экрана";
    static Object message = "Выберите разрешение экрана";
    static Object result  = "";
    private String[] resolution = {};
    private JRadioButton[] options = {new JRadioButton("800x600"), new JRadioButton("1024x768"), new JRadioButton("1200x600"), new JRadioButton("1280x1024"), new JRadioButton("1680x1050"), new JRadioButton("1920x1080")};

    public ScreenResolutionRadio() {
        createGUI();
    }
    public void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Locale.getISOLanguages();
        setSize(width, height);
        result = JOptionPane.showConfirmDialog(getParent(),new Object[]{title, options}, String.valueOf(message), JOptionPane.OK_OPTION);
        if (Integer.parseInt(String.valueOf(result)) == JOptionPane.OK_OPTION) {
            for(int i = 0; i < options.length; i++) {
    	        if (options[i].isSelected()) {
                    result = options[i].getText();
                    break;
                }
    	    }
            JOptionPane.showMessageDialog(getParent(), result);
            resolution = String.valueOf(result).split("x");
            width  = Integer.parseInt(resolution[0]);
            height = Integer.parseInt(resolution[1]);
        }
        setSize(width, height);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ScreenResolutionRadio();
    }
}