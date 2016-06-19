import java.applet.*;
import java.awt.*;
import java.util.Vector;

class BattleScreenViewer extends ScreenViewer
{
    CharViewer p1CharViewer, p2CharViewer;
    final int hudHeight = 100;

    public BattleScreenViewer (CharViewer char1, CharViewer char2)
    {
	p1CharViewer = char1;
	p2CharViewer = char2;
    }


    public void add ()
    {
    }


    public void remove ()
    {
    }


    public void draw (Graphics g)
    {
	g.setColor (Color.green);
	g.fillRect (0, 0, app.getWidth (), app.getHeight ());
	//Large green battlefield

	p1CharViewer.draw (g);
	p2CharViewer.draw (g);
	//Draw characters

	g.setColor (Color.blue);
	g.fillRect (0, 0, app.getWidth (), scaleY (app.battleModel.hudHeight));
	g.fillRect (0, scaleY (MasterModel.VertCellCount - app.battleModel.hudHeight), scaleX (MasterModel.HoriCellCount), scaleY (app.battleModel.hudHeight));
	//Blue HUD at top and bottom
	write (g, "P1: " + app.battleModel.p1CharModel.getName (), 10, MasterModel.HoriCellCount, 80, "sanserif", 50, Color.magenta);
	write (g, "P2: " + app.battleModel.p2CharModel.getName (), 10, MasterModel.HoriCellCount, MasterModel.VertCellCount - 20, "sanserif", 50, Color.cyan);
	//Player 1 info on top, player 2 on bottom

	int xlen = MasterModel.HoriCellCount / 8;
	//Length of each skill box on HUD
	for (int i = 0 ; i < 4 ; i++)
	{ //For each character, draw skill boxes for HUD at top and bottom
	    double cdPercent1 = app.battleModel.p1CharModel.skills [i].curCooldown / (double) (app.battleModel.p1CharModel.skills [i].getCooldown ());
	    double cdPercent2 = app.battleModel.p2CharModel.skills [i].curCooldown / (double) (app.battleModel.p2CharModel.skills [i].getCooldown ());
	    //Calculate ratio between skill's current cooldown and max cooldown
	    g.setColor (Color.orange);
	    g.fillRect (scaleX (MasterModel.HoriCellCount / 2 + i * xlen), 0, scaleX (MasterModel.HoriCellCount / 2 + (i + 1) * xlen), scaleY (hudHeight));
	    g.fillRect (scaleX (MasterModel.HoriCellCount / 2 + i * xlen), scaleY (MasterModel.VertCellCount - hudHeight), scaleX (MasterModel.HoriCellCount / 2 + (i + 1) * xlen), scaleY (hudHeight));
	    write (g, String.valueOf (i + 1), MasterModel.HoriCellCount / 2 + i * xlen + xlen / 3, MasterModel.HoriCellCount / 2 + (i + 1) * xlen - xlen / 3, 80, "sanserif", 30, Color.red);
	    write (g, String.valueOf (i + 1), MasterModel.HoriCellCount / 2 + i * xlen + xlen / 3, MasterModel.HoriCellCount / 2 + (i + 1) * xlen - xlen / 3, MasterModel.VertCellCount - 30, "sanserif", 30, Color.red);
	    //Fill the right side of the HUD with orange boxes with numbers to represent character skills
	    g.setColor (Color.cyan);
	    g.fillRect (scaleX (MasterModel.HoriCellCount / 2 + i * xlen), scaleY ((int) (hudHeight * (1 - cdPercent1))), scaleX (MasterModel.HoriCellCount / 2 + (i + 1) * xlen), scaleY ((int) (hudHeight * cdPercent1 + 1)));
	    g.fillRect (scaleX (MasterModel.HoriCellCount / 2 + i * xlen), scaleY ((int) (MasterModel.VertCellCount - hudHeight * cdPercent2)), scaleX (MasterModel.HoriCellCount / 2 + (i + 1) * xlen), scaleY ((int) (hudHeight * cdPercent2 + 1)));
	    //Draw blue boxes on top of orange boxes with height based on the cooldown ratio to represent cooldown times
	    g.setColor (Color.black);
	    g.drawLine (scaleX (MasterModel.HoriCellCount / 2 + i * xlen), 0, scaleX (MasterModel.HoriCellCount / 2 + i * xlen), scaleY (hudHeight));
	    g.drawLine (scaleX (MasterModel.HoriCellCount / 2 + (i + 1) * xlen), 0, scaleX (MasterModel.HoriCellCount / 2 + (i + 1) * xlen), scaleY (hudHeight));
	    //Player 1
	    g.drawLine (scaleX (MasterModel.HoriCellCount / 2 + i * xlen), scaleY (MasterModel.VertCellCount - hudHeight), scaleX (MasterModel.HoriCellCount / 2 + i * xlen), scaleY (MasterModel.VertCellCount));
	    g.drawLine (scaleX (MasterModel.HoriCellCount / 2 + (i + 1) * xlen), scaleY (MasterModel.VertCellCount - hudHeight), scaleX (MasterModel.HoriCellCount / 2 + (i + 1) * xlen), scaleY (MasterModel.VertCellCount));
	    //Player 2
	    //draw black lines between skill boxes

	    if (app.battleModel.winner != 0)
	    {
		drawVictory (g);
	    }
	}
	//HUD: Add more later

    }


    public int boundX (int x, int pad)
    {
	//Check if x is out of screen bounds and return modified value
	//pad is the padding around the x value, which is the center
	if (x - pad < 0)
	{
	    return pad;
	}
	else if (x + pad > MasterModel.HoriCellCount)
	{
	    return MasterModel.HoriCellCount - pad;
	}
	else
	{
	    return x;
	}
    }


    public int boundY (int y, int pad)
    {
	//Check if y is out of screen bounds and return modified value
	if (y - pad < hudHeight)
	{
	    return hudHeight + pad;
	}
	else if (y + pad > MasterModel.VertCellCount - hudHeight)
	{
	    return MasterModel.VertCellCount - hudHeight - pad;
	}
	else
	{
	    return y;
	}
    }


    public void drawVictory (Graphics g)
    {
	if (app.battleModel.winner == 1)
	{
	    //System.out.println("1");
	    write (g, "Gottem Boys!!", MasterModel.HoriCellCount / 5, MasterModel.HoriCellCount, MasterModel.VertCellCount / 3, "sanserif", 50, Color.magenta);
	    write (g, "Player 1 Wins!!", MasterModel.HoriCellCount / 5, MasterModel.HoriCellCount, MasterModel.VertCellCount / 3 + 90, "sanserif", 50, Color.magenta);
	}
	else
	{
	    //System.out.println("2");
	    write (g, "Gottem Boys!!", MasterModel.HoriCellCount / 5, MasterModel.HoriCellCount, MasterModel.VertCellCount / 3, "sanserif", 50, Color.cyan);
	    write (g, "Player 2 Wins!!", MasterModel.HoriCellCount / 5, MasterModel.HoriCellCount, MasterModel.VertCellCount / 3 + 90, "sanserif", 50, Color.cyan);
	}

    }
}
