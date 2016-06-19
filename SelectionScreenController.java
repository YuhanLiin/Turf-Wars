import java.applet.*;
import java.awt.*;

class SelectionScreenController extends ScreenController{
    int p1CharNum , p2CharNum;
    CharController charControllers[] = new CharController [2];
    CharController charControllers2[] = new CharController [2];
    
    public SelectionScreenController(){
	charControllers[0] = new SlasherController();
	charControllers[1] = new BlasterController();
	charControllers2[0] = new SlasherController();
	charControllers2[1] = new BlasterController();
    }

    public void handler(Event event){
	if (event.target == app.selectionViewer.buttons[0]){
	    //Back button returns screen to Title
	    app.selectionModel = new SelectionScreenModel();
	    MasterModel.changeScreen("Title");            
	}
	else if (event.target == app.selectionViewer.buttons[1]){
	    //Put more stuff here regarding character selection
	    if (app.selectionModel.p1Select){
		app.selectionModel.p1Select = false;
		p1CharNum = app.selectionModel.charNum;
	    }
	    else{
		MasterModel.changeScreen("Battle");
		p2CharNum = app.selectionModel.charNum;
		app.battleModel = new BattleScreenModel(app.selectionModel.characters[p1CharNum], app.selectionModel.characters2[p2CharNum]);
		app.battleViewer = new BattleScreenViewer(app.selectionViewer.charViewers[p1CharNum], app.selectionViewer.charViewers2[p2CharNum]);
		app.battleController = new BattleScreenController(charControllers[p1CharNum], charControllers2[p2CharNum]);
		app.selectionModel = new SelectionScreenModel();
	    }
	}
	else{
	    //Change current character based on choice selected
	    app.selectionModel.charNum = app.selectionViewer.charChoice.getSelectedIndex();
	}
    }
}
