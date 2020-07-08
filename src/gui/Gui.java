package gui;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import map.Map;

public class Gui extends Thread {
  private JFrame jframe;
  private JPanel jpanel;
  private Map map;
  private Graphics g;

  public Gui() {
    jframe = new JFrame();
    jpanel = new JPanel();
    map = new Map();
  }

  //展示游戏界面
  public final void show() {
  //展示游戏界面
	int side = map.side;
	int length;
	int width;
	length = map.xMax * side;
	width = map.yMax * side;

	//把游戏界面画出来
    jframe.setSize(length + 100, width + 100);
    jpanel.setBounds(0, 0, length, width);
    jframe.setTitle("生命游戏");
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jframe.setLocationRelativeTo(null);
    jframe.add(jpanel);
    jframe.setVisible(true);
    g = jpanel.getGraphics();

    //开始画图
    jframe.update(g);
    for (int i = 0; i < map.xMax; i++) {
    	for (int j = 0; j < map.yMax; j++) {
    		g.drawRect(i * side, j * side, side, side);
    	}
    }
    for (int i = 0; i < map.xMax; i++) {
    	for (int j = 0; j < map.yMax; j++) {
    		if (map.cell[i][j].getDeath()) {
    			g.fillRect(j * side, i * side, side, side);
    		}
    	}
    }
}

	public final void run() {
		show();
		while (true) {
			try {
				sleep(2000);
				refresh();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public final void refresh() {
		int xMax = map.xMax;
		int yMax = map.yMax;
		int side = map.side;
		boolean[][] lastcondition = new boolean[map.xMax][map.yMax];
		map.cell1=map.cell;

	    //记录上一次图内的细胞存活情况
	    for (int i = 0; i < xMax; i++) {
	    	 for (int j = 0; j < yMax; j++) {
	    	    //map.cell1[i][j]=new Cell(i,j);
	    	    lastcondition[i][j] = map.cell[i][j].getDeath();
	    	    	//map.cell1[i][j].changeLife(map.cell[i][j].getDeath());
	    	 }
	    }
	    //计算下个方块的存活状况
	    for (int i = 0; i < xMax; i++) {
	    	for (int j = 0; j < yMax; j++) {
	    	    map.cell[i][j].setSituation(map.getLiving(
	    	    	map.cell[i][j], lastcondition));
	    	}
	    }

	    jpanel.update(g);
	    //画方块
	    for (int i = 0; i < xMax; i++) {
	    	for (int j = 0; j < yMax; j++) {
	    	    g.drawRect(i * side, j * side, side, side);
	    	}
	    }
	    //填充方块，存活细胞为黑
		for (int i = 0; i < map.xMax; i++) {
			for (int j = 0; j < map.yMax; j++) {
				if (map.cell[i][j].getDeath()) {
    				g.fillRect(j * side, i * side, side, side);
    			}
			}
		}
	}
}