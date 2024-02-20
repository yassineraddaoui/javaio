package pack;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileApp {


    public static void main(String[] args) {
        files();
    }

    static void file() {

    }

    static void files() {
        try (var f = Files.newBufferedReader(Path.of("../file.txt"))) {

            System.out.println(f.readLine());
        } catch (IOException e) {
            System.out.println(" error ");
        }
    }
}
