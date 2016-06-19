class BlasterModel extends CharModel{
    private static final String name = "Blaster";
    private static final String description = "Long-ranged marksman who destroys enemies from afar.";
    private static final int baseSpeed = 5;  
	
    public BlasterModel(){
	skills[0] = new GrapeshotModel();
	skills[1] = new RecoilblastModel();
	skills[2] = new CannonModel();
	skills[3] = new RapidfireModel();
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
