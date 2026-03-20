package seedu.duke;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Manages the list of expenses.
 */
public class ExpenseList {
    private static final Logger logger = Logger.getLogger(ExpenseList.class.getName());

    private ArrayList<Expense> expenses;

    /**
     * Constructs an empty ExpenseList.
     */
    public ExpenseList() {
        this.expenses = new ArrayList<>();
    }

    /**
     * Adds an expense to the list.
     *
     * @param expense the expense to add
     */
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    /**
     * Returns the expense at the given index.
     *
     * @param index the zero-based index
     * @return the expense at that index
     */
    public Expense getExpense(int index) {
        return expenses.get(index);
    }

    /**
     * Returns the number of expenses in the list.
     *
     * @return the size of the list
     */
    public int size() {
        return expenses.size();
    }

    /**
     * Returns the full list of expenses.
     *
     * @return the list of expenses
     */
    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    /**
     * Returns the total sum of all expense amounts.
     *
     * @return the total amount
     */
    public double getTotal() {
        assert expenses != null : "Internal expense list should not be null";

        double total = 0;
        for (Expense expense : expenses) {
            assert expense != null : "Expense entries should not be null";
            total += expense.getAmount();
        }
        logger.log(Level.FINE, "Computed total {0} from {1} expenses", new Object[]{total, expenses.size()});
        return total;
    }
}
