package jermi.task;

public class Event extends TaskWithDateTime {

    public Event(String description, String dateTime) {
        this(description, dateTime, "0");
    }

    public Event(String description, String dateTime, String isDone) {
        super(description, dateTime, isDone);
    }

    @Override
    String getTypeCode() {
        return "E";
    }

    @Override
    public String toString() {
        return String.format("%s (at: %s)", super.toString(), this.getDateTime());
    }
}
