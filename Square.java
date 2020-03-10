


/**
 * Square.java
 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of 
 *
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Square is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the square's bounding rectangle.
 */

public class Square extends ClosedShape {
       //The side of the square
	private int side;
	

    /**
     * Creates a square.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param side The side of the circle.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the square is filled with colour, false if opaque.
     */
    public Square (int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled) {
    	super (insertionTime, x, y, vx, vy, colour, isFilled);
    	this.side = side;
    
    }
    
    /**
     * Method to convert a square to a string.
     */
    public String toString () {
    	String result = "This is a square\n";
    	result += super.toString ();
	result += "Its side is " + this.side + "\n";
    	return result;
    }
    
    /**
     * @param Resets the side.
     */
    public void setSide (int diameter) {
    	this.side = diameter;
    }
    
    /**
     * @return The side of the square.
     */
    public int getSide() {
    	return side;
    }

    /**
     * @return The width of the square
     */
 	public int getWidth() {
		return side;
	}

 	/**
 	 * @return The height of the square
 	 */
 	public int getHeight() {
		return side;
	}
    
    /**
     * Draw the square on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw (GraphicsContext g) {
    	g.setFill(colour);
    	g.setStroke(colour);
    	if (isFilled) {
    		g.fillRoundRect(x, y, side, side, side/2, side/2  );
    	} 
    	else {
    		g.strokeRoundRect(x, y, side, side, side/2, side/2 );
	    }
    }
}
