package paint_manager;

public class Room {
	private double length;
	private double width;
	private double height;
	
	
	public Room(double length, double width, double height) throws IllegalArgumentException{
		if (length <= 0 || width <= 0 || height <= 0) {
			throw new IllegalArgumentException();
		}
		
		this.length = length;
		this.width = width;
		this.height = height;
	}

	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public double getFloorArea() {
		return length * width;
	}

	public double getVolume() {
		return length * width * height;
	}

}
