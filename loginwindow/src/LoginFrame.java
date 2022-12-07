import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener {
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginFrame() {
        super("Logowanie");

        setLayout(new FlowLayout());
   
        usernameLabel = new JLabel("User name  : ");
        passwordLabel = new JLabel("Password: ");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        loginButton = new JButton("Sign In");

        loginButton.addActionListener(this);

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent event) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("admin") && password.equals("admin123")) {
            System.out.println("You have successfully logged in!");
        } else {
            System.out.println("\n" +
                    "Incorrect data Check again.");
        }
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
