// The "Screen" class.
import java.applet.*;
import java.awt.*;

abstract class Screen extends Applet //Base class for all screens
{
    Graphics g = getGraphics();
    //Reference to exterior screen name
    String screenName;
    boolean isRunning = true;
    
    public Screen(String s){
	screenName = s;
    }
    
    public void init ()
    {
	// Place the body of the initialization method here
    } // init method
    
    public void start(){ //Start function for most screens
	while(isRunning){
	    continue;
	}
    }
    
    public boolean action(Event e, Object o){ // Use as superfunction at the end of subfunctions
	isRunning = false;
	return false;
    }
    
    public void paint (Graphics g)
    {
	// Place the body of the drawing method here
    } // paint method
} // Screen class
