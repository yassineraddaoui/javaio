package Serialization;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class find {
    public static void main(String[] args) throws IOException {
        var f = Path.of("C:\\Program Files\\JetBrains\\IntelliJ IDEA 2023.2.1");
        try (var m =
                     Files.find(f, 0, (p,a) -> a.isSymbolicLink())) { // y1
            m.map(Path::toString)
                    .toList()
                    .stream()
                    .filter(s -> s.endsWith(".txt")) // y2
                    .forEach(System.out::println);
        }
    }
}
