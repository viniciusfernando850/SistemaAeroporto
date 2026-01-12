package StarTrackAirlines.InterfaceGrafica.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginView extends JPanel {
    private final JTextField usuario;
    private final JPasswordField senha;
    private final JButton botaoEntrar;

    public LoginView() {
        this.usuario = new JTextField();
        this.senha = new JPasswordField();
        this.botaoEntrar = new JButton("Login");

        configurarLayout();
    }

    private void configurarLayout() {
        setLayout(new BorderLayout());

        JPanel background =
                new PainelBackGround("/StarTrackAirlines/InterfaceGrafica/Images/background-login.jpg");
        background.setLayout(new BorderLayout());
        StyleLogin.desingBackground(background);

        JPanel painel = new JPanel(new GridBagLayout());
        StyleLogin.designLateral(painel);
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel usuarioLabel = new JLabel("Usuário");
        JLabel senhaLabel = new JLabel("Senha");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 5, 0, 5);
        gbc.anchor = GridBagConstraints.WEST;
        painel.add(usuarioLabel, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(0, 5, 15, 5);
        StyleLogin.designCampo(this.usuario);
        painel.add(this.usuario, gbc);

        gbc.gridy = 2;
        gbc.insets = new Insets(15, 5, 0, 5);
        painel.add(senhaLabel, gbc);

        gbc.gridy = 3;
        gbc.insets = new Insets(0, 5, 20, 5);
        StyleLogin.designCampo(this.senha);
        painel.add(this.senha, gbc);

        gbc.gridy = 4;
        gbc.insets = new Insets(30, 5, 15, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        StyleLogin.designBotao(this.botaoEntrar, 120, 32);
        painel.add(this.botaoEntrar, gbc);

        background.add(painel, BorderLayout.WEST);

        add(background, BorderLayout.CENTER);
    }

    public void configurarMensagemErro(JFrame mainWindow) {
        JDialog dialogWindow = new JDialog(mainWindow, "Acesso Negado", true);
        dialogWindow.setLayout(new BorderLayout());

        Image icone = new ImageIcon(getClass().getResource(
                "/StarTrackAirlines/InterfaceGrafica/Images/atencao.png")).getImage();
        dialogWindow.setIconImage(icone);

        JLabel mensagemErro = new JLabel("Usuário e/ou senha inválidos!");

        JButton ok = new JButton("Ok");

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogWindow.dispose();
            }
        });
        ok.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                StyleLogin.designBotaoPressionado(ok, 60, 28);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                StyleLogin.designBotao(ok, 60, 28);
            }
        });

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(30, 50, 30, 50);
        gbc.anchor = GridBagConstraints.CENTER;
        painel.add(mensagemErro, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(0, 50, 30, 50);
        StyleLogin.designBotao(ok, 60, 28);
        painel.add(ok, gbc);

        StyleLogin.designMensagemErro(dialogWindow, mensagemErro, painel);

        dialogWindow.add(painel);
        dialogWindow.pack();
        dialogWindow.setLocationRelativeTo(this);
        dialogWindow.setVisible(true);
    }

    public JTextField getUsuario() {return this.usuario;}
    public JPasswordField getSenha() {return this.senha;}
    public JButton getBotaoEntrar() {return this.botaoEntrar;}

}
