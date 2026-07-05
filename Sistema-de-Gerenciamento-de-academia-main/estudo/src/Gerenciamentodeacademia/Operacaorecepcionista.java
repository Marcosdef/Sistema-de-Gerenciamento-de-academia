package Gerenciamentodeacademia;

import Gerenciamentodeacademia.enuns.Cargo;
import Gerenciamentodeacademia.enuns.Horario;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Operacaorecepcionista extends JPanel {
    private final ArrayList<Recepcionista> recepicionista = Repositorio.getInstancia().getRecepcionistas();
    private CardLayout cardLayout;
    private JPanel container;
    private JTextField txtNome;
    private JTextField txtCpf;
    private JTextField txtTelefone;
    private JTextField txtEndereco;
    private JTextField txtSalario;
    private JComboBox<Horario> cbhora;
    private JButton btnCadastrar;
    private JButton btnlistar;
    private JButton btnbuscar;
    private JButton btndeletar;
    private JButton btnbAtualizar;
    private JButton btnAtualizar;
    private JButton btnvoltar;

    public Operacaorecepcionista(CardLayout cardLayout, JPanel container) {
        this.cardLayout = cardLayout;
        this.container = container;

        setSize(500,650);
        setLayout(null);

        // Coluna Esquerda

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20,20,80,25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(100,20,250,25);
        add(txtNome);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(20,60,80,25);
        add(lblCpf);

        txtCpf = new JTextField();
        txtCpf.setBounds(100,60,250,25);
        add(txtCpf);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(20,100,80,25);
        add(lblTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(100,100,250,25);
        add(txtTelefone);

        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(20,140,80,25);
        add(lblEndereco);

        txtEndereco = new JTextField();
        txtEndereco.setBounds(100,140,250,25);
        add(txtEndereco);

        JLabel lblSalario = new JLabel("Salario:");
        lblSalario.setBounds(20,180,80,25);
        add(lblSalario);

        txtSalario = new JTextField();
        txtSalario.setBounds(100,180,200,25);
        add(txtSalario);
// Hora

        JLabel lblHora = new JLabel("Horario: ");
        lblHora.setBounds(20,220,80,25);
        add(lblHora);

        cbhora = new JComboBox<>(Horario.values());
        cbhora.setBounds(100,220,200,25);
        add(cbhora);

// Botoes

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(20, 260, 150, 35);
        add(btnCadastrar);

        btnlistar = new JButton("Listar");
        btnlistar.setBounds(180, 260, 150, 35);
        add(btnlistar);

        btnbuscar = new JButton("Buscar");
        btnbuscar.setBounds(20, 305, 150, 35);
        add(btnbuscar);

        btndeletar = new JButton("Deletar");
        btndeletar.setBounds(180, 305, 150, 35);
        add(btndeletar);

        btnbAtualizar = new JButton("Buscar para atualizar");
        btnbAtualizar.setBounds(20, 350, 150, 35);
        add(btnbAtualizar);

        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(180, 350, 150, 35);
        add(btnAtualizar);

        btnvoltar = new JButton("Voltar");
        btnvoltar.setBounds(180, 395, 150, 35);
        add(btnvoltar);

        btnCadastrar.addActionListener(e -> salvarrecepcionista());
        btnlistar.addActionListener(e -> listar());
        btnbuscar.addActionListener(e -> buscarentidade());
        btndeletar.addActionListener(e -> deletar());
        btnbAtualizar.addActionListener(e -> buscarparaatualizar());
        btnAtualizar.addActionListener(e -> atualizar());

        btnvoltar.addActionListener(e -> {
            this.cardLayout.show(this.container, "menu");
        });

        setVisible(true);
    }
    private void salvarrecepcionista() {
        if(txtNome.getText().trim().isEmpty() || txtCpf.getText().trim().isEmpty() || txtTelefone.getText().trim().isEmpty() || cbhora.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this,"Todos os capos devem ser preenchidos");
            return;
        }
        for (Recepcionista a : recepicionista) {
            if (a.getCpf().equals(txtCpf.getText().trim())) {
                JOptionPane.showMessageDialog(this, "CPF já existente.");
                return;
            }
        }
        for (Recepcionista a : recepicionista){
            if (a.getTelefone().equals((txtTelefone.getText().trim()))){
                JOptionPane.showMessageDialog(this,"Telefone ja existente.");
                return;
            }
        }
        Recepcionista rece = new Recepcionista(
                txtCpf.getText().trim(),
                txtNome.getText().trim(),
                Double.parseDouble(txtSalario.getText().trim()),
                txtEndereco.getText().trim(),
                txtTelefone.getText().trim(),
                Cargo.recepiscionista,
                (Horario) cbhora.getSelectedItem()
        );

        recepicionista.add(rece);

        JOptionPane.showMessageDialog(this, rece.exibir());
        limpar();
    }
    public void limpar(){
        txtNome.setText("");
        txtCpf.setText("");
        txtTelefone.setText("");
        txtEndereco.setText("");
        txtSalario.setText("");
        cbhora.setSelectedIndex(0);
    }
    public void listar() {

        if (recepicionista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum recepcionista cadastrado.");
            return;
        }
        String lista = "";
        for (Recepcionista a : recepicionista) {
            lista += a.exibir() + "\n\n";
        }
        JOptionPane.showMessageDialog(this, lista);
    }
    public Recepcionista acharcpf(String cpf){
        for(Recepcionista rece : recepicionista){
            if(rece.getCpf().equals(cpf)){
                return rece;
            }
        }
        return null;
    }
    public void buscarentidade(){
        String cpf = JOptionPane.showInputDialog("digite um cpf");
        Recepcionista rece = acharcpf(cpf);
        if(rece == null){
            JOptionPane.showMessageDialog(this,"Cpf inexistente");
        } else {
            JOptionPane.showMessageDialog(this, rece.exibir());
        }
    }
    public void deletar(){
        String cpf = JOptionPane.showInputDialog("digite um cpf");
        Recepcionista rece = acharcpf(cpf);
        if(rece == null){
            JOptionPane.showMessageDialog(this,"Cpf inexistente");
        } else {
            recepicionista.remove(rece);
            JOptionPane.showMessageDialog(this,"Recepcionista deletado com sucesso");
        }
    }
    public void buscarparaatualizar () {
        String cpf = JOptionPane.showInputDialog("digite o cpf");
        Recepcionista rece = acharcpf(cpf);
        if (rece == null) {
            JOptionPane.showMessageDialog(this, "CPF inexistente.");
            return;
        }
        txtNome.setText(rece.getNome());
        txtCpf.setText(rece.getCpf());
        txtTelefone.setText(rece.getTelefone());
        txtEndereco.setText(rece.getEndereco());
        cbhora.setSelectedItem(rece.getHorario());

        txtCpf.setEditable(false);
        JOptionPane.showMessageDialog(this,"Clique no botao atualizar para atualizar");
    }
    public void atualizar() {

        Recepcionista rece = acharcpf(txtCpf.getText().trim());

        if (rece == null) {
            JOptionPane.showMessageDialog(this, "Busque um recepcionista primeiro.");
            return;
        }

        rece.setNome(txtNome.getText().trim());
        rece.setTelefone(txtTelefone.getText().trim());
        rece.setNome(txtNome.getText().trim());
        rece.setTelefone(txtTelefone.getText().trim());
        rece.setEndereco(txtEndereco.getText().trim());
        rece.setHorario((Horario) cbhora.getSelectedItem());

        JOptionPane.showMessageDialog(this, "Recepcionista atualizado com sucesso!");

        txtCpf.setEditable(true);
        limpar();
    }
}