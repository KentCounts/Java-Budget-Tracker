/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.BudgetModel;

import java.util.ArrayList;

public class BudgetService {

    // FIELDS
    // list of all budgets
    private ArrayList<BudgetModel> budgets;


    // CONSTRUCTORS
    // default constructor
    // initialize budget list
    public BudgetService() {

        budgets = new ArrayList<>();
    }


    // CORE METHODS
    // add budget
    public void addBudget(BudgetModel budget) {

        budgets.add(budget);
    }


    // remove budget by id
    public boolean removeBudgetById(int id) {

        BudgetModel budget = findBudgetById(id);

        if (budget != null) {

            budgets.remove(budget);

            return true;
        }

        return false;
    }


    // get all budgets
    public ArrayList<BudgetModel> getBudgets() {

        return budgets;
    }


    // find budget by id
    public BudgetModel findBudgetById(int id) {

        for (BudgetModel budget : budgets) {

            if (budget.getId() == id) {

                return budget;
            }
        }

        return null;
    }


    // clear all budgets
    public void clearBudgets() {

        budgets.clear();
    }


    // SEARCH METHODS
    // get budgets by category
    public ArrayList<BudgetModel> getBudgetsByCategory(String category) {

        ArrayList<BudgetModel> matchingBudgets = new ArrayList<>();

        for (BudgetModel budget : budgets) {

            if (budget.getCategory().equalsIgnoreCase(category)) {

                matchingBudgets.add(budget);
            }
        }

        return matchingBudgets;
    }


    // get over-budget budgets
    public ArrayList<BudgetModel> getOverBudgetBudgets() {

        ArrayList<BudgetModel> overBudget = new ArrayList<>();

        for (BudgetModel budget : budgets) {

            if (budget.isOverBudget()) {

                overBudget.add(budget);
            }
        }

        return overBudget;
    }


    // get budgets under limit
    public ArrayList<BudgetModel> getBudgetsUnderLimit() {

        ArrayList<BudgetModel> underBudget = new ArrayList<>();

        for (BudgetModel budget : budgets) {

            if (!budget.isOverBudget()) {

                underBudget.add(budget);
            }
        }

        return underBudget;
    }


    // STATISTICS
    // get total budget limit
    public double getTotalBudgetLimit() {

        double total = 0;

        for (BudgetModel budget : budgets) {

            total += budget.getLimitAmount();
        }

        return total;
    }


    // get total spent amount
    public double getTotalSpentAmount() {

        double total = 0;

        for (BudgetModel budget : budgets) {

            total += budget.getSpentAmount();
        }

        return total;
    }


    // get total remaining budget
    public double getTotalRemainingBudget() {

        double total = 0;

        for (BudgetModel budget : budgets) {

            total += budget.getRemainingAmount();
        }

        return total;
    }


    // get average percent used
    public double getAveragePercentUsed() {

        if (budgets.isEmpty()) {

            return 0;
        }

        double total = 0;

        for (BudgetModel budget : budgets) {

            total += budget.getPercentUsed();
        }

        return total / budgets.size();
    }


    // FUTURE IMPROVEMENTS
    // update budget
    // sort budgets by category
    // sort budgets by remaining amount
    // recurring monthly budget reset
    // budget alerts/warnings
}