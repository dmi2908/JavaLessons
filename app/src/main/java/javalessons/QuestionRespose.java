import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Locale;

public class QuestionRespose extends JFrame {
    static int width = 250, height = 90;
    static String title   = "Ответьте на вопросы";
    static Object message = "Закурить есть?";
    static Object result  = "";
    private ImageIcon icon = null;
    private String[] options = {"Да", "Нет"};

    public QuestionRespose() {
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
            if (result == "Да") {
                message = "А зажигалка?";
                result = JOptionPane.showInputDialog(getParent(), message, title, JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);
                if (result != null) {
                    if (result == "Да") {
                        JOptionPane.showMessageDialog(getParent(), "Спасибо!");
                    } else {
                        JOptionPane.showMessageDialog(getParent(), "Ладно, сам найду, спасибо");
                    }
                }
            } else {
                message = "А мелочи не найдется?";
                result  = JOptionPane.showInputDialog(getParent(), message, title, JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);
                if (result != null) {
                    if (result == "Да") {
                        JOptionPane.showMessageDialog(getParent(), "Спасибо, добрый человек!");
                    } else {
                        JOptionPane.showMessageDialog(getParent(), "Жадина!");
                    }
                }
            }
        }
        setVisible(true);
    }
    public static void main(String[] args) {
        new QuestionRespose();
    }
}