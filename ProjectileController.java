class ProjectileController extends AttackController{
    int facex, facey;
    int speed;
    //Direction faced and speed per frame
    
    public ProjectileController(int x, int y, int r, int fx, int fy, int s){
	//Extra parameters on top of attackController, but no endframe required
	super(x, y, r, 100);
	facex = fx;
	facey = fy;
	speed = s;
    }
    
    public boolean frameProcess (){
	//Move projectile in the right direction and returns whether it's out of bounds or not
	if (curFrame != 0){
	    float dist;
	    //Distance projectile travels
	    if (facex != 0 && facey != 0){
		dist = speed/(float)Math.sqrt(2);
	    }
	    else{
		dist = speed;
	    }
	    posx += Math.round(facex*dist);
	    posy += Math.round(facey*dist);
	}
	
	if ((posx > MasterModel.HoriCellCount || posx < 0) && (posy > MasterModel.VertCellCount-app.battleViewer.hudHeight || posy < app.battleViewer.hudHeight)){
	    return false;
	}
	return true;
    }
}
