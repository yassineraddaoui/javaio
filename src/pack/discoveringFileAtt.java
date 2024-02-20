package pack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class discoveringFileAtt {
    public static void main(String[] args) {
        Path path = Paths.get("file1.txt");
        System.out.println(Files.isRegularFile(path));
        System.out.println(Files.isSymbolicLink(path));
        System.out.println(Files.isDirectory(path));
        try {
            System.out.println(Files.isSameFile(path, Paths.get("file12.txt")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            //if not found IOException
            System.out.println(Files.isHidden(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // if not found false
        System.out.println(Files.isReadable(Paths.get("/seal/baby.png")));
        System.out.println(Files.isWritable(Paths.get("dolphin.txt")));
        System.out.println(Files.isExecutable(Paths.get("whale.png")));
    }
}
