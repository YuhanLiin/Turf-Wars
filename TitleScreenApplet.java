// The "TitleScreen" class.
import java.applet.*;
import java.awt.*;

public class TitleScreenApplet extends Screen
{
    //Buttons to go to other screens
    Button playButton = new Button("Play");
    Button instructionButton = new Button("Instructions");
    
    public TitleScreenApplet(String s){
	super(s);
    }
    
    public void init (){      
	add(playButton);
	add(instructionButton);
    } // init method that adds the main buttons
    
    public boolean action(Event e, Object o){
	if (e.target == playButton){  
	     screenName = "CharSelect";
	}
	else{
	    screenName = "Instruction";
	}
	return super.action(e,o);
    }
    
    public void paint (Graphics g)
    {
	// Place the body of the drawing method here
    } // paint method
} // TitleScreen class
