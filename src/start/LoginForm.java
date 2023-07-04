package start;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class LoginForm extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginForm() {
        initializeUI();
    }

    private void initializeUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Login Form");
        setSize(900, 490);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel photoPanel = new JLabel(new ImageIcon(getClass().getResource("/resources/loginform2.gif")));
        photoPanel.setBounds(550, 0, 300, 490);
        photoPanel.setBackground(Color.GREEN);
        getContentPane().add(photoPanel);

        JLabel backgroundLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/frame4.gif")));
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        getContentPane().add(backgroundLabel);

        getContentPane().setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(80, 0, 600, 390);
        mainPanel.setOpaque(false);
        mainPanel.setLayout(null);
        backgroundLabel.add(mainPanel);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
        userLabel.setBounds(99, 133, 80, 25);
        mainPanel.add(userLabel);

        textField = new JTextField();
        textField.setFont(new Font("Poppins", Font.PLAIN, 14));
        textField.setBounds(179, 127, 275, 37);
        mainPanel.add(textField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
        passwordLabel.setBounds(99, 185, 80, 25);
        mainPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBounds(179, 179, 275, 37);
        mainPanel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Poppins", Font.PLAIN, 14));
        loginButton.setBounds(179, 227, 94, 30);
        loginButton.addActionListener(this);
        loginButton.setBackground(Color.PINK);
        loginButton.setForeground(Color.BLACK);

        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(Color.RED);
                loginButton.setForeground(Color.WHITE);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(Color.PINK);
                loginButton.setForeground(Color.BLACK);
            }
        });

        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        loginButton.setOpaque(true);
        mainPanel.add(loginButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = textField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("admin") && password.equals("12345")) {
                JOptionPane.showMessageDialog(this, "Login successful");
                dispose();
                tetris.Tetris.main(null);
                
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        }
    }

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
        
        
    }
}
