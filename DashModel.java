class DashModel extends SkillModel{
    static private String name = "Dash";
    static private String description = "Move a short distance in any of the 8 cardinal directions.";
    static private int cooldown = 2*MasterModel.FPS;
    static private int endFrame = MasterModel.FPS/5;

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
	
