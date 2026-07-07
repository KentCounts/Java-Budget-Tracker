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
import Services.BudgetService;


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

        SwingUtilities.invokeLater(() -> {

            FileManager fileManager = new FileManager();

            fileManager.ensureDataFilesExist();

            TransactionService transactionService = new TransactionService();
            
            BudgetService budgetService = new BudgetService();

            ArrayList<TransactionModel> loadedTransactions =
                    fileManager.loadTransactions();

            for (TransactionModel transaction : loadedTransactions) {

                transactionService.addTransaction(transaction);
            }
            
            ArrayList<BudgetModel> loadedBudgets =
                    fileManager.loadBudgets();

            for (BudgetModel budget : loadedBudgets) {

                budgetService.addBudget(budget);
            }

            ReportService reportService =
                    new ReportService(transactionService);

            MainWindow window =
                    new MainWindow(
                            transactionService,
                            reportService,
                            budgetService,
                            fileManager
                    );

            window.setVisible(true);
        });
    }
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
