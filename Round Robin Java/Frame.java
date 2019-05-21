import java.awt.*;
import java.lang.* ;
import java.awt.event.*;
import javax.swing.* ;
import java.util.* ;
import java.util.Timer ;
import java.util.TimerTask ;

public class Frame extends JFrame
{
	
	JPanel aPanel = new JPanel() ;
	JPanel bPanel = new JPanel() ;
	JPanel cPanel = new JPanel() ;
	
	JLabel labelA = new JLabel("A") ;
	JLabel labelB = new JLabel("B") ;
	JLabel labelC = new JLabel("C") ;
	
	JProgressBar progressA = new JProgressBar(0,10) ;
	JProgressBar progressB = new JProgressBar(0,5) ;
	JProgressBar progressC = new JProgressBar(0,8) ;
	
	//sets layout for frame
	BorderLayout layout = new BorderLayout() ;
	Box box = Box.createVerticalBox() ;
	
	public Frame()
	{
		labelA.setVisible(true);
		labelB.setVisible(true) ;
		labelC.setVisible(true) ;
		
		progressA.setValue(0) ;
		progressA.setStringPainted(true);
		
		progressB.setValue(0) ;
		progressB.setStringPainted(true) ;
		
		progressC.setValue(0) ;
		progressC.setStringPainted(true);
		
		//adding components to frame in box layout
		add(box) ;
		
		//panels
		box.add(aPanel) ;
		box.add(bPanel) ;
		box.add(cPanel) ;
		
		//labels
		aPanel.add(labelA) ;
		bPanel.add(labelB) ;
		cPanel.add(labelC) ;
		
		//progress bars
		aPanel.add(progressA) ;
		bPanel.add(progressB) ;
		cPanel.add(progressC) ;
	}
	
	public void timer()
	{
		Timer timer = new Timer() ;
				TimerTask task = new TimerTask()
				{	
					public void run()
					{
						
						repaint() ;
						revalidate() ;
					}
				};
		timer.scheduleAtFixedRate(task,1,1);
	}
	
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
}