package Gerenciamentodeacademia;

import Gerenciamentodeacademia.enuns.Cargo;
import Gerenciamentodeacademia.enuns.Especialidade;
import Gerenciamentodeacademia.enuns.Horario;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Operacaopersonal extends JPanel {
        private final ArrayList<Personaltrainer> perso = Repositorio.getInstancia().getPersonaltrainers();
        private CardLayout cardLayout;
        private JPanel container;
        private JTextField txtNome;
        private JTextField txtCpf;
        private JTextField txtTelefone;
        private JTextField txtEndereco;
        private JTextField txtSalario;
        private JComboBox<Horario> cbhora;
        private JComboBox<Especialidade> cbespecialidade;
        private JButton btnCadastrar;
        private JButton btnlistar;
        private JButton btnbuscar;
        private JButton btndeletar;
        private JButton btnbAtualizar;
        private JButton btnAtualizar;
        private JButton btnvoltar;
        private JButton btntreinamento;

        public Operacaopersonal(CardLayout cardLayout, JPanel container) {
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

            JLabel lblEspecialidade = new JLabel("Especialidade:");
            lblEspecialidade.setBounds(20,260,100,25);
            add(lblEspecialidade);

            cbespecialidade = new JComboBox<>(Especialidade.values());
            cbespecialidade.setBounds(120,260,200,25);
            add(cbespecialidade);

    // Botoes

            btnCadastrar = new JButton("Cadastrar");
            btnCadastrar.setBounds(20, 300, 150, 35);
            add(btnCadastrar);

            btnlistar = new JButton("Listar");
            btnlistar.setBounds(180, 300, 150, 35);
            add(btnlistar);

            btnbuscar = new JButton("Buscar");
            btnbuscar.setBounds(20, 340, 150, 35);
            add(btnbuscar);

            btndeletar = new JButton("Deletar");
            btndeletar.setBounds(180, 340, 150, 35);
            add(btndeletar);

            btnbAtualizar = new JButton("Buscar para atualizar");
            btnbAtualizar.setBounds(20, 380, 150, 35);
            add(btnbAtualizar);

            btnAtualizar = new JButton("Atualizar");
            btnAtualizar.setBounds(180, 380, 150, 35);
            add(btnAtualizar);

            btntreinamento = new JButton("Fazer treinamento");
            btntreinamento.setBounds(180,420,150,35);
            add(btntreinamento);

            btnvoltar = new JButton("Voltar");
            btnvoltar.setBounds(20, 420, 150, 35);
            add(btnvoltar);

            btnCadastrar.addActionListener(e -> salvarrecepcionista());
            btnlistar.addActionListener(e -> listar());
            btnbuscar.addActionListener(e -> buscarentidade());
            btndeletar.addActionListener(e -> deletar());
            btnbAtualizar.addActionListener(e -> buscarparaatualizar());
            btnAtualizar.addActionListener(e -> atualizar());
            btntreinamento.addActionListener(e -> criartreinamento());

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
            for (Personaltrainer a : perso) {
                if (a.getCpf().equals(txtCpf.getText().trim())) {
                    JOptionPane.showMessageDialog(this, "CPF já existente.");
                    return;
                }
            }
            for (Personaltrainer a : perso){
                if (a.getTelefone().equals((txtTelefone.getText().trim()))){
                    JOptionPane.showMessageDialog(this,"Telefone ja existente.");
                    return;
                }
            }
            Personaltrainer personal = new Personaltrainer(
                    txtCpf.getText().trim(),
                    txtNome.getText().trim(),
                    Double.parseDouble(txtSalario.getText().trim()),
                    txtEndereco.getText().trim(),
                    txtTelefone.getText().trim(),
                    Cargo.personaltrainer,
                    (Horario) cbhora.getSelectedItem(),
                    (Especialidade) cbespecialidade.getSelectedItem()
            );

            perso.add(personal);

            JOptionPane.showMessageDialog(this, personal.exibir());
            limpar();
        }
        public void limpar(){
            txtNome.setText("");
            txtCpf.setText("");
            txtTelefone.setText("");
            txtEndereco.setText("");
            txtSalario.setText("");
            cbhora.setSelectedIndex(0);
            cbespecialidade.setSelectedIndex(0);
        }
        public void listar() {

            if (perso.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum personal cadastrado.");
                return;
            }
            String lista = "";
            for (Personaltrainer a : perso) {
                lista += a.exibir() + "\n\n";
            }
            JOptionPane.showMessageDialog(this, lista);
        }
        public Personaltrainer acharcpf(String cpf){
            for(Personaltrainer perso : perso){
                if(perso.getCpf().equals(cpf)){
                    return perso;
                }
            }
            return null;
        }
        public void buscarentidade(){
            String cpf = JOptionPane.showInputDialog("digite um cpf");
            Personaltrainer personal = acharcpf(cpf);
            if(personal == null){
                JOptionPane.showMessageDialog(this,"Cpf inexistente");
            } else {
                JOptionPane.showMessageDialog(this, personal.exibir());
            }
        }
        public void deletar(){
            String cpf = JOptionPane.showInputDialog("digite um cpf");
            Personaltrainer personal = acharcpf(cpf);
            if(personal == null){
                JOptionPane.showMessageDialog(this,"Cpf inexistente");
            } else {
                perso.remove(personal);
                JOptionPane.showMessageDialog(this,"Personal deletado com sucesso");
            }
        }
        public void buscarparaatualizar () {
            String cpf = JOptionPane.showInputDialog("digite o cpf");
            Personaltrainer perso = acharcpf(cpf);
            if (perso == null) {
                JOptionPane.showMessageDialog(this, "CPF inexistente.");
                return;
            }
            txtNome.setText(perso.getNome());
            txtCpf.setText(perso.getCpf());
            txtTelefone.setText(perso.getTelefone());
            txtEndereco.setText(perso.getEndereco());
            cbhora.setSelectedItem(perso.getHorario());
            cbespecialidade.setSelectedItem(perso.getEspecialidade());

            txtCpf.setEditable(false);
            JOptionPane.showMessageDialog(this,"clique no botao atualizar para atualizar");
        }
        public void atualizar() {

            Personaltrainer perso = acharcpf(txtCpf.getText().trim());

            if (perso == null) {
                JOptionPane.showMessageDialog(this, "Busque um personal primeiro.");
                return;
            }

            perso.setNome(txtNome.getText().trim());
            perso.setTelefone(txtTelefone.getText().trim());
            perso.setNome(txtNome.getText().trim());
            perso.setTelefone(txtTelefone.getText().trim());
            perso.setEndereco(txtEndereco.getText().trim());
            perso.setHorario((Horario) cbhora.getSelectedItem());
            perso.setEspecialidade((Especialidade)cbespecialidade.getSelectedItem());

            JOptionPane.showMessageDialog(this, "Personal atualizado com sucesso!");

            txtCpf.setEditable(true);
            limpar();
        }
    public void criartreinamento() {
        String treinamento;
        String cpf = JOptionPane.showInputDialog("Digite o CPF do aluno:");

        Alunos aluno = Repositorio.getInstancia().achar(cpf);

        if (aluno != null) {
            treinamento = JOptionPane.showInputDialog("Faça o treinamento para o aluno:");
            aluno.setTreinamento(treinamento);
            JOptionPane.showMessageDialog(this, "Treinamento realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "CPF não encontrado.");
        }
    }
}
