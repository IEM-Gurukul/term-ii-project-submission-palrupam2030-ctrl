package com.passwordgen.ui;

import com.passwordgen.core.CharacterPool;
import com.passwordgen.core.Generator;
import com.passwordgen.core.PasswordGenerator;
import com.passwordgen.core.SecurePasswordGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class MainUI extends JFrame {

    private JTextField lengthField;
    private JTextField outputField;
    private JCheckBox uppercaseCheck;
    private JCheckBox lowercaseCheck;
    private JCheckBox numbersCheck;
    private JCheckBox symbolsCheck;
    private JCheckBox secureModeCheck;
    private JButton generateButton;
    private JButton copyButton;

    public MainUI() {
        setTitle("Random Password Generator");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(9, 1, 10, 10));

        JLabel titleLabel = new JLabel("Random Password Generator", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel);

        JPanel lengthPanel = new JPanel();
        lengthPanel.add(new JLabel("Password Length:"));
        lengthField = new JTextField(10);
        lengthPanel.add(lengthField);
        add(lengthPanel);

        uppercaseCheck = new JCheckBox("Include Uppercase", true);
        lowercaseCheck = new JCheckBox("Include Lowercase", true);
        numbersCheck = new JCheckBox("Include Numbers", true);
        symbolsCheck = new JCheckBox("Include Symbols", false);
        secureModeCheck = new JCheckBox("Use Secure Mode", true);

        add(uppercaseCheck);
        add(lowercaseCheck);
        add(numbersCheck);
        add(symbolsCheck);
        add(secureModeCheck);

        JPanel outputPanel = new JPanel();
        outputPanel.add(new JLabel("Generated Password:"));
        outputField = new JTextField(20);
        outputField.setEditable(false);
        outputPanel.add(outputField);
        add(outputPanel);

        JPanel buttonPanel = new JPanel();
        generateButton = new JButton("Generate Password");
        copyButton = new JButton("Copy Password");
        buttonPanel.add(generateButton);
        buttonPanel.add(copyButton);
        add(buttonPanel);

        generateButton.addActionListener(e -> generatePassword());
        copyButton.addActionListener(e -> copyPassword());

        setVisible(true);
    }

    private void generatePassword() {
        try {
            int length = Integer.parseInt(lengthField.getText().trim());

            CharacterPool pool = new CharacterPool(
                    uppercaseCheck.isSelected(),
                    lowercaseCheck.isSelected(),
                    numbersCheck.isSelected(),
                    symbolsCheck.isSelected()
            );

            Generator generator;

            if (secureModeCheck.isSelected()) {
                generator = new SecurePasswordGenerator(pool);
            } else {
                generator = new PasswordGenerator(pool);
            }

            String password = generator.generatePassword(length);
            outputField.setText(password);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid numeric password length.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Unexpected error: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void copyPassword() {
        String password = outputField.getText();

        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No password to copy.",
                    "Copy Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringSelection selection = new StringSelection(password);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        JOptionPane.showMessageDialog(this,
                "Password copied to clipboard!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainUI::new);
    }
}