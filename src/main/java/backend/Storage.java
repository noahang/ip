package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Storage {

    String filePath;

    /**
     * Creates a new storage class
     *
     * @param filePath the path of the file to be written to
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Writes all tasks from ToDoList into the filePath that Storage was initialised with.
     * If a directory existed before, no directory will be created.
     * If the file existed before, it's contents will be overwritten with the new content of the ToDoList.
     * Otherwise, a new parent directory will be created for the file
     * and the file will be created andwritten to.
     *
     * @param list the ToDoList containing the tasks to be written to the file
     */
    // @@author testing1234567891011121314
    // Reused from https://github.com/testing1234567891011121314/ip
    // with minor modifications
    public void saveDataToDisk(ToDoList list) {
        try {
            File file = new File(filePath);
            File dir = new File(file.getParent());
            boolean dirCreated = dir.mkdirs();
            FileWriter fw = new FileWriter(filePath, false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < list.getLength(); i++) {
                bw.write(list.getTask(i).toFileEntry());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException("This should never happen", e);
        }
    }
}
