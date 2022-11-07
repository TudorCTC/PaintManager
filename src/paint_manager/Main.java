package paint_manager;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double length = 0;
		double width = 0;
		double height = 0;
		int layers = 0;
		Room room = null;
		String command = "DEFAULT";
		System.out.println("Welcome to Paint Manager!\nPaint Manager expects the dimensions of the rooms to be in metres.");
		DecimalFormat format = new DecimalFormat();
		format.setMaximumFractionDigits(2);
		
		while (!command.equals("QUIT")) {
			System.out.println("Enter the length of the room:");
			try {
				length = in.nextDouble();
			} catch (Exception e) {
				System.out.println("The length needs to be a positive floating point number. Please try again.");
				in.nextLine();
				continue;
			}
			
			System.out.println("Enter the width of the room:");
			try {
				width = in.nextDouble();
			} catch (Exception e) {
				System.out.println("The width needs to be a positive floating point number. Please try again.");
				in.nextLine();
				continue;
			}
			
			System.out.println("Enter the height of the room:");
			try {
				height = in.nextDouble();
			} catch (Exception e) {
				System.out.println("The height needs to be a positive floating point number. Please try again.");
				in.nextLine();
				continue;
			}
			
			try {
				room = new Room(length, width, height);
			} catch(Exception e) {
				System.out.println("Room dimensions must be greater than 0. Please try again.");
				continue;
			}
			
			System.out.println("The following operations are available:");
			System.out.println("    FLOOR AREA - compute the are of the floor");
			System.out.println("    VOLUME - compute the volume of the room");
			System.out.println("    PAINT - compute the amount of paint needed");
			System.out.println("    NEW ROOM - create a new room");
			System.out.println("    QUIT - quit the program");
			System.out.println("Please enter the name of the operation you would like to perform.");
			command = "DEFAULT";
			
			while (!command.equals("NEW ROOM") && !command.equals("QUIT")) {
				command = in.nextLine();
				
				switch  (command) {
					case "FLOOR AREA":
						System.out.println("Area of the floor is: " + format.format(room.getFloorArea()) + " square metres.");
						break;
					case "VOLUME":
						System.out.println("The volume of the room is: " + format.format(room.getVolume()) + " cubic metres.");
						break;
					case "PAINT":
						System.out.println("How many layers would you like?");
						layers = 0;
						while (layers <= 0) {
							try {
								layers = in.nextInt();
								if (layers <= 0) System.out.println("The number of layers must be a positive integer. Please try again.");
							} catch (Exception e) {
								System.out.println("The number of layers must be a positive integer. Please try again.");
								in.nextLine();
							}
						}
						System.out.println("The amount of paint needed is: " + format.format(PaintManager.getPaintNeeded(room, layers)) + " litres.");
						break;
				}
			}
		}
		
		System.out.println("Goodbye!");
		in.close();
	}
}
