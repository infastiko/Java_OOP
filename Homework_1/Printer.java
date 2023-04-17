package Homework_1;

import java.io.File;
import java.io.FileWriter;

public class Printer {
    void print(String inputString) {
        System.out.println(inputString);
    }

    void saveFile(String inputString) {

        try {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("/file_relationships.txt");
            File file = new File(pathFile);

            if (file.createNewFile()) {
                System.out.println("\nfile.created");
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(inputString);
                fileWriter.flush();
                fileWriter.close();
            } else {
                System.out.println("\nfile.existed");
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            System.out.println(inputString);
        }
    }
}