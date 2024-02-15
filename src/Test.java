import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Path;

public class Test {

    public static void main(String[] args) {
    }

    private void copyPath(Path input, Path output) throws IOException {

        PrintStream outB=new PrintStream("file.txt");
        PrintWriter outC=new PrintWriter("file.txt");
        try(outB;outC){
            outB.println("Line 1");
            outC.println("Line 2");
        }

    }
}