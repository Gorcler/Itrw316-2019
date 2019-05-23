import javax.swing.* ;
import java.lang.* ;

public class Threads extends Thread
{
	int time = 0 ;
	int count = 0 ;
	int quantumTime = 4 ;
	int quantumTimeCount = 0 ;
	int arrivalTime = 0 ;
	int burstTime = time ;
	int repeat = 0 ;
	String name;
	Thread t;

	//constructor
	Threads (String threadname, int priority)
	{
		name = threadname; 
		t = new Thread(this,name);
		t.setPriority(priority) ;
		try
		{
			t.join() ;
		}
		catch(Exception e)
		{
			System.out.println("Not joined");
		}
		t = Thread.currentThread() ;
		t.setPriority(priority) ;

		System.out.println("Thread Thread : " + Thread.currentThread());
		System.out.println("Thread : " + name + " Priority : " + getPriority()) ;
		System.out.println("Thread t : " + t + ", Priority : " + t.getPriority()) ;
	}
	
	public void setBT()
	{
		burstTime = burstTime - quantumTime ;
	}
	
	public int getBT()
	{
		return burstTime ;
	}
	
	public void setAT(int AT)
	{
		arrivalTime = AT ;
	}
	
	public void incQTC()
	{
		quantumTimeCount ++ ;
	}
	
	public int getQuantumTimeCount()
	{
		return quantumTimeCount ;
	}
	
	public int getProgress()
	{
		return count ;
	}
	
	public void setLoop(int loop)
	{
		time = loop ;
	}
	
	public int getLoop()
	{
		return time ;
	}
	
	@Override
	public void run() 
	{	
		try 
		{
			for(int i = 1; i <= time; i++) //run through thread
			{
				System.out.println(t.getName()+ " , " +  i);
				Thread.sleep(1000); //pause thread
				count++ ;
			}
		}
		catch (InterruptedException e) 
		{
			System.out.println(t + "Interrupted");
		}
		
		System.out.println(t + " exiting.");
	}
}

class MultiThread
{
	public static void main(String[] args) 
	{
		//frame 
		Frame pro = new Frame() ;
		pro.setVisible(true) ;
		pro.pack() ;
		pro.setSize(550,400) ;
		pro.setResizable(false);
		pro.setLocationRelativeTo(null) ;
		pro.setDefaultCloseOperation(pro.EXIT_ON_CLOSE) ;
	}
}