import java.applet.*;
import java.awt.*;
import java.awt.event.*;

class InstructionScreenController extends ScreenController{
    public InstructionScreenController (){

    }
    
    public void handler(Event event){
	if (event.target == app.instructionViewer.buttons[0]){
	    MasterModel.changeScreen("Title");
	}
	
    }
}
