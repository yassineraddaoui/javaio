import java.io.*;
import java.nio.Buffer;

public class ClassChaining {
    public static void main(String[] args) throws IOException {
        new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("")
                )
        );
        new BufferedInputStream(
                new ObjectInputStream(
                        new FileInputStream("")
                )
        );

        new BufferedReader(
                new InputStreamReader(
                       new FileInputStream("")
                )
        );
        new BufferedReader(
                new FileReader("")
        );

        new ObjectOutputStream(new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream("")
                )
        ));
        new PrintStream(new FileOutputStream(""));

        new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream("new" ))
                )
        );

    }
}
