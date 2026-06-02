/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

/**
 *
 * @author Kent
 */

// IMPORTS

import Models.TransactionModel;
import java.util.ArrayList;


public class TransactionService {

    // FIELDS
    // list of all transactions
    private ArrayList<TransactionModel> transactions;

    // CONSTRUCTORS
    // default constructor
    public TransactionService() {
        transactions = new ArrayList<>();
    }

// CORE
// add transaction
public void addTransaction(TransactionModel transaction) {

    transactions.add(transaction);
}

// remove transaction by id
public boolean removeTransactionById(int id) {

    for (TransactionModel transaction : transactions) {

        if (transaction.getId() == id) {

            transactions.remove(transaction);

            return true;
        }
    }

    return false;
}

// get all transactions
public ArrayList<TransactionModel> getTransactions() {

    return transactions;
}

// find transaction by id
public TransactionModel findTransactionById(int id) {

    for (TransactionModel transaction : transactions) {

        if (transaction.getId() == id) {

            return transaction;
        }
    }

    return null;
}

// clear all transactions
public void clearTransactions() {

    transactions.clear();
}

}
