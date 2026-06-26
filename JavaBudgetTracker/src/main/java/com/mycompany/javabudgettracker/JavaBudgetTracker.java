/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javabudgettracker;

/**
 *
 * @author Kent
 */
// IMPORTS
// Swing utilities
// service imports
// UI imports
import Enums.TransactionType;
import Models.BudgetModel;
import Models.TransactionModel;
import Services.ReportService;
import Services.TransactionService;
import Storage.FileManager;
import UI.MainWindow;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

// TO DO:
// Packages / Classes
// Model / Transaction, Budget
// Storage / File, Data
// UI / Main, Transaction, Report, Menu, Summary
// Utils / Currency convert, Date, Validation

public class JavaBudgetTracker {
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                TransactionService transactionService = new TransactionService();
                ReportService reportService = new ReportService(transactionService);

                MainWindow window = new MainWindow(
                        transactionService,
                        reportService
                );

                window.setVisible(true);
            }
        });
    }
    
    // main():
    //     initialize
    //     initialize storage
    //     load saved data
    //     launch Swing UI

    // function: initialize
    // create:
    //     transaction service
    //     budget service
    //     reporting service
    //     file manager

    // function: loadApplicationData()
    // load transactions from storage
    // populate services

    // function: launchUI()
    // create main application window
    // set look and feel
    // configure window behavior
    // display GUI

    // function: shutdown()
    // save data
    // release resources
    // close application


    // FUTURE IMPROVEMENTS
    // database backend
    // charts/graphs
    // cloud sync
    // user accounts
    // encryption/security
}
