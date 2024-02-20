package Serialization;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Giraffe implements Serializable {
    int age;

    public static int nbrGiraffe=0;
    public transient  String id;

    public Giraffe(int a,String id){
        age=a;
        nbrGiraffe++;
    }

    @Override
    public String toString() {
        return "Giraffa age = "+age+" ,id =  "+id+", nbr = "+nbrGiraffe;
    }
}
class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var g = new Giraffe(5,"1");
        var a = new Giraffe(6,"2");
        var b = new Giraffe(7,"3");
        List<Giraffe> lg = new ArrayList<>(List.of(g, a, b));
        var in=new BufferedReader(new FileReader("file1.txt"));
        String s;
        while((s=in.readLine())!=null){
            System.err.println(s);
        }
        serialize(lg);
        deserialize().forEach(System.out::println);

    }
    public static void serialize(List<Giraffe> lg) throws IOException {
        try (var out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("file.txt")))) {
            for (Giraffe o : lg) {
                out.writeObject(o);
            }
        }
    }
    public static List<Giraffe> deserialize() throws IOException, ClassNotFoundException {
        List<Giraffe> lg=new ArrayList<>();
        try (var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("file.txt")))) {
            while(true){
                var o = in.readObject();
                if( o instanceof Giraffe g){
                    lg.add(g);
                }
            }
        }
        catch (EOFException eofException){
        }
        return lg;
    }
}
