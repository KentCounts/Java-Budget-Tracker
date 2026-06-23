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

public class BudgetPanel extends JPanel {

    public BudgetPanel() {

        setLayout(new BorderLayout());

        JLabel label = new JLabel(
                "Budgets",
                SwingConstants.CENTER
        );

        add(label, BorderLayout.CENTER);
    }
}
