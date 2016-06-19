abstract class SkillModel{
    
    int curFrame;
    int curCooldown;
    boolean isActive = false;
    
    
    public void lowerCooldown(){
	curCooldown--;
	if (curCooldown < 0){
	    curCooldown = 0;
	}
    }
    
    abstract public String getName();    
    abstract public String getDescription();    
    abstract public int getCooldown();
    abstract public int getEndFrame();
}
