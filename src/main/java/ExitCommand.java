import java.io.IOException;

public class ExitCommand extends Command {

    ExitCommand() {
        super();
    }

    @Override
    void execute(TaskList taskList, Ui ui, Storage storage) throws JermiException {
        ui.exit();
    }

    @Override
    boolean shouldExit() {
        return true;
    }
}
