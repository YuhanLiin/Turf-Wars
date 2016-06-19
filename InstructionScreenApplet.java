// The "InstructionScreenApplet" class.
import java.applet.*;
import java.awt.*;

public class InstructionScreenApplet extends Screen
{
    //Button to go back
    Button backButton = new Button("Back");
    //Font of instructions
    Font titleFont = new Font ("SanSerif", Font.PLAIN, 20);
    
    public InstructionScreenApplet(String s){
	super(s);
    }
    
    public void init ()
    {
	add(backButton);
    } // init method to add button
    
    public boolean action(Event e, Object o){
	//Change screen to Title when back button is pressed
	screenName = "Title";
	return super.action(e,o);
    }
    
    public void paint (Graphics g)
    {
	g.setFont(titleFont);
	g.drawString("Instructions", 300, 100);
    } // paint method
} // InstructionScreenApplet class
