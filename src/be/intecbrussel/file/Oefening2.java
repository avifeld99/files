package be.intecbrussel.file;

import java.io.File;
import java.nio.file.Path;

public class Oefening2 {
    public static void main(String[] args) {

        Path path = Path.of("C:\\Users\\intec\\IdeaProjects\\file_lezen_schrijven");
        File file = path.toFile();
        File[] files = file.listFiles();

        for (File iterateFiles : files) {
            if (iterateFiles.isDirectory()) {
                System.out.println("Directory: " + iterateFiles.getName());
            }
            else {
                System.out.println("File: " + iterateFiles.getName());
            }
        }
    }
}
