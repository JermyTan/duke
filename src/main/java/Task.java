public abstract class Task {
    private String description;
    private boolean isDone;

    Task(String description, String isDone) {
        this.description = description;
        this.isDone = isDone.equals("1");
    }

    private String getStatusIcon() {
        return this.isDone ? "\u2713" : "\u2718";
    }

    void markAsDone() {
        this.isDone = true;
    }

    abstract String getTypeCode();

    @Override
    public String toString() {
        return String.format("[%s][%s] %s", this.getTypeCode(), this.getStatusIcon(), this.description);
    }

    String toSaveFormat() {
        return String.format("%s|%d|%s", this.getTypeCode(), this.isDone ? 1 : 0, this.description);
    }
}
