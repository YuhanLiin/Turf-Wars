import java.applet.*;
import java.awt.*;

class TitleScreenViewer extends ScreenViewer{
    private final String title = "Turf War";  
    private final String creater = "Yuhan Lin";
    
    public TitleScreenViewer(){
	buttons = new Button[2];
	buttons[0] = new Button("Play");
	buttons[1] = new Button("Instruction");
    }
    
    public void draw(Graphics g){
	g.setColor(Color.blue);
	g.fillRect(0, 0, app.getWidth(), app.getHeight());
	//Make everything blue
	write(g, title, MasterModel.HoriCellCount/5, MasterModel.HoriCellCount, MasterModel.VertCellCount/3, "sanserif", 100, Color.green);
	write(g, "By: "+creater, MasterModel.HoriCellCount/3, MasterModel.HoriCellCount, MasterModel.VertCellCount*2/3, "sanserif", 40, Color.red);
    }
    
    public void add(){
	addButton(buttons[0], 0.5, 0.5, 8, 10);
	addButton(buttons[1], 0.5, 0.5, 1, 10);
    }
    
    public void remove(){
	app.remove(buttons[0]);
	app.remove(buttons[1]);
    }
}
