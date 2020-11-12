
import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Henri Feinaj.
 *
 */
public class BouncingShapesWindow {

    private static final int ANIMATION_DELAY = 10;
    private static final String FRAME_TITLE = "Bouncing Shape Frame";

    private GraphicsContext gc;
    private Queue<ClosedShape> shapesToAdd;
    private ArrayList<ClosedShape> activeShapes;
    private ArrayList<ClosedShape> allShapes;
    private int currentTime = 0;
    private boolean flag = true;

    private String filename;

    public BouncingShapesWindow(GraphicsContext gc, String filename) {
        this.gc = gc;

        activeShapes = new ArrayList<ClosedShape>();
        allShapes = new ArrayList<ClosedShape>();
        this.initShapes(filename);
        this.insertShapes();
        drawClosedShapes();

        actionPerformed();
        flashShapes();

    }

    private void drawClosedShapes() {
        for (ClosedShape s : activeShapes) {
            s.draw(gc);

        }
    }

    //method used to flash specific shape
    private void flashShapes() {

        for (ClosedShape s : allShapes) { //iterate over shapes
            // if(s instanceof Circle){
            if (((Line) s).isIsflash()) { //check if flash
                //get color attributes
                int r = ((Line) s).getR1();
                int b = ((Line) s).getB1();
                int g = ((Line) s).getG1();
                //get old color
                Color oldColor = s.getColour();
                //create new color
                Color newColor = Color.rgb(r, g, b);

                //change new color for few seconds
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), ae -> {

                    s.setColour(newColor);
                    s.draw(gc);

                }));
                //switch back to original color
                Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(7), ae -> {

                    s.setColour(oldColor);
                    s.draw(gc);

                }));

                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();
                timeline2.setCycleCount(Animation.INDEFINITE);
                timeline2.play();

            }
            

        }
    }

    private void initShapes(String filename) {
        shapesToAdd = ReadShapeFile.readDataFile(filename);
    }

    private void insertShapes() {
        //no more shapes to add, we are done
        if (shapesToAdd.isEmpty()) {
            
            return;
        }

        //add shapes if needed
        ClosedShape current = shapesToAdd.peek();
        if (current instanceof Line) {
            allShapes.add(current);
        }

        while (!shapesToAdd.isEmpty() && (current.getInsertionTime() <= currentTime * ANIMATION_DELAY)) {
            activeShapes.add(current);

            shapesToAdd.dequeue();
            if (!shapesToAdd.isEmpty()) {
                current = shapesToAdd.peek();
            }
        }
    }

    public void actionPerformed() {

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(5), ae -> onTime()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    private void onTime() {
        currentTime++;
        double h = gc.getCanvas().getHeight();
        double w = gc.getCanvas().getWidth();
        gc.clearRect(0, 0, w, h);
        moveShapes();
        insertShapes();
        drawClosedShapes();

    }

    public void moveShapes() {
        double dimsY = gc.getCanvas().getHeight();
        double dimsX = gc.getCanvas().getWidth();
        for (ClosedShape s : activeShapes) {
            s.move();

            // Move us back in and bounce if we went outside the drawing area.
            if (s.outOfBoundsX(dimsX)) {
                s.putInBoundsX(dimsX);
                s.bounceX();
            }

            if (s.outOfBoundsY(dimsY)) {
                s.putInBoundsY(dimsY);
                s.bounceY();
            }

        }
    }

}
