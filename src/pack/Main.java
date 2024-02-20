package pack;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {

        //IN THE LEGACY WAY WE USE THE FULL PATH
        // AND THIS INCONVENIENT BECAUSE
        // THE APP SHOULD BE PORTABLE(BE ABLE TO WORK IN DIFFERENT OPERATING SYSTEM)
        Path p1 = Paths.get("C:a/b/c/d"); //Relative Path
        Path p2 = Paths.get("a/b/c/d"); //Absolute Path In Linux
        Path p3 = Path.of("a","b","c");
        Path p4 = Path.of("C:a","b");
        var path=Path.of("C:/yassine/amal");

        System.out.println("Filename is: " + path.getFileName());

        System.out.println(" Root is: " + path.getRoot());

        Path currentParent = path;
        while((currentParent = currentParent.getParent()) != null)
            System.out.println(" Current parent is: " + currentParent);
        System.out.println();

        System.out.println(p2.getParent()); // a/b/c

        System.out.println("getNameCount + getName :");
        //IGNORE ROOT
        IntStream.range(0,p2.getNameCount())
                .forEach(i-> System.out.print(p1.getName(i)+" "));
        System.out.println("\nSub path : ");

        //SUB-PATH
        System.out.println(p1.subpath(2, 3)); //only index 2
        System.out.println("Relativize :");
        System.out.println(p1.relativize(p4));
        System.out.println(p4.relativize(p1));
        System.out.println("TO REAL PATH :");
        System.out.println(Paths.get("/").toRealPath());
    }
}
