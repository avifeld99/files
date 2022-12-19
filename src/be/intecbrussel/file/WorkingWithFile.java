package be.intecbrussel.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class WorkingWithFile {
    public static void main(String[] args) {

        // absolute path
        // relative path

        /*// Path path = Path.of("C://Users//intec//IdeaProjects//cashier//src//be//intecbrussel");
        Path path1 = Path.of("myfolder/myfile.txt");
        File file1 = path1.toFile();
        File myFile = new File("myfolder/myfile.txt");

        try {
            file1.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException();
        }*/

        // to use this code on your own files make sure your Path is correct.
        Path path = Path.of("C:\\Users\\intec\\IdeaProjects\\exceptions");
        File aDirectory = path.toFile();
        File[] files = aDirectory.listFiles();
        for (File file : files) {
            if(file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
            } else {
                System.out.println("File: " + file.getName());
            }
        }

    }
}
