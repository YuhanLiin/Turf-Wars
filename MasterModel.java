final class MasterModel{ //Contains overhead info for the game. Set as a static class
    static private String screenMode = "Title";
    //Screen names are: Title, Instruction, Selection, and Battle
    static boolean screenUpdateFlag = false;
    //Flag for whether screen has been updated
    static final int VertCellCount = 700;
    static final int HoriCellCount = 800;
    //Constants for # of graphic cell rows and columns
    static double cellHeight, cellWidth;
    //Dimensions of each graphic cell
    static final int FPS = 30;
    //How many frames per second the game runs at
    static final int charCount = 2;
    
    private MasterModel(){ //Can't be instantiated
    }
    
    static public void changeScreen(String name){
	screenMode = name;
	screenUpdateFlag = true;
    } //Changes name of screen currently displayed
    
    static public String getScreen(){
	return screenMode;
    }  //Returns name of current screen
}
