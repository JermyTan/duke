public class Parser {

    Command parse(String inputCommand, String inputDetails) throws JermiException {
        Command command = null;
        switch (inputCommand) {
        case "list":
            command = new ListCommand();
            break;
        case "bye":
            command = new ExitCommand();
            break;
        case "todo":
        case "deadline":
        case "event":
        case "done":
        case "delete":
            if (inputDetails.isEmpty()) {
                throw new EmptyDescriptionException(inputCommand);
            }
            switch (inputCommand) {
            case "todo":
                command = new AddCommand(TaskType.TO_DO, inputDetails);
                break;
            case "deadline":
                command = new AddCommand(TaskType.DEADLINE, inputDetails);
                break;
            case "event":
                command = new AddCommand(TaskType.EVENT, inputDetails);
                break;
            case "done":
                command = new DoneCommand(inputDetails);
                break;
            case "delete":
                command = new DeleteCommand(inputDetails);
                break;
            }
            break;
        default:
            throw new InvalidCommandException();
        }
        return command;
    }
}
