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

    private int id;
    private double amount;
    private String category;
    private String description;
    private LocalDate date;
    private TransactionType type;


    // CONSTRUCTORS
    public TransactionModel() {

    }

    public TransactionModel(
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

    // GETTERS
    // get id
    public int getId() {
        return id;
    }


    // get amount
    public double getAmount() {
        return amount;
    }


    // get category
    public String getCategory() {
        return category;
    }


    // get description
    public String getDescription() {
        return description;
    }


    // get date
    public LocalDate getDate() {
        return date;
    }


    // get transaction type
    public TransactionType getType() {
        return type;
    }

// SETTERS
// set id
public void setId(int id) {
    this.id = id;
}


// set amount
public void setAmount(double amount) {
    this.amount = amount;
}

// set category
public void setCategory(String category) {
    this.category = category;
}

// set description
public void setDescription(String description) {
    this.description = description;
}

// set date
public void setDate(LocalDate date) {
    this.date = date;
}

// set type
public void setType(TransactionType type) {
    this.type = type;
}

// OUTPUT
// return formatted transaction string
@Override
public String toString() {

    return "Transaction { " +
            "id=" + id +
            ", amount=" + amount +
            ", category='" + category + '\'' +
            ", description='" + description + '\'' +
            ", date=" + date +
            ", type=" + type +
            " }";
}

    // FUTURE IMPROVEMENTS
    // tags/labels
    // recurring transaction flag
    // payment method
    // merchant/vendor name
    // receipt attachment support
    // transaction validation
}