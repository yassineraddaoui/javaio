package pack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SearchingDirs {
    public static void main(String[] args) throws IOException {
        Path p = Path.of("E:\\yassin");
        //FIND WITH Files.find(p,depth,predicate)
        try(var s = Files.find(
                p,
                5,
                (pp,a)->a.isRegularFile() &&
                        pp.toString().endsWith("(1).pdf"))
        ){
            s.forEach(System.out::println);
        }

        try (var stream = Files.walk(p, 5)) {
            stream
                    .filter(f->f.toString().endsWith("(1).pdf"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
