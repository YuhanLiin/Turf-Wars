class RecoilblastModel extends SkillModel{
    static private String name = "Recoil Blast";
    static private String description = "Propels a bullet forward and the user backwards";
    static private int cooldown = 6*MasterModel.FPS;
    static private int endFrame = MasterModel.FPS/2;
    
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
