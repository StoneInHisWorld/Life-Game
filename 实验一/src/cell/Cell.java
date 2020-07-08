package cell;

public class Cell {

	//细胞属性
	boolean ifDead;
	//周围的细胞数
	int cellsSurround;
	//位置
	int x,y;
	
	public Cell(int x,int y) {
		this.x=x;
		this.y=y;
	}

	public void setLife(int ranNum) {
		if(ranNum==0)
			this.ifDead=false;
		else
			this.ifDead=true;
	}

//	public static void main(String[] args) {

//	}
	public void changeLife(boolean n) {
		
			this.ifDead=n;
		
	}
	public void setSurroun(int surround) {
		this.cellsSurround=surround;
	}
	
	public int getX() {
		return x;
	}	
	
	public int getY() {
		return y;
	}	

	public boolean getDeath() {
		return ifDead;
	}
	public void setSituation(int n) {
		if(n==3) {
			this.ifDead=false;//活
		}
		else if(n==1||n>3){
			this.ifDead=true;//不变
		}

	}
	
}