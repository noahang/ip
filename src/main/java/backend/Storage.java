package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Storage {

    String filePath;

    public void saveDataToDisk(ToDoList list) {
        try {
            File file = new File(filePath);
            File dir = new File(file.getParent());
            boolean dirCreated = dir.mkdirs();
            // @@author testing1234567891011121314
            // Reused from https://github.com/testing1234567891011121314/ip
            // with minor modifications
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
