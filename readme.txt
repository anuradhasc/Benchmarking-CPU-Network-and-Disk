					Manual for Benchmarking
1. CPU:
* To run the floating point benchmarking of CPU, run the file name CPUFloat.java by opening the cmd and setting the path where the CPUFloat.java file is kept.
* First compile this file using: javac CPUFloat.java command on Linux terminal.
* Run it using command: java CPUFloat
* Output should look something like this:

    Fig 1: For GFLOPS average of no of GFLOPs  = 13.04 	











* Similarly, to run the integer point benchmarking of CPU, run the file name ThreadDemoCPUInteger.java by opening the cmd and setting the path where the ThreadDemoCPUInteger.java file is kept.
* Compile this file using: javac ThreadDemoCPUInteger.java command on Linux terminal.
* Run it using command: java ThreadDemoCPUInteger.
* Output should look something like this:

    Fig 2: For IOPS average of no of IOPs  = 13.04 GIOPS	
     
         








2. DISK:
* To run the benchmarking of DISK, run the file name callingDisk.java by opening the cmd and setting the path where the callingDisk.java file is kept.
* First compile this file using: javac callingDisk.java command on your cmd.
* Run it using command: java callingDisk
* Output file will be something like this:
       
      Fig 3: Throughput latency for Sequential read, write and Random read, write. 
      
      
      
      
      
      
      
      
      
      
      
3. Network (TCP):
* To run the TCP benchmarking of Network, first run the file name Server.java by opening the cmd and setting the path where the Server.java file is kept.
* Compile this file using: javac Server.java command on your cmd.
* Run it using command: java Server.
* Keep this terminal open and now open another terminal.
* In this terminal run Client.java by javac Client.java and then java Client commands.
* Output will be something like this:
       
Fig 4: TCP Server Client session

4. Network (UDP):
* To run the TCP benchmarking of Network, first run the file name Server.java by opening the cmd and setting the path where the Server.java file is kept.
* Compile this file using: javac Server.java command on your cmd.
* Run it using command: java Server.
* Keep this terminal open and now open another terminal.
* In this terminal run Client.java by javac Client.java and then java Client commands.
* Output will be something like this:

Figure 5: UDP Client Server session.
