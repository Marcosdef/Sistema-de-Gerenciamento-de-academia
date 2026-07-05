package Gerenciamentodeacademia;

import Gerenciamentodeacademia.enuns.objetosacademia;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Operacaoobjetosacademia extends JPanel {
    private final ArrayList<objetosdemalhacao> objeto = Repositorio.getInstancia().getObjetosdemalhacao();
    private CardLayout cardLayout;
    private JPanel container;
    private JTextField txtquantidade;
    private JComboBox<objetosacademia> cbobjeto;
    private JButton btnCadastrar;
    private JButton btnlistar;
    private JButton btnbuscar;
    private JButton btndeletar;
    private JButton btnbAtualizar;
    private JButton btnAtualizar;
    private JButton btnvoltar;

    public Operacaoobjetosacademia(CardLayout cardLayout, JPanel container) {
        this.cardLayout = cardLayout;
        this.container = container;

        setSize(500,650);
        setLayout(null);
// Esquerda
        JLabel lblquantia = new JLabel("Quantidade");
        lblquantia.setBounds(20,60,80,25);
        add(lblquantia);

        txtquantidade = new JTextField();
        txtquantidade.setBounds(100,60,200,25);
        add(txtquantidade);
// Hora

        JLabel lblobjeto = new JLabel("objetos de malhação: ");
        lblobjeto.setBounds(20,20,80,25);
        add(lblobjeto);

        cbobjeto = new JComboBox<>(objetosacademia.values());
        cbobjeto.setBounds(100,20,200,25);
        add(cbobjeto);

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
        if(txtquantidade.getText().trim().isEmpty() || cbobjeto.getSelectedItem() == null){
            JOptionPane.showMessageDialog(this,"Todos os capos devem ser preenchidos");
            return;
        }
        for (objetosdemalhacao a : objeto) {
            if (a.getObjetosacademia() == (objetosacademia) cbobjeto.getSelectedItem()) {
                JOptionPane.showMessageDialog(this, "Equipamento ja existente");
                return;
            }
        }
        objetosdemalhacao obj = new objetosdemalhacao(
                (objetosacademia) cbobjeto.getSelectedItem(),
                Integer.parseInt(txtquantidade.getText().trim())
        );

        objeto.add(obj);

        JOptionPane.showMessageDialog(this,"Objeto cadastrado com sucesso.");

        limpar();
    }
    public void limpar(){
        txtquantidade.setText("");
        cbobjeto.setSelectedIndex(0);
    }
    public void listar() {

        if(objeto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum equipamento cadastrado.");
            return;
        }
        String lista = "";
        for(objetosdemalhacao o : objeto){
            lista += "Objeto: " + o.getObjetosacademia()
                    + "\nQuantidade: " + o.getQuantidade()
                    + "\n\n";
        }
        JOptionPane.showMessageDialog(this,lista);
    }
    public objetosdemalhacao acharObjeto(objetosacademia nome){
        for(objetosdemalhacao o : objeto){
            if(o.getObjetosacademia() == nome){
                return o;
            }
        }
        return null;
    }
    public void buscarentidade(){
        objetosacademia nome =
                (objetosacademia) JOptionPane.showInputDialog(
                        this,
                        "Escolha um Equipamento",
                        "Buscar",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        objetosacademia.values(),
                        objetosacademia.values()[0]
                );
        objetosdemalhacao obj = acharObjeto(nome);
        if(obj == null){
            JOptionPane.showMessageDialog(this,"Equipamento inexistente");
        }else{
            JOptionPane.showMessageDialog(this, obj.exibir());
        }
    }
    public void deletar(){
        objetosacademia nome =
                (objetosacademia) JOptionPane.showInputDialog(
                        this,
                        "Escolha um Equipamento",
                        "Buscar",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        objetosacademia.values(),
                        objetosacademia.values()[0]
                );
        objetosdemalhacao obj = acharObjeto(nome);
        if(objeto == null){
            JOptionPane.showMessageDialog(this,"Equipamento inexistente");
        } else {
            objeto.remove(obj);
            JOptionPane.showMessageDialog(this,"Equipamento deletado com sucesso");
        }
    }
    public void buscarparaatualizar () {
        objetosacademia nome =
                (objetosacademia) JOptionPane.showInputDialog(
                        this,
                        "Escolha um objeto",
                        "Buscar",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        objetosacademia.values(),
                        objetosacademia.values()[0]
                );
        objetosdemalhacao obj = acharObjeto(nome);
        if(obj == null){
            JOptionPane.showMessageDialog(this,"Equipamento inexistente.");
            return;
        }
        cbobjeto.setSelectedItem(obj.getObjetosacademia());
        txtquantidade.setText(String.valueOf(obj.getQuantidade()));
        cbobjeto.setEnabled(false);
    }
    public void atualizar() {
        objetosdemalhacao obj = acharObjeto((objetosacademia) cbobjeto.getSelectedItem());
        if(obj == null){
            JOptionPane.showMessageDialog(this,"Busque um equipamento primeiro.");
            return;
        }
        obj.setQuantidade(
                Integer.parseInt(txtquantidade.getText().trim()));

        JOptionPane.showMessageDialog(this, "Equipamento atualizado com sucesso.");

        cbobjeto.setEnabled(true);

        limpar();
    }
}