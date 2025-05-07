package app;

import javax.management.monitor.MonitorSettingException;
import javax.swing.*;
import java.awt.*;
import java.util.jar.JarEntry;

public class GUI {
    private JFrame window;
    private JTextField nameField;
    private JTextField lifeField;
    private JButton createButton;
    private JButton applyButton;
    private JLabel statusLabel;
    private JButton removeButton;
    private JTextField amountField;
    private DefaultListModel<Monster> monsterListModel;
    private JList<Monster> monsterListView;

    public GUI() {
        configWindow();             // Define window size, title, close operation, etc
        initComponents();           // Create and configure all buttons, fields, etc.
        setupLayout();              // Define the layout of components
        addListeners();
    }

    private void configWindow() {
        window = new JFrame();
        window.setTitle("Monster Tracker RPG");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(420,420);
        window.setResizable(false);
    }

    private void initComponents() {
        nameField = new JTextField(10);
        lifeField = new JTextField(5);
        amountField = new JTextField(5);

        createButton = new JButton("Create monster");
        applyButton = new JButton("Apply");
        removeButton = new JButton("Remove");
        statusLabel = new JLabel(" ");

        applyButton.setEnabled(false);
        removeButton.setEnabled(false);
        //amountField.setEnabled(false);

        monsterListModel = new DefaultListModel<>();
        monsterListView = new JList<>(monsterListModel);
        monsterListView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        monsterListView.setVisibleRowCount(8);
        // change ScrollPanel list information
        monsterListView.setCellRenderer(new ListCellRenderer<Monster>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Monster> list, Monster value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = new JLabel(value.getName() + " - Life: " + value.getLife());
                if (isSelected) {
                    label.setOpaque(true);
                    label.setBackground(list.getSelectionBackground());
                    label.setForeground(list.getSelectionForeground());
                }
                return label;
            }
        });
    }

    private void setupLayout() {
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

        // control panel -> to apply damage and heal
        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Value:"));
        controlPanel.add(amountField);
        controlPanel.add(applyButton);
        controlPanel.add(removeButton);

        // monster list
        JScrollPane listScrollPane = new JScrollPane(monsterListView);

        // status label
        JPanel statusPanel = new JPanel();
        statusPanel.add(statusLabel);

        // add everything to the main panel
        mainPanel.add(createPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(listScrollPane);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(controlPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(statusPanel);

        // add main panel to window
        window.setContentPane(mainPanel);
        window.setVisible(true);
    }

    private void addListeners() {
        createButton.addActionListener(e -> {
            String nameText = nameField.getText().trim();
            String lifeText = lifeField.getText().trim();

            if (nameText.isEmpty() || lifeText.isBlank()) {
                JOptionPane.showMessageDialog(window, "Preencha o nome a vida!");
                return;
            }

            try {
                int life = Integer.parseInt(lifeText);
                if (life <= 0) throw new NumberFormatException();

                Monster newMonster = new Monster(nameText, life);
                monsterListModel.addElement(newMonster);

                // clean the fields
                nameField.setText("");
                lifeField.setText("");
                statusLabel.setText("Monster created: " + newMonster.getName());

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(window, "Life should be a integer number!");
            }
        });

        monsterListView.addListSelectionListener(e -> {
            boolean selected = monsterListView.getSelectedIndex() != -1;
            applyButton.setEnabled(selected);
            removeButton.setEnabled(selected);
        });

        applyButton.addActionListener(e -> {
            Monster selected = monsterListView.getSelectedValue();
            if (selected == null) return;

            try {
                int amount = Integer.parseInt(amountField.getText().trim());
                selected.changeLife(amount);
                monsterListView.repaint();
                amountField.setText("");
                monsterListView.clearSelection();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(window, "Enter an integer (positive or negative)");
            }
        });

        removeButton.addActionListener(e -> {
            int index = monsterListView.getSelectedIndex();
            if (index != -1) {
                Monster removed = monsterListModel.remove(index);
                statusLabel.setText("Monster removed: " + removed.getName());
            }
        });
    }

    // Test interface
    public static void main(String[] args) {
        new GUI();
    }
}