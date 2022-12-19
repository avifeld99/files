package be.intecbrussel.file;

import java.io.File;
import java.nio.file.Path;
import java.util.Date;

public class Oefening3 {
    public static void main(String[] args) {

        Path path = Path.of("C:\\Users\\intec\\IdeaProjects\\exceptions");
        File file = path.toFile();

        Date date = new Date(file.lastModified());

        System.out.println(date);
    }
}
