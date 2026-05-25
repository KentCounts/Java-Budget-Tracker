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
    // full constuctor
    // initialize all fields

    // GETTERS
    // get id
    // get name
    // get category
    // get limit amount
    // get spent amount
    // get start date
    // get end dte

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