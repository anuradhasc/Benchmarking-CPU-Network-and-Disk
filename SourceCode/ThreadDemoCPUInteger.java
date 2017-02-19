
import java.lang.Thread;

 class CalculationDemo_Int {

	public void doCalculations()
	{
		int x = 10;
		int y = 11;
		int res;
		try{
			long i=0;
			
			//for(long i=0; i<999999999; i++)
			double[] IOPS =  new double[601];
			for(int j=0; j< 600; j++)
			{
			double startTime = System.nanoTime();
			while(i<99999991)
			{
				
					res = (10*10)+(10/10);
					res = 13*12;
					res = 10483905 + 15;
					res = 2944+ 10;
					/*res = 9 + 10933;
					res = 10000000 -(100 + 2);
					res = 11000 + 10;
					res = 23089 - 10;
					res = 7504 + 20;
					res = 8809 - 20;
					res = 7901 + 30;
					res = 99029 - 30;
					res = 10 - 10;
					res = 120 - 90;
					res = 30 -2;
					res = 1089+2;
					res = 90 - 10;
					res = 88 - 10;*/
					i++;

			}

		
			double endTime = System.nanoTime(); 
			double totalTime = endTime - startTime;
			System.out.println("Time taken by CPU for Integer point cals "+ totalTime/1000000 + "milliseconds");
			
			System.out.println("No of IOPS:");
			IOPS[j] = (7*9999991)/totalTime ;
			//System.out.print(8*99999999);
			//System.out.println("noOfIops " + IOPS[j]);
		}
		}catch(Exception e)
	
		{
		
		}
	}
}
 public class ThreadDemoCPUInteger extends Thread {

		private String threadName;
		private Thread t;
		CalculationDemo_Int CD;
		
		ThreadDemoCPUInteger(String name, CalculationDemo_Int cd)
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
			CalculationDemo_Int demoObj = new CalculationDemo_Int();
			ThreadDemoCPUInteger T1 = new ThreadDemoCPUInteger("Thread-1", demoObj );
			T1.start();
			
			ThreadDemoCPUInteger T2 = new ThreadDemoCPUInteger("Thread-2", demoObj);
			T2.start();
			
			ThreadDemoCPUInteger T3 = new ThreadDemoCPUInteger("Thread-3", demoObj);
			T3.start();
			
			ThreadDemoCPUInteger T4 = new ThreadDemoCPUInteger("Thread-4", demoObj);
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


