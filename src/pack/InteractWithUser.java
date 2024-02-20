package pack;

import java.io.*;
import java.util.Arrays;
import java.util.Locale;

public class InteractWithUser {
    public static void main(String[] args)  throws IOException {
        //readFromConsole();
        //printToConsole();
        //interactWithConsole();
        //interactWithReader(); // throws IO
    }

    private static void printToConsole() {
        PrintStream ps=new PrintStream(System.out);
        try(ps){
            ps.println("This is me from PrintStream");
        }

        PrintWriter out=new PrintWriter(System.out);
        try(out){
            out.print("This is me from PrintWriter");
        }

        BufferedWriter outB=new BufferedWriter(new OutputStreamWriter(System.out));
        try(outB){
            outB.write("This is me from BufferedWriter");
        }
        catch (IOException o){
            o.printStackTrace();
        }
    }

    public static void interactWithReader() throws IOException{
        var Reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput= Reader.readLine();
        System.out.println("u entered =" + userInput);
    }
    public static void interactWithConsole(){
        Console console = System.console();
        if (console != null) {
            String userInput = console.readLine();
            console.writer().println("You entered: " + userInput);
        } else {
            System.err.println("Console not available");
        }
    }
    public static void writeWithConsole() throws FileNotFoundException {
        Console console = System.console();
        console.writer()
                .println("Salut from console");
        console.format("your sold is %d $",255);
        console.writer().println();
        console.printf("age = %d years ",23);
        console.writer().format(new Locale("fr", "CA"), "Hello World");
        console.writer().append("append");
        var writer=console.writer();
        writer.println();
    }
    private void echo() throws IOException {
        var o = new FileWriter("new-zoo.txt");
        try (var f = new FileReader("zoo-data.txt");
             var b = new BufferedReader(f); o) {

            o.write(b.readLine());
        }
        o.write("");
    }
    public static void readFromConsole(){
        Console console = System.console();
        console.readLine();
        console.readLine("Give a name");
        char [] pass= console.readPassword("Give me a password");
        try{
            System.out.println(new InputStreamReader(System.in).read());
            System.out.println(new BufferedReader((new InputStreamReader(System.in))).readLine());
        }
        catch (IOException io){
            io.printStackTrace();
        }
        System.out.println(System.console().readLine());

    }
    public static void reviewConsoleMethods(){
        Console console = System.console();
        if (console == null) {
            throw new RuntimeException("Console not available");
        } else {
            String name = console.readLine("Please enter your name: ");
            console.writer().format("Hi %s", name);
            console.writer().println();
            console.format("What is your address? ");
            String address = console.readLine();
            char[] password = console.readPassword("Enter a password "
                    + "between %d and %d characters: ", 5, 10);
            char[] verify = console.readPassword("Enter the password again: ");
            console.printf("Passwords "
                    + (Arrays.equals(password, verify) ? "match" : "do not match"));
        }
    }
}
