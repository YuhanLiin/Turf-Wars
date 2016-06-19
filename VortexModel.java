class VortexModel extends SkillModel{
    static private String name = "Vortex";
    static private String description = "Become invinsible and slice up everything around you for the next 4 seconds.";
    static private int cooldown = 17*MasterModel.FPS;
    static private int endFrame = MasterModel.FPS*4;
    
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
