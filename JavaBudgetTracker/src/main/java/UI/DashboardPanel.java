
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

public class DashboardPanel extends JPanel {

    private ReportService reportService;
    private BudgetService budgetService;

    private JPanel dashboardPanel;

    public DashboardPanel(
            ReportService reportService,
            BudgetService budgetService
    ) {

        this.reportService = reportService;
        this.budgetService = budgetService;

        setLayout(new BorderLayout());

        setupDashboard();
    }


    private void setupDashboard() {

        dashboardPanel = new JPanel(new GridLayout(0, 1));


        // FINANCIAL SUMMARY
        JLabel titleLabel = new JLabel(
                "Financial Summary",
                SwingConstants.CENTER
        );

        JLabel incomeLabel = new JLabel(
                "Total Income: $" + reportService.generateIncomeReport(),
                SwingConstants.CENTER
        );

        JLabel expenseLabel = new JLabel(
                "Total Expenses: $" + reportService.generateExpenseReport(),
                SwingConstants.CENTER
        );

        JLabel balanceLabel = new JLabel(
                "Balance: $" + reportService.generateBalanceReport(),
                SwingConstants.CENTER
        );

        JLabel transactionCountLabel = new JLabel(
                "Transaction Count: "
                + reportService.getTotalTransactionCount(),
                SwingConstants.CENTER
        );


        // BUDGET SUMMARY
        JLabel budgetTitleLabel = new JLabel(
                "Budget Summary",
                SwingConstants.CENTER
        );

        JLabel totalBudgetLabel = new JLabel(
                "Total Budget Limit: $"
                + budgetService.getTotalBudgetLimit(),
                SwingConstants.CENTER
        );

        JLabel totalSpentLabel = new JLabel(
                "Total Budget Spent: $"
                + budgetService.getTotalSpentAmount(),
                SwingConstants.CENTER
        );

        JLabel remainingBudgetLabel = new JLabel(
                "Remaining Budget: $"
                + budgetService.getTotalRemainingBudget(),
                SwingConstants.CENTER
        );


        // BUDGET WARNINGS
        JLabel warningLabel = new JLabel(
                createBudgetWarnings(),
                SwingConstants.CENTER
        );


        // REFRESH BUTTON
        JButton refreshButton = new JButton(
                "Refresh Dashboard"
        );

        refreshButton.addActionListener(e -> {

            removeAll();

            setupDashboard();

            revalidate();
            repaint();
        });


        // ADD COMPONENTS
        dashboardPanel.add(titleLabel);

        dashboardPanel.add(incomeLabel);
        dashboardPanel.add(expenseLabel);
        dashboardPanel.add(balanceLabel);
        dashboardPanel.add(transactionCountLabel);


        dashboardPanel.add(budgetTitleLabel);

        dashboardPanel.add(totalBudgetLabel);
        dashboardPanel.add(totalSpentLabel);
        dashboardPanel.add(remainingBudgetLabel);

        dashboardPanel.add(warningLabel);

        dashboardPanel.add(refreshButton);


        add(dashboardPanel, BorderLayout.CENTER);
    }


    private String createBudgetWarnings() {

        String warnings = "Budget Status: ";

        if (budgetService.getOverBudgetBudgets().isEmpty()) {

            warnings += "All budgets within limits.";

        } else {

            warnings += "Over budget: ";

            for (BudgetModel budget :
                    budgetService.getOverBudgetBudgets()) {

                warnings += budget.getName() + " ";
            }
        }

        return warnings;
    }
}