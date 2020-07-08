package cell;

public class Cell {

	//细胞属性
	private boolean ifDead;
	//周围的细胞数
	private int cellsSurround;
	//位置
	private int x, y;

	public Cell(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	public final void setLife(final int ranNum) {
		if (ranNum == 0) {
			this.ifDead = false; //死亡
		} else {
			this.ifDead = true; //存活
		}
	}

	public final void changeLife(final boolean n) {
			this.ifDead = n;
	}

	public final void setSurround(final int surround) {
		this.cellsSurround = surround;
	}

	public final int getX() {
		return x;
	}

	public final int getY() {
		return y;
	}

	public final boolean getDeath() {
		return ifDead;
	}

	public final void setSituation(final int n) {
		if (n == 3) {
			this.ifDead = true; //活
		} else if (n <= 1 || n > 3) {
			this.ifDead = false; //死亡
		}
	}
}