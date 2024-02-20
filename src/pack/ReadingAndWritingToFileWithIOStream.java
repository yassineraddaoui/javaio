package pack;

import java.io.*;

public class ReadingAndWritingToFileWithIOStream {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            copyStreamByByte(new BufferedInputStream(new FileInputStream("file2.txt")),
                    new BufferedOutputStream(new FileOutputStream("file1.txt")));


            //TO read data more efficiently we could precise how many byte to read at a time
            copyStreamByBytes(
                    new BufferedInputStream(new FileInputStream("file2.txt")),
                    new BufferedOutputStream(new FileOutputStream("file1.txt")),
                    1024);

            copyStreamByCharacter(
                    new BufferedReader(new FileReader("file1.txt")),
                    new BufferedWriter(new FileWriter("file2.txt"))
                    );


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //READING DATA 1 BYTE AT A TIME
    static void copyStreamByByte(InputStream in , OutputStream out) throws IOException {
        //  we are reading and writing bytes !
        // WHY WE ARE USING AN INT INSTEAD OF BYTE
        // we need an extra value to indicate to end of stream
        int b;
        while ((b = in.read()) != -1) {
            out.write(b);
        }
    }

    static void copyStreamByBytes(InputStream in , OutputStream out,int batchSize) throws IOException {
        int b;
        while ((b = in.read(new byte[batchSize],0,batchSize)) != -1) {
            out.write(b);
            /*
            When data is written to an output stream, the underlying operating system does not guarantee that the data will make it to the file system immediately. The flush() method requests that all accumulated data be written immediately to
            disk.
            */
        }
    }
    static void copyStreamByCharacter(Reader in , Writer out) throws IOException{
        int b;
        while((b=in.read())!=-1){
            out.write(b);
        }
    }
    static void copyStreamByCharacters(File src , File dest) throws IOException{

        try(var reader =new BufferedReader(new FileReader(src));
        var writer = new BufferedWriter(new FileWriter(dest))
        ){
            String line=null;
            while((line= reader.readLine())!=null){
                writer.write(line);
                writer.newLine();
            }
        }
    }
    static void copyStreamByCharactersUsingPrintStream(File src , File dest) throws IOException{

        try(var reader =new BufferedReader(new FileReader(src));
            var writer = new PrintWriter(new FileWriter(dest))
        ){
            String line=null;
            while((line= reader.readLine())!=null){
               //methods in PrintStream does not throw checked exception !!!!!!
                //unlike other I/O Streams
                writer.println(line);
            }
        }
    }

}
