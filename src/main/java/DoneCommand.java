import java.io.IOException;

public class DoneCommand extends Command {
    private int ordering;

    DoneCommand(String ordering) throws JermiException {
        super();

        try {
            this.ordering = Integer.parseInt(ordering);
        } catch (NumberFormatException e) {
            throw new NotANumberException();
        }
    }

    @Override
    void execute(TaskList taskList, Ui ui, Storage storage) throws JermiException {
        Task task = taskList.getTask(this.ordering);
        task.markAsDone();
        ui.echo("Nice! I've marked this task as done:", "  " + task);
        storage.taskListToFile();
    }

    @Override
    boolean shouldExit() {
        return false;
    }
}
