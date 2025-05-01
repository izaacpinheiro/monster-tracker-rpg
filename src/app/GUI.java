package app;

import javax.swing.*;
import java.util.jar.JarEntry;

public class GUI {
    private JFrame window;
    private JTextField nameField; // field é o campo onde vai ser digitado
    private JTextField lifeField;
    private JButton createButton;
    private JButton applyDamageButton;
    private JButton healButton;
    private JTextField amountField;
    // private JLabel statusLabel;
    private DefaultListModel<Monster> monsterListModel;
    private JList<Monster> monsterListView;

    public GUI() {
        configWindow();             // Define window size, title, close operation, etc
        initComponents();           // Create and configure all buttons, fields, etc.
        setupLayout();              // Define the layout of components
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
        amountField = new JTextField(3);

        createButton = new JButton("Create monster");
        applyDamageButton = new JButton("+");
        healButton = new JButton("-");

        healButton.setEnabled(false);
        applyDamageButton.setEnabled(false);
        amountField.setEnabled(false);

        monsterListModel = new DefaultListModel<>();
        monsterListView = new JList<>(monsterListModel);
        monsterListView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void setupLayout() {
        // Add components to the panel and position them with LayoutManager
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // row create monster
        JPanel createPanel = new JPanel();
        createPanel.add(new JLabel("Name:"));
        createPanel.add(nameField);
        createPanel.add(new JLabel("Life:"));
        createPanel.add(lifeField);
        createPanel.add(createButton);

        // row apply damage (provavelmente não vou usar mas vou deixar aqui por enquanto)
        //JPanel damagePanel = new JPanel();
        //damagePanel.add(new JLabel("Damage/Heal:"));
        //damagePanel.add(damageField);
        //damagePanel.add(applyDamageButton);

        // control panel -> to apply damage and heal
        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Valor:"));
        controlPanel.add(amountField);
        controlPanel.add(applyDamageButton);
        controlPanel.add(healButton);

        // monster list
        JScrollPane listScrollPane = new JScrollPane(monsterListView);

        // add everything to the main panel
        mainPanel.add(createPanel);
        mainPanel.add(Box.createVerticalStrut(10)); // space
        mainPanel.add(new JLabel("Monsters:"));
        mainPanel.add(listScrollPane);
        mainPanel.add(controlPanel);

        // add main panel to window
        window.add(mainPanel);
    }

    private void addListeners() {
        // Define what happens when creating a monster, applying damage, etc.
    }

    // Test interface
    public static void main(String[] args) {
        new GUI();
    }
}
