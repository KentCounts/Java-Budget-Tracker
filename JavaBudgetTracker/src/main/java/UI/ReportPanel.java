/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kent
 */
package UI;

import Services.ReportService;
import Services.BudgetService;
import Models.BudgetModel;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ReportPanel extends JPanel {

    private ReportService reportService;
    private BudgetService budgetService;

    private JTextArea reportArea;


    public ReportPanel(
            ReportService reportService,
            BudgetService budgetService
    ) {

        this.reportService = reportService;
        this.budgetService = budgetService;

        setLayout(new BorderLayout());

        setupDisplay();
        generateReport();
    }


    private void setupDisplay() {

        reportArea = new JTextArea();

        reportArea.setEditable(false);

        reportArea.setFont(
                new Font("Monospaced", Font.PLAIN, 14)
        );


        JScrollPane scrollPane =
                new JScrollPane(reportArea);


        JButton refreshButton =
                new JButton("Refresh Reports");


        refreshButton.addActionListener(e -> {

            generateReport();

        });


        add(scrollPane, BorderLayout.CENTER);

        add(refreshButton, BorderLayout.SOUTH);
    }


    private void generateReport() {

        StringBuilder report =
                new StringBuilder();


        // FINANCIAL SUMMARY
        report.append("FINANCIAL SUMMARY\n");
        report.append("==============================\n");

        report.append(
                "Total Income: $"
                + reportService.generateIncomeReport()
                + "\n"
        );

        report.append(
                "Total Expenses: $"
                + reportService.generateExpenseReport()
                + "\n"
        );

        report.append(
                "Balance: $"
                + reportService.generateBalanceReport()
                + "\n\n"
        );


        // STATISTICS
        report.append("STATISTICS\n");
        report.append("==============================\n");

        report.append(
                "Highest Expense: "
                + reportService.getHighestExpense()
                + "\n"
        );

        report.append(
                "Highest Income: "
                + reportService.getHighestIncome()
                + "\n"
        );

        report.append(
                "Average Expense: $"
                + reportService.getAverageExpense()
                + "\n"
        );

        report.append(
                "Average Income: $"
                + reportService.getAverageIncome()
                + "\n"
        );

        report.append(
                "Transaction Count: "
                + reportService.getTotalTransactionCount()
                + "\n\n"
        );


        // CATEGORY SUMMARY
        report.append("CATEGORY SUMMARY\n");
        report.append("==============================\n");


        Map<String, Double> categories =
                reportService.generateCategorySummary();


        for (String category : categories.keySet()) {

            report.append(
                    category
                    + ": $"
                    + categories.get(category)
                    + "\n"
            );
        }


        report.append("\n");


        // BUDGET SUMMARY
        report.append("BUDGET SUMMARY\n");
        report.append("==============================\n");


        for (BudgetModel budget :
                budgetService.getBudgets()) {


            report.append(
                    budget.getName()
                    + " - "
                    + budget.getPercentUsed()
                    + "% used"
                    + "\n"
            );
        }


        reportArea.setText(
                report.toString()
        );
    }
}