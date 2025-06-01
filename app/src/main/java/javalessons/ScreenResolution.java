import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Locale;

public class ScreenResolution extends JFrame {
    static int width = 250, height = 90;
    static String title   = "Выберите разрешение экрана";
    static Object message = "Выберите разрешение экрана";
    static Object result  = "";
    private String[] resolution = {};
    private ImageIcon icon = null;
    private String[] options = {"800x600", "1024x768", "1200x600", "1280x1024", "1680x1050", "1920x1080"};

    public ScreenResolution() {
        createGUI();
    }
    public void createGUI() {
        UIManager.put("OptionPane.okButtonText"    , "Да"    );
        UIManager.put("OptionPane.cancelButtonText", "Отмена");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Locale.getISOLanguages();
        setSize(width, height);
        icon = new ImageIcon("images/warning.png");
        result = JOptionPane.showInputDialog(getParent(), message, title, JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);
        if (result != null) {
            JOptionPane.showMessageDialog(getParent(), result);
            resolution = String.valueOf(result).split("x");
            width  = Integer.parseInt(resolution[0]);
            height = Integer.parseInt(resolution[1]);
        }
        setSize(width, height);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ScreenResolution();
    }
}