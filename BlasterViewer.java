import java.applet.*;
import java.awt.*;

class BlasterViewer extends CharViewer{
    public BlasterViewer(){
	skillViewers[0] = new GrapeshotViewer();
	skillViewers[1] = new RecoilblastViewer();
	skillViewers[2] = new CannonViewer();
	skillViewers[3] = new RapidfireViewer();
    }
    
    public void drawArgs(Graphics g, int x, int y, int r){
	//Draw some circles and squares centered around x and y
	double root = Math.sqrt(2);
	g.setColor(Color.magenta);
	g.fillOval(scaleX(x-r), scaleY(y-r), scaleX(r*2), scaleY(r*2));
	g.setColor(Color.orange);
	g.fillRect(scaleX(x-(int)(root*r/2)), scaleY(y-(int)(root*r/2)), scaleX((int)(root*r)), scaleY((int)(root*r)));
    }
}
