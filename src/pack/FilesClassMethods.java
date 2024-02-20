package pack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.concurrent.ConcurrentNavigableMap;

public class FilesClassMethods  {
    public static void main(String[] args) throws IOException {

        Path p = FileSystems.getDefault().getPath("/hsd");
        Path p2 = FileSystems.getDefault().getPath("/hsd");
        //Method with NOOO IOException
        Files.isDirectory(p);
        Files.isRegularFile(p);
        Files.isSymbolicLink(p);
        Files.exists(p);
        //IO Exception
        Files.createDirectories(p);
        Files.createDirectory(p);
        Files.deleteIfExists(p);
        Files.isSameFile(p,p2);
        Files.readAllLines(p);
        Files.size(p);
        Files.write(p, "dqsdqs".getBytes());
        Files.setLastModifiedTime(p, FileTime.fromMillis(1532));
        Files.readAttributes(p, BasicFileAttributes.class);
        Files.newBufferedWriter(Path.of(""));
        Files.list(p);
        Files.getLastModifiedTime(p);
        Files.isHidden(p);
        Files.copy(p,p2);
        Files.find(p,0,(path, basicFileAttributes) -> true);
        Files.walkFileTree(p,null,0,null);
        Files.move(p,p2);
        Files.mismatch(p,p2);
    }
}
