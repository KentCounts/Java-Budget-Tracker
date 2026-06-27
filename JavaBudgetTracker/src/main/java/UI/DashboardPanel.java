package UI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kent
 */
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import Services.ReportService;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class DashboardPanel extends JPanel {
    
    private ReportService reportService;

    public DashboardPanel(ReportService reportService) {
        this.reportService = reportService;
        setLayout(new BorderLayout());
        setupDashboard();
    }
    
    private void setupDashboard() {

    JPanel dashboardPanel = new JPanel(new GridLayout(5, 1));

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
            "Transaction Count: " + reportService.getTotalTransactionCount(),
            SwingConstants.CENTER
    );

    JButton refreshButton = new JButton("Refresh Dashboard");

    refreshButton.addActionListener(e -> {
        removeAll();
        setupDashboard();
        revalidate();
        repaint();
    });

    dashboardPanel.add(incomeLabel);
    dashboardPanel.add(expenseLabel);
    dashboardPanel.add(balanceLabel);
    dashboardPanel.add(transactionCountLabel);
    dashboardPanel.add(refreshButton);

    add(dashboardPanel, BorderLayout.CENTER);
}
}
