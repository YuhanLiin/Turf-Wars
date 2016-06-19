import java.applet.*;
import java.awt.*;

class SlasherViewer extends CharViewer{
    public SlasherViewer(){
	skillViewers[0] = new CutViewer();
	skillViewers[1] = new DashViewer();
	skillViewers[2] = new SlowdownViewer();
	skillViewers[3] = new VortexViewer();
    }
    
    public void drawArgs(Graphics g, int x, int y, int r){
	//Draw some circles centered around x and y
	g.setColor(Color.red);
	g.fillOval(scaleX(x-r), scaleY(y-r), scaleX(r*2), scaleY(r*2));
	g.setColor(Color.black);
	g.fillOval(scaleX(x-3*r/4), scaleY(y-3*r/4), scaleX(3*r/2), scaleY(3*r/2));
	g.setColor(Color.red);
	g.fillOval(scaleX(x-r/2), scaleY(y-r/2), scaleX(r), scaleY(r));
    }
}
