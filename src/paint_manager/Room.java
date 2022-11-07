package paint_manager;
/**
 * This class is meant to represent a real life physical room.
 * It provides utilities such as retrieving its dimensions, the floor area and so on.
 * @author Tudor-Nicolae Cotoc
 *
 */
public class Room {
	private double length;
	private double width;
	private double height;
	
	/**
	 * Creates a new room with the specified dimensions.
	 * @param length - the length of the room
	 * @param width - the width of the room
	 * @param height - the height of the room
	 * @throws IllegalArgumentException if any of the argument is less than or equal to 0
	 */
	public Room(double length, double width, double height) throws IllegalArgumentException{
		if (length <= 0 || width <= 0 || height <= 0) {
			throw new IllegalArgumentException("Arguments less than or equal to zero");
		}
		
		this.length = length;
		this.width = width;
		this.height = height;
	}

	/**
	 * Returns the length of the room.
	 * @return the length of the room
	 */
	public double getLength() {
		return length;
	}

	/**
	 * Returns the width of the room.
	 * @return the width of the room
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * Returns the height of the room.
	 * @return the height of the room.
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Returns the area of the floor in the room.
	 * @return the area of the floor
	 */
	public double getFloorArea() {
		return length * width;
	}

	/**
	 * Returns the volume of the room.
	 * @return the volume of the room.
	 */
	public double getVolume() {
		return length * width * height;
	}

}
