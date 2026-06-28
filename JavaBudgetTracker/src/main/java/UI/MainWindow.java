/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

/**
 *
 * @author Kent
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import Services.TransactionService;
import Services.ReportService;


 public class MainWindow extends JFrame {

    private JPanel contentPanel;
    
    private DashboardPanel dashboardPanel;
    private TransactionPanel transactionPanel;
    private BudgetPanel budgetPanel;
    private ReportPanel reportPanel;
    
    private TransactionService transactionService;
    private ReportService reportService;

    public MainWindow(
            TransactionService transactionService,
            ReportService reportService
    ) {

        this.transactionService = transactionService;
        this.reportService = reportService;

        setTitle("Java Budget Tracker");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializePanels();
        setupLayout();
    }

    private void setupLayout() {

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel menuPanel = createMenuPanel();

        contentPanel = new JPanel(new BorderLayout());

        showPanel(dashboardPanel);
        
        mainPanel.add(menuPanel, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    private JPanel createMenuPanel() {

        JPanel menuPanel = new JPanel(new GridLayout(6, 1));

        JButton dashboardButton = new JButton("Dashboard");
        JButton transactionsButton = new JButton("Transactions");
        JButton budgetsButton = new JButton("Budgets");
        JButton reportsButton = new JButton("Reports");
        JButton saveButton = new JButton("Save");
        JButton exitButton = new JButton("Exit");

        dashboardButton.addActionListener(e -> showPanel(dashboardPanel));
        transactionsButton.addActionListener(e -> showPanel(transactionPanel));
        budgetsButton.addActionListener(e -> showPanel(budgetPanel));
        reportsButton.addActionListener(e -> showPanel(reportPanel));
        
        saveButton.addActionListener(e -> System.out.println("Save feature coming soon."));
        exitButton.addActionListener(e -> System.exit(0));

        menuPanel.add(dashboardButton);
        menuPanel.add(transactionsButton);
        menuPanel.add(budgetsButton);
        menuPanel.add(reportsButton);
        menuPanel.add(saveButton);
        menuPanel.add(exitButton);

        return menuPanel;
    }

    private void showPanel(JPanel panel) {

        contentPanel.removeAll();
        contentPanel.add(panel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
    
    private void initializePanels() {

    dashboardPanel = new DashboardPanel(reportService);
    transactionPanel = new TransactionPanel(transactionService);
    budgetPanel = new BudgetPanel();
    reportPanel = new ReportPanel();
}
}