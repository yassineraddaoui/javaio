package Serialization;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

class ObjetPere{
    No no =new No();
    int i=99;
}
class Objet extends ObjetPere implements Serializable{
    public Objet(){

    }
    public Objet(No no){
        this.no=no;
        i=99;
    }

    @Override
    public String toString() {
        return " : ::"+this.no +" "  +i;
    }
}
class No  {

}
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    Path p = Paths.get("myfile.txt");
    new BufferedReader(new FileReader("myfile.txt")).lines()
                    .forEach(System.out::println);
    System.out.println("------After processus-------");
    serialize(new Objet(),p);
        new BufferedReader(new FileReader("myfile.txt")).lines()
                .forEach(System.out::println);
        deserialize();
    }

    private static void serialize(Objet objet, Path p) throws IOException {

        var out=new ObjectOutputStream(new FileOutputStream(p.toString()));
        out.writeObject(objet);
        out.close();
    }

    private static void deserialize() throws IOException, ClassNotFoundException {

        var in=new ObjectInputStream(new FileInputStream("myfile.txt"));
        if(in.readObject() instanceof Objet o)
            System.out.println(o.toString());
        in.close();
    }


}

