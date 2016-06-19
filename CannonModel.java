class CannonModel extends SkillModel{
    static private String name = "Gaia Cannon";
    static private String description = "Fires a large shot that slowly engulfs your enemy.";
    static private int cooldown = 8*MasterModel.FPS;
    static private int endFrame = MasterModel.FPS/4;
    
    public String getName(){
	return name;
    }
    
    public String getDescription(){
	return description;
    }
    
    public int getCooldown(){
	return cooldown;
    }
    
    public int getEndFrame(){
	return endFrame;
    }
}
