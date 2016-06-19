import java.applet.*;
import java.awt.*;
import java.util.TimerTask;

class FrameTask extends TimerTask{
    static MainApplet app;
    
    public void run(){ 
	app.getController().frameProcess();
	app.paint(app.getGraphics());
	       
    }
    
}
