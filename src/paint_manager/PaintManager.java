package paint_manager;
/**
 * This class is meant to provide utilities that are useful
 * in the process of painting a room.
 * @author Tudor-Nicolae Cotoc
 *
 */
public class PaintManager {
	/**
	 * This constant represents what area can be covered by one litre of paint.
	 * It is set to 6.5, an arbitrary value. 
	 */
	public static final double AREA_PER_PAINT_LITRE = 6.5;

	public static double getPaintNeeded(Room room, int layers) throws IllegalArgumentException {
		if (room == null) throw new IllegalArgumentException("Null object");
		if (layers <= 0) throw new IllegalArgumentException("Number of layers smaller than or equal to 0");
		
		double length = room.getLength();
		double width = room.getWidth();
		double height = room.getHeight();
		
		double wallArea = 2 * height * (length + width);
		double ceiling = length * width;
		double paintArea = wallArea + ceiling;
		
		return (paintArea / AREA_PER_PAINT_LITRE) * (double) layers;
	}

}
