import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CopyMove {
    public static void main(String[] args) throws IOException {
        Path p1= Path.of("demo.txt");
        Path p2=Path.of("copie.txt");
        System.out.println(Files.isSameFile(p1, p2));
        Files.copy(p1,p2);
        Files.move(p2,p1, StandardCopyOption.REPLACE_EXISTING);


    }
}
