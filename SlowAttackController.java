class SlowAttackController extends AttackController{
    public SlowAttackController(int x, int y, int r, int ef){
	super(x,y,r,ef);
    }
    
    public void hitEffect (CharModel character){
	//Character loses speed when hit
	character.curSpeed = character.getBaseSpeed()*3/4;
    }
    
    
}
