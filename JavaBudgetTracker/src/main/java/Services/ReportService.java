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
    public ArrayList<TransactionModel> getTransactionsByCategory(String category) {

        ArrayList<TransactionModel> results = new ArrayList<>();

        ArrayList<TransactionModel> transactions =
                transactionService.getTransactions();

        for (TransactionModel transaction : transactions) {

            if (transaction.getCategory().equalsIgnoreCase(category)) {

                results.add(transaction);
            }
        }

        return results;
    }


    // get transactions by type
    // INCOME or EXPENSE
    public ArrayList<TransactionModel> getTransactionsByType(TransactionType type) {

        ArrayList<TransactionModel> results = new ArrayList<>();

        ArrayList<TransactionModel> transactions =
                transactionService.getTransactions();

        for (TransactionModel transaction : transactions) {

            if (transaction.getType() == type) {

                results.add(transaction);
            }
        }

        return results;
    }


    // get transactions between dates
    public ArrayList<TransactionModel> getTransactionsBetweenDates(
            LocalDate startDate,
            LocalDate endDate
    ) {

        ArrayList<TransactionModel> results = new ArrayList<>();

        ArrayList<TransactionModel> transactions =
                transactionService.getTransactions();

        for (TransactionModel transaction : transactions) {

            LocalDate transactionDate = transaction.getDate();

            if ((transactionDate.isEqual(startDate) || transactionDate.isAfter(startDate))
                    && (transactionDate.isEqual(endDate) || transactionDate.isBefore(endDate))) {

                results.add(transaction);
            }
        }

        return results;
    }


    // search transactions by description
    public ArrayList<TransactionModel> searchTransactionsByDescription(String keyword) {

        ArrayList<TransactionModel> results = new ArrayList<>();

        ArrayList<TransactionModel> transactions =
                transactionService.getTransactions();

        for (TransactionModel transaction : transactions) {

            if (transaction.getDescription().toLowerCase().contains(keyword.toLowerCase())) {

                results.add(transaction);
            }
        }

        return results;
    }


    // STATISTICS
    // get highest expense transaction
    public TransactionModel getHighestExpenseTransaction() {

        TransactionModel highestExpense = null;

        ArrayList<TransactionModel> transactions =
                transactionService.getTransactions();

        for (TransactionModel transaction : transactions) {

            if (transaction.getType() == TransactionType.EXPENSE) {

                if (highestExpense == null
                        || transaction.getAmount() > highestExpense.getAmount()) {

                    highestExpense = transaction;
                }
            }
        }

        return highestExpense;
    }

    // get highest income transaction
    public TransactionModel getHighestIncomeTransaction() {

        TransactionModel highestIncome = null;

        ArrayList<TransactionModel> transactions =
                transactionService.getTransactions();

        for (TransactionModel transaction : transactions) {

            if (transaction.getType() == TransactionType.INCOME) {

                if (highestIncome == null
                        || transaction.getAmount() > highestIncome.getAmount()) {

                    highestIncome = transaction;
                }
            }
        }

        return highestIncome;
    }

    // get average expense
    public double getAverageExpense() {

        double totalExpenses = 0;
        int expenseCount = 0;

        ArrayList<TransactionModel> transactions =
                transactionService.getTransactions();

        for (TransactionModel transaction : transactions) {

            if (transaction.getType() == TransactionType.EXPENSE) {

                totalExpenses += transaction.getAmount();

                expenseCount++;
            }
        }

        if (expenseCount == 0) {

            return 0;
        }

        return totalExpenses / expenseCount;
    }

    // get average income
    public double getAverageIncome() {

        double totalIncome = 0;
        int incomeCount = 0;

        ArrayList<TransactionModel> transactions =
                transactionService.getTransactions();

        for (TransactionModel transaction : transactions) {

            if (transaction.getType() == TransactionType.INCOME) {

                totalIncome += transaction.getAmount();

                incomeCount++;
            }
        }

        if (incomeCount == 0) {

            return 0;
        }

        return totalIncome / incomeCount;
    }

    // get total transaction count
    public int getTotalTransactionCount() {

        return transactionService.getTransactions().size();
    }

    // DISPLAY
    // format report output
    public String formatReportOutput() {

        String report = "";

        report += "=== Budget Report ===\n";
        report += "Total Income: $" + generateIncomeReport() + "\n";
        report += "Total Expenses: $" + generateExpenseReport() + "\n";
        report += "Balance: $" + generateBalanceReport() + "\n";
        report += "Average Income: $" + getAverageIncome() + "\n";
        report += "Average Expense: $" + getAverageExpense() + "\n";
        report += "Transaction Count: " + getTotalTransactionCount() + "\n";

        return report;
    }


    // print report summary
    public void printReportSummary() {

        System.out.println(formatReportOutput());
    }


    // export report data (future)
    public void exportReportData() {

        // TODO:
        // export report data to CSV, TXT, or PDF later
    }


    // FUTURE IMPROVEMENTS
    // chart/graph support
    // CSV export
    // PDF export
    // advanced analytics
    // recurring transaction analysis
    // predictive budgeting
}
