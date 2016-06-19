// The "CharSelectionApplet" class.
import java.applet.*;
import java.awt.*;

public class CharSelectionApplet extends Screen
{
    //Decides who's picking a character
    boolean p1Flag = true;
    Button selectButton = new Button("Select");
    Button backButton = new Button("Back");
    
    public CharSelectionApplet(String s){
	super(s);
    }
    
    public void init ()
    {
	add(selectButton);
	add(backButton);
    } // init method to add buttons
    
    public boolean action(Event e, Object o){
	if (e.target == backButton){
	    screenName = "Title";
	}
	return super.action(e,o);
    }
    
    public void paint (Graphics g)
    {
	// Place the body of the drawing method here
    } // paint method
} // CharSelectionApplet class
