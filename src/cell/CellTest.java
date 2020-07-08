package cell;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CellTest {

	private static Cell cell = new Cell(0, 0);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetLife() {
		cell.setLife(0);
		assertEquals(false, cell.getDeath());
		cell.setLife(1);
		assertEquals(true, cell.getDeath());
	}

	@Test
	public void testSetSituation() {
		boolean lastTime;
		//使细胞活过来
		cell.setSituation(3);
		assertEquals(true, cell.getDeath());
		//细胞状况保持不变
		lastTime = cell.getDeath();
		cell.setSituation(2);
		assertEquals(lastTime, cell.getDeath());
		//使细胞死亡
		cell.setSituation(4);
		assertEquals(false, cell.getDeath());
		cell.setSituation(1);
		assertEquals(false, cell.getDeath());
		cell.setSituation(0);
		assertEquals(false, cell.getDeath());
		//细胞状况保持不变
		lastTime = cell.getDeath();
		cell.setSituation(2);
		assertEquals(lastTime, cell.getDeath());
	}

}
