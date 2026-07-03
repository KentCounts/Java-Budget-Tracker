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
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;

public class TransactionPanel extends JPanel {

    private TransactionService transactionService;

    private JTextField amountField;
    private JTextField categoryField;
    private JTextField descriptionField;
    private JTextField dateField;
    private JComboBox<TransactionType> typeBox;
    private JTable transactionTable;
    private DefaultTableModel tableModel;
    
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

        JButton addButton = new JButton("Add Transaction");
        JButton deleteButton = new JButton("Delete Transaction");
        JButton clearButton = new JButton("Clear Transactions");

        addButton.addActionListener(e -> addTransaction());
        deleteButton.addActionListener(e -> deleteTransaction());
        clearButton.addActionListener(e -> clearTransactions());

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

        formPanel.add(new JLabel(""));
        formPanel.add(deleteButton);
        
        formPanel.add(new JLabel(""));
    formPanel.add(clearButton);

        add(formPanel, BorderLayout.NORTH);
    }

    private void setupDisplay() {

        String[] columns = {
                "ID",
                "Amount",
                "Category",
                "Description",
                "Date",
                "Type"
        };

        tableModel = new DefaultTableModel(columns, 0);

        transactionTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(transactionTable);

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

        int selectedRow = transactionTable.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a transaction to delete.",
                    "Delete Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        int id = (int) tableModel.getValueAt(selectedRow, 0);

        boolean removed = transactionService.removeTransactionById(id);

        if (removed) {

            refreshTransactionDisplay();

            JOptionPane.showMessageDialog(
                    this,
                    "Transaction deleted successfully."
            );
        }
    }
    
    private void clearTransactions() {

    int result = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to delete all transactions?",
            "Confirm Clear",
            JOptionPane.YES_NO_OPTION
    );

    if (result == JOptionPane.YES_OPTION) {

        transactionService.clearTransactions();

        refreshTransactionDisplay();

        JOptionPane.showMessageDialog(
                this,
                "All transactions cleared."
        );
    }
}
    
    private void refreshTransactionDisplay() {

       tableModel.setRowCount(0);

       for (TransactionModel transaction : transactionService.getTransactions()) {

           Object[] row = {
                   transaction.getId(),
                   transaction.getAmount(),
                   transaction.getCategory(),
                   transaction.getDescription(),
                   transaction.getDate(),
                   transaction.getType()
           };

           tableModel.addRow(row);
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