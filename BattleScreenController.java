import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

class BattleScreenController extends ScreenController implements KeyListener
{
    CharController p1CharController, p2CharController;
    boolean keys[] = new boolean [200];
    //Array to represent whether a key was pressed
    ControlParser p1Controls = new ControlParser (new int[]
    {
	87, 83, 65, 68, 71, 72, 74, 75
    }


    );
    //Movement: w s a d     Skills: g h j k
    ControlParser p2Controls = new ControlParser (new int[]
    {
	38, 40, 37, 39, 100, 101, 102, 104
    }


    );
    //Movement: upArrow downArrow leftArror rightArror     Skills: numpad4 numpad5 numpad6 numpad8
    private int victoryFrame = 3 * MasterModel.FPS;

    public BattleScreenController (CharController char1, CharController char2)
    {
	p1CharController = char1;
	p2CharController = char2;
	ControlParser.keys = keys;
    }


    public void handler (Event e)
    {
    }


    public CharModel getModel (Object obj)
    {
	//Matches Controllers and Viewers with corresponding Model instance
	if (obj == p1CharController || obj == app.battleViewer.p1CharViewer)
	{
	    return app.battleModel.p1CharModel;
	}
	else if (obj == p2CharController || obj == app.battleViewer.p2CharViewer)
	{
	    return app.battleModel.p2CharModel;
	}
	else
	{
	    return null; //Debug purposes
	}
    }


    public CharViewer getViewer (Object obj)
    {
	//Matches Controllers with corresponding Viewer instance
	if (obj == p1CharController)
	{
	    //System.out.println("Viewer");
	    return app.battleViewer.p1CharViewer;
	}
	else if (obj == p2CharController)
	{
	    //System.out.println("Viewer");
	    return app.battleViewer.p2CharViewer;
	}
	else
	{
	    return null; //Debug purposes
	}
    }


    public CharController getController (Object obj)
    {
	//Matches Viewers with corresponding Controller instance
	if (obj == app.battleViewer.p1CharViewer)
	{
	    return p1CharController;
	}
	else if (obj == app.battleViewer.p2CharViewer)
	{
	    return p2CharController;
	}
	else
	{
	    return null; //Debug purposes
	}
    }


    //Keylistener methods
    public void keyTyped (KeyEvent event)
    {
    }


    public void keyPressed (KeyEvent event)
    {
	keys [event.getKeyCode ()] = true;
    }


    public void keyReleased (KeyEvent event)
    {
	keys [event.getKeyCode ()] = false;
    }


    //////////////////////////
    private void checkVictory ()
    {
	if (app.battleModel.winner == 0)
	{
	    if (app.battleModel.p1CharModel.isAlive == false)
	    {
		app.battleModel.winner = 2;
	    }
	    else if (app.battleModel.p2CharModel.isAlive == false)
	    {
		app.battleModel.winner = 1;
	    }
	}

	if (app.battleModel.winner != 0)
	{
	    victoryFrame--;
	}

    }


    public void frameProcess ()
    {
	p1CharController.setSkillVectors ();
	p2CharController.setSkillVectors ();
	p1CharController.processCommands (p1Controls);
	p2CharController.processCommands (p2Controls);
	p1CharController.processSkills ();
	p2CharController.processSkills ();
	p1CharController.processAttacks (app.battleModel.p2CharModel);
	p2CharController.processAttacks (app.battleModel.p1CharModel);

	if (victoryFrame == 0)
	{
	    //System.out.println("Done");
	    MasterModel.changeScreen ("Title");
	    app.action (new Event (new Object (), 1, new Object ()), new Object ());
	    return;
	}


	checkVictory ();
    }
}
