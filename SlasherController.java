class SlasherController extends CharController{
    public SlasherController(){
	skillControllers[0] = new CutController();
	skillControllers[1] = new DashController();
	skillControllers[2] = new SlowdownController();
	skillControllers[3] = new VortexController();
    }
}
