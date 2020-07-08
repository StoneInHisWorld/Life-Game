package map;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cell.Cell;

public class MapTest {

	private static Map map1;
	private static Map map2, map3;
	private static boolean[][] last1, last2, last3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		map1 = new Map(3, 3, 25);
		map2 = new Map(3, 3, 25);
		map3 = new Map(3, 3, 25);
		map1.setCells();
		map2.setCells();
		map3.setCells();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
    	//针对map1进行细胞生死赋值
		map1.cell[0][1].setLife(1);
		map1.cell[1][0].setLife(1);
		map1.cell[1][2].setLife(1);
		map1.cell[2][1].setLife(1);
		last1 = new boolean[map1.xMax][map1.yMax];
		for (int i = 0; i < map1.xMax; i++) {
		    for (int j = 0; j < map1.yMax; j++) {
		    	last1[i][j] = map1.cell[i][j].getDeath();
		    }
		}
		//针对map2进行细胞生死赋值
		map2.cell[0][2].setLife(1);
		map2.cell[1][1].setLife(1);
		map2.cell[2][0].setLife(1);
		last2 = new boolean[map2.xMax][map2.yMax];
		for (int i = 0; i < map2.xMax; i++) {
		    for (int j = 0; j < map2.yMax; j++) {
		    	last2[i][j] = map2.cell[i][j].getDeath();
		    }
		}
		//针对map3进行细胞生死赋值
		map3.cell[0][1].setLife(1);
		map3.cell[0][0].setLife(1);
		map3.cell[0][2].setLife(1);
		map3.cell[1][0].setLife(1);
		map3.cell[2][1].setLife(1);
		last3 = new boolean[map3.xMax][map3.yMax];
		for (int i = 0; i < map3.xMax; i++) {
		    for (int j = 0; j < map3.yMax; j++) {
		    	last3[i][j] = map3.cell[i][j].getDeath();
		    }
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetLiving() {
		//针对map1进行验证
		assertEquals(2, map1.getLiving(map1.cell[0][0], last1));
		assertEquals(2, map1.getLiving(map1.cell[0][1], last1));
		assertEquals(2, map1.getLiving(map1.cell[0][2], last1));
		assertEquals(2, map1.getLiving(map1.cell[1][0], last1));
		assertEquals(4, map1.getLiving(map1.cell[1][1], last1));
		assertEquals(2, map1.getLiving(map1.cell[1][2], last1));
		assertEquals(2, map1.getLiving(map1.cell[2][0], last1));
		assertEquals(2, map1.getLiving(map1.cell[2][1], last1));
		assertEquals(2, map1.getLiving(map1.cell[2][2], last1));
		//针对map2进行验证
		assertEquals(1, map2.getLiving(map2.cell[0][0], last2));
		assertEquals(2, map2.getLiving(map2.cell[0][1], last2));
		assertEquals(1, map2.getLiving(map2.cell[0][2], last2));
		assertEquals(2, map2.getLiving(map2.cell[1][0], last2));
		assertEquals(2, map2.getLiving(map2.cell[1][1], last2));
		assertEquals(2, map2.getLiving(map2.cell[1][2], last2));
		assertEquals(1, map2.getLiving(map2.cell[2][0], last2));
		assertEquals(2, map2.getLiving(map2.cell[2][1], last2));
		assertEquals(1, map2.getLiving(map2.cell[2][2], last2));
		//针对map3进行验证
		assertEquals(2, map3.getLiving(map3.cell[0][0], last3));
		assertEquals(3, map3.getLiving(map3.cell[0][1], last3));
		assertEquals(1, map3.getLiving(map3.cell[0][2], last3));
		assertEquals(3, map3.getLiving(map3.cell[1][0], last3));
		assertEquals(5, map3.getLiving(map3.cell[1][1], last3));
		assertEquals(3, map3.getLiving(map3.cell[1][2], last3));
		assertEquals(2, map3.getLiving(map3.cell[2][0], last3));
		assertEquals(1, map3.getLiving(map3.cell[2][1], last3));
		assertEquals(1, map3.getLiving(map3.cell[2][2], last3));
	}

}
