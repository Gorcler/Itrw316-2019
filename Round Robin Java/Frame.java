import java.awt.*;
import java.lang.* ;
import java.awt.event.*;
import javax.swing.* ;
import java.util.* ;
import java.util.Timer ;
import java.util.TimerTask ;

public class Frame extends JFrame
{
	int countA = 0 ;
	int countB = 0 ;
	int countC = 0 ;
	
	JPanel aPanel = new JPanel() ;
	JPanel bPanel = new JPanel() ;
	JPanel cPanel = new JPanel() ;
	JPanel buttons = new JPanel() ;
	
	JLabel labelA = new JLabel("A") ;
	JLabel labelB = new JLabel("B") ;
	JLabel labelC = new JLabel("C") ;
	
	public JProgressBar progressA = new JProgressBar(0,10) ;
	public JProgressBar progressB = new JProgressBar(0,5) ;
	public JProgressBar progressC = new JProgressBar(0,8) ;
	
	JButton roundRobin = new JButton("Round Robin") ;
	JButton queue = new JButton("Multiple Queue") ;
	JButton priority = new JButton("Priority") ;
	
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
		
		//Adding components to frame in box layout
		add(box) ;
		
		//Panels
		box.add(aPanel) ;
		box.add(bPanel) ;
		box.add(cPanel) ;
		box.add(buttons);
		
		//Labels
		aPanel.add(labelA) ;
		bPanel.add(labelB) ;
		cPanel.add(labelC) ;
		
		//Progress bars
		aPanel.add(progressA) ;
		bPanel.add(progressB) ;
		cPanel.add(progressC) ;
		
		//Buttons
		buttons.add(priority) ;
		buttons.add(queue) ;
		buttons.add(roundRobin) ;
	}
	
	
	
	public void setProgressA(int proA)
	{
		progressA.setMaximum(proA);
	}
	
	public void setProgressB(int proB)
	{
		progressB.setMaximum(proB);
	}
	
	public void setProgressC(int proC)
	{
		progressC.setMaximum(proC);
	}
	
	public void incProgressA()
	{
		countA += 3 ;
		progressA.setValue(countA) ;
	}
	
	public void incProgressB()
	{
		countB += 3 ;
		progressB.setValue(countB) ;
	}
	
	public void incProgressC()
	{
		countC += 3 ;
		progressC.setValue(countC) ;
	}
}