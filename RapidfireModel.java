class RapidfireModel extends SkillModel{
    static private String name = "Rapid Fire";
    static private String description = "Resets all other cooldowns for rapid fire action.";
    static private int cooldown = 10*MasterModel.FPS;
    static private int endFrame = MasterModel.FPS/10;
    
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
