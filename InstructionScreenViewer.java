import java.applet.*;
import java.awt.*;

class InstructionScreenViewer extends ScreenViewer{
    private final String instructions1 = "    This is a 2-player game, where each player gets to choose and control a character on the game map. After the players select their respective characters, they must use their attacks to destroy"
					+ " the other player's character while avoiding their opponent. Each character has the ability to move around the battlefield in the 8 cardinal directions as well as 4 skills at its disposal."
					+ " Skills can include dashes, attacks, and projectiles and will go on a period of cooldown when they are used.";
    
    private final String instructions2 = "    Player 1 uses WASD for directions and the keys GHJK to use skills. Player 2 uses arrow keys and numpad keys 4568 for skills. Turn numlock on to enable controls. Have fun!";                            

    public InstructionScreenViewer(){
	buttons = new Button[1];
	buttons[0] = new Button("Back");
    }
    
    public void draw(Graphics g){
    g.setColor(Color.blue);
	g.fillRect(0, 0, app.getWidth(), app.getHeight());
	//Make everything blue
	
	int y = write(g, "Instructions", MasterModel.HoriCellCount/3, MasterModel.HoriCellCount, 80, "sanserif", 40, Color.white);
	y = write(g, instructions1, MasterModel.HoriCellCount/10, MasterModel.HoriCellCount, y+8, "sanserif", 20, Color.white);
	write(g, instructions2, MasterModel.HoriCellCount/10, MasterModel.HoriCellCount, y+50, "sanserif", 20, Color.white);
    }
    
    public void add(){
	addButton(buttons[0], 1.0, 1.0, 0, 13);
    }
    
    public void remove(){
	app.remove(buttons[0]);
    }
}
