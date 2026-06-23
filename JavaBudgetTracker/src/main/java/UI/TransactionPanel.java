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

public class TransactionPanel extends JPanel {

    public TransactionPanel() {

        setLayout(new BorderLayout());

        JLabel label = new JLabel(
                "Transactions",
                SwingConstants.CENTER
        );

        add(label, BorderLayout.CENTER);
    }
}