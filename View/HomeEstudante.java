package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomeEstudante extends JFrame {
    private JPanel contentPanel;

    public HomeEstudante() {
        setTitle("Universidade Mais Saber");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create sidebar
        JPanel sidebar = createSidebar();

        // Create content panel
        contentPanel = new JPanel();
        contentPanel.setBackground(new Color(243, 243, 243));

        // Add logo to content panel
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/Img/Logo.png"));
        Image scaledImage = logoIcon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledImage));
        contentPanel.add(logoLabel);


        // Add panels to main panel
        mainPanel.add(sidebar, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Add main panel to frame
        add(mainPanel);
    }

    private JPanel createSidebar() {
        JPanel sidebar = new JPanel(null); // Using null layout for absolute positioning
        sidebar.setPreferredSize(new Dimension(200, getHeight()));
        sidebar.setBackground(new Color(168, 168, 168)); // Blue background

        // Create menu buttons
        JButton inscricaoBtn = createMenuButton("Inscrição", 200);
        JButton avaliacoesBtn = createMenuButton("Avaliações", 250);
        JButton matriculaBtn = createMenuButton("Matricula", 300);
        JButton backBtn = createMenuButton("← Voltar", 620);


        // Add buttons to sidebar
        sidebar.add(inscricaoBtn);
        sidebar.add(avaliacoesBtn);
        sidebar.add(matriculaBtn);
        sidebar.add(backBtn);

        return sidebar;
    }

    private JButton createMenuButton(String text, int yPosition) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isPressed()) {
                    g.setColor(new Color(0, 0, 200));
                } else if (getModel().isRollover()) {
                    g.setColor(new Color(30, 30, 255));
                } else {
                    g.setColor(new Color(0, 0, 255));
                }
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(g);
            }
        };

        button.setBounds(20, yPosition, 160, 40);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);

        // Add hover effect
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });

        // Add click handling
        button.addActionListener(e -> handleMenuClick(text));

        return button;
    }

    private void handleMenuClick(String menuItem) {
        switch(menuItem) {
            case "Inscrição":
                // Handle inscription
                JOptionPane.showMessageDialog(this, "Área de Inscrição");
                break;
            case "Avaliações":
                // Handle evaluations
                JOptionPane.showMessageDialog(this, "Área de Avaliações");
                break;
            case "Matricula":
                // Handle enrollment
                JOptionPane.showMessageDialog(this, "Área de Matrícula");
                break;
            case "← Voltar":
                new LoginScreen().setVisible(true);
                dispose();
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new HomeEstudante().setVisible(true);
        });
    }
}