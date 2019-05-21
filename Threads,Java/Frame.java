import java.awt.*;
import java.lang.* ;
import java.awt.event.*;
import javax.swing.* ;
import java.util.* ;
import java.util.Timer ;
import java.util.TimerTask ;

public class Frame extends JFrame
{
	//creating frame
		JPanel aPanel = new JPanel() ;
		JPanel bPanel = new JPanel() ;
		JPanel cPanel = new JPanel() ;
		JPanel dPanel = new JPanel() ;
		JPanel ePanel = new JPanel() ;
		JPanel buttons = new JPanel() ;
	
	//buttons
		JButton normal = new JButton("Normal") ;
		JButton priority = new JButton("Priority") ;
		JButton roundRobin = new JButton("Round Robin") ;
		JButton queue = new JButton("Multiple Queue") ;
		JButton addProcess = new JButton("Add Process");
		JButton reset = new JButton("Reset") ;
		JButton exit = new JButton("Exit") ;
		
		//labels
		JLabel labelA = new JLabel("A") ;
		JLabel labelB = new JLabel("B") ;
		JLabel labelC = new JLabel("C") ;
		JLabel labelD = new JLabel("D") ;
		JLabel labelE = new JLabel("E") ;
		
		//progress bar's
		JProgressBar progressA = new JProgressBar(0,20) ;//20
		JProgressBar progressB = new JProgressBar(0,12) ;//12
		JProgressBar progressC = new JProgressBar(0,24) ;//24
		JProgressBar progressD = new JProgressBar(0,16) ;//16
		JProgressBar progressE = new JProgressBar(0,8) ;//8
		
		//sets layout for frame
		BorderLayout layout = new BorderLayout() ;
		Box box = Box.createVerticalBox() ;
		
	public Frame()
	{
		labelA.setVisible(true);
		labelB.setVisible(true) ;
		labelC.setVisible(true) ;
		labelD.setVisible(true) ;
		labelE.setVisible(true) ;
		
		progressA.setValue(0) ;
		progressA.setStringPainted(true);
		
		progressB.setValue(0) ;
		progressB.setStringPainted(true) ;
		
		progressC.setValue(0) ;
		progressC.setStringPainted(true);
		
		progressD.setValue(0) ;
		progressD.setStringPainted(true);
		
		progressE.setValue(0) ;
		progressE.setStringPainted(true);
		
		//adding components to frame in box layout
		add(box) ;
		//panels
		box.add(aPanel) ;
		box.add(bPanel) ;
		box.add(cPanel) ;
		box.add(dPanel) ;
		box.add(ePanel) ;
		box.add(buttons);
		
		//labels
		aPanel.add(labelA) ;
		bPanel.add(labelB) ;
		cPanel.add(labelC) ;
		dPanel.add(labelD) ;
		ePanel.add(labelE) ;
		
		//progress bars
		aPanel.add(progressA) ;
		bPanel.add(progressB) ;
		cPanel.add(progressC) ;
		dPanel.add(progressD) ;
		ePanel.add(progressE) ;
		
		//buttons
		buttons.add(addProcess) ;
		buttons.add(normal);
		buttons.add(priority) ;
		buttons.add(queue) ;
		buttons.add(roundRobin) ;
		buttons.add(reset) ;
		buttons.add(exit) ;
		
		
		//round robin and its action listner
		normal.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent msg)
			{
				addProcess.setEnabled(false) ;
				normal.setEnabled(false) ;
				priority.setEnabled(false) ;
				queue.setEnabled(false) ;
				roundRobin.setEnabled(false) ;
				
				Threads a = new Threads("A",5); //create new thread A
				a.setLoop(20) ; // burst time
				a.start() ;
				
				Threads b = new Threads("B",5); //create new thread B
				b.setLoop(12) ; // burst time
				b.start() ;
				
				Threads c = new Threads("C",5); //create new thread C
				c.setLoop(24); // burst time
				c.start() ;
				
				Threads d = new Threads("D",5); //create new thread D
				d.setLoop(16) ;//bust time
				d.start() ;
				
				Threads e = new Threads("E",5); //create new thread E
				e.setLoop(8) ; //burst time
				e.start() ;
				
				Timer timer = new Timer() ;
				TimerTask task = new TimerTask()
				{	
					public void run()
					{
						incProgressA(a.getProgress()) ;
						incProgressB(b.getProgress()) ;
						incProgressC(c.getProgress()) ;
						incProgressD(d.getProgress()) ;
						incProgressE(e.getProgress()) ;
						
						repaint() ;
						revalidate() ;
					}
				};
				timer.scheduleAtFixedRate(task,1,1);
				try 
				{
					Thread.sleep(1000); //pause thread
				} 
				catch (InterruptedException error) 
				{
					System.out.println("Main thread Interrupted");
				}
			}
		});
		
		//priority
		priority.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent msg)
			{
				addProcess.setEnabled(false) ;
				normal.setEnabled(false) ;
				priority.setEnabled(false) ;
				queue.setEnabled(false) ;
				roundRobin.setEnabled(false) ;
				
				Threads a = new Threads("A",8); //create new thread A
				a.setLoop(20) ; // burst time
				a.start() ;
				
				Threads b = new Threads("B",4); //create new thread B
				b.setLoop(12) ; // burst time
				b.start() ;
				
				Threads c = new Threads("C",5); //create new thread C
				c.setLoop(24); // burst time
				c.start() ;
				
				Threads d = new Threads("D",10); //create new thread D
				d.setLoop(16) ;//bust time
				d.start() ;
				
				Threads e = new Threads("E",2); //create new thread E
				e.setLoop(8) ; //burst time
				e.start() ;

			}
		});
		
		//multiple queues
		queue.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent e)
			{

			}
		});
		
		//round robin
		roundRobin.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		
		//reset frame and progress 
		reset.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent e)
			{
				addProcess.setEnabled(true) ;
				normal.setEnabled(true) ;
				priority.setEnabled(true) ;
				queue.setEnabled(true) ;
				roundRobin.setEnabled(true) ;
				
				aPanel.remove(progressA) ;
				bPanel.remove(progressB) ;
				cPanel.remove(progressC) ;
				dPanel.remove(progressD) ;
				ePanel.remove(progressE) ;
				

				aPanel.add(progressA) ;
				bPanel.add(progressB) ;
				cPanel.add(progressC) ;
				dPanel.add(progressD) ;
				ePanel.add(progressE) ;
		
				incProgressA(0) ;
				incProgressB(0) ;
				incProgressC(0) ;
				incProgressD(0) ;
				incProgressE(0) ;
				
				repaint();
				revalidate();
			}
		});
		
		//exit program
		exit.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent e)
			{
				System.exit(0) ;
			}
		});
	}
	
	//methods to increase values of pogressbars
	public void incProgressA(int countA)
	{
		progressA.setValue(countA) ;
	}
	
	public void incProgressB(int countB)
	{
		progressB.setValue(countB) ;
	}
	
	public void incProgressC(int countC)
	{
		progressC.setValue(countC) ;
	}
	
	public void incProgressD(int countD)
	{
		progressD.setValue(countD) ;
	}
	
	public void incProgressE(int countE)
	{
		progressE.setValue(countE) ;
	}
}