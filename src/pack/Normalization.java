package pack;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Normalization {

    public static void main(String[] args) {
        String filePath = "C:\\..\\projects\\..\\myapp\\logs/./app.log";

        // Normalize the file path
        Path normalizedPath = Paths.get(filePath).normalize();

        // Display the normalized path
        System.out.println("Original Path: " + filePath);
        System.out.println("Normalized Path: " + normalizedPath.toString());
        System.out.println(Path.of("C:").relativize(normalizedPath));
    }
}
