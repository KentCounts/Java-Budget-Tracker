/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

/**
 *
 * @author Kent
 */

import Enums.TransactionType;
import Models.TransactionModel;
import Services.TransactionService;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class TransactionPanel extends JPanel {

    private TransactionService transactionService;

    private JTextField amountField;
    private JTextField categoryField;
    private JTextField descriptionField;
    private JTextField dateField;
    private JTextField deleteIdField;
    private JComboBox<TransactionType> typeBox;
    private JTextArea transactionDisplay;

    public TransactionPanel(TransactionService transactionService) {

        this.transactionService = transactionService;

        setLayout(new BorderLayout());

        setupForm();
        setupDisplay();

        refreshTransactionDisplay();
    }

    private void setupForm() {

        JPanel formPanel = new JPanel(new GridLayout(8, 2));

        amountField = new JTextField();
        categoryField = new JTextField();
        descriptionField = new JTextField();
        dateField = new JTextField("2026-06-20");
        typeBox = new JComboBox<>(TransactionType.values());
        deleteIdField = new JTextField();

        JButton addButton = new JButton("Add Transaction");
        JButton deleteButton = new JButton("Delete Transaction");

        addButton.addActionListener(e -> addTransaction());
        deleteButton.addActionListener(e -> deleteTransaction());

        formPanel.add(new JLabel("Amount:"));
        formPanel.add(amountField);

        formPanel.add(new JLabel("Category:"));
        formPanel.add(categoryField);

        formPanel.add(new JLabel("Description:"));
        formPanel.add(descriptionField);

        formPanel.add(new JLabel("Date YYYY-MM-DD:"));
        formPanel.add(dateField);

        formPanel.add(new JLabel("Type:"));
        formPanel.add(typeBox);

        formPanel.add(new JLabel(""));
        formPanel.add(addButton);
        
        formPanel.add(new JLabel("Delete Transaction ID:"));
        formPanel.add(deleteIdField);

        formPanel.add(new JLabel(""));
        formPanel.add(deleteButton);

        add(formPanel, BorderLayout.NORTH);
    }

    private void setupDisplay() {

        transactionDisplay = new JTextArea();
        transactionDisplay.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(transactionDisplay);

        add(scrollPane, BorderLayout.CENTER);
    }

    private void addTransaction() {

        try {

            int id = transactionService.getTransactions().size() + 1;
            double amount = Double.parseDouble(amountField.getText());
            String category = categoryField.getText();
            String description = descriptionField.getText();
            LocalDate date = LocalDate.parse(dateField.getText());
            TransactionType type = (TransactionType) typeBox.getSelectedItem();

            TransactionModel transaction = new TransactionModel(
                    id,
                    amount,
                    category,
                    description,
                    date,
                    type
            );

            transactionService.addTransaction(transaction);

            clearFields();
            refreshTransactionDisplay();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid transaction input.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void deleteTransaction() {

    try {

        int id = Integer.parseInt(deleteIdField.getText());

        boolean removed = transactionService.removeTransactionById(id);

        if (removed) {

            JOptionPane.showMessageDialog(
                    this,
                    "Transaction deleted successfully."
            );

            deleteIdField.setText("");
            refreshTransactionDisplay();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Transaction ID not found.",
                    "Delete Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
                this,
                "Please enter a valid transaction ID.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
    private void refreshTransactionDisplay() {

        transactionDisplay.setText("");

        for (TransactionModel transaction : transactionService.getTransactions()) {

            transactionDisplay.append(transaction.toString() + "\n");
        }
    }

    private void clearFields() {

        amountField.setText("");
        categoryField.setText("");
        descriptionField.setText("");
        dateField.setText("2026-06-20");
        typeBox.setSelectedIndex(0);
    }
}