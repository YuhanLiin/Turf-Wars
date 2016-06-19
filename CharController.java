import java.applet.*;
import java.awt.*;
import java.util.*;

class CharController extends Controller{
    SkillController[] skillControllers = new SkillController[4];
    Vector attackControllers = new Vector();
    
    protected CharModel getModel(){
	//Gets corresponding CharModel instance by notifying the screen controller
	return app.battleController.getModel(this);
    }
    
    protected CharViewer getViewer(){
	//Gets corresponding CharViewer instance by notifying the screen controller
	if (app.battleController==null){
	    System.out.println("controller null");
	}
	return app.battleController.getViewer(this);
    }
    
    protected void setSkillVectors(){
	for (int i=0; i<4; i++){
	    skillControllers[i].setVectors(attackControllers, getViewer().attackViewers);
	}
    }
    
    public void move(){
	double dist;
	//Distance travelled in x or y direction
	if (getModel().facex != 0 && getModel().facey != 0){
	    dist = getModel().curSpeed/Math.sqrt(2);
	    //Use pythagoreas to account for diagonal movement
	} 
	else{
	    dist = getModel().curSpeed;
	    //No modifications for straight movement
	}
	//Now change x and y based on the calculated dist value. Accounts for screen bounds
	getModel().posx = app.battleViewer.boundX(getModel().posx+(int)Math.round(dist*getModel().facex), getModel().radius);
	getModel().posy = app.battleViewer.boundY(getModel().posy+(int)Math.round(dist*getModel().facey), getModel().radius);
    }
    
    public void processCommands(ControlParser controls){
	Pair facing = controls.moveCommand();
	if (facing.x != 0 || facing.y != 0){
	    //If movement has been registered and facing isnt (0,0)
	    getModel().canMove = true;
	    if (getModel().canTurn){
		//Turn the character if possible
		getModel().facex = facing.x;
		getModel().facey = facing.y;
	    }
	}
	
	if (getModel().canMove){
	    move();
	}
	getModel().canMove = false;
	
	int skillNum = controls.skillCommand(); 
	if(getModel().canAct && skillNum >= 0){
	    //System.out.println(String.valueOf(skillNum)+" Used");
	    skillControllers[skillNum].use(getModel().skills[skillNum]);
	}
    }
    
    public void processSkills(){
	for (int i=0; i<4; i++){
	    //System.out.println(String.valueOf(getModel().skills[i].curCooldown));
	    skillControllers[i].frameProcess(getModel().skills[i], getModel());
	}
    }
    
    public void processAttacks(CharModel target){
	//Process a player's current attacks. Deletes attacks that have expired
	for (int i=0; i<attackControllers.size(); i++){
	    ((AttackController)(attackControllers.get(i))).hitProcess(target);
	    if (!((AttackController)(attackControllers.get(i))).frameProcess()){
		//End attack
		attackControllers.remove(i);
		getViewer().attackViewers.remove(i);
		i-=1;
	    }
	}
    }

}
