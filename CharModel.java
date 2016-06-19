abstract class CharModel{
    protected SkillModel skills[] = new SkillModel[4];
    //List of skills character possesses
    int posx, posy;
    final int radius = 20;
    //X and Y position of character and radius
    int facex, facey;
    int curSpeed;
    //Direction the character is facing (0, 1, -1) and current movespeed per frame
    boolean isAlive = true;
    //Game ends when a character is dead
    boolean canAct = true;
    //False when another skill is being used
    boolean canTurn = true;
    //False while a dash is used
    boolean canMove = false;
    //Character can only move when movement keys are pressed or when dash is used
    boolean invincible = false;
    //Only true when Vortex is used
    
    public CharModel(){
	curSpeed = getBaseSpeed();
    }
    
    abstract public String getName();
    abstract public String getDescription();
    abstract public int getBaseSpeed();
    
    public SkillModel[] getSkills(){
	return skills;
    }

}
