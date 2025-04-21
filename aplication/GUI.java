package aplication;

import javax.swing.*;

public class GUI extends JFrame {
    private JTextField campoNome;
    private JTextField campoVida;
    private JButton botaoCriar;
    private JButton aplicarDano;
    private JTextField campoDano;
    // private JLabel labelStatus;
    private DefaultListModel<Monstro> listaMonstros;
    private JList<Monstro> visualListaMonstros;

    public GUI(){
        // configurarJanela();         // Define tamanho, título, fechar ao sair, etc
        // inicializarComponentes();   // Cria e configura todos os botões, campos etc.
        // montarLayout();             // Define a disposição dos elementos
        // adicionarListeners();       // Adiciona ações aos botões
        // this.setVisible(true);      // Exibe a janela
    }

    private void configurarJanela(){
        // setTitle, setSize, setDefaultCloseOperation, etc
    }

    private void inicializarComponentes(){
        // instancia JTextFields, JButtons, JLabel, JList, etc.
    }

    private void montarLayout(){
        // adiciona os componentes no painel e posiciona com LayoutManager
    }

    private void adicionarListeners(){
        // define o que acontece ao clicar em criar monstro, aplicar dano, etc
    }

    // Testar interface
    public static void main(String[] args) {
        //new GUI();
    }
}
