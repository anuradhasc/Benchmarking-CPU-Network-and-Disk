//package CPU;

import java.io.*;
import java.net.*;

public class UDPClient implements Runnable{
	
	public void run()
	{
		DatagramSocket sock = null;
		int port = 5065;
		String s;
		try{
			
				sock = new DatagramSocket();		
				InetAddress host = InetAddress.getByName("172.31.34.51");
					
				byte[] arr = new byte[1024];
				for(int i=0; i<1024; i++)
				{
					arr[i] = 'e';
				}
				
				byte[] arr1 = new byte[65000];
				for(int i=0; i<65000; i++)
				{
					arr1[i] = 'e';
				}
				
				byte[] arr2 = new byte[10];
				for(int i=0; i<10; i++)
				{
					arr2[i] = 'e';
				}
					
				// buffer for receiving server msg.
				byte[] buffer = new byte[1024];
				
				double startTime = System.nanoTime()/1000000;
		
				DatagramPacket dp = new DatagramPacket(arr, arr.length, host, port);
				//System.out.println("STarttime"+startTime);
				
				sock.send(dp);
				//System.out.print("Data sent");
				//waiting for reply
				DatagramPacket replyFromServer = new DatagramPacket(buffer, buffer.length);
				sock.receive(replyFromServer);
				
				double endTime = System.nanoTime()/1000000;
				System.out.println(endTime);

				byte[] data = replyFromServer.getData();
				
				double totalTime = (endTime - startTime)/1000;
				double throughput = 1024/totalTime;
							
				System.out.println("Throughput for 1 KB is "+ throughput +"B/s");
				System.out.println("Latency for 1 KB is "+ totalTime + " ms ");

				byte[] buffer1 = new byte[65000];
				
				startTime = System.nanoTime()/1000000;
		
				DatagramPacket dp1 = new DatagramPacket(arr1, arr1.length, host, port);
				//System.out.println("STarttime"+startTime);
				
				sock.send(dp1);
				//System.out.print("Data sent");
				//waiting for reply
				DatagramPacket replyFromServer1 = new DatagramPacket(buffer1, buffer1.length);
				sock.receive(replyFromServer1);
				
				endTime = System.nanoTime()/1000000;
				System.out.println(endTime);

				//byte[] data = replyFromServer.getData();
				
				totalTime = (endTime - startTime)/1000;
				throughput = 650000/totalTime;
							
				System.out.println("Throughput for 64 KB is "+ throughput +"B/s");
				System.out.println("Latency for 64 KB is "+ totalTime + " ms ");
				
				byte[] buffer2 = new byte[10];
				
				startTime = System.nanoTime()/1000000;
		
				DatagramPacket dp2 = new DatagramPacket(arr2, arr2.length, host, port);
				//System.out.println("STarttime"+startTime);
				
				sock.send(dp2);
				//System.out.print("Data sent");
				//waiting for reply
				DatagramPacket replyFromServer2 = new DatagramPacket(buffer2, buffer2.length);
				sock.receive(replyFromServer2);
				
				endTime = System.nanoTime()/1000000;
				System.out.println(endTime);

				//byte[] data = replyFromServer.getData();
				
				totalTime = (endTime - startTime)/1000;
				throughput = 10/totalTime;
							
				System.out.println("Throughput for 1 B is "+ throughput +"B/s");
				System.out.println("Latency for 1 B is "+ totalTime + " ms ");
				
				sock.close();
				
			
		}catch(IOException io)
		{
			System.out.println("Exception "+ io);
		}
		
	}
	public static void echo(String msg)
    {
        System.out.println(msg);
    }
	
//	public static void main(String args[])
//	{
//		Thread threadClient = new Thread(new UDPClient());
//		System.out.print("Starting thread1");
//		threadClient.start();
//		Thread threadClient1 = new Thread(new UDPClient());
//		System.out.print("Starting thread2");
//
//		threadClient1.start();
//
//		/*try {
//			threadClient.join();
//			threadClient1.join();
//
//		} catch (Exception e) {
//			System.out.println("Thread Interrupted" + e);
//		}*/
//
//	}
	
	public static void main(String[] args) {
		//UDPServer server = new UDPServer();
		//Thread udpthread = new Thread(server);
		// server.run();
		Thread threadClient = new Thread(new UDPClient());
		Thread threadClient1 = new Thread(new UDPClient());
		threadClient.start();
		threadClient1.start();

		try {
			threadClient.join();
			threadClient1.join();

		} catch (Exception e) {
			System.out.println("Thread Interrupted" + e);
		}

	}
	
}
