import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    private JButton loginButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel languageLabel;
    private JComboBox<String> languageComboBox;

    public LoginFrame() {
        super("Login");
        setLayout(new GridBagLayout());

        usernameLabel = new JLabel("Username:");
        add(usernameLabel, getConstraints(0, 0, 1, 1, GridBagConstraints.LINE_END));

        usernameField = new JTextField(10);
        add(usernameField, getConstraints(1, 0, 2, 1, GridBagConstraints.LINE_START));

        passwordLabel = new JLabel("Password:");
        add(passwordLabel, getConstraints(0, 1, 1, 1, GridBagConstraints.LINE_END));

        passwordField = new JPasswordField(10);
        add(passwordField, getConstraints(1, 1, 2, 1, GridBagConstraints.LINE_START));

        //language label
        languageLabel = new JLabel("Language");
        add(languageLabel, getConstraints(0, 2, 1, 1, GridBagConstraints.LINE_END));

        String[] languages = {"English", "Spanish", "French"};
        languageComboBox = new JComboBox<>(languages);
        add(languageComboBox, getConstraints(1, 2, 2, 1, GridBagConstraints.LINE_START));

        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("admin") && password.equals("admin")) {
                    JOptionPane.showMessageDialog(LoginFrame.this,
                            "Login successful!",
                            "Login",
                            JOptionPane.INFORMATION_MESSAGE);
                    String language = (String) languageComboBox.getSelectedItem();
                    JOptionPane.showMessageDialog(LoginFrame.this,
                            "You have selected " + language + " as the language",
                            "Language Selection",
                            JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this,
                            "Invalid username or password!",
                            "Login",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        add(loginButton, getConstraints(1, 3, 1, 1, GridBagConstraints.CENTER));

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private GridBagConstraints getConstraints(int gridx, int gridy, int gridwidth, int gridheight, int anchor) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 0, 5);
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridwidth;
        c.gridheight = gridheight;
        c.anchor = anchor;

        return c;
    }

    public static void main(String[] args) {
        LoginFrame frame = new LoginFrame();
        frame.setVisible(true);
    }

}