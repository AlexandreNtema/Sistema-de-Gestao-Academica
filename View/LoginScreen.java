package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Alexandre Ntema
 */
public class LoginScreen extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginScreen() {
        configureFrame();
        JPanel mainPanel = createMainPanel();
        addComponentsToPanel(mainPanel);
        add(mainPanel);
    }

    private void configureFrame() {
        setTitle("Universidade Mais Saber - Sistema Acadêmico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(243, 243, 243));
        return panel;
    }

    private void addComponentsToPanel(JPanel panel) {
        panel.add(createLogoPanel());
        panel.add(createLabel("Usuário:", 70, 240));
        panel.add(usernameField = createTextField(70, 265));
        panel.add(createLabel("Senha:", 70, 310));
        panel.add(passwordField = createPasswordField(70, 335));
        panel.add(createLoginButton());
    }

    private JPanel createLogoPanel() {
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        logoPanel.setBounds(0, 20, 400, 200);
        logoPanel.setBackground(new Color(243, 243, 243));

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("Logo.png"));
        Image scaledImage = logoIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledImage));

        logoPanel.add(logoLabel);
        return logoPanel;
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 260, 20);
        label.setForeground(Color.BLACK);
        return label;
    }

    private JTextField createTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 260, 30);
        return textField;
    }

    private JPasswordField createPasswordField(int x, int y) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(x, y, 260, 30);
        return passwordField;
    }

    private JButton createLoginButton() {
        JButton loginButton = new JButton("Entrar");
        loginButton.setBounds(150, 390, 100, 35);
        loginButton.setBackground(new Color(0, 0, 255));
        loginButton.setForeground(Color.BLACK);
        loginButton.setFocusPainted(false);

        loginButton.addActionListener(e -> handleLogin());
        addHoverEffect(loginButton);

        return loginButton;
    }

    private void addHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(0, 0, 220));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(0, 0, 255));
            }
        });
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            showMessage("Por favor, preencha todos os campos.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
        } else {
            new HomeEstudante().setVisible(true);
            dispose();

            // TODO: Implement actual authentication logic
            //showMessage("Implementar lógica de autenticação aqui", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

    public static void main(String[] args) {
            new LoginScreen().setVisible(true);
    }

}
