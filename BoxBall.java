import java.awt.Color;
import java.util.Random;

/**
 * The BoxBall class simulates a number of balls contained inside a virtual box. The objects bounce off of the walls randomly.
 * 
 * @author Isaiah Wesley
 * @version March 21, 2016
 */
public class BoxBall
{
    private int diameter;
    private Canvas canvas;
    private int xPosition;
    private int yPosition;
    private int xVelocity;
    private int yVelocity;
    private final Color color;
    private final Random random = new Random();
    
    public BoxBall(Canvas drawCanvas,int bottom, int top, int left, int right, int xVelocity, int yVelocity) {
        canvas = drawCanvas;
        int bottomLine = bottom;
        int topLine = top;
        int leftLine = left;
        int rightLine = right;
        int xPosition = random.nextInt((canvas.getSize().height));
        int yPosition = random.nextInt((canvas.getSize().height));
        color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        diameter = random.nextInt(72) + 8;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }
    /**
     * Invokes the draw method necessary for the simulation to work.
     */
    public void draw() 
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }
    /**
     * Specifies how the balls move in the box.
     */
    public void move()
    {
        erase();
        xPosition += xVelocity;
        yPosition += yVelocity;
        draw();
    }
    /**
     * Invokes the erase method to clear simulated balls. 
     */
    public void erase(){
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }
    /**
     * Returns the x-position of the balls. 
     * @return xPosition
     */
    public int getXPos()
    {
        return xPosition;
    }
    /**
     * Returns the y-position of the balls.
     * @return yPosition
     */
    public int getYPos()
    {
        return yPosition;
    }
    /**
     * Returns the value of the diameter.
     * @return diameter
     */
    public int getDiameter()
    {
        return diameter;
    }
}
