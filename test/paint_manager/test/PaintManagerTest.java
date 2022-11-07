package paint_manager.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import paint_manager.PaintManager;
import paint_manager.Room;

public class PaintManagerTest {
	// dimensions of the test room
	private double length;
	private double width;
	private double height;
	// layers of paint
	private int layers;
	private Room testRoom;
	// volume of paint needed, in litres
	private double paint;
	
	/**
	 * The getPaintNeeded() method must throw an IllegalArgumentException when
	 * a null object is provided or the number of layers is less than or equal to zero.
	 */
	@Test
	public void testInvalidGetPaint1() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			paint = PaintManager.getPaintNeeded(null, 1);
		});
		
		assertEquals("Null object", e.getMessage());
	}
	
	@Test
	public void testInvalidGetPaint2() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			paint = PaintManager.getPaintNeeded(null, 0);
		});
		
		assertEquals("Null object", e.getMessage());
	}
	
	@Test
	public void testInvalidGetPaint3() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			double paint = PaintManager.getPaintNeeded(null, -1);
		});
		
		assertEquals("Null object", e.getMessage());
	}
	
	@Test
	public void testInvalidGetPaint4() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			testRoom = new Room(1, 2, 3);
			paint = PaintManager.getPaintNeeded(testRoom, 0);
		});
		
		assertEquals("Number of layers smaller than or equal to 0", e.getMessage());
	}
	
	@Test
	public void testInvalidGetPaint5() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			testRoom = new Room(1, 2, 3);
			paint = PaintManager.getPaintNeeded(testRoom, -1);
		});
		
		assertEquals("Number of layers smaller than or equal to 0", e.getMessage());
	}
	
	/**
	 * The getPaintNeeded() method must return the correct volume of paint when valid arguments are provided.
	 */
	
	@Test
	public void testGetPaint1() {
		length = 4;
		width = 3;
		height = 2;
		testRoom = new Room(length, width, height);
		
		double wallArea = 2 * height * (length + width);
		double ceiling = length * width;
		double paintArea = wallArea + ceiling;
		layers = 1;
		
		assertEquals((double) ((paintArea / PaintManager.AREA_PER_PAINT_LITRE) * layers), PaintManager.getPaintNeeded(testRoom, layers));
	}
	
	@Test
	public void testGetPaint2() {
		length = 4;
		width = 3;
		height = 2;
		testRoom = new Room(length, width, height);
		
		double wallArea = 2 * height * (length + width);
		double ceiling = length * width;
		double paintArea = wallArea + ceiling;
		layers = 2;
		
		assertEquals((double) ((paintArea / PaintManager.AREA_PER_PAINT_LITRE) * layers), PaintManager.getPaintNeeded(testRoom, layers));
	}
	
	@Test
	public void testGetPaint3() {
		length = 4.7;
		width = 2.5;
		height = 3.8;
		testRoom = new Room(length, width, height);
		
		double wallArea = 2 * height * (length + width);
		double ceiling = length * width;
		double paintArea = wallArea + ceiling;
		layers = 3;
		
		assertEquals((double) ((paintArea / PaintManager.AREA_PER_PAINT_LITRE) * layers), PaintManager.getPaintNeeded(testRoom, layers));
	}
}
