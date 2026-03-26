package com.passwordgen.ui;

import com.passwordgen.core.PasswordGenerator;
import com.passwordgen.policy.BasicPasswordPolicy;
import com.passwordgen.policy.StrongPasswordPolicy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI extends JFrame {
    private JTextField lengthField;
    private JCheckBox upperCheck, lowerCheck, numCheck, symCheck;
    private JRadioButton basicRadio, strongRadio;
    private JTextField resultField;
    private PasswordGenerator generator;

    public MainUI() {
        setTitle("Secure Random Password Generator");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen
        setLayout(new GridLayout(8, 1, 5, 5));

        // Initialize default generator
        generator = new PasswordGenerator(new StrongPasswordPolicy());

        // UI Components
        JPanel lengthPanel = new JPanel();
        lengthPanel.add(new JLabel("Password Length: "));
        lengthField = new JTextField("12", 5);
        lengthPanel.add(lengthField);
        add(lengthPanel);

        upperCheck = new JCheckBox("Include Uppercase", true);
        lowerCheck = new JCheckBox("Include Lowercase", true);
        numCheck = new JCheckBox("Include Numbers", true);
        symCheck = new JCheckBox("Include Symbols", true);
        
        JPanel checkPanel1 = new JPanel();
        checkPanel1.add(upperCheck);
        checkPanel1.add(lowerCheck);
        add(checkPanel1);
        
        JPanel checkPanel2 = new JPanel();
        checkPanel2.add(numCheck);
        checkPanel2.add(symCheck);
        add(checkPanel2);

        basicRadio = new JRadioButton("Basic Policy");
        strongRadio = new JRadioButton("Strong Policy (Guarantees all types)", true);
        ButtonGroup policyGroup = new ButtonGroup();
        policyGroup.add(basicRadio);
        policyGroup.add(strongRadio);
        
        JPanel radioPanel = new JPanel();
        radioPanel.add(basicRadio);
        radioPanel.add(strongRadio);
        add(radioPanel);

        JButton generateBtn = new JButton("Generate Password");
        add(generateBtn);

        resultField = new JTextField();
        resultField.setEditable(false);
        resultField.setHorizontalAlignment(JTextField.CENTER);
        resultField.setFont(new Font("Monospaced", Font.BOLD, 16));
        add(resultField);

        // Event Listener (Exception Handling implemented here)
        generateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int length = Integer.parseInt(lengthField.getText());
                    
                    if (basicRadio.isSelected()) {
                        generator.setPolicy(new BasicPasswordPolicy());
                    } else {
                        generator.setPolicy(new StrongPasswordPolicy());
                    }

                    String pwd = generator.generate(length, upperCheck.isSelected(), lowerCheck.isSelected(), numCheck.isSelected(), symCheck.isSelected());
                    resultField.setText(pwd);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainUI.this, "Please enter a valid number for length.", "Input Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(MainUI.this, ex.getMessage(), "Configuration Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        // Run UI on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }
}