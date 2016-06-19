class SlasherModel extends CharModel{
    private static String name = "Slasher";
    private static String description = "Fast moving assassin who specializes in neutralizing targets up close.";
    private static final int baseSpeed = 7;
    
    public SlasherModel(){
	skills[0] = new CutModel();
	skills[1] = new DashModel();
	skills[2] = new SlowdownModel();
	skills[3] = new VortexModel();
    }
    
    public String getName(){
	return name;
    }
    
    public String getDescription(){
	return description;
    }
    
    public int getBaseSpeed(){
	return baseSpeed;
    }
}
