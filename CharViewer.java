import java.applet.*;
import java.awt.*;
import java.util.*;

abstract class CharViewer extends Viewer
{
    SkillViewer[] skillViewers = new SkillViewer [4];
    Vector attackViewers = new Vector ();

    protected CharModel getModel ()
    {
	//Gets corresponding CharModel instance by notifying the screen controller
	return app.battleController.getModel (this);
    }


    protected CharController getController ()
    {
	//Gets corresponding CharController instance by notifying the screen controller
	return app.battleController.getController (this);
    }


    abstract public void drawArgs (Graphics g, int x, int y, int r); //For drawing character on selection screen
    public void draw (Graphics g)
    {
	for (int i = 0 ; i < attackViewers.size () ; i++)
	{
	     ((AttackViewer)(attackViewers.get (i))).drawArgs (g,
			((AttackController) (getController ().attackControllers.get (i))).posx,
			((AttackController) (getController ().attackControllers.get (i))).posy,
			((AttackController) (getController ().attackControllers).get (i)).radius);
	}
	
	drawArgs (g, getModel ().posx, getModel ().posy, getModel ().radius);
	
	for (int i = 0 ; i < 4 ; i++)
	{
	    if (getModel().skills[i].isActive){
		skillViewers [i].drawArgs (g, getModel ().posx, getModel ().posy, getModel ().radius, getModel ().facex, getModel ().facey);
		break;
	    }
	}

	
    }
}
