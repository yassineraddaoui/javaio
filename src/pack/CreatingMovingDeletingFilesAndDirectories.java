package pack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CreatingMovingDeletingFilesAndDirectories {

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) throws IOException {

        Path sourceFile = Paths.get("C:/file");
        Path targetDir = Paths.get("C:/move");

            // Source file exists and is a regular file
            try {
                Path targetFile = targetDir.resolve(sourceFile.getFileName());

                // Copy the source file to the target file in the directory
                Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File copied successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        long position = Files.mismatch(sourceFile,targetDir);
        if (position == -1) {
            System.out.println("The files are identical.");
        } else {
            System.out.println("Files differ at position: " + position);
        }
    }
}
