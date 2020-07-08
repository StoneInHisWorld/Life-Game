package map;

import java.util.Random;

import cell.Cell;
import gui.GUI;

public class Map {

	//地图的规格
	 public  int xMax=5;

	 public  int yMax=5;
	
	//细胞丛
	public Cell[][] cell;
	
	public Map() {
		initial();
	}

	public static void main(String[] args) {
		Map map=new Map();
		map.initial();
		GUI gui=new GUI();
		gui.show();
		
      }
    
	
	public void initial() {
		Random random=new Random();
		cell=new Cell[xMax][yMax];
    	
    	for(int i=0;i<xMax;i++) {
    		for(int j=0;j<yMax;j++) {
    			cell[i][j]=new Cell(i,j);
    			cell[i][j].setLife((int)random.nextInt(2));
    			//cell[i][j].setStatus(1);
    		}
    	}
    }

	public int getLiving(Cell cell){
		int x=cell.getX(),y=cell.getY();
		int count=0;
		
		//一般情况
		if(x>=1&&x<xMax-1&&y>=1&&y<yMax-1) {
			for(int i=x-1;i<=x+1;i++)
				for(int j=y-1;j<y+1;j++)
					if(this.cell[i][j].getDeath()==false)
						count++;
			if(cell.getDeath()==true)
				return count;
			else
				return count-1;
		}
		
		//顺时针讨论边界情况
		//在左上角
		else if(x==0&&y==0) {
			for(int i=0;i<=1;i++)
				for(int j=0;j<=1;j++)
					if(this.cell[i][j].getDeath()==false)
						count++;
			if(cell.getDeath()==true)
				return count;
			else
				return count-1;
		}
			
		//在最上面一列
		else if(x==0&&y>=1&&y<yMax-1){
			for(int i=0;i<=1;i++)
				for(int j=y-1;j<=y+1;j++)
					if(this.cell[i][j].getDeath()==false)
						count++;
			if(cell.getDeath()==true)
				return count;
			else
				return count-1;
		}
		
		//在右上角
		else if(x==0&&y==yMax-1) {
			for(int i=x;i<=x+1;i++)
				for(int j=y-1;j<=y;j++)
					if(this.cell[i][j].getDeath()==false)
						count++;
			if(cell.getDeath()==true)
				return count;
			else
				return count-1;
		}
		
		//在最右边
		else if(y==yMax-1&&x>=1&&x<xMax-1){
			for(int i=x-1;i<=x+1;i++)
				for(int j=yMax-1;y<=yMax;y++)
					if(this.cell[i][j].getDeath()==false)
						count++;
			if(cell.getDeath()==true)
				return count;
			else
				return count-1;
		}
		
		//在右下角
		else if(x==xMax-1&&y==yMax-1) {
			for(int i=xMax-2;i<xMax;i++)
				for(int j=yMax-2;j<yMax;j++)
					if(this.cell[i][j].getDeath()==false)
						count++;
			if(cell.getDeath()==true)
				return count;
			else
				return count-1;
		}
		
		//最下边
		else if(x==xMax-1&&y>=1&&y<xMax-1){
			for(int i=xMax-2;i<xMax;i++)
				for(int j=y-1;j<=y+1;j++)
					if(this.cell[i][j].getDeath()==false)
						count++;
			if(cell.getDeath()==true)
				return count;
			else
				return count-1;
		}
		
		//在左下角
		else if(x==xMax-1&&y==0) {
			for(int i=xMax-2;i<xMax;i++)
				for(int j=0;j<=1;j++)
					if(this.cell[i][j].getDeath()==false)
						count++;
			if(cell.getDeath()==true)
				return count;
			else
				return count-1;
		}
		
		//在最左边一列
		else if(y==0&&x>=1&&x<xMax-1){
			for(int i=x-1;i<=x+1;i++)
				for(int j=0;j<=1;j++)
					if(this.cell[i][j].getDeath()==false)
						count++;
			if(cell.getDeath()==true)
				return count;
			else
				return count-1;
		}
		return count-1;
	}
}