package seedu.duke;

/**
 * Handles user-facing output for SpendTrack.
 */
public class Ui {

    /**
     * Displays a success message after an expense is added.
     *
     * @param expense the expense that was added
     */
    public void showAddSuccess(Expense expense) {
        System.out.println("New expense added:");
        System.out.println("  " + expense);
    }

    /**
     * Displays an error message to the user.
     *
     * @param message the error message to display
     */
    public void showError(String message) {
        System.out.println("Error: " + message);
    }
}
