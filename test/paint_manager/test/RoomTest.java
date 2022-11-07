package paint_manager.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import paint_manager.Room;

public class RoomTest {
	// dimensions of the test room
	private double length;
	private double width;
	private double height;
	private Room testRoom = null;
	
	/**
	 *  The room constructor must only accept strictly positive arguments.
	 */
	@Test
	public void testCreateInvalidRoom1() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			testRoom = new Room(0.0, 0.0, 0.0);
		});
		
		assertEquals("Arguments less than or equals to zero", exception.getMessage());
	}
	
	@Test
	public void testCreateInvalidRoom2() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			testRoom = new Room(-1.0, -1.0, -1.0);
		});
		
		assertEquals("Arguments less than or equals to zero", exception.getMessage());
	}
	
	@Test
	public void testCreateInvalidRoom3() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			testRoom = new Room(13.0, 5.0, 0.0);
		});
		
		assertEquals("Arguments less than or equals to zero", exception.getMessage());
	}
	
	@Test
	public void testCreateInvalidRoom4() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			testRoom = new Room(13.0, 0.0, 5.0);
		});
		
		assertEquals("Arguments less than or equals to zero", exception.getMessage());
	}
	
	@Test
	public void testCreateInvalidRoom5() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			testRoom = new Room(0.0, 5.0, 12.0);
		});
		
		assertEquals("Arguments less than or equals to zero", exception.getMessage());
	}
	
	@Test
	public void testCreateInvalidRoom6() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			testRoom = new Room(17.0, 3.0, -1.0);
		});
		
		assertEquals("Arguments less than or equals to zero", exception.getMessage());
	}
	
	@Test
	public void testCreateInvalidRoom7() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			testRoom = new Room(17.0, -1.0, 3.0);
		});
		
		assertEquals("Arguments less than or equals to zero", exception.getMessage());
	}
	
	@Test
	public void testCreateInvalidRoom8() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			testRoom = new Room(-1.0, 17.0, 3.0);
		});
		
		assertEquals("Arguments less than or equals to zero", exception.getMessage());
	}
	
	/**
	 * When positive arguments are provided, the room constructor creates an object successfully.
	 * Furthermore, the user can retrieve the dimensions used when creating the object.
	 */
	@Test
	public void testCreateValidRoom() {
		length = 13.5;
		width = 4.7;
		height = 5;
		testRoom = new Room(length, width, height);
		
		assertNotNull(testRoom);
		assertEquals(13.5, testRoom.getLength());
		assertEquals(4.7, testRoom.getWidth());
		assertEquals(5, testRoom.getHeight());
	}
	
	/**
	 * The Room object must return the correct area of the floor.
	 */
	@Test
	public void testGetFloorArea1() {
		length = 3;
		width = 5;
		height = 10;
		testRoom = new Room(length, width, height);
		
		assertEquals(15, testRoom.getFloorArea());
	}
	
	@Test
	public void testGetFloorArea2() {
		length = 6.5;
		width = 3.15;
		height = 4.7;
		testRoom = new Room(length, width, height);
		
		assertEquals(6.5 * 3.15, testRoom.getFloorArea());
	}
	
	/**
	 * The Room object must return the correct volume of the room.
	 */
	@Test
	public void testGetVolume1() {
		length = 5;
		width = 4;
		height = 3;
		testRoom = new Room(length, width, height);
		
		assertEquals(60.0, testRoom.getVolume());
	}
	
	@Test
	public void testGetVolume2() {
		length = 9.1;
		width = 7.2;
		height = 8.1;
		testRoom = new Room(length, width, height);
		
		assertEquals(9.1 * 7.2 * 8.1, testRoom.getVolume());
	}
}
