
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author Henri Feinaj.
 *
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {

    
    
         //Instance variables
         private static int px;
         private static int py;
         private static int vx;
         private static int vy;
         private static boolean isFill;
         private static int r;
         private static int g;
         private static int b;
         private static int insert_time;
	// TODO: You will likely need to write four methods here. One method to
	// construct each shape
	// given the Scanner passed as a parameter. I would suggest static
	// methods in this case.

	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * 
	 * @param in
	 *            the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue<ClosedShape> readDataFile(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();
                
                 String shapeName = "";
                 while (in.hasNextLine()) { //check if has more lines
                        String line = in.nextLine();
                        
                        if(line.length()!=0){ //skip empty lines
                        Scanner inputLine =  new Scanner(line);//store valid line into scanner
                        shapeName=inputLine.next();//get shape name
                        
                        
                        //check which shape it's
                        if(shapeName.equals("circle") || shapeName.equals("square")){
                            
                            shapeQueue.enqueue(getCircleOrSquare(inputLine, shapeName));
                        }
                        
                        else if(shapeName.equals("oval") || shapeName.equals("rect") || shapeName.equals("line")){
                            shapeQueue.enqueue(getOvalOrRectangle(inputLine, shapeName));
                        }
                        
                        }
                }
		//Right now, returning an empty Queue.  You need to change this.
		return shapeQueue;
	}


        /**
         * Method used to get all relevant data from files for Circle or Square
         * and return the instance of ClosedShape
         * @param input
         * @param shapeType
         * @return 
         */
        public static ClosedShape getCircleOrSquare(Scanner input, String shapeType){
            ClosedShape shape = null;
            Color shapeColor = null;
            //check shape
            if(shapeType.equals("circle")){
                px = input.nextInt();
                py = input.nextInt();
                vx = input.nextInt();
                vx = input.nextInt();
                isFill = input.nextBoolean();
                int diameter = input.nextInt();
                r = input.nextInt();
                g = input.nextInt();
                b = input.nextInt();
                shapeColor = Color.rgb(r, g, b);
                insert_time = input.nextInt();
                
                //fill constructor
                shape = new Circle(insert_time, px, py, vx, vy,diameter,  shapeColor,isFill);
                System.out.println(shape.toString());
            }
            
            else if(shapeType.equals("square")){
                px = input.nextInt();
                py = input.nextInt();
                vx = input.nextInt();
                vx = input.nextInt();
                isFill = input.nextBoolean();
                int side = input.nextInt();
                r = input.nextInt();
                g = input.nextInt();
                b = input.nextInt();
                shapeColor = Color.rgb(r, g, b);
                insert_time = input.nextInt();
                
                //fill constructor
                shape = new Square(insert_time, px, py, vx, vy,side,shapeColor,isFill);
                System.out.println(shape.toString());
            }
            
            
            return shape;
        }
        
         /**
         * Method used to get all relevant data from files for Oval or Rectangle
         * and return the instance of ClosedShape
         * @param input
         * @param shapeType
         * @return 
         */
        public static ClosedShape getOvalOrRectangle(Scanner input, String shapeType){
            ClosedShape shape = null;
            Color shapeColor = null;
            int width = 0;
            int height = 0;
            
            if(shapeType.equals("oval")){
                px = input.nextInt();
                py = input.nextInt();
                vx = input.nextInt();
                vx = input.nextInt();
                isFill = input.nextBoolean();
                width = input.nextInt();
                height = input.nextInt();
                r = input.nextInt();
                g = input.nextInt();
                b = input.nextInt();
                shapeColor = Color.rgb(r, g, b);
                insert_time = input.nextInt();
                
                //fill constructor
                shape = new Oval(insert_time, px, py, vx, vy,width,height,  shapeColor,isFill);
                System.out.println(shape.toString());
            }
            
            else if(shapeType.equals("rect")){
                px = input.nextInt();
                py = input.nextInt();
                vx = input.nextInt();
                vx = input.nextInt();
                isFill = input.nextBoolean();
                width = input.nextInt();
                height = input.nextInt();
                r = input.nextInt();
                g = input.nextInt();
                b = input.nextInt();
                shapeColor = Color.rgb(r, g, b);
                insert_time = input.nextInt();
                
                //fill constructor
                shape = new Rectangle(insert_time, px, py, vx, vy,width,height,  shapeColor,isFill);
                System.out.println(shape.toString());
            }
            
               else if(shapeType.equals("line")){
                px = input.nextInt();
                py = input.nextInt();
                vx = input.nextInt();
                vx = input.nextInt();
                isFill = input.nextBoolean();
                width = input.nextInt();
                height = input.nextInt();
                r = input.nextInt();
                g = input.nextInt();
                b = input.nextInt();
                shapeColor = Color.rgb(r, g, b);
                insert_time = input.nextInt();
                
                //for flashing colors
                boolean isFlash = input.nextBoolean();
                int r1 = input.nextInt();
                int g1 = input.nextInt();
                int b1 = input.nextInt();
                
                //fill constructor
                shape = new Line(insert_time, px, py, vx, vy,width,height,  shapeColor,isFill, isFlash,
                                 r1,g1,b1);
                System.out.println(shape.toString());
            }
            
            
            return shape;
        }


	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename
	 *            the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename) {
	    // HINT: You might want to open a file here.
            File inputFile = new File(filename); //read file
	    Scanner in = null; //null is not sensible. Please change
	    try 
            {
                in = new Scanner(inputFile); //pass file object to scanner
                

            } catch (FileNotFoundException ex) { //exception
                System.err.println("\n\n*** FileNotFoundException ***");
                System.err.println("Data file <" + filename + "> does NOT exist");
                System.err.println("Please try again");

            }
	    return ReadShapeFile.readDataFile(in);
	    
	}
}
