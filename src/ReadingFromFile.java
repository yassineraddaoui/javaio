import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class ReadingFromFile {

    public static void main(String[] args) throws IOException {
/*        Path p = FileSystems.getDefault().getPath("file.txt");
        System.out.println("Files.readAllLines(p) :"+Files.readAllLines(p));
        System.out.println("Files.readAllBytes(p) :"+ Arrays.toString(Files.readAllBytes(p)));
        System.out.println("Files.readString(p) :"+Files.readString(p));
        System.out.print("Files.newBufferedReader(p).lines().forEach(System.out::println) :");
        Files.newBufferedReader(p).lines().forEach(System.out::println);
        System.out.print("Files.newInputStream(p).read() :");
        System.out.println(Files.newInputStream(p).read());
        System.out.print("new BufferedReader(new InputStreamReader(new FileInputStream(p.toString()))).lines().forEach(System.out::println) :");
        new BufferedReader(new InputStreamReader(new FileInputStream(p.toString()))).lines().forEach(System.out::println);
        System.out.print("new FileInputStream('file.txt').read() :");
        System.out.println(new FileInputStream("file.txt").read());
        System.out.print("new FileReader(p.toString()).read() :");
        System.out.println(new FileReader(p.toString()).read());

 */
        copyPath(Path.of("file.txt"),Paths.get("file1.txt"));
        new BufferedReader(new InputStreamReader(new FileInputStream("file.txt"))).lines().forEach(System.out::println);

    }
    private static void copyPath(Path input, Path output) throws IOException {
        try (var reader = Files.newBufferedReader(input);
             var writer = Files.newBufferedWriter(output)) {
            int i;
            while ((i = reader.read()) != -1) {
                writer.write(i);
            }
        }
    }
}

