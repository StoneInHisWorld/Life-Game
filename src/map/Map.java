//��ͼ�ļ�����Ҫ�����������ĵ��ã���ȡϸ����Χ��ϸ����Ŀ���Լ��趨ϸ������������ʼ������ϸ��

package map;

import java.util.Random;

import cell.Cell;
import gui.Gui;

public class Map {
	//��ͼ�Ĺ��
	public int xMax = 100; //��ͼ������󷽸���
	public int yMax = 100; //��ͼ������󷽸���
	public int side = 5; //�߳�
	//ϸ����
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

		//һ�����
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
			//˳ʱ�����۱߽����
			//�����Ͻ�
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
			//��������һ��
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
			//�����Ͻ�
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
			//�����ұ�
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
			//�����½�
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
			//���±�
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
			//�����½�
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
			//�������һ��
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

	//��ʹ��initial()�Ĺ��캯��
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