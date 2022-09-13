// Server program
 
import java.io.*;
import java.net.*;
 
class MyServer{
    public static void main(String[] args)
    {
        try {
           
            // establish connection
            ServerSocket serversocket
                = new ServerSocket(1355);
 
            System.out.println("server is busy");
            
        
 
            // Socket object to accept all the connections
            Socket socket = serversocket.accept();
            
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            System.out.println("I am ALIVE");
           
            // Printstream to print all the data
            PrintStream ps
                = new PrintStream(socket.getOutputStream());
 
            BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
           
            System.out.println(
                "Response sent");
           
            // Printing bufferedreader data
            ps.print(br.readLine());
            socket.close();
            serversocket.close();
        }
        catch (IOException e) {
           
            // Catch block for data stream errors
            System.out.println("Not found data for socket"
                               + e);
        }
    }
}