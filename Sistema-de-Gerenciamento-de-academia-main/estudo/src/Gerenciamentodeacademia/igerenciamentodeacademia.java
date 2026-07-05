package Gerenciamentodeacademia;

import javax.swing.*;
import java.awt.*;

public class igerenciamentodeacademia {

    public void Tela_principal() {

        JFrame frame = new JFrame("Sistema");
        frame.setSize(900, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel container = new JPanel(cardLayout);

        Operacaoaluno operacaoaluno = new Operacaoaluno(cardLayout,container);
        Operacaorecepcionista operacaorecepcionista = new Operacaorecepcionista(cardLayout,container);
        Operacaoobjetosacademia operacaoobjetosacademia = new Operacaoobjetosacademia(cardLayout,container);
        Operacaopersonal operacaopersonal = new Operacaopersonal(cardLayout,container);

        JPanel menu = new JPanel();
        JButton btnIrCadastro = new JButton("Cadastro Aluno");
        JButton btnIrrece = new JButton("cadastro recepcionista");
        JButton btnIrobjetos = new JButton("cadastrar equipamento");
        JButton btnIrperso = new JButton("cadastrar personal");

        menu.add(btnIrCadastro);
        menu.add(btnIrrece);
        menu.add(btnIrobjetos);
        menu.add(btnIrperso);

        container.add(menu, "menu");
        container.add(operacaoaluno, "cadastroAluno");
        container.add(operacaorecepcionista,"cadastrorecepcionista");
        container.add(operacaoobjetosacademia,"cadastroequipamento");
        container.add(operacaopersonal,"cadastropersonal");

        btnIrCadastro.addActionListener(e -> {
            cardLayout.show(container, "cadastroAluno");
        });
        btnIrrece.addActionListener(e ->cardLayout.show(container,"cadastrorecepcionista"));
        btnIrobjetos.addActionListener(e -> cardLayout.show(container,"cadastroequipamento"));
        btnIrperso.addActionListener(e -> cardLayout.show(container,"cadastropersonal"));

        frame.add(container);
        frame.setVisible(true);
    }
}