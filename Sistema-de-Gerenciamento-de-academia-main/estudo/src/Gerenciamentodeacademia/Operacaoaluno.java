package Gerenciamentodeacademia;
import Gerenciamentodeacademia.enuns.Mesalidade;
import Gerenciamentodeacademia.enuns.tipoPlano;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Operacaoaluno extends JPanel {
    private final ArrayList<Alunos> alunos = Repositorio.getInstancia().getAlunos();
    private CardLayout cardLayout;
    private JPanel container;
    private JTextField txtNome;
    private JTextField txtCpf;
    private JTextField txtTelefone;
    private JTextField txtAltura;
    private JTextField txtPeso;
    private JTextField txtDatanaci;
    private JComboBox<tipoPlano> cbPlano;
    private JComboBox<Mesalidade> cbmen;
    private JButton btnCadastrar;
    private JButton btnlistar;
    private JButton btnbuscar;
    private JButton btndeletar;
    private JButton btnbAtualizar;
    private JButton btnAtualizar;
    private JButton btnvoltar;
    private JButton btnrenovar;

    public Operacaoaluno(CardLayout cardLayout, JPanel container) {
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

// Mensalidade

        JLabel lblmen = new JLabel("Mensalidades: ");
        lblmen.setBounds(20,140,100,25);
        add(lblmen);

        cbmen = new JComboBox<>(Mesalidade.values());
        cbmen.setBounds(120,140,250,25);
        add(cbmen);

// Coluna direita

        JLabel lblAltura = new JLabel("Altura:");
        lblAltura.setBounds(400,20,80,25);
        add(lblAltura);

        txtAltura = new JTextField();
        txtAltura.setBounds(480,20,200,25);
        add(txtAltura);

        JLabel lblPeso = new JLabel("Peso:");
        lblPeso.setBounds(400,60,80,25);
        add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(480,60,200,25);
        add(txtPeso);

        JLabel lblData = new JLabel("Nascimento:");
        lblData.setBounds(400,100,100,25);
        add(lblData);

        txtDatanaci = new JTextField();
        txtDatanaci.setBounds(480,100,200,25);
        add(txtDatanaci);

// Plano

        JLabel lblPlano = new JLabel("Plano:");
        lblPlano.setBounds(400,140,80,25);
        add(lblPlano);

        cbPlano = new JComboBox<>(tipoPlano.values());
        cbPlano.setBounds(480,140,200,25);
        add(cbPlano);

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

        btnrenovar = new JButton("Renovar");
        btnrenovar.setBounds(20, 395, 150, 35);
        add(btnrenovar);

        btnvoltar = new JButton("Voltar");
        btnvoltar.setBounds(180, 395, 150, 35);
        add(btnvoltar);

        btnCadastrar.addActionListener(e -> salvarAluno());
        btnlistar.addActionListener(e -> listar());
        btnbuscar.addActionListener(e -> buscarentidade());
        btndeletar.addActionListener(e -> deletar());
        btnbAtualizar.addActionListener(e -> buscarparaatualizar());
        btnAtualizar.addActionListener(e -> atualizar());
        btnrenovar.addActionListener(e -> renovarmensalidade());

        btnvoltar.addActionListener(e -> {
            this.cardLayout.show(this.container, "menu");
        });

        setVisible(true);
    }
    private void salvarAluno() {
        if(txtNome.getText().trim().isEmpty() || txtCpf.getText().trim().isEmpty() || txtTelefone.getText().trim().isEmpty() || cbPlano.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this,"Todos os capos devem ser preenchidos");
            return;
        }
        for (Alunos a : alunos) {
            if (a.getCpf().equals(txtCpf.getText().trim())) {
                JOptionPane.showMessageDialog(this, "CPF já existente.");
                return;
            }
        }
        for (Alunos a : alunos){
            if (a.getTelefone().equals((txtTelefone.getText().trim()))){
                JOptionPane.showMessageDialog(this,"Telefone ja existente.");
                return;
            }
        }
        Alunos aluno = new Alunos(txtCpf.getText().trim(),
                txtNome.getText().trim(),
                "",
                txtTelefone.getText().trim(),
                (tipoPlano) cbPlano.getSelectedItem(),
                Double.parseDouble(txtPeso.getText().trim()),
                Double.parseDouble(txtAltura.getText().trim()),
                0,"");

        mensalidade(aluno);

        alunos.add(aluno);

        JOptionPane.showMessageDialog(this, aluno.exibir());
        limpar();
    }
    public void limpar(){
        txtTelefone.setText("");
        txtCpf.setText("");
        txtNome.setText("");
        txtAltura.setText("");
        txtDatanaci.setText("");
        txtPeso.setText("");
    }
    public void listar() {

        if (alunos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum aluno cadastrado.");
            return;
        }
        String lista = "";
        for (Alunos a : alunos) {
            lista += a.exibir() + "\n\n";
        }
        JOptionPane.showMessageDialog(this, lista);
    }
    public Alunos acharcpf(String cpf){
        for(Alunos aluno : alunos){
            if(aluno.getCpf().equals(cpf)){
                return aluno;
            }
        }
        return null;
    }
    public void buscarentidade(){
        String cpf = JOptionPane.showInputDialog("digite um cpf");
        Alunos aluno = acharcpf(cpf);
        if(aluno == null){
            JOptionPane.showMessageDialog(this,"Cpf inexistente");
        } else {
            JOptionPane.showMessageDialog(this, aluno.exibir());
        }
    }
    public void deletar(){
        String cpf = JOptionPane.showInputDialog("digite um cpf");
        Alunos aluno = acharcpf(cpf);
        if(aluno == null){
            JOptionPane.showMessageDialog(this,"Cpf inexistente");
        } else {
            alunos.remove(aluno);
            JOptionPane.showMessageDialog(this,"Aluno deletado com sucesso");
        }
    }
    public void buscarparaatualizar () {
        String cpf = JOptionPane.showInputDialog("digite o cpf");
        Alunos aluno = acharcpf(cpf);
        if (aluno == null) {
            JOptionPane.showMessageDialog(this, "CPF inexistente.");
            return;
        }
        txtNome.setText(aluno.getNome());
        txtCpf.setText(aluno.getCpf());
        txtTelefone.setText(aluno.getTelefone());
        cbPlano.setSelectedItem(aluno.getTipo());
        txtAltura.setText(String.valueOf(aluno.getAltura()));
        txtPeso.setText(String.valueOf(aluno.getPeso()));
        txtDatanaci.setText(String.valueOf(aluno.getDataNascimento()));

        txtCpf.setEditable(false);
        JOptionPane.showMessageDialog(this,"clique no botao atualizar para atualizar");
    }
    public void atualizar() {

        Alunos aluno = acharcpf(txtCpf.getText().trim());

        if (aluno == null) {
            JOptionPane.showMessageDialog(this, "Busque um aluno primeiro.");
            return;
        }

        aluno.setNome(txtNome.getText().trim());
        aluno.setTelefone(txtTelefone.getText().trim());
        aluno.setTipo((tipoPlano) cbPlano.getSelectedItem());
        aluno.setAltura(Double.parseDouble(txtAltura.getText().trim()));
        aluno.setPeso(Double.parseDouble(txtPeso.getText().trim()));
        aluno.setDataNascimento(Integer.parseInt(txtDatanaci.getText().trim()));

        mensalidade(aluno);

        JOptionPane.showMessageDialog(this, "Aluno atualizado com sucesso!");

        txtCpf.setEditable(true);
        limpar();
    }
    public void mensalidade(Alunos aluno) {

        Mesalidade opcao = (Mesalidade) cbmen.getSelectedItem();

        if (opcao == Mesalidade.mensal) {
            aluno.planomensal();
        } else if (opcao == Mesalidade.anual) {
            aluno.planoanual();
        }
    }
    public void renovarmensalidade() {

        String cpf = JOptionPane.showInputDialog("Digite o CPF:");
        Alunos aluno = acharcpf(cpf);

        if (aluno == null) {
            JOptionPane.showMessageDialog(this, "Aluno não encontrado");
            return;
        }

        String[] opcoes = {"Mensal", "Anual"};

        int opcao = JOptionPane.showOptionDialog(
                this,
                "Escolha o plano:",
                "Renovar mensalidade",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );

        switch (opcao) {
            case 0 -> aluno.planomensal();
            case 1 -> aluno.planoanual();
            default -> JOptionPane.showMessageDialog(this, "Cancelado");
        }
    }
}