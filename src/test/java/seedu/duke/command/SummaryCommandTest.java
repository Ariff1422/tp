package seedu.duke.command;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.Expense;
import seedu.duke.ExpenseList;
import seedu.duke.Ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SummaryCommandTest {

    private ExpenseList expenses;
    private Ui ui;

    @BeforeEach
    void setUp() {
        expenses = new ExpenseList();
        ui = new Ui();
    }

    @Test
    void execute_emptyList_doesNotThrow() {
        SummaryCommand cmd = new SummaryCommand();
        cmd.execute(expenses, ui);
        assertEquals(0, expenses.size());
    }

    @Test
    void execute_singleCategory_correctTotal() {
        expenses.addExpense(new Expense("Coffee", 3.50, "Food", LocalDate.now()));
        expenses.addExpense(new Expense("Lunch", 10.00, "Food", LocalDate.now()));
        SummaryCommand cmd = new SummaryCommand();
        cmd.execute(expenses, ui);
        assertEquals(13.50, expenses.getTotal(), 0.01);
    }

    @Test
    void execute_multipleCategories_allGrouped() {
        expenses.addExpense(new Expense("Coffee", 3.50, "Food", LocalDate.now()));
        expenses.addExpense(new Expense("Bus", 1.20, "Transport", LocalDate.now()));
        expenses.addExpense(new Expense("Lunch", 10.00, "Food", LocalDate.now()));
        SummaryCommand cmd = new SummaryCommand();
        cmd.execute(expenses, ui);
        assertEquals(14.70, expenses.getTotal(), 0.01);
    }

    @Test
    void execute_afterExecution_doesNotModifyList() {
        expenses.addExpense(new Expense("Coffee", 3.50, "Food", LocalDate.now()));
        expenses.addExpense(new Expense("Bus", 1.20, "Transport", LocalDate.now()));
        int sizeBefore = expenses.size();
        new SummaryCommand().execute(expenses, ui);
        assertEquals(sizeBefore, expenses.size());
    }
}
