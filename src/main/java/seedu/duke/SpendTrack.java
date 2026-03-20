package seedu.duke;

import java.util.logging.Logger;

import seedu.duke.command.Command;

/**
 * Main application class for SpendTrack.
 * Owns the main loop: read → parse → execute → repeat.
 */
public class SpendTrack {

    private static final Logger logger = Logger.getLogger(SpendTrack.class.getName());

    static {
        logger.setUseParentHandlers(false);
    }

    private final Ui ui;
    private final ExpenseList expenses;

    public SpendTrack() {
        ui = new Ui();
        expenses = new ExpenseList();
    }

    /**
     * Starts the application.
     */
    public void run() {
        logger.info("SpendTrack application starting");
        ui.showWelcome();
        boolean isRunning = true;
        while (isRunning) {
            String input = ui.readCommand();
            try {
                Command command = Parser.parse(input);
                command.execute(expenses, ui);
                isRunning = !command.isExit();
            } catch (SpendTrackException e) {
                logger.warning("SpendTrackException caught: " + e.getMessage());
                ui.showError(e.getMessage());
            }
        }
        logger.info("SpendTrack application exiting");
    }

    public static void main(String[] args) {
        new SpendTrack().run();
    }
}
