//package cloud;
import java.net.*; 
import java.io.*; 

public class Server implements Runnable
{ 
 protected Socket clientSocket;

 public static void main(String[] args) throws IOException 
   { 
    ServerSocket serverSocket = null; 

    try { 
         serverSocket = new ServerSocket(5052); 
         System.out.println ("Connection Socket Created");
         try { 
              while (true)
                 {
                  System.out.println ("Waiting for Connection");
                  //new EchoServer2 (serverSocket.accept()); 
                  new Thread(new Server(serverSocket.accept())).start();
                  new Thread(new Server(serverSocket.accept())).start();
                 }
             } 
         catch (IOException e) 
             { 
              System.err.println("Accept failed."); 
              System.exit(1); 
             } 
        } 
    catch (IOException e) 
        { 
         System.err.println("Could not listen on port: 5052."); 
         System.exit(1); 
        } 
    finally
        {
         try {
              serverSocket.close(); 
             }
         catch (IOException e)
             { 
              System.err.println("Could not close port: 5052."); 
              System.exit(1); 
             } 
        }
   }

 public Server (Socket clientSoc)
   {
    clientSocket = clientSoc;
   // start();
   }

 public void run()
   {
    System.out.println ("New Communication Thread Started");

    try { 
         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), 
                                      true); 
         BufferedReader in = new BufferedReader( 
                 new InputStreamReader( clientSocket.getInputStream())); 

         String inputLine; 

         while ((inputLine = in.readLine()) != null) 
             { 
             // System.out.println ("Server: " + inputLine); 
              out.println("Reply from Server"+inputLine); 
              out.println("Reply from Server"+inputLine); 
              out.println("Reply from Server"+inputLine); 

              if (inputLine.equals("Bye.")) 
                  break; 
             } 

         out.close(); 
         in.close(); 
         clientSocket.close(); 
        } 
    catch (IOException e) 
        { 
         System.err.println("Problem with Communication Server");
         System.exit(1); 
        } 
    }
} 