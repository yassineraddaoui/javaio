package pack;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class newFile {
    public static void main(String[] args) throws IOException {
         new File("/weather/winter/snow.dat");
         new File(new File("snow.dat"), "/weather/winter");
         new File("weather", "/winter/snow.dat");
         new File(new File("/weather/winter"), "snow.dat");
         Path.of("/weather/winer/snow.dat").toFile();
        System.out.println(Path.of("ds").toRealPath());
    }
}
