package be.intecbrussel.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Oefening1 {
    public static void main(String[] args) {

        Path path = Path.of("C:\\Users\\intec\\IdeaProjects\\exceptions");
        File file = path.toFile();

        try {
            if (file.exists()) {
                System.out.println("file already exists, not added");
            }
            else {
                System.out.println("file added");
                file.createNewFile();
            }
        }
        catch (IOException ioe) {
            throw new RuntimeException();
        }
    }
}
