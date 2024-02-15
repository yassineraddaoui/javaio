import java.io.*;

public class AdvancedAPIs {
    public static void main(String[] args) throws IOException {
        readData(new FileInputStream("file.txt"));
    }
    public static void readData(InputStream is) throws IOException {
        System.out.print((char) is.read()); // L
        if (is.markSupported()) {
            is.mark(100); // Marks up to 100 bytes
            System.out.print((char) is.read()); // I
            System.out.print((char) is.read()); // O
            is.reset(); // Resets stream to position before I
        }
        is.skip(1);
        System.out.print((char) is.read()); // I
        System.out.print((char) is.read()); // O
        System.out.print((char) is.read()); // N

    }
}
