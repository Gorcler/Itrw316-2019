// Java program for implementation of RR scheduling 
  
public class Scheduling	extends Thread
{ 
    // Method to find the wait time for all processes 
    static void waitTime(int processes[], int n, int bt[], int wt[], int quantum) 
    {
		Frame frm = new Frame();
		frm.setVisible(true) ;
		frm.pack() ;
		frm.setSize(300,200) ;
		frm.setResizable(false);
		frm.setLocationRelativeTo(null) ;
		frm.setDefaultCloseOperation(frm.EXIT_ON_CLOSE) ;
		frm.timer() ;
		
        // Create remaining burst times 
        int rem_bt[] = new int[n]; 
        for (int i = 0 ; i < n ; i++)
		{			
            rem_bt[i] =  bt[i]; 
		}
		
        int time = 0; // Current time 
		
        // Keep traversing processes in round robin manner until all of them are not done. 
        while(true) 
        { 
            boolean done = true; 
       
            // Traverse all processes one by one repeatedly 
            for (int i = 0 ; i < n; i++) 
            { 
                // If burst time of a process is greater than 0  then only need to process further 
                if (rem_bt[i] > 0) 
                { 
                    done = false; // There is a pending process 
       
                    if (rem_bt[i] > quantum) 
                    { 
                        // Increase the value of t i.e. shows  how much time a process has been processed 
                        time += quantum; 
       
                        // Decrease the burst_time of current process  by quantum 
                        rem_bt[i] -= quantum;
						System.out.println("Rem_BT: " + rem_bt[i]);
						try
						{
							Thread.sleep(1000) ;	
						}
						catch (InterruptedException e)
						{
							System.out.println("Fault") ;
							
						}
						
						if(processes[i] == 1)
						{
							frm.incProcess();
						}
						if(processes[i] == 2)
						{
							
						}
						if(processes[i] == 3)
						{
							
						}
						
						
                    } 
       
                    // If burst time is smaller than or equal to quantum. Last cycle for this process 
                    else
                    { 
                        // Increase the value of time to shows how much time a process has been processed 
                        time = time + rem_bt[i]; 
       
                        // Waiting time is current time minus time used by this process 
                        wt[i] = time - bt[i]; 
       
                        // As the process gets fully executed make its remaining burst time = 0 
                        rem_bt[i] = 0; 
                    } 
                } 
            } 
            // If all processes are done 
            if (done == true) 
			{
              break; 
			}
        } 
    } 
       
    // Method to calculate turn around time 
    static void findTurnAroundTime(int processes[], int n, int bt[], int wt[], int tat[]) 
    { 
        // calculating turnaround time by adding bt[i] + wt[i] 
        for (int i = 0; i < n ; i++)
		{			
			tat[i] = bt[i] + wt[i];
		}			
    } 
       
    // Method to calculate average time 
    static void avgTime(int processes[], int n, int bt[], int quantum) 
    { 
        int wt[] = new int[n], tat[] = new int[n]; 
        int total_wt = 0, total_tat = 0; 
       
        // Function to find waiting time of all processes 
        waitTime(processes, n, bt, wt, quantum); 
       
        // Function to find turn around time for all processes 
        findTurnAroundTime(processes, n, bt, wt, tat); 
       
        // Display processes along with all details 
        System.out.println("Processes " + " Burst time " + " Waiting time " + " Turn around time"); 
       
        // Calculate total waiting time and total turn around time 
        for (int i=0; i<n; i++) 
        { 
            total_wt = total_wt + wt[i]; 
            total_tat = total_tat + tat[i]; 
            System.out.println(" " + (i+1) + "\t\t" + bt[i] +"\t " + wt[i] +"\t\t " + tat[i]); 
        } 
       
        System.out.println("Average waiting time = " + (float)total_wt / (float)n); 
        System.out.println("Average turn around time = " + (float)total_tat / (float)n); 
    } 
      
    public static void main(String[] args) 
    {
        // process ID's 
        int processes[] = { 1, 2, 3}; 
        int n = processes.length; 
       
        // Burst time of all processes 
        int burst_time[] = {10, 5, 8}; 

        // Time quantum 
        int quantum = 3 ; 
        avgTime(processes, n, burst_time, quantum) ; 
		
    } 
} 
