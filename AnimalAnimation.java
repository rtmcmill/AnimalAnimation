import java.awt.*;
import java.util.*;


//You will not lose points for using magic numbers in the AnimalAnimation program/methods. 
//However, try to define as many values as constants as you can.

/**
*
* Program that draws a bird, house, grass, and sun and animates the bird
*
* @author Robert McMillion
*
*/

public class AnimalAnimation {
    
    /** Max width of the panel */
    public static final int WIDTH = 500;
    
    /** Max height of the panel */
    public static final int HEIGHT = 400;
    
    /** Sleep time in milliseconds */
    public static final int SLEEP_TIME = 200;
    
    /** Start of x for the animation */
    public static final int INITIAL_X = 10;
    
    /** Start of y for the animation */
    public static final int INITIAL_Y = 200;
    
    /** Total number of updates in the panel */
    public static final int NUMBER_OF_UPDATES = 80;
    
    /** Change in x for the animation */
    public static final int DX = 5;
    
    //The main method creates the animation by repeatedly drawing the background 
    //and animal, then "sleeping" (pausing) for a short time.
    //Feel free to change the size of the drawing panel, initial x-, y-coordinates
    //of the animal, the number of for loop iterations, and the sleep time to
    //whatever works best for your animation. You may also replace the drawAnimal()
    //method with several methods to better imply motion.
    
    /** Main Method that runs the program
    *
    *
    *
    * @param args No arguments passed
    *
    */
    public static void main (String[] args) {
        
        DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
        Graphics g = panel.getGraphics();
        
        int x = INITIAL_X;
        int y = INITIAL_Y;
        for (int i = 0; i < NUMBER_OF_UPDATES; i++) {
            drawBackground(g);
            if((x + DX * i) % 2 == 0){
                drawAnimal(g, x + DX * i, y);
                }
            else{
                drawAnimal2(g, x + DX * i, y);
                }
            panel.sleep(SLEEP_TIME);
        } 
         
        System.out.println("\n*CLOSE the Drawing Panel to exit the program*");
    }
    
    //Draws a plain white background. 
    //Replace this method with more elaborate one that draws a scene, for example, 
    //a house with trees, sky, and grass, the beach with ocean and sky, 
    //a video game background such as might be found in a Mario game, etc.
    //Be creative!
    
    /**
    *
    * Method that draws the background using the g pen
    *
    * @param g pen that will draw on the panel
    *
    */
    public static void drawBackground(Graphics g) {
        
        // Sky
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        // Grass
        g.setColor(Color.GREEN);
        g.fillRect(0, 395, WIDTH, 4);
        
        // House
        g.setColor(Color.RED);
        g.fillRect(20, 299, 100, 100);
        
        // Rooftop
        g.setColor(Color.BLACK);
        Polygon p = new Polygon();
        p.addPoint(20, 299);
        p.addPoint(120, 299);
        p.addPoint(70, 299 / 2);
        g.fillPolygon(p);
        
        // Sun
        g.setColor(Color.YELLOW);
        g.fillOval(-50, -50, 100, 100);
        
        
    }
    
    /**
    *
    * Method that draws the bird with it's wings down
    *
    * @param g Pen that will draw on the canvas
    * @param x x-value of the bird
    * @param y y-value of the bird
    *
    */ 
    public static void drawAnimal(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        
        // Body
        g.fillRect(x, y - 100, 50, 20);
        
        // Eyes
        g.setColor(Color.WHITE);
        g.drawOval(x + 40, y - 100, 5, 5);
        
        // Wings down
        g.setColor(Color.BLACK);
        g.drawLine(x + 30, y - 90, x + 15, y - 120); 
        g.drawLine(x + 30, y - 90, x + 15, y - 60);
        
    } 
    
    
    /**
    *
    * Method that draws the bird with it's wings up
    *
    * @param g Pen that draws the bird
    * @param x x-value of the bird
    * @param y y-value of the bird
    *
    */
    public static void drawAnimal2(Graphics g, int x, int y){
        g.setColor(Color.BLACK);
        
        // Body
        g.fillRect(x, y - 100, 50, 20);
        
        // Eyes
        g.setColor(Color.WHITE);
        g.drawOval(x + 40, y - 100, 5, 5);
        
        // Wings up
        g.setColor(Color.BLACK);
        g.drawLine(x + 30, y - 90, x + 45, y - 120); 
        g.drawLine(x + 30, y - 90, x + 45, y - 60);
        
    }
    
}