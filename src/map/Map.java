//地图文件，主要负责主函数的调用，获取细胞周围活细胞数目，以及设定细胞的生死，初始化所有细胞

package map;

import java.util.Random;

import cell.Cell;
import gui.Gui;

public class Map {
	//地图的规格
	public int xMax = 100; //地图纵向最大方格数
	public int yMax = 100; //地图横向最大方格数
	public int side = 5; //边长
	//细胞丛
	public Cell[][] cell = new Cell[xMax][yMax];
	public Cell[][] cell1 = new Cell[xMax][yMax];

	public Map() {
		initial();
	}

	public static void main(final String[] args) {
		Map map = new Map();
		map.initial();
		Gui gui = new Gui();
		//cell1=new Cell[xMax][yMax];
		//map.cell1=map.cell;
		gui.start();
    }

	public final void initial() {
		Random random = new Random();
		//cell=new Cell[xMax][yMax];

    	for (int i = 0; i < xMax; i++) {
    		for (int j = 0; j < yMax; j++) {
    			cell[i][j] = new Cell(i, j);
    			cell[i][j].setLife((int) random.nextInt(2));
    		}
    	}
    }

	public final int getLiving(final Cell cell, final boolean lastcondition[][]) {
		int x = cell.getX(), y = cell.getY();
		int count = 0;

		//一般情况
		if (x >= 1 && x < xMax - 1 && y >= 1 && y < yMax - 1) {
			for (int i = x - 1; i <= x + 1; i++) {
				for (int j = y - 1; j <= y + 1; j++) {
					if (lastcondition[i][j]) {
						count++;
					}
				}
			}
			if (!this.cell[x][y].getDeath()) {
			     return count;
			} else {
			     return count - 1;
			}
		} else if (x == 0 && y == 0) {
			//顺时针讨论边界情况
			//在左上角
			for (int i = 0; i <= 1; i++) {
				for (int j = 0; j <= 1; j++) {
					if (lastcondition[i][j]) {
						count++;
					}
				}
			}
			//if(cell.getDeath()==false)
			if (!this.cell[x][y].getDeath()) {
				return count;
			} else {
				return  count - 1;
			}
		} else if (x == 0 && y >= 1 && y < yMax - 1) {
			//在最上面一列
			for (int i = 0; i <= 1; i++) {
				for (int j = y - 1; j <= y + 1; j++) {
					if (lastcondition[i][j]) {
						count++;
					}
				}
			}
			if (!this.cell[x][y].getDeath()) {
				return count;
			} else {
				return count - 1;
			}
		} else if (x == 0 && y == yMax - 1) {
			//在右上角
			for (int i = 0; i <= 1; i++) {
				for (int j = yMax - 2; j <= yMax - 1; j++) {
					if (lastcondition[i][j]) {
						count++;
					}
				}
			}
			if (!this.cell[x][y].getDeath()) {
				return count;
			} else {
				return count - 1;
				}
		} else if (y == yMax - 1 && x >= 1 && x < xMax - 1) {
			//在最右边
			for (int i = x - 1; i <= x + 1; i++) {
				for (int j = yMax - 2; j <= yMax - 1; j++) {
					if (lastcondition[i][j]) {
						count++;
					}
				}
			}
			if (!this.cell[x][y].getDeath()) {
				return count;
			} else {
				return count - 1;
			}
		} else if (x == xMax - 1 && y == yMax - 1) {
			//在右下角
			for (int i = xMax - 2; i < xMax; i++) {
				for (int j = yMax - 2; j < yMax; j++) {
					if (lastcondition[i][j]) {
						count++;
					}
				}
			}
			if (!this.cell[x][y].getDeath()) {
				return count;
			} else {
				return count - 1;
			}
		} else if (x == xMax - 1 && y >= 1 && y < xMax - 1) {
			//最下边
			for (int i = xMax - 2; i < xMax; i++) {
				for (int j = y - 1; j <= y + 1; j++) {
					if (lastcondition[i][j]) {
						count++;
					}
				}
			}
			if (!this.cell[x][y].getDeath()) {
				return count;
			} else {
				return count - 1;
			}
		} else if (x == xMax - 1 && y == 0) {
			//在左下角
			for (int i = xMax - 2; i < xMax; i++) {
				for (int j = 0; j <= 1; j++) {
					if (lastcondition[i][j]) {
						count++;
					}
				}
			}
			if (!this.cell[x][y].getDeath()) {
				return count;
			} else {
				return count - 1;
			}
		} else {
			//在最左边一列
			for (int i = x - 1; i <= x + 1; i++) {
				for (int j = 0; j <= 1; j++) {
					if (lastcondition[i][j]) {
						count++;
					}
				}
			}
			if (!this.cell[x][y].getDeath()) {
				return count;
			} else {
				return count - 1;
			}
		}
	}

	//不使用initial()的构造函数
	public Map(final int xMax, final int yMax, final int side) {
		this.xMax = xMax;
		this.yMax = yMax;
		this.side = side;
	}

	public final void setCells() {
    	for (int i = 0; i < xMax; i++) {
    		for (int j = 0; j < yMax; j++) {
    			cell[i][j] = new Cell(i, j);
    			cell[i][j].setLife(0);
    		}
    	}
	}
}