//package cloud;

import java.io.*;
import java.net.*;

public class Client {
	
    public static void main(String[] args) throws IOException {

        String serverHostname = new String ("172.31.34.51");

       // if (args.length > 0)
         //  serverHostname = args[0];
        System.out.println ("Attemping to connect to host " +
                serverHostname + " on port 5052.");

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        char[] arr = new char[1024*64];
        //char[] arr1 = new char[1024];
        char[] arr2 = new char[10];

		for(int i=0; i<1024*64; i++)
		{
			arr[i] = 'e';
		}
        char[] arr1 = new char[1024];
        for(int i=0; i<1024; i++)
        {
            arr1[i] = 'e';
        }
        for(int i=0; i<10; i++)
        {
            arr2[i] = 'e';
        }
		String fromserver;
        try {
            echoSocket = new Socket(serverHostname, 5052);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            double startTime = System.nanoTime();
			//System.out.println(startTime);

			out.println(arr);
			//System.out.println("From client: array passed");
			//out.println("hey again");
			//out.println("hey again again");

			fromserver = in.readLine();
			double endTime = System.nanoTime();
			System.out.println(endTime);
			//System.out.println("From server"+fromserver);
			double totalTime = (endTime - startTime)/1000;
			double throughput = 1024*64/totalTime;
			System.out.println("Thread1: Throughput for 64 KB is "+ throughput +"MB/s");
			System.out.println("Thread1: Latency for 64 KB is "+ totalTime/1000 + " ms ");

            startTime = System.nanoTime();
            //System.out.println(startTime);

            out.println(arr1);
            //System.out.println("From client: array passed");
            //out.println("hey again");
            //out.println("hey again again");

            fromserver = in.readLine();
            endTime = System.nanoTime();
            System.out.println(endTime);
            //System.out.println("From server"+fromserver);
            totalTime = (endTime - startTime)/1000;
            throughput = 1024/totalTime;
            System.out.println("Thread1: Throughput for 1 KB is "+ throughput +"MB/s");
            System.out.println("Thread1: Latency for 1 KB is "+ totalTime/1000 + " ms ");

            startTime = System.nanoTime();
            //System.out.println(startTime);

            out.println(arr2);
            //System.out.println("From client: array passed");
            //out.println("hey again");
            //out.println("hey again again");

            fromserver = in.readLine();
            endTime = System.nanoTime();
            System.out.println(endTime);
            //System.out.println("From server"+fromserver);
            totalTime = (endTime - startTime)/1000;
            throughput = 10/totalTime;
            System.out.println("Thread1: Throughput for 1 B is "+ throughput +"MB/s");
            System.out.println("Thread1: Latency for 1 B is "+ totalTime/1000 + " ms ");

        
        
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: " + serverHostname);
            System.exit(1);
        }

	/*BufferedReader stdIn = new BufferedReader(
                                   new InputStreamReader(System.in));
	String userInput;

        System.out.println ("Type Message (\"Bye.\" to quit)");
        byte[] arr = new byte[1024];
        for(int i=0; i< 1024; i++)
        {
        	arr[i] = 'a';
        }
	while ((userInput = stdIn.readLine()) != null) 
           {
	    out.println(userInput);

            // end loop
            if (userInput.equals("Bye."))
                break;

	    System.out.println("echo: " + in.readLine());
	   }*/

	out.close();
	in.close();
	echoSocket.close();
    }
}
