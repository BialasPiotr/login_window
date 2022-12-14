import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login{

    public static void main(String[] args){

        JFrame frame = new JFrame("Logging into the chat room");
        frame.setSize(250, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);

    }

    private static void placeComponents(JPanel panel){

        panel.setLayout(null);

        JLabel userLabel = new JLabel("User name:");
        userLabel.setBounds(10, 10, 120, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(130, 10, 120, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 40, 120, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(130, 40, 120, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Log in");
        loginButton.setBounds(90, 80, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String username = userText.getText();
                String password = String.valueOf(passwordText.getPassword());

                if(username.equals("test") && password.equals("test")){
                    ChatWindow window = new ChatWindow();
                    window.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            }
        });

    }

}

class ChatWindow extends JFrame{

    public ChatWindow(){
        setTitle("Chat");
        setSize(400, 500);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JTextField textField = new JTextField();
        panel.add(textField);
        textField.setColumns(30);

        JButton btnSend = new JButton("Send");
        panel.add(btnSend);

        JTextArea textArea = new JTextArea();
        getContentPane().add(textArea, BorderLayout.CENTER);

        btnSend.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String text = textField.getText();
                textArea.append("Bialas: " + text + "\n");
                textField.setText("");
            }
        });
    }

}