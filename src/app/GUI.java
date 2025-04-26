package app;

import javax.swing.*;

public class GUI {
    private JTextField nameField;
    private JTextField lifeField;
    private JButton createButton;
    private JButton applyDamageButton;
    private JTextField damageField;
    // private JLabel statusLabel;
    private DefaultListModel<Monster> monsterListModel;
    private JList<Monster> monsterListView;

    public GUI() {
        // configWindow();             // DDefine window size, title, close operation, etc
        // initComponents();           // Create and configure all buttons, fields, etc.
        // setupLayout();              // Define the layout of components
        // addListeners();             // Add action to the buttons
        // this.setVisible(true);      // Show the window
    }

    private void configWindow() {
        // setTitle, setSize, setDefaultCloseOperation, etc
    }

    private void initComponents() {
        // Instantiate JTextFields, JButtons, JLabel, JList, etc.
    }

    private void setupLayout() {
        // Add components to the panel and position them with LayoutManager
    }

    private void addListeners() {
        // Define what happens when creating a monster, applying damage, etc.
    }

    // Test interface
    public static void main(String[] args) {
        //new GUI();
    }
}
