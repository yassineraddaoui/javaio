import java.io.*;


/*

 */
public class HowToWriteToTheConsole {
    public static void main(String[] args) throws IOException {
        write();
        write2();
        write3();
        write4();
        write5();
    }

    private static void write3() {
        Console c=System.console();
        if(c==null){
            System.out.println("Sorry Console is busy !! ");
            return;
        }
        c.printf("Hello from Console");
        c.writer()
                        .println("Hello from console writer !!");
        c.flush();

    }

    private static void write2() throws IOException {
        BufferedOutputStream outputStream =
                new BufferedOutputStream(System.out);
        outputStream.write("Hello from OutputStream\n".getBytes());
        outputStream.flush();
    }

    private static void write() throws IOException {
        BufferedWriter outputStream=
                new BufferedWriter(
                        new OutputStreamWriter(System.out)
                );
            outputStream.write("hello from Buffered writer");
        outputStream.newLine();
        outputStream.flush();
    }
    private static void write4() throws IOException {
        PrintWriter outputStream=
                new PrintWriter(new BufferedWriter(new PrintWriter(System.out)));
        outputStream.println("hello from PrintWriter");
        outputStream.flush();
    }
    private static void write5() throws IOException {

        OutputStream outputStream =
                new PrintStream(System.out);
        outputStream.write("hello from OutputStream".getBytes());
        outputStream.flush();
    }


}
