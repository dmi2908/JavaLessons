import javax.swing.*;
import java.util.Locale;

public class RegistrationForm extends JFrame {
    static int width = 250, height = 90;
    static String title    = "Привет!";
    static Object message  = "Вы хотите зарегистрироваться?";
    static Object result   = "";
    static String password = "";
    static boolean lValid  = false;
    private ImageIcon icon = null;
    
    public RegistrationForm() {
        createGUI();
    }
    public void createGUI() {
        UIManager.put("OptionPane.yesButtonText", "Да" );
        UIManager.put("OptionPane.noButtonText" , "Нет");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Locale.getISOLanguages();
        setSize(width, height);
        icon = new ImageIcon("images/warning.png");
        result = JOptionPane.showConfirmDialog(getParent(), message, title, JOptionPane.YES_NO_OPTION);
        if (Integer.parseInt(String.valueOf(result)) == JOptionPane.YES_OPTION) {
            title   = "Логин";
            message = "Введите логин";
            result = JOptionPane.showInputDialog(getParent(),title, String.valueOf(message), JOptionPane.QUESTION_MESSAGE);
            if (result != null) {
                while(!lValid) {
                    if (String.valueOf(result).length() < 5 || String.valueOf(result).contains(" ")) {
                        result = JOptionPane.showInputDialog(getParent(),title, String.valueOf(message), JOptionPane.QUESTION_MESSAGE);
                    } else {
                        lValid = true;
                        break;
                    }  
                }
                if (lValid) {
                    title   = "Пароль";
                    message = "Введите пароль";
                    JPasswordField jpf = new JPasswordField();
                    result = JOptionPane.showConfirmDialog(getParent(),new Object[]{title, jpf}, String.valueOf(message), JOptionPane.OK_CANCEL_OPTION);
                    if (Integer.parseInt(String.valueOf(result)) == JOptionPane.OK_OPTION) {
                        lValid   = false;
                        while (!lValid) {
                            if (String.valueOf(jpf.getPassword()).length() < 8 || String.valueOf(jpf.getPassword()).contains(" ") || !String.valueOf(jpf.getPassword()).matches(".*\\d.*")) {
                                result = JOptionPane.showConfirmDialog(getParent(),new Object[]{title, jpf}, String.valueOf(message), JOptionPane.OK_CANCEL_OPTION);
                            } else {
                                lValid = true;
                                break;
                            }
                        }
                        if (lValid) {
                            title    = "Пароль";
                            message  = "Повторите пароль";
                            lValid   = false;
                            password = String.valueOf(jpf.getPassword());
                            JPasswordField jpfC = new JPasswordField();
                            result   = JOptionPane.showConfirmDialog(getParent(),new Object[]{title, jpfC}, String.valueOf(message), JOptionPane.OK_CANCEL_OPTION);
                            if (Integer.parseInt(String.valueOf(result)) == JOptionPane.OK_OPTION) {
                                while (!lValid) {
                                    if (!String.valueOf(jpfC.getPassword()).equals(password)) {
                                        result = JOptionPane.showConfirmDialog(getParent(),new Object[]{title, jpfC}, String.valueOf(message), JOptionPane.OK_CANCEL_OPTION);
                                    } else {
                                        lValid = true;
                                        break;
                                    }
                                }
                                if (lValid) {
                                    JOptionPane.showMessageDialog(getParent(), "Регистрация завершена!");
                                }
                            }
                        }
                    }
                }
            }
            if (Integer.parseInt(String.valueOf(result)) == JOptionPane.NO_OPTION) {
                setVisible(false);
                dispose();
            }
        }
    }
    public static void main(String[] args) {
        new RegistrationForm();
    }
}