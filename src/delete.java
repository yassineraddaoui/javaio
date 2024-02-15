import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class delete {
    public static void main(String[] args) {
        Path p= Paths.get("demo.txt");
        try {
            //Files.delete(p);
            System.out.println(Files.deleteIfExists(p));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
