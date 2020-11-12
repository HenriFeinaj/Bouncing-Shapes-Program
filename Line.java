
/**
 * Line.java
 *
 * @version 2.0.0 Originally written by Bette Bultena but heavily modified for
 * the purposes of "CS-115 programming module".
 *
 */
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * Line is an Line shape that can be drawn to the screen, either filled with
 * colour or opaque. Its position is determined by the upper left corner of the
 * line bounding.
 */
public class Line extends ClosedShape {

    //The width and height of the Line (major and minor axis)
    private int width, height;
    private boolean isflash;
    private int r1;
    private int g1;
    private int b1;

    /**
     * Creates an Line.
     *
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the Line (in pixels).
     * @param height The height of the Line (in pixels).
     * @param colour The line colour or fill colour.
     * @param isFilled True if the Line is filled with colour, false if opaque.
     */
    public Line(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled,
            boolean isflash, int r1, int g1, int b1) {
        super(insertionTime, x, y, vx, vy, colour, isFilled);
        this.width = width;
        this.height = height;
        this.isflash = isflash;
        this.r1 = r1;
        this.g1 = g1;
        this.b1 = b1;
    }

    /**
     * Method to convert an Line to a string.
     */
    public String toString() {
        String result = "This is an line\n";
        result += super.toString();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }

    /**
     * @param width Resets the width.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @param height Resets the height.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return The width of the Line.
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return The height of the Line.
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return the isflash
     */
    public boolean isIsflash() {
        return isflash;
    }

    /**
     * @param isflash the isflash to set
     */
    public void setIsflash(boolean isflash) {
        this.isflash = isflash;
    }

    /**
     * @return the r1
     */
    public int getR1() {
        return r1;
    }

    /**
     * @param r1 the r1 to set
     */
    public void setR1(int r1) {
        this.r1 = r1;
    }

    /**
     * @return the g1
     */
    public int getG1() {
        return g1;
    }

    /**
     * @param g1 the g1 to set
     */
    public void setG1(int g1) {
        this.g1 = g1;
    }

    /**
     * @return the b1
     */
    public int getB1() {
        return b1;
    }

    /**
     * @param b1 the b1 to set
     */
    public void setB1(int b1) {
        this.b1 = b1;
    }

    /**
     * Draw the Line.
     *
     * @param g The graphics object of the drawable component.
     */
    public void draw(GraphicsContext g) {
        g.setFill(colour);
        g.setStroke(colour);
        g.setLineWidth(width);
        g.strokeLine(x, y, width, height);

    }
}
