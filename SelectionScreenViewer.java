import java.applet.*;
import java.awt.*;

class SelectionScreenViewer extends ScreenViewer{
    Choice charChoice = new Choice();
    CharViewer charViewers[] = new CharViewer[MasterModel.charCount];
    CharViewer charViewers2[] = new CharViewer[MasterModel.charCount];
    
    public SelectionScreenViewer(){
	buttons = new Button[2];
	buttons[0] = new Button("Back");
	buttons[1] = new Button("Select");
	for(int i=0; i<MasterModel.charCount; i++){
	    charChoice.add(app.selectionModel.characters[i].getName());
	}
	//Initiate buttons and dropdown menu
	
	charViewers[0] = new SlasherViewer();
	charViewers[1] = new BlasterViewer();
	charViewers2[0] = new SlasherViewer();
	charViewers2[1] = new BlasterViewer();
    }
    
    public void add(){
	addButton(buttons[0], 1, 0, 1, 20);
	addButton(buttons[1], 1, 0, 20, 20);
	addButton(charChoice, 0.5, 0.5, 1, 0);
    }
    
    public void remove(){
	for (int i=0; i<2; i++){
	    app.remove(buttons[i]);
	}
	app.remove(charChoice);
    }
    
    public void draw(Graphics g){
	g.setColor(Color.blue);
	g.fillRect(0, 0, app.getWidth(), app.getHeight());
	//Make everything blue
	g.setColor(Color.white);
	g.drawLine(0, scaleY(MasterModel.VertCellCount/6), scaleX(MasterModel.HoriCellCount), scaleY(MasterModel.VertCellCount/6));
	//white line across
	g.drawLine(scaleX(MasterModel.HoriCellCount/2), scaleY(MasterModel.VertCellCount/6), scaleX(MasterModel.HoriCellCount/2), scaleY(MasterModel.VertCellCount));
	//white line vertically
	
	int y;
	if (app.selectionModel.p1Select){
	    write(g, "P1:", MasterModel.HoriCellCount/6, MasterModel.HoriCellCount, 80, "sanserif", 50, Color.magenta);
	}
	else{
	    write(g, "P2:", MasterModel.HoriCellCount/6, MasterModel.HoriCellCount, 80, "sanserif", 50, Color.cyan);        
	}
	write(g, "Character Select", MasterModel.HoriCellCount/6+100, MasterModel.HoriCellCount, 80, "sanserif", 50, Color.white);

	y = MasterModel.VertCellCount/6+70;        
	y = write(g, app.selectionModel.getCurChar().getName(), 70, MasterModel.HoriCellCount/2, y, "sanserif", 40, Color.red);
	y+=20;
	y = write(g, app.selectionModel.getCurChar().getDescription(), 70, MasterModel.HoriCellCount/2, y+2, "sanserif", 20, Color.white);
	y = MasterModel.VertCellCount/6+50;
	//Write text on left side of screen
	y = write(g, "Skills", MasterModel.HoriCellCount/2+50, MasterModel.HoriCellCount, y+20, "sanserif", 30, Color.white);
	for (int i=0; i<4; i++){
	    y = write(g, app.selectionModel.getCurChar().getSkills()[i].getName(), MasterModel.HoriCellCount/2+50, MasterModel.HoriCellCount-50, y, "sanserif", 20, Color.red);
	    y = write(g, app.selectionModel.getCurChar().getSkills()[i].getDescription(), MasterModel.HoriCellCount/2+50, MasterModel.HoriCellCount-50, y, "sanserif", 15, Color.white);
	    y += 30;
	}
	//Write text on right side of screen
	
	charViewers[app.selectionModel.charNum].drawArgs(g, MasterModel.HoriCellCount/4, (int)(MasterModel.VertCellCount*0.75), 100);
    }
}
