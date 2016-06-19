class CutModel extends SkillModel{
    static private String name = "Cut";
    static private String description = "Cookie-cutter melee attack that hits right in front of you.";
    static private int cooldown = (int)(0.3*MasterModel.FPS);
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
