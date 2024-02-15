import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadAndWriteObjects {
    public static void main(String[] args) throws IOException {

        Files.writeString(Path.of("file1.txt"),"");
        copyStream(
                new FileInputStream("file.txt"),
                new FileOutputStream("file1.txt")
        );
        Files.readAllLines(Path.of("file.txt")).forEach(System.out::println);
    }

    static void copyStream(InputStream in, OutputStream out) throws IOException {
        int batchSize = 1;
        var buffer = new byte[batchSize];
        int lengthRead;
        while ((lengthRead = in.read(buffer, 0, batchSize)) > 0) {
            out.write(buffer, 0, lengthRead);
            out.flush();
        }
    }
}
