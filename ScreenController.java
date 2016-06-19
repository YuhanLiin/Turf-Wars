import java.applet.*;
import java.awt.*;
import java.awt.event.*;

abstract class ScreenController extends Controller{
    //Button[] buttons;
    public ScreenController(){
    }//Sets a reference to the buttons in the controller
    
    abstract public void handler(Event event);
    
    public void frameProcess(){}
}
