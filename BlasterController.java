class BlasterController extends CharController{
    public BlasterController(){
	skillControllers[0] = new GrapeshotController();
	skillControllers[1] = new RecoilblastController();
	skillControllers[2] = new CannonController();
	skillControllers[3] = new RapidfireController();
    }
}
