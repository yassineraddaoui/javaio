package Serialization;

import java.io.*;

public class StaticSerialization implements Serializable {
    transient String password="sjdfk"; //ignored
    static int i=1; //

    //NotSerializable a=null; //ignored
    //NotSerializable  a=new NotSerializable(); //Exception
    public static void main(String[] args) {
        var ob=new willbeSerializable();
        ob.x="changeMePlease";
        serialize(ob);
        deserialize();
    }

    private static void deserialize() {
        try(var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("file.txt")))) {
            while(true){
                var Object=in.readObject();
                if(Object instanceof willbeSerializable o)
                    System.out.println(o.x);
            }
        }
        catch (ClassNotFoundException classNotFoundException){
            System.out.println("ClassNotFound");
        }
        catch (EOFException eof){
            System.out.println("End Of file");
        }
        catch (IOException e) {
            System.out.println("IOException");
        }
    }

    private static void serialize(willbeSerializable willbeSerializable) {
        try(var out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("file.txt")))){
            out.writeObject(willbeSerializable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
class Father{
    String x= "My-freakingName";
      static int changeCount=0;
    Father(){
        changeCount++;
        System.out.println(changeCount);
        x="ChangedByFather";
    }
}
class willbeSerializable extends Father implements Serializable{
    static int guessMe=99;
    public willbeSerializable(){
        x=x+"Constructor call";
    }

    @Override
    public String toString() {
        return this.x;
    }
}