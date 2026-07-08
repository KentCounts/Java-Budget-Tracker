/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

/**
 *
 * @author Kent
 */

import Models.BudgetModel;
import Services.BudgetService;
import Storage.FileManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;

public class BudgetPanel extends JPanel {

    private BudgetService budgetService;
    private FileManager fileManager;

    private JTextField nameField;
    private JTextField categoryField;
    private JTextField limitAmountField;
    private JTextField spentAmountField;
    private JTextField startDateField;
    private JTextField endDateField;

    private JTable budgetTable;
    private DefaultTableModel tableModel;

    public BudgetPanel(
            BudgetService budgetService,
            FileManager fileManager
    ) {

        this.budgetService = budgetService;
        this.fileManager = fileManager;

        setLayout(new BorderLayout());

        setupForm();
        setupDisplay();

        refreshBudgetDisplay();
    }

    private void setupForm() {

        JPanel formPanel = new JPanel(new GridLayout(9, 2));

        nameField = new JTextField();
        categoryField = new JTextField();
        limitAmountField = new JTextField();
        spentAmountField = new JTextField("0");
        startDateField = new JTextField("2026-06-20");
        endDateField = new JTextField("2026-06-30");

        JButton addButton = new JButton("Add Budget");
        JButton deleteButton = new JButton("Delete Budget");
        JButton clearButton = new JButton("Clear Budgets");

        addButton.addActionListener(e -> addBudget());
        deleteButton.addActionListener(e -> deleteBudget());
        clearButton.addActionListener(e -> clearBudgets());

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Category:"));
        formPanel.add(categoryField);

        formPanel.add(new JLabel("Limit Amount:"));
        formPanel.add(limitAmountField);

        formPanel.add(new JLabel("Spent Amount:"));
        formPanel.add(spentAmountField);

        formPanel.add(new JLabel("Start Date YYYY-MM-DD:"));
        formPanel.add(startDateField);

        formPanel.add(new JLabel("End Date YYYY-MM-DD:"));
        formPanel.add(endDateField);

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
                "Name",
                "Category",
                "Limit",
                "Spent",
                "Remaining",
                "Percent Used",
                "Start Date",
                "End Date"
        };

        tableModel = new DefaultTableModel(columns, 0);

        budgetTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(budgetTable);

        add(scrollPane, BorderLayout.CENTER);
    }

    private void addBudget() {

        try {

            int id = budgetService.getBudgets().size() + 1;
            String name = nameField.getText();
            String category = categoryField.getText();
            double limitAmount = Double.parseDouble(limitAmountField.getText());
            double spentAmount = Double.parseDouble(spentAmountField.getText());
            LocalDate startDate = LocalDate.parse(startDateField.getText());
            LocalDate endDate = LocalDate.parse(endDateField.getText());

            BudgetModel budget = new BudgetModel(
                    id,
                    name,
                    category,
                    limitAmount,
                    spentAmount,
                    startDate,
                    endDate
            );

            budgetService.addBudget(budget);

            clearFields();
            refreshBudgetDisplay();
            saveBudgets();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid budget input.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void deleteBudget() {

        int selectedRow = budgetTable.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a budget to delete.",
                    "Delete Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        int id = (int) tableModel.getValueAt(selectedRow, 0);

        boolean removed = budgetService.removeBudgetById(id);

        if (removed) {

            refreshBudgetDisplay();
            saveBudgets();

            JOptionPane.showMessageDialog(
                    this,
                    "Budget deleted successfully."
            );
        }
    }

    private void clearBudgets() {

        int result = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete all budgets?",
                "Confirm Clear",
                JOptionPane.YES_NO_OPTION
        );

        if (result == JOptionPane.YES_OPTION) {

            budgetService.clearBudgets();

            refreshBudgetDisplay();
            saveBudgets();

            JOptionPane.showMessageDialog(
                    this,
                    "All budgets cleared."
            );
        }
    }

    private void refreshBudgetDisplay() {

        tableModel.setRowCount(0);

        for (BudgetModel budget : budgetService.getBudgets()) {

            Object[] row = {
                    budget.getId(),
                    budget.getName(),
                    budget.getCategory(),
                    budget.getLimitAmount(),
                    budget.getSpentAmount(),
                    budget.getRemainingAmount(),
                    budget.getPercentUsed(),
                    budget.getStartDate(),
                    budget.getEndDate()
            };

            tableModel.addRow(row);
        }
    }

    private void clearFields() {

        nameField.setText("");
        categoryField.setText("");
        limitAmountField.setText("");
        spentAmountField.setText("0");
        startDateField.setText("2026-06-20");
        endDateField.setText("2026-06-30");
    }

    private void saveBudgets() {

        fileManager.saveBudgets(
                budgetService.getBudgets()
        );
    }
}