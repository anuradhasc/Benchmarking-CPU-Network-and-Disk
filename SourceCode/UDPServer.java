//package CPU;

import java.io.*;
import java.net.*;

public class UDPServer  {

	public static void main(String args[]) {
		DatagramSocket sock = null;
		try {

			// Creating a server socket, parameter is local port number.
			sock = new DatagramSocket(5065);

			// buffer to receive incoming data
			byte[] buffer = new byte[1024];
			DatagramPacket incomingpack = new DatagramPacket(buffer, buffer.length);

			System.out.println("Server socket created. Waiting for incoming data");

			 //while(true)
			 //{
				sock.receive(incomingpack);
				byte[] data = incomingpack.getData();
				//System.out.println("Received from client. Sending reply");
				String incomingdata = new String(data, 0, incomingpack.getLength());
				incomingdata = "OK" + incomingdata;
				//System.out.print("Incoming data is " + incomingdata);
				DatagramPacket sendingback = new DatagramPacket(incomingdata.getBytes(), incomingdata.getBytes().length,
						incomingpack.getAddress(), incomingpack.getPort());
				sock.send(sendingback);

			byte[] buffer1 = new byte[65000];
			DatagramPacket incomingpack1 = new DatagramPacket(buffer1, buffer1.length);

			System.out.println("Server socket created. Waiting for incoming data");

			 //while(true)
			 //{
				sock.receive(incomingpack1);
				byte[] data1 = incomingpack1.getData();
				//System.out.println("Received from client. Sending reply");
				String incomingdata1 = new String(data1, 0, incomingpack1.getLength());
				incomingdata1 = "OK" + incomingdata1;
				//System.out.print("Incoming data is " + incomingdata);
				DatagramPacket sendingback1 = new DatagramPacket(incomingdata1.getBytes(), incomingdata1.getBytes().length,
						incomingpack1.getAddress(), incomingpack1.getPort());
				sock.send(sendingback1);
			 //}
		
			byte[] buffer2 = new byte[10];
			DatagramPacket incomingpack2 = new DatagramPacket(buffer2, buffer2.length);

			System.out.println("Server socket created. Waiting for incoming data");

			 //while(true)
			 //{
				sock.receive(incomingpack2);
				byte[] data2 = incomingpack2.getData();
				//System.out.println("Received from client. Sending reply");
				String incomingdata2 = new String(data2, 0, incomingpack2.getLength());
				incomingdata2 = "OK" + incomingdata2;
				//System.out.print("Incoming data is " + incomingdata);
				DatagramPacket sendingback2 = new DatagramPacket(incomingdata2.getBytes(), incomingdata2.getBytes().length,
						incomingpack2.getAddress(), incomingpack2.getPort());
				sock.send(sendingback2);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			
		}
	//	sock.close();
	}

}
