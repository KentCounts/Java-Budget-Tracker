/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Kent
 */

// IMPORTS
import java.time.LocalDate;

public class BudgetModel {

    // FIELDS
    // unique budget id
    private int id;
    // budget name
    private String name;
    // budget category
    private String category;
    // budget limit / maximum amount
    private double limitAmount;
    // amount currently spent
    private double spentAmount;
    // start date
    private LocalDate startDate;
    // end date
    private LocalDate endDate;


    // CONSTRUCTORS
    // default constructor
    public BudgetModel() {

    }


    // full constructor
    // initialize all fields
    public BudgetModel(
            int id,
            String name,
            String category,
            double limitAmount,
            double spentAmount,
            LocalDate startDate,
            LocalDate endDate
    ) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.limitAmount = limitAmount;
        this.spentAmount = spentAmount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

// GETTERS
// get id
public int getId() {
    return id;
}

// get name
public String getName() {
    return name;
}

// get category
public String getCategory() {
    return category;
}

// get limit amount
public double getLimitAmount() {
    return limitAmount;
}

// get spent amount
public double getSpentAmount() {
    return spentAmount;
}

// get start date
public LocalDate getStartDate() {
    return startDate;
}

// get end date
public LocalDate getEndDate() {
    return endDate;
}
    // SETTERS
    // set id
    // set name
    // set category
    // set limit amount
    // set spent amount
    // set start date
    // set end date


    // BUDGET LOGIC
    // addSpending(amount)
    // getRemainingAmount()

    // isOverBudget()
    // getPercentUsed()

    // OUTPUT
    // toString()


    // FUTURE IMPROVEMENTS
    // recurring monthly budgets
    // budget alerts/warnings
    // category-specific reports
    // rollover unused budget amount
    // multiple budget periods
}