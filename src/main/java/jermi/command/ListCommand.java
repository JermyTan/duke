package jermi.command;

import jermi.component.Formatter;
import jermi.component.Storage;
import jermi.component.TaskList;
import jermi.exception.JermiException;
import jermi.task.Task;
import java.util.List;
import java.util.stream.Collectors;


/**
 * A representation of the command to list the tasks in the list.
 */
public class ListCommand extends Command {
    /**
     * Public constructor for class.
     */
    public ListCommand() {
        super();
    }

    /**
     * Executes the command.
     *
     * @param taskList Task list.
     * @param formatter Formatter.
     * @param storage Storage.
     * @return Output response.
     * @throws JermiException JermiException.
     */
    @Override
    public String execute(TaskList taskList, Formatter formatter, Storage storage) throws JermiException {
        List<String> tasks = taskList
                .getList()
                .stream()
                .map(Task::toString)
                .collect(Collectors.toList());

        for (int index = 1; index <= tasks.size(); index++) {
            tasks.set(index - 1, index + "." + tasks.get(index - 1));
        }
        tasks.add(0, "Here are the tasks in your list:");
        return formatter.echo(tasks.toArray(new String[0]));
    }

    /**
     * Indicates if the program should exit.
     *
     * @return {@code false}.
     */
    @Override
    public boolean shouldExit() {
        return false;
    }
}
