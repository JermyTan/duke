import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Storage {
    private File file;
    private TaskList taskList;

    Storage(String pathName, TaskList taskList) throws JermiException {
        this.taskList = taskList;
        this.file = new File(pathName);
        this.fileToTaskList();
    }

    private Task fileFormatToTask(String fileFormat) {
        Task task = null;
        String[] components = fileFormat.split("\\|");

        switch (components[0]) {
        case "T":
            task = new ToDo(components[2], components[1]);
            break;
        case "D":
            task = new Deadline(components[2], components[3], components[1]);
            break;
        case "E":
            task = new Event(components[2], components[3], components[1]);
            break;
        }
        return task;
    }

    private void fileToTaskList() throws JermiException {
        try {
            List<String> lines = Files.readAllLines(this.file.toPath());
            for (String line : lines) {
                this.taskList.add(this.fileFormatToTask(line));
            }
        } catch (IOException e) {
            throw new ReadingException(e.getMessage());
        }
    }

    void taskListToFile() throws JermiException {
        try {
            StringBuilder toWrite = new StringBuilder();
            for (Task task : this.taskList.getList()) {
                toWrite.append(task.toSaveFormat());
                toWrite.append("\n");
            }
            Files.writeString(this.file.toPath(), toWrite.toString());
        } catch (IOException e) {
            throw new WritingException(e.getMessage());
        }
    }




}
