package pack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Enhancing_with_Files {
    public static void main(String[] args) {
        try {
            /*the entire file is read at once for all three of these,
            thereby storing all the contents of the file in memory at the same time.
             If the file is significantly large, you may trigger
            an OutOfMemoryError when trying to load all of it into memory*/

            //copyPathAsBytes(Path.of("file.txt"),Path.of("file1.txt"));
            //copyPathAsString(Path.of("file.txt"),Path.of("file1.txt"));
            //copyPathAsLines(Path.of("file.txt"),Path.of("file1.txt"));

            //Print the file as we reed it
            //the contents of the file are read and processed lazily, which means that only a small
            //portion of the file is stored in memory at any given time
            readLazily(Path.of("file.txt"));
            System.out.println("Res : ");
            //manipulate file :
            readLazilyLog(Path.of("file.txt"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readLazilyLog(Path path) throws IOException {
        try (Stream<String> s = Files.lines(path)) {
            s
                    .filter(f->f.startsWith("WARN"))
                    .map(f->f.substring(5))
                    .forEach(System.out::println);
        }
    }
    private static void readLazily(Path path) throws IOException {
        try (Stream<String> s = Files.lines(path)) {
            s.forEach(System.out::println);
        }
    }
    private static void copyPathAsString(Path input, Path output) throws IOException {
        String text = Files.readString(input);
        Files.writeString(output,text);
    }
    private static void copyPathAsBytes(Path input, Path output) throws IOException {
        byte[] bytes = Files.readAllBytes(input);
        Files.write(output, bytes);
    }
    private static void copyPathAsLines(Path input, Path output) throws IOException {
        List<String> lines = Files.readAllLines(input);
        Files.write(output, lines);
    }
}
