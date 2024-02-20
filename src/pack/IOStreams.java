package pack;

import java.io.*;

public class IOStreams {
    public static void main(String[] args) throws IOException {
        try (
                var inputStream = new BufferedReader(new FileReader("file1.txt"));
                var outputStream = new BufferedWriter(new FileWriter("file2.txt"))
        ) {

            new DataInputStream(new BufferedInputStream(new FileInputStream("")));
            new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("zoo-data.txt")));

            new BufferedInputStream(new FileInputStream("z.txt"));
            new BufferedWriter(new FileWriter("z.txt"));

            new BufferedOutputStream(new FilterOutputStream(System.out));
            new BufferedInputStream(new ObjectInputStream(System.in));
            int c;
            while ((c = inputStream.read()) != -1) {
                System.out.println("c = " + c);
                outputStream.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        test(new DataInputStream(new FileInputStream("")), new FileOutputStream(""));
        new PrintStream(new FileOutputStream("test"));

    }

    static void test(InputStream i, OutputStream o) {

    }
}
