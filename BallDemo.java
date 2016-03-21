import java.awt.Color;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Isaiah Wesley
 * @version March 21, 2016
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulates two bouncing balls
     */
    public void boxBounce()
    {
        int bottomLine = 415; //position of the bottom line. 
        int topLine = 0;      //position of the top line. 
        int leftLine = 0;     //position of the left line.
        int rightLine = 415;  //position of the right line.
        final int OFFSET = 85; //registers the offset value.
              
        myCanvas.setVisible(true);

        // Canvas creates the bottom line. 
             myCanvas.drawLine(50, bottomLine, 550, bottomLine);
            
             myCanvas.drawLine(OFFSET + leftLine, OFFSET + bottomLine, OFFSET + rightLine, OFFSET + bottomLine);
        // Canvas creates the top line. 
             myCanvas.drawLine(OFFSET + leftLine, OFFSET + topLine, OFFSET + rightLine, OFFSET + topLine);
        // Canvas creates the left line.
             myCanvas.drawLine(OFFSET + leftLine, OFFSET + topLine, OFFSET + leftLine, OFFSET + bottomLine);
        // Canvas creates the right line
             myCanvas.drawLine(OFFSET + rightLine,OFFSET + topLine, OFFSET + bottomLine, OFFSET + leftLine);

        // creates and presents the simulated balls
             BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, bottomLine, myCanvas);
             
             ball.draw();
             
             BouncingBall secBall = new BouncingBall(70, 80, 20, Color.RED, bottomLine, myCanvas);
            
             secBall.draw();
             
             BallBox initBall = new Ballbox(myCanvas, OFFSET + bottomLine, OFFSET + topLine, OFFSET + rightLine, OFFSET + leftLine);
             
             initBall.draw();
             
             BallBox secBall = new Ballbox(myCanvas, OFFSET + bottomLine, OFFSET + topLine, OFFSET + rightLine, OFFSET + leftLine);
             
             secBall.draw();
            
             BallBox thrdBall = new Ballbox(myCanvas, OFFSET + bottomLine, OFFSET + topLine, OFFSET + rightLine, OFFSET + leftLine);
             
             thrdBall.draw();
            
             Ballbox frthBall = new Ballbox(myCanvas, OFFSET + bottomLine, OFFSET + topLine, OFFSET + rightLine, OFFSET + leftLine);
            
             frthBall.draw();
            
             Ballbox fifthBall = new Ballbox(myCanvas, OFFSET + bottomLine, OFFSET + topLine, OFFSET + rightLine, OFFSET + leftLine);
             
             fifthBall.draw();
             
        // enact the bouncing simulation
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            initBall.move();
            secBall.move();
            // stop once ball has travelled a certain distance on x-axis
            if(ball.getXPosition() >= 550 || secBall.getXPosition() >= 550) {
                finished = true;
            }
            thrdBall.move();
            frthBall.move();
            fifthBall.move();
        }
    }
}