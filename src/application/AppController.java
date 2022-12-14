package application;

import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import paint_manager.PaintManager;
import paint_manager.Room;

/**
 * This application acts as a controller for the main scene of the application
 * and allows the app to be interactive.
 * @author Tudor-Nicolae Cotoc
 *
 */
public class AppController {
	// instead of  length, width, height
	// JavaFX uses width,  depth, height
	@FXML private TextField width;
	@FXML private TextField depth;
	@FXML private TextField height;
	@FXML private TextField layers;
	@FXML private Label errorMessage;
	
	@FXML private Box cuboid;
	@FXML private VBox resultsBox;
	@FXML private Label floorArea;
	@FXML private Label volume;
	@FXML private Label paintNeeded;
	
	// unit of length in pixels
	final static int LENGTH_UNIT = 100;
	
	/**
	 * This function is executed whenever the "Compute" button is pressed.
	 */
	public void compute() {
		double w;
		double d;
		double h;
		int l;
		// input validation
		try {
			w = Double.parseDouble(width.getText());
			if (w <= 0) {
				errorMessage.setText("Length must be a positive!");
				errorMessage.setVisible(true);
				return;
			}
		} catch (Exception e) {
			errorMessage.setText("Length must be a number!");
			errorMessage.setVisible(true);
			return;
		}
		
		try {
			d = Double.parseDouble(depth.getText());
			if (d <= 0) {
				errorMessage.setText("Width must be a positive!");
				errorMessage.setVisible(true);
				return;
			}
		} catch (Exception e) {
			errorMessage.setText("Width must be a number!");
			errorMessage.setVisible(true);
			return;
		}
		
		try {
			h = Double.parseDouble(height.getText());
			if (h <= 0) {
				errorMessage.setText("Height must be a positive!");
				errorMessage.setVisible(true);
				return;
			}
		} catch (Exception e) {
			errorMessage.setText("Height must be a number!");
			errorMessage.setVisible(true);
			return;
		}
		
		try {
			l = Integer.parseInt(layers.getText());
			if (l <= 0) {
				errorMessage.setText("Nr. of layers must be positive!");
				errorMessage.setVisible(true);
				return;
			}
		} catch (Exception e) {
			errorMessage.setText("Nr. of layers must be a number!");
			errorMessage.setVisible(true);
			return;
		}
		
		errorMessage.setVisible(false);
		setCuboid(w, d, h);
		setResults(w, d, h, l);
	}

	/**
	 * This function will compute the floor area, volume and paint needed according to user input,
	 * then display the results in the results box.
	 * @param w - width (length)
	 * @param d - depth (width)
	 * @param h - height
	 * @param l - layers of paint
	 */
	private void setResults(double w, double d, double h, int l) {
		Room room = new Room(w, d, h);
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		floorArea.setText("Area of the floor is: " + df.format(room.getFloorArea()) + " square meters.");
		volume.setText("Volume of the room is: " + df.format(room.getVolume()) + " cubic meters.");
		paintNeeded.setText("Paint needed to paint the walls with " + l + " layer(s): " + df.format(PaintManager.getPaintNeeded(room, l)) + " litres of paint.");
		resultsBox.setVisible(true);
	}

	/**
	 * This function will resize the cuboid shape based on user input.
	 * @param w - width (length)
	 * @param d - depth (depth)
	 * @param h - height
	 */
	private void setCuboid(double w, double d, double h) {
		// rotate cuboid
		Transform t = new Rotate();
		t = t.createConcatenation(new Rotate(-10, Rotate.Y_AXIS));
		t = t.createConcatenation(new Rotate(10, Rotate.X_AXIS));
		cuboid.getTransforms().clear();
		cuboid.getTransforms().setAll(t);
		
		// scale the dimensions
		// I am not sure if this is the best way to do this,
		// but I wanted to make sure I maintain the ratios between the dimensions, 
		// while not making the cuboid too large.
		while (w > 5 || d > 5 || h > 5) {
			w /= 2;
			d /= 2;
			h /= 2;
		}
		
		cuboid.setWidth(LENGTH_UNIT * w);
		cuboid.setHeight(LENGTH_UNIT * h);
		cuboid.setDepth(LENGTH_UNIT * d);
		cuboid.setVisible(true);
	}
}
