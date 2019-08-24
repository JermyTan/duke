public class ToDo extends Task {

    ToDo(String description) {
        this(description, "0");
    }

    ToDo(String description, String isDone) {
        super(description, isDone);
    }

    @Override
    String getTypeCode() {
        return "T";
    }
}
