import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class FileProp {
    public static void main(String[] args) {
        Path filePath = Paths.get(".");


        //print . ????
        System.out.println(filePath.getFileName());
// Check if a path exists
        boolean exists = Files.exists(filePath);

// Get the file's size in bytes
        PrintWriter p = new PrintWriter(System.out);
        /*
        this method is modifying the standard output stream==>
        try {
            long fileSize = Files.size(filePath);
            p.printf("fileSize %d bytes%n", fileSize); // Note the format specifier %d and the newline character %n
        } catch (IOException e) {
            System.out.println("err");
        }
        finally {
            p.close();
        }
         */
        try {
            long fileSize = Files.size(filePath);
            System.out.printf("fileSize %d bytes%n", fileSize);
        } catch (IOException e) {
            System.err.println("err");
        }


// Get the last modified timestamp
        try {
            FileTime lastModifiedTime = Files.getLastModifiedTime(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

// Check if it's a directory
        boolean isDirectory = Files.isDirectory(filePath);

// Get file attributes
        try {
            BasicFileAttributes attributes = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("Creation Time: " + attributes.creationTime());
            System.out.println("Last Access Time: " + attributes.lastAccessTime());
            System.out.println("Is Directory: " + attributes.isDirectory());
            System.out.println("Is Regular File: " + attributes.isRegularFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
