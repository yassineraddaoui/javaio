package pack;

import java.io.IOException;
import java.nio.file.Path;

public class PathMethods {
    public static void main(String[] args)  {
        Path p= Path.of("/dsqlkd");
        Path p2= Path.of("/dsqlkd");

        p.toFile();
        p.toAbsolutePath();
        p.toUri();

        p.subpath(0,1);
        p.relativize(p2);
        p.resolve(".");
        p.normalize();

        p.getName(0);
        p.relativize(p2);
        p.getRoot();
        p.getParent();
        p.getFileName();
        p.getNameCount();
        p.getFileSystem();

        try {
            p.toRealPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
