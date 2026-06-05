/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

// IMPORTS
// model imports
import Models.BudgetModel;
import Models.TransactionModel;
// enums?
import Enums.TransactionType;
// utilities
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.HashMap;


/**
 *
 * @author Kent
 */
public class ReportService {

    // FIELDS
    // reference to transaction service
    private TransactionService transactionService;

    // list of budgets
    private ArrayList<BudgetModel> budgets;

    // cached report data
    // optional
    // private String lastGeneratedReport;

    // CONSTRUCTORS
    // default constructor
    public ReportService() {

        transactionService = new TransactionService();

        budgets = new ArrayList<>();
    }


    // constructor with transaction service dependency
    public ReportService(TransactionService transactionService) {

        this.transactionService = transactionService;

        budgets = new ArrayList<>();
    }



    // REPORT GENERATION
    // generate income report
    // calculate total income
    public double generateIncomeReport() {

        double totalIncome = 0;

        ArrayList<TransactionModel> transactions =
                transactionService.getTransactions();

        for (TransactionModel transaction : transactions) {

            if (transaction.getType() == TransactionType.INCOME) {

                totalIncome += transaction.getAmount();
            }
        }

        return totalIncome;
    }


    // generate expense report
    // calculate total expenses
    public double generateExpenseReport() {

        double totalExpenses = 0;

        ArrayList<TransactionModel> transactions =
                transactionService.getTransactions();

        for (TransactionModel transaction : transactions) {

            if (transaction.getType() == TransactionType.EXPENSE) {

                totalExpenses += transaction.getAmount();
            }
        }

        return totalExpenses;
    }


    // generate balance report
    // income - expenses
    public double generateBalanceReport() {

        return generateIncomeReport() - generateExpenseReport();
    }
    
    // generate category summary
    // totals grouped by category
    public HashMap<String, Double> generateCategorySummary() {

        HashMap<String, Double> categoryTotals = new HashMap<>();

        ArrayList<TransactionModel> transactions =
                transactionService.getTransactions();

        for (TransactionModel transaction : transactions) {

            String category = transaction.getCategory();
            double amount = transaction.getAmount();

            if (transaction.getType() == TransactionType.EXPENSE) {

                categoryTotals.put(
                        category,
                        categoryTotals.getOrDefault(category, 0.0) + amount
                );
            }
        }

        return categoryTotals;
    }


    // generate monthly report
    // transactions filtered by month/year
    public ArrayList<TransactionModel> generateMonthlyReport(int month, int year) {

        ArrayList<TransactionModel> monthlyTransactions = new ArrayList<>();

        ArrayList<TransactionModel> transactions =
                transactionService.getTransactions();

        for (TransactionModel transaction : transactions) {

            if (transaction.getDate().getMonthValue() == month
                    && transaction.getDate().getYear() == year) {

                monthlyTransactions.add(transaction);
            }
        }

        return monthlyTransactions;
    }


    // generate budget usage report
    // compare spending against budget limits
    public HashMap<String, Double> generateBudgetUsageReport() {

        HashMap<String, Double> budgetUsage = new HashMap<>();

        HashMap<String, Double> categoryTotals = generateCategorySummary();

        for (BudgetModel budget : budgets) {

            String category = budget.getCategory();
            double spent = categoryTotals.getOrDefault(category, 0.0);

            budgetUsage.put(category, spent);
        }

        return budgetUsage;
    }


    // SEARCH
    // get transactions by category
    // get transactions by type
    // INCOME or EXPENSE
    // get transactions between dates
    // search transactions by description


    // STATISTICS
    // get highest expense transaction
    // get highest income transaction
    // get average expense
    // get average income
    // get total transaction count


    // DISPLAY
    // format report output
    // print report summary
    // export report data (future)


    // FUTURE IMPROVEMENTS
    // chart/graph support
    // CSV export
    // PDF export
    // advanced analytics
    // recurring transaction analysis
    // predictive budgeting
}
