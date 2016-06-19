import java.applet.*;
import java.awt.*;

abstract class ScreenViewer extends Viewer{
    Button buttons[];
    
    abstract public void add();
    
    abstract public void remove();
    
    protected void addButton(Component b, double wx, double wy, int posx, int posy){
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.weightx = wx; //how "haevy" the object is (how much actual space it takes up)        
	gbc.weighty = wy; //ditto
	gbc.gridx = posx; //position in the grid
	gbc.gridy = posy; //position in the grid
	app.add(b, gbc);
    } 
}
