package be.intecbrussel.files;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class WorkingWithFiles {
    public static void main(String[] args) {

        try {
            Path path = Path.of("myfolder/myinnerfolder/myfile.txt");

            Files.createDirectories(path.getParent());

            if (Files.notExists(path)) {
                Files.createFile(path);
                System.out.println("Created new file");
            }
            else {
                System.out.println("File already exist");
            }

            List<String> lines = new ArrayList<>();
            lines.add("Hi");
            lines.add("Hello");

            Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);

            Files.lines(path).forEach(System.out::println);

            Path pathCopy = Paths.get("myfolder/myinnerfolder/myfile02.txt");
            Files.copy(path, pathCopy, StandardCopyOption.REPLACE_EXISTING);

            Files.deleteIfExists(path);
        }
        catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
