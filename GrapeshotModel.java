class GrapeshotModel extends SkillModel{
    static private String name = "Grapeshot";
    static private String description = "Launch a standard long range attack consisting of 3 projectiles at once!";
    static private int cooldown = 3*MasterModel.FPS/2;
    static private int endFrame = MasterModel.FPS/3;
    
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
