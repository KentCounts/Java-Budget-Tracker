/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

/**
 *
 * @author Kent
 */
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

import Services.BudgetService;
import Storage.FileManager;

public class BudgetPanel extends JPanel {
    
    private BudgetService budgetService;
    private FileManager fileManager;

    public BudgetPanel(
        BudgetService budgetService,
        FileManager fileManager
    ) 
    {
        
        this.budgetService = budgetService;
        this.fileManager = fileManager;

        setLayout(new BorderLayout());

        JLabel label = new JLabel(
                "Budgets",
                SwingConstants.CENTER
        );

        add(label, BorderLayout.CENTER);
    }
}
