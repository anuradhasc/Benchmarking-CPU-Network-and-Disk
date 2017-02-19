

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.IOException;
import java.lang.Thread;


class DiskOps_1 {

	public  void randWriteFile(int buffersize) {
		// TODO Auto-generated method stub
		//int position = 10;
		
		String filename = "writerand.txt";

		byte[] arr = new byte[buffersize];
		for(int i=0; i<buffersize; i++)
		{
			arr[i] = 'e';
		}

		try{
			RandomAccessFile file = new RandomAccessFile(filename, "rw");
		
			double startTime = System.nanoTime();
			
			for(int i=0; i< arr.length; i++)
			file.seek(getRandomposition(arr.length));
			file.write(arr);	
			
			double endTime = System.nanoTime();
			
			file.close();
			
			double totalTime = (endTime - startTime)/1000000000;
			//System.out.println(endTime);
			//System.out.println(startTime);
			//System.out.println(totalTime);

			System.out.println("Throughput for rand write a file of size "+ buffersize + " is "+ ((buffersize/totalTime)*2)/1000000 + " MB/s");
			System.out.println("Latency is "+totalTime+ "s");

			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}

	private long getRandomposition(int length) {
		// TODO Auto-generated method stub
		
		return (long)(Math.random())*length;
	}

	public int randReadFile(int buffersize) {
		// TODO Auto-generated method stub
		int dataRead = 0;
		String filename = "writerand.txt";
		try{
			
			RandomAccessFile file = new RandomAccessFile(filename, "rw");
			
			byte[] data = new byte[buffersize];
			//buffer.seek(3);
			double startTime = System.nanoTime();
			
			for(int i=0; i< buffersize; i++)
			file.seek(getRandomposition(buffersize));			
			//file.seek();
			dataRead = file.read(data);
			
			double endTime = System.nanoTime();

			System.out.println("no of bytes read"+dataRead);
			double totalTime = (endTime - startTime)/1000000000;
			System.out.println("Throughput for rand read a file of size "+ buffersize + " is "+ ((buffersize/totalTime)*2)/1000000 + " MB/s");
			System.out.println("Latency is "+totalTime+ "s");

			//System.out.println( totalTime/1000000 + "ms");
			
			file.read(data);
			file.close();
			
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		//System.out.println("data of file "+dataRead);
		return dataRead;
		
	}

	public  void readFile(int buffersize) throws IOException {
		// TODO Auto-generated method stub
		
		String filePath = "Test.txt";
		
		Path path = Paths.get(filePath);
		//File file = new File("C:\\Users\\Sanjay Chaudhary\\workspace_1\\cloud\\Data\\Test.txt");

		FileChannel fchannel = FileChannel.open(path);
		ByteBuffer buffer = ByteBuffer.allocate(buffersize);
		
		int noOfBytesRead;
		
		double startTime = System.nanoTime();
		
		noOfBytesRead = fchannel.read(buffer);
		
		double endTime = System.nanoTime();
		double totalTime = (endTime - startTime)/1000000000;
		System.out.println("Throughput for seq read of a file of size "+ buffersize + " is "+ ((buffersize/totalTime)*2)/1000000 + " MB/s");
		System.out.println("Latency is "+totalTime+ "s");

	//	System.out.println(totalTime/1000000 + "ms");
		fchannel.close();
			
	}
	public  void WriteFile(int buffersize) throws IOException
	{		
		byte[] arr = new byte[buffersize];
		
		for(int i=0; i<buffersize; i++)
		{
			arr[i] = 'e';
		}

		ByteBuffer buf = ByteBuffer.wrap(arr);
		
		//String filePath = "C:\\Users\\Sanjay Chaudhary\\workspace_1\\cloud\\Data\\Test.txt";
		File file = new File("Test.txt");
		FileOutputStream fos = new FileOutputStream(file.getAbsoluteFile());
		FileChannel fchannel = fos.getChannel();
		//System.out.println(buf.)
		
		double startTime = System.nanoTime();
		
		int noOfBytesWritten = fchannel.write(buf);
		
		double endTime = System.nanoTime();
		double totalTime = (endTime - startTime)/1000000000;

		System.out.println("Throughput for seq write a file of size "+ buffersize + " is "+ ((buffersize/totalTime)*2)/1000000 + " MB/s");
		System.out.println("Latency is "+totalTime+ "s");

//		System.out.println(totalTime/1000000 + "ms" + "Time taken to write " + noOfBytesWritten);
		fchannel.close();
		fos.close();
	
	}
	
	
	
}

public class callingDisk extends Thread{
	
		private String threadName;
		private Thread t;
		DiskOps_1 dops;
		
		callingDisk(String name, DiskOps_1 DP)
		{
			threadName = name;
			dops = DP;
			System.out.println("Creating  "+threadName);
		}
		// run() method contains the instructions to be performed.
		public void run()
		{
			
			System.out.println("Running  " +threadName);		
				//System.out.println("Inside for loop  " + threadName +" " + i);
				// Putting thread to sleep
				//Thread.sleep(50);
			synchronized(dops)
			{
			try {
				System.out.println("-------Readings for Sequential Write--------------------------------------------------------");
				System.out.println("Time taken for disk to write a file of 1 B");
				dops.WriteFile(10);
				System.out.println("Time taken for disk to write a file of 1 KB");
				dops.WriteFile(1024);
				System.out.println("Time taken for disk to write a file of 1 MB");
				dops.WriteFile(1024*1024);
				System.out.println();
				System.out.println("-------Readings for Sequential Read--------------------------------------------------------");
				System.out.println("Time taken for disk to read a file of 1 B");
				dops.readFile(10);
				System.out.println("Time taken for disk to read a file of 1 KB");
				dops.readFile(1024);
				System.out.println("Time taken for disk to read a file of 1 MB");
				dops.readFile(1024*1024);
				System.out.println();
				System.out.println("-------Readings for Randomly Reading a File-------------------------------------------------");
				System.out.println("Time taken for disk to randomly read a file of 1 B");
				dops.randReadFile(10);
				System.out.println("Time taken for disk to randomly read a file of 1 KB");
				dops.randReadFile(1024);
				System.out.println("Time taken for disk to randomly read a file of 1 MB");
				dops.randReadFile(1024*1024); 
				System.out.println();
				System.out.println("-------Readings for Radonmly Writing to a File-----------------------------------------------");
				System.out.println("Time taken for disk to randomly write a file of 1 B");
				dops.randWriteFile(10);
				System.out.println("Time taken for disk to randomly write a file of 1 KB");
				dops.randWriteFile(1024);
				System.out.println("Time taken for disk to randomly write a file of 1 MB");
				dops.randWriteFile(1024*1024);
				System.out.println();

			}
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			System.out.println(threadName + "Exiting");
		}
		
		public void start()
		{
			System.out.println("Starting" + threadName);
			if( t == null)
			{
				t = new Thread(this, threadName);
				t.start();
			}
		}
		
		public static void main(String[] args)
		{
			DiskOps_1 demoObj = new DiskOps_1();
			callingDisk T1 = new callingDisk("Thread-1", demoObj );
			T1.start();
			
			callingDisk T2 = new callingDisk("Thread-2", demoObj);
			T2.start();
			
			try{
				
			T1.join();
			T2.join();
				
			}catch(Exception e)
			{
				System.out.println("Interrupted");
			}
			
		}
		
	


}
