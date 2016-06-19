class SlowdownModel extends SkillModel{
    static private String name = "Slowdown";
    static private String description = "Slows down the movements of any enemy near you";
    static private int cooldown = 7*MasterModel.FPS;
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
