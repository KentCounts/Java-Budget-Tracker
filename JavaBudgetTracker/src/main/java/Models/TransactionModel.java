/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Kent
 */

import java.time.LocalDate;

import Enums.TransactionType;

public class Transaction {

    private int id;
    private double amount;
    private String category;
    private String description;
    private LocalDate date;
    private TransactionType type;


    // CONSTRUCTORS
    public Transaction() {

    }

    public Transaction(
            int id,
            double amount,
            String category,
            String description,
            LocalDate date,
            TransactionType type
    ) {

        this.id = id;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
        this.type = type;
    }
}

    // GETTERS
    // get id
    // get amount
    // get category
    // get description
    // get date
    // get transaction type

    // SETTERS
    // set id
    // set amount
    // set category
    // set description
    // set date
    // set transaction type

    // OUTPUT
    // function: toString()
    // return formatted transaction string

    // FUTURE IMPROVEMENTS
    // tags/labels
    // recurring transaction flag
    // payment method
    // merchant/vendor name
    // receipt attachment support
    // transaction validation
}