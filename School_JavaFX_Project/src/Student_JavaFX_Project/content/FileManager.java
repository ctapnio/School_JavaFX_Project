/**
 * Christian Tapnio
 * 991 359 879
 * Assignment 3
 */
package Student_JavaFX_Project.content;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void setRecord(String fileName, String record) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(record);
        bw.newLine();

        bw.flush();
    }

}
