package AirportSystem.InterfaceGrafica;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel contentPainel = new JPanel(cardLayout);

    public MainWindow() {
        configurarJanela();

        requestFocusInWindow();
    }

    public void configurarJanela() {
        Image icon = new ImageIcon(getClass().getResource(
                "/AirportSystem/InterfaceGrafica/Images/airplane_1.png")).getImage();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Star Track Airport System");
        setIconImage(icon);
        setContentPane(contentPainel);
        setVisible(true);
    }

    public void adicionarTela(JPanel view, String tela) {
        contentPainel.add(view, tela);
    }

    public void showLogin(String tela) {
        cardLayout.show(contentPainel, tela);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void showOperacional(String tela) {}

    public void showVendas(String tela) {
        cardLayout.show(contentPainel, tela);
        setPreferredSize(new Dimension(1000, 800));
        setLocationRelativeTo(null);
        setResizable(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
