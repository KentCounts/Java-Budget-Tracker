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
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class MainWindow extends JFrame {

    public MainWindow() {

        setTitle("Java Budget Tracker");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel placeholderLabel = new JLabel(
                "Java Budget Tracker - GUI Shell",
                SwingConstants.CENTER
        );

        mainPanel.add(placeholderLabel, BorderLayout.CENTER);

        add(mainPanel);
    }
}
