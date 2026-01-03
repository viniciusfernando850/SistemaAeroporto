package AirportSystem.InterfaceGrafica.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginView extends JPanel {
    private JTextField usuario;
    private JPasswordField senha;
    private JComboBox<String> seletor;
    private JButton botaoEntrar;
    private final LoginController controller;

    public LoginView(LoginController loginController) {
        this.controller = loginController;

        inicializarComponentes();
        configurarLayout();
        configurarEventos();
    }

    public void configurarLayout() {
        setLayout(new BorderLayout());

        JPanel background =
                new PainelBackGround("/AirportSystem/InterfaceGrafica/Images/background-login.jpg");
        background.setLayout(new BorderLayout());
        StyleLogin.desingBackground(background);

        JPanel painel = new JPanel(new GridBagLayout());
        StyleLogin.designLateral(painel);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(20, 5, 20, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        StyleLogin.designCampo(this.usuario);
        painel.add(this.usuario, gbc);

        gbc.gridy = 1;
        StyleLogin.designCampo(this.senha);
        painel.add(this.senha, gbc);

        gbc.gridy = 2;
        StyleLogin.designSeletor(this.seletor);
        painel.add(this.seletor, gbc);

        gbc.insets = new Insets(30, 5, 15, 5);
        gbc.gridy = 3;
        StyleLogin.designBotao(this.botaoEntrar);
        painel.add(this.botaoEntrar, gbc);

        background.add(painel, BorderLayout.WEST);

        add(background, BorderLayout.CENTER);
    }

    private void inicializarComponentes() {
        gerarBotao();
        gerarCampos();
        gerarSeletor();
    }

    private void gerarBotao() {
        this.botaoEntrar = new JButton("Login");
    }

    private void gerarCampos() {
        this.usuario = new JTextField("Usuário");
        this.senha = new JPasswordField();
        senha.setText("Senha");
        this.senha.setEchoChar((char) 0);
    }

    private void gerarSeletor() {
        this.seletor = new JComboBox<>();

        seletor.addItem("-- Selecione uma opção --");
        seletor.addItem("Seção de Vendas");
        seletor.addItem("Seção de Check-in");
        seletor.addItem("Seção Administrativa");
    }

    private void configurarEventos() {
        setFocusable(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                requestFocusInWindow();
            }
        });

        botaoEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.realizarLogin(usuario.getText(), senha.getPassword());
            }
        });

        botaoEntrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                StyleLogin.designBotaoPressionado(botaoEntrar);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                StyleLogin.designBotao(botaoEntrar);
            }
        });

        usuario.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (usuario.getText().equals("Usuário"))
                    usuario.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (usuario.getText().isEmpty())
                    usuario.setText("Usuário");
            }
        });

        senha.addFocusListener(new FocusListener() {
            boolean senhaPlaceHolder = true;

            @Override
            public void focusGained(FocusEvent e) {
                if (senhaPlaceHolder) {
                    senha.setText("");
                    senha.setEchoChar('*');
                    senhaPlaceHolder = false;
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (senha.getPassword().length == 0) {
                    senha.setText("Senha");
                    senha.setEchoChar((char) 0);
                    senhaPlaceHolder = true;
                }
            }
        });
    }

}
