package be.intecbrussel.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.List;

public class Oefening1 {
    public static void main(String[] args) {

/*
-Schrijf enkele regels tekst naar het bestand.
-Lees de tekst terug van het bestand.
-Hernoem het bestand.Gebruik hiervoor de methode `Files.move()`
-Druk wat kenmerken van een bestand af.Zoals bijvoorbeeld de size, is het readonly enz.
-Druk de gegevens van de eigenaar van het bestand af. (Zoek zelf naar een manier om dit te doen)
*/
        try {
            Path path = Path.of("myfolder/myinnerfolder/Files_Oefeningen.txt");
            Files.createDirectories(path.getParent());

            if (Files.notExists(path)) {
                Files.createFile(path);
                System.out.println("new file created");
            }
            else {
                System.out.println("file already exists");
            }

            List<String> myList = new ArrayList<>();
            myList.add("Hello");
            myList.add("How are you");
            myList.add("Thanks, I'm fine");

            Files.write(path, myList, StandardOpenOption.APPEND);

            Files.lines(path).forEach(System.out::println);

            Path newPath = Path.of("myfolder/myinnerfolder/Files_Oef_new.txt");

            Files.move(path, newPath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println(Files.size(newPath));
            System.out.println(Files.isReadable(newPath));
            System.out.println(Files.isHidden(newPath));
            System.out.println(Files.getFileStore(newPath));

            FileOwnerAttributeView owner = Files.getFileAttributeView(newPath, FileOwnerAttributeView.class);
            System.out.println(owner.getOwner());
            UserPrincipal getOwner = owner.getOwner();
            System.out.println(getOwner.getName());

        }
        catch (IOException ioe) {
            throw new RuntimeException();
        }
    }
}
