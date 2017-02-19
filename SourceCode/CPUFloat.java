
import java.lang.Thread;

class CPU {
	
	public void doCalculations()
	{
		float x = 0.65f;
		float y = 1.0098f;
		float res;
		int i=0;
		double[] GFLOPS = new double[600];
		for(int j=0; j< 600; j++)
		{
		double startTime = System.nanoTime();
		
		//while( i< 9999999)
		for(i=0; i<9999991; i++)
		{
		
			res = (0.67f*1.0909f)+(1.098f/0.90f);
			res = 0999.07896f*.0990f;
			res = 0999.07896f+0999.07896f;
			res = 0999.07896f - 9.09f;
			res = 9.0999f - 7.94f;
			res = 89.0098f -(70.8f + 2.0f);
			res = 8889.087f + 10.00f;
			/*res = 8909.f - 10.01f;
			res = 9987.098f + 20.01f;
			res = 19098.067f - 20.01f;
			res = 12230.9f + 30.01f;
			res = 1298.98f - 30.01f;
			res = 1890.87f + 30.08f;
			res = 1876.05f - 12389.098f;
			res = 14376.897f - 2.00f;
			res = 1234.08f + 2.00f;
			 res = 124059.0756f - 10.00f;
			 res = 1876.05f - 12389.098f;
			 res = 14376.897f - 2.00f;
			 res = 1234.08f + 2.00f;
			 res = 124059.0756f - 10.00f;
			 res = 16534.89f + (float)i;
			 res = 124059.0756f - 10.00f;
			 res = 1876.05f - 12389.098f;
			 res = 14376.897f - 2.00f;
			 res = 1234.08f + 2.00f;
			 res = 124059.0756f - 10.00f;
			 res = 16534.89f + (float)i;
			 res = 124059.0756f - 10.00f;
			 res = 16534.89f + (float)i;*/
			
			//i++;
		}
		double endTime = System.nanoTime();
		double totalTime = endTime - startTime;
		System.out.println("Time taken by CPU for floating point cals "+ (totalTime/1000000) + " milliseconds");
		
		System.out.println("No of GFLOPS:");
		GFLOPS[j] = (10*9999991)/totalTime ;
		
		//System.out.println("noOfGFlops " + GFLOPS[j]);
	}
	}

	
}
public class CPUFloat extends Thread {

	private String threadName;
	private Thread t;
	CPU CD;
	
	CPUFloat(String name, CPU cd)
	{
		threadName = name;
		CD = cd;
		System.out.println("Creating  "+threadName);
	}
	// run() method contains the instructions to be performed.
	public void run()
	{
		
		System.out.println("Running  " +threadName);		
			//System.out.println("Inside for loop  " + threadName +" " + i);
			// Putting thread to sleep
			//Thread.sleep(50);
		synchronized(CD)
		{
		CD.doCalculations();
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
		CPU demoObj = new CPU();
		CPUFloat T1 = new CPUFloat("Thread-1", demoObj );
		T1.start();
		
		CPUFloat T2 = new CPUFloat("Thread-2", demoObj);
		T2.start();
		
		CPUFloat T3 = new CPUFloat("Thread-3", demoObj);
		T3.start();
		
		CPUFloat T4 = new CPUFloat("Thread-4", demoObj);
		T4.start();
		
		try{
			
		T1.join();
		T2.join();
		T3.join();
		T4.join();
			
		}catch(Exception e)
		{
			System.out.println("Interrupted");
		}
		
	}
	
}
