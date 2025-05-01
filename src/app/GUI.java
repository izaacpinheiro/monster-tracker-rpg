package app;

import javax.swing.*;

public class GUI {
    private JFrame window;
    private JTextField nameField;
    private JTextField lifeField;
    private JButton createButton;
    private JButton applyDamageButton;
    private JTextField damageField;
    // private JLabel statusLabel;
    private DefaultListModel<Monster> monsterListModel;
    private JList<Monster> monsterListView;

    public GUI() {
        configWindow();             // Define window size, title, close operation, etc
        // initComponents();           // Create and configure all buttons, fields, etc.
        // setupLayout();              // Define the layout of components
        // addListeners();             // Add action to the buttons
        window.setVisible(true);      // Show the window
    }

    private void configWindow() {
        // setTitle, setSize, setDefaultCloseOperation, etc
        window = new JFrame();
        window.setTitle("Monster Tracker RPG");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(420,420);
        window.setResizable(false);
    }

    private void initComponents() {
        // Instantiate JTextFields, JButtons, JLabel, JList, etc.
        nameField = new JTextField(10);
        lifeField = new JTextField(5);
        damageField = new JTextField(5);

        createButton = new JButton("Create monster");
        applyDamageButton = new JButton("Apply damage");

        monsterListModel = new DefaultListModel<>();
        monsterListView = new JList<>(monsterListModel);
        monsterListView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void setupLayout() {
        // Add components to the panel and position them with LayoutManager
    }

    private void addListeners() {
        // Define what happens when creating a monster, applying damage, etc.
    }

    // Test interface
    public static void main(String[] args) {
        new GUI();
    }
}
