import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Create {
    public static void main(String[] args) {

        // throws Exception if exists
        try {
            Files.createDirectories(
                    Path.of("yassine/raddaoui")
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

