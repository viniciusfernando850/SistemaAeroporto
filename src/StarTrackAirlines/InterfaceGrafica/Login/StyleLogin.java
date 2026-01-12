package StarTrackAirlines.InterfaceGrafica.Login;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StyleLogin {
    private static Color azulPrussia = new Color(0, 7, 45);
    private static Color azulImperial = new Color(10, 36, 114);
    private static Color vermelhoCarmezim = new Color(163, 0, 21);
    private static Color brancoNeve = new Color(249, 249, 249);

    public static void designCampo(JTextField campo) {
        campo.setPreferredSize(new Dimension(200, 35));
        campo.setBackground(brancoNeve);
        campo.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, azulImperial));
        campo.setOpaque(true);

    }

    public static void designBotao(JButton botao, int width, int height) {
        botao.setPreferredSize(new Dimension(width, height));
        botao.setBackground(azulImperial);
        botao.setForeground(brancoNeve);
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setContentAreaFilled(false);
        botao.setOpaque(true);
    }

    public static void designBotaoPressionado(JButton botao, int width, int height) {
        botao.setPreferredSize(new Dimension(width, height));
        botao.setBackground(azulPrussia);
        botao.setForeground(brancoNeve);
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setOpaque(true);
    }

    public static void designLateral(JPanel painel) {
        painel.setBackground(brancoNeve);
        painel.setBorder(new EmptyBorder(20, 10, 20, 10));
        painel.setPreferredSize(new Dimension(330, 500));

    }

    public static void designMensagemErro(JDialog dialogWindow, JLabel mensagemErro, JPanel painel) {
        dialogWindow.setBackground(brancoNeve);
        painel.setBackground(brancoNeve);

        mensagemErro.setFont(new Font("Arial", Font.BOLD, 14));
        mensagemErro.setForeground(vermelhoCarmezim);
    }

    public static void desingBackground(JPanel background) {
        background.setPreferredSize(new Dimension(800, 500));
    }
}
