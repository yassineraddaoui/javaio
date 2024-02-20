package pack;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileClassMethods {
    public static void main(String[] args) {
        File f=new File("/sqdlqs");
        File f2=new File("/sqdlqs");

        f.delete();
        f.isHidden();
        f.isDirectory();
        f.isFile();
        f.isAbsolute();
        f.exists();
        f.canExecute();
        f.canRead();
        f.canWrite();
        f.compareTo(f2);
        f.toURI();
        f.deleteOnExit();
        f.getFreeSpace();
        f.getParent();
        f.getUsableSpace();
        f.getAbsolutePath();
        f.getTotalSpace();
        try {

            f.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
