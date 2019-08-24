import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class TaskWithDateTime extends Task {
    private String dateTime;

    TaskWithDateTime(String description, String dateTime, String isDone) {
        super(description, isDone);
        try {
            this.dateTime = this.parseStringFormatDateTime(dateTime);
        } catch (DateTimeParseException e) {
            this.dateTime = dateTime;
        }
    }

    private LocalDateTime stringToDateTime(String string) {
        return LocalDateTime.parse(string, DateTimeFormatter.ofPattern("d/M/yyyy HHmm"));
    }

    private String dateTimeToString(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("d MMMM yyyy, h.mma"));
    }

    private String parseStringFormatDateTime(String stringFormatDateTime) {
        return this.dateTimeToString(this.stringToDateTime(stringFormatDateTime));
    }

    String getDateTime() {
        return this.dateTime;
    }

    @Override
    String toSaveFormat() {
        return String.format("%s|%s", super.toSaveFormat(), this.dateTime);
    }
}
