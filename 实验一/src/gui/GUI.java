package gui;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import map.Map;
//import 
public class GUI { 
	JFrame jframe=new JFrame();
	JPanel jpanel=new JPanel();
	Map map;
	public void  show()
	{
		jframe=new JFrame();
		jframe.setSize(600,600);
		jpanel=new JPanel();
    	jpanel.setBounds(0,0,400,400);
    	map=new Map(); 
    	//int count=0;
    	jframe.setTitle("生命游戏");
    	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jframe.setLocationRelativeTo(null);
    	jframe.add(jpanel);
    	jframe.setVisible(true);
    	jpanel.setVisible(true);
    	Graphics g=jpanel.getGraphics();
    	
    	for(int i=0;i<map.xMax;i++) {
    		for(int j=0;j<map.yMax;j++) {
    			g.drawRect(i*25, j*25, 25, 25);
    		}
    	}
    	for(int i=0;i<map.xMax;i++) {
    		for(int j=0;j<map.yMax;j++) {
    			if(map.cell[i][j].getDeath()==true) {
    				g.fillRect(i*25, j*25, 25, 25);
    			}
    			else {
    				g.drawRect(i*25, j*25, 25, 25);
    			}
    		}
    	}
    	long d1= System.currentTimeMillis();
    	while(true) {
    		long d2= System.currentTimeMillis();
    		if(d2-d1>3000) {
    			//int change;
    			d1=d2;
    			jframe.repaint();
    			for(int i=0;i<map.xMax;i++) {
    	    		for(int j=0;j<map.yMax;j++) {
    	    			g.drawRect(i*25, j*25, 25, 25);
    	    		}
    	    	}
    			for(int i=0;i<map.xMax;i++) {
    				for(int j=0;j<map.yMax;j++) {
    					if(map.cell[i][j].getDeath()==true) {
    	    				g.fillRect(i*25, j*25, 25, 25);
    	    			}
    	    			else {
    	    				g.drawRect(i*25, j*25, 25, 25);
    				    }
    				}
    			}
    			
    			for(int i=0;i<map.xMax;i++) {
    	    		for(int j=0;j<map.yMax;j++) {
    	    			map.cell[i][j].setSituation(map.getLiving(map.cell[i][j]));
    	    		}
    	    	}
    		  /*  count++;
    		    jframe.setTitle("这是第"+count+"次演化");
    			if(count>20) break;*/
    	    }	    	
      }
}
}


