# PaintManager

This project is my solution to a software challenge proposed by a company. It was built using **Java 15**, **JavaFX 15**, **Scene Builder** and tested with **JUnit 5**. It was developed and tested on Linux (Ubuntu 20.04).

There are two options for running this project - it has both a **command line interface**, as well as a **graphical user interface**.

To run the **graphical user interface**, it is enough to run the script present in the repository:
```
$ ./run.sh
```

To run the **command line interface**, run this command in the terminal:
```
$ java -jar PaintManagerCLI.jar
```

# Development process
## Assumptions

When starting this project, I made a few assumptions:
  * When painting the walls, we would also like to paint the ceiling.
  * The dimensions for the rooms will be given in metres.
  * The rooms will be rectangular (cuboid in 3D) in shape.
  * You can apply paint in multiple layers.
  * The number of layers that can be applied is small enough that we do not need to be concerned with overflow.

## Design

After establishing the assumptions, I had to come up with a way to structure the project. Even though the problem specification was pretty straightforward, such that all of the logic could have been bundled in one PaintManager class, I thought it made more sense, both from a logical as well as an OOP perspective, to have two classes, PaintManager and Room.

By separating the logic like this, the Room objects can maintain the rooms' dimensions and provide information such as floor area or volume, while the PaintManager will only be concerned with logic exclusive to the painting process.

## Testing

I made use of the *TDD* paradigm while creatng this project and, as such, I started by writing tests for the PaintManager and Room classes. Even though the project was straightforward, I made sure the tests for as extensive as possible, especially when it comes to input validation.

## Programming

I found coding the logic of the system to be the fastest and easiest part of the project.

What took longer was creating the CLI program and the GUI, such that both of them provide pleasant and self-explanatory user experiences.

## Deployment

In order to deploy the CLI it was enough to export the project as a JAR with the CLI program as the main entry point.

Deploying the GUI app was more difficult because of the project depending on external JavaFX libraries. I ran into some issues with IDE specific tools for exporting JavaFX projects, but after numerous attempts to package the app cleanly, I figured that making the app run on other computers is the most important aspect. Therefore, I just added a copy of the JavaFX 15 SDK to the repository and wrote a script to eecute the full command required to run the app. While I believe this is not the cleanest method, it was the one that allowed me to ensure the project can be run on other machines.

Total time taken: 3 hours and 30 minutes for everything up until deployment.

## Documentation

I also wrote documentation for almost all the classes and their methods and left comments wherever I considered they were necessary. I admit that some of the methods are quite simple and explanatory just by their method signature, but I think that documentation never hurts.

# Possible improvements

If I had more time to work on the project, there are a few improvements that could be made:
  
  * Add extra functionality to the PaintManager and Room classes: ability to select a color when painting, support for different shaped rooms.
  * Refine and improve the GUI: for example, if we were to implement a paint color, it would be interesting if the color shade got more and more intense the more layers of paint are added.
  * Further testing - not just unit testing, but ensuring the project works on multiple platforms etc.
  * Finding a better packaging solution for the GUI. 
