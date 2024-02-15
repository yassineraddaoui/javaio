import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class FileSystemTest {

    public static void main(String[] args) throws IOException {

        Path p = FileSystems.getDefault()
                .getPath(".");
        Path p2=Path.of(".");
        Path p3= Paths.get(".");
        try (Stream<Path> stream = Files.list(p)) {
             stream.forEach(x ->
                    System.out.println(" " + x.toString()));
             }
        try {
            var out=new BufferedReader(new FileReader("file.txt"));
            String c=null;
            while((c =out.readLine()) !=null){
                System.out.println(c);
            }
        } catch (FileNotFoundException e) {
            System.out.println("hyrhf");
        }
        System.out.println();
        Files.readAllLines(Path.of("file.txt"))
                .forEach(System.out::println);
        var in=new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line=in.readLine())!=null)
            System.out.println(line);
    }
}
