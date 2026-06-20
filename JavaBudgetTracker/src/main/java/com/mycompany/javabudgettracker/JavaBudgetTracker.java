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

// TO DO:
// Packages / Classes
// Model / Transaction, Budget
// Storage / File, Data
// UI / Main, Transaction, Report, Menu, Summary
// Utils / Currency convert, Date, Validation

public class JavaBudgetTracker {
    
    public static void main(String[] args) {

    // INTEGRATION TESTING
    // TEST 1: create services
    // - create TransactionService
    // - create ReportService using TransactionService
    // - create FileManager

    TransactionService transactionService =
            new TransactionService();

    ReportService reportService =
            new ReportService(transactionService);

    FileManager fileManager =
            new FileManager();

    fileManager.ensureDataFilesExist();


    // TEST 2: create sample transactions
    // - create income transaction
    // - create expense transaction
    // - create another expense transaction
    // - add all transactions to TransactionService
    TransactionModel income =
            new TransactionModel(
                    1,
                    1500.00,
                    "Paycheck",
                    "Biweekly paycheck",
                    LocalDate.of(2026, 5, 1),
                    TransactionType.INCOME
            );

    TransactionModel groceries =
            new TransactionModel(
                    2,
                    75.50,
                    "Food",
                    "Groceries",
                    LocalDate.of(2026, 5, 2),
                    TransactionType.EXPENSE
            );

    TransactionModel rent =
            new TransactionModel(
                    3,
                    850.00,
                    "Rent",
                    "Monthly rent",
                    LocalDate.of(2026, 5, 3),
                    TransactionType.EXPENSE
            );

    transactionService.addTransaction(income);
    transactionService.addTransaction(groceries);
    transactionService.addTransaction(rent);


    // TEST 3: verify transaction service
    // - print all transactions
    // - find transaction by id
    // - remove transaction by id
    // - print remaining transactions

    System.out.println("\n=== TRANSACTIONS ===");

    for (TransactionModel transaction :
            transactionService.getTransactions()) {

        System.out.println(transaction);
    }

    System.out.println(
            "\nFound Transaction:"
    );

    System.out.println(
            transactionService.findTransactionById(2)
    );

    transactionService.removeTransactionById(2);

    System.out.println(
            "\nAfter Removing ID 2:"
    );

    for (TransactionModel transaction :
            transactionService.getTransactions()) {

        System.out.println(transaction);
    }


    // TEST 4: verify report service
    // - print total income
    // - print total expenses
    // - print balance
    // - print category summary
    // - print highest expense
    // - print average expense
    // - print transaction count

    System.out.println("\n=== REPORTS ===");

    System.out.println(
            "Income: "
            + reportService.generateIncomeReport()
    );

    System.out.println(
            "Expenses: "
            + reportService.generateExpenseReport()
    );

    System.out.println(
            "Balance: "
            + reportService.generateBalanceReport()
    );

    System.out.println(
            "Highest Expense: "
            + reportService.getHighestExpenseTransaction()
    );

    System.out.println(
            "Average Expense: "
            + reportService.getAverageExpense()
    );

    System.out.println(
            "Transaction Count: "
            + reportService.getTotalTransactionCount()
    );

    System.out.println(
            reportService.generateCategorySummary()
    );


    // TEST 5: verify transaction file saving/loading
    // - call FileManager.ensureDataFilesExist()
    // - save transactions to file
    // - load transactions from file into a new ArrayList
    // - print loaded transactions

    fileManager.saveTransactions(
            transactionService.getTransactions()
    );

    ArrayList<TransactionModel> loadedTransactions =
            fileManager.loadTransactions();

    System.out.println(
            "\n=== LOADED TRANSACTIONS ==="
    );

    for (TransactionModel transaction :
            loadedTransactions) {

        System.out.println(transaction);
    }


    // TEST 6: create sample budgets
    // - create BudgetModel objects
    // - call addSpending()
    // - print remaining amount
    // - print percent used
    // - print over-budget status

    BudgetModel foodBudget =
            new BudgetModel(
                    1,
                    "Food Budget",
                    "Food",
                    300,
                    0,
                    LocalDate.of(2026, 5, 1),
                    LocalDate.of(2026, 5, 31)
            );

    foodBudget.addSpending(150);

    System.out.println("\n=== BUDGET ===");

    System.out.println(foodBudget);

    System.out.println(
            "Remaining: "
            + foodBudget.getRemainingAmount()
    );

    System.out.println(
            "Percent Used: "
            + foodBudget.getPercentUsed()
    );

    System.out.println(
            "Over Budget: "
            + foodBudget.isOverBudget()
    );


    // TEST 7: verify budget file saving/loading
    // - save budgets to file
    // - load budgets from file into a new ArrayList
    // - print loaded budgets

    ArrayList<BudgetModel> budgets =
            new ArrayList<>();

    budgets.add(foodBudget);

    fileManager.saveBudgets(budgets);

    ArrayList<BudgetModel> loadedBudgets =
            fileManager.loadBudgets();

    System.out.println(
            "\n=== LOADED BUDGETS ==="
    );

    for (BudgetModel budget :
            loadedBudgets) {

        System.out.println(budget);
    }


    // TEST 8: cleanup / final result
    // - confirm no crashes
    // - confirm output looks correct
    // - confirm transactions.txt and budgets.txt are created

    System.out.println(
            "\n=== BACKEND TEST COMPLETE ==="
    );

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
