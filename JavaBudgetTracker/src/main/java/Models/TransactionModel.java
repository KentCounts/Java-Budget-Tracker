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

public class TransactionModel {
    // unique transaction id
    private int id;

    private double amount;

    // category name IE Food, Rent, Entertainment. 
    private String category;

    // transaction description/notes
    private String description;

    private LocalDate date;

    // transaction type
    // INCOME or EXPENSE
    private TransactionType type;

    // CONSTRUCTORS
    // default constructor
    // full constructor
    // initialize all fields

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