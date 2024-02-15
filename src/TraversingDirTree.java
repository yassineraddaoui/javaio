import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class TraversingDirTree {
    public static void main(String[] args) throws IOException {
        var p =Path.of("C:\\DRIVERS");
        try (var stream = Files.walk(p, 3)) {
            stream
                    .filter(f->f.endsWith("setup.exe"))
                    .filter(Files::isRegularFile) // Filter out directories
                    .forEach(path -> System.out.println(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new TraversingDirTree()
                .getPathSize(Path.of("C:\\Java Lambdas and Streams"))/1000000.0 +"mg");
    }
    private long getSize(Path p) {
        try {
            return Files.size(p);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
    public long getPathSize(Path source) throws IOException {
        try (var s = Files.walk(source,5, FileVisitOption.FOLLOW_LINKS)) {
            return s.parallel()
                    .filter(p -> !Files.isDirectory(p))
                    .mapToLong(this::getSize)
                    .sum();
        }
    }    /*
    A depth-first search traverses the structure from the root to an arbitrary leaf and then navigates back up toward the root, traversing fully any paths it skipped
    along the way.
    */
    public static void depthFirstSearch(){

    }
    /*
    a breadth-first search starts at the root and processes all elements of each
particular depth before proceeding to the next depth level. The results are ordered by depth,
with all nodes at depth 1 read before all nodes at depth 2, and so on.
     */
    public static void breadthFirstSearch(){

    }
}
