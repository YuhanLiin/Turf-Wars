import java.applet.*;
import java.awt.*;
import java.awt.event.*;

class TitleScreenController extends ScreenController{
    public TitleScreenController(){
    }
    
    public void handler(Event event){
	if (event.target == app.titleViewer.buttons[0]){
	    MasterModel.changeScreen("Selection");
	}
	else if (event.target == app.titleViewer.buttons[1]){
	    MasterModel.changeScreen("Instruction");
	}
	
	//Changes screen to selection or instruction screen
    }
}
