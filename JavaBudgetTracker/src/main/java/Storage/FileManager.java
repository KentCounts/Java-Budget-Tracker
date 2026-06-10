/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Storage;

/**
 *
 * @author Kent
 */

// IMPORTS
// model imports
import Models.BudgetModel;
import Models.TransactionModel;
// collections
import java.util.ArrayList;
// file reading/writing
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
// date parsing
import java.time.LocalDate;
// enums
import Enums.TransactionType;

public class FileManager {

    // FIELDS
    // transaction data file path
    private String transactionFilePath;
    // budget data file path
    private String budgetFilePath;
    // delimiter for saved data
    // example: "," or "|"
    private final String DELIMITER = "|";

    // CONSTRUCTORS
    // default constructor
    // set default file paths
    public FileManager() {

        transactionFilePath = "transactions.txt";

        budgetFilePath = "budgets.txt";
    }

    // constructor with custom file paths
    public FileManager(
            String transactionFilePath,
            String budgetFilePath
    ) {

        this.transactionFilePath = transactionFilePath;

        this.budgetFilePath = budgetFilePath;
    }

    // TRANSACTION STORAGE
    // function: saveTransactions(transactions)
    // open transaction file
    // loop through transaction list
    // convert each transaction to file-safe string
    // write each transaction line to file
    // close file
    // function: loadTransactions()
    // open transaction file
    // read each line
    // convert each line into TransactionModel object
    // add transaction to list
    // return transaction list
    // function: transactionToFileLine(transaction)
    // convert transaction object into delimited text
    // example:
    // id|amount|category|description|date|type
    // function: fileLineToTransaction(line)
    // split line by delimiter
    // parse values
    // create TransactionModel
    // return TransactionModel

    // BUDGET STORAGE
    // function: saveBudgets(budgets)
    // open budget file
    // loop through budget list
    // convert each budget to file-safe string
    // write each budget line to file
    // close file
    // function: loadBudgets()
    // open budget file
    // read each line
    // convert each line into BudgetModel object
    // add budget to list
    // return budget list
    // function: budgetToFileLine(budget)
    // convert budget object into delimited text
    // example:
    // id|name|category|limitAmount|spentAmount|startDate|endDate
    // function: fileLineToBudget(line)
    // split line by delimiter
    // parse values
    // create BudgetModel
    // return BudgetModel

    // FILE UTILITIES
    // function: ensureDataFilesExist()
    // create data files if they do not exist
    // function: clearTransactionFile()
    // erase all transaction data
    // function: clearBudgetFile()
    // erase all budget data

    // FUTURE IMPROVEMENTS
    // CSV support
    // JSON support
    // database storage
    // encrypted storage
    // automatic backups
    // iport/export tools
}