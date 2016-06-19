// The "MainApplet" class.
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.TimerTask;
import java.util.Timer;
import java.awt.image.BufferedImage;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainApplet extends Applet
{
    BufferedImage bufferedScreen;
    
    TitleScreenViewer titleViewer;
    TitleScreenController titleController;
    InstructionScreenViewer instructionViewer;
    InstructionScreenController instructionController;
    SelectionScreenModel selectionModel;
    SelectionScreenViewer selectionViewer;
    SelectionScreenController selectionController; 
    BattleScreenController battleController;
    BattleScreenViewer battleViewer;
    BattleScreenModel battleModel;   
    
    ScreenViewer curScreenViewer;
    ScreenController curScreenController;
    
    FrameTask frameTask = new FrameTask();
    Timer frameTimer = new Timer(); 
    
    static public void main(String args[]){
    	MainApplet applet = new MainApplet();
    	applet.setPreferredSize(new Dimension(800,700));
    	applet.setSize(new Dimension(800,700));
    	applet.init();
    	//applet.start();
    	
    	Frame mainFrame = new Frame(); //Initialize the frame to draw applet in 
    	 		mainFrame.addWindowListener(new WindowAdapter(){ //Allow applet to be closed lol 
    	 			public void windowClosing(WindowEvent we){ 
    	 				System.exit(0); 
    	 			} 
    	 		}); 
    			mainFrame.add(applet); 
    	 		mainFrame.pack(); 
    	 		mainFrame.setVisible(true); 
    	 		 
    			applet.start(); //start the applet 

    }
    
    public ScreenController getController(){
	return curScreenController;
    }
    
    private void rescale(){
	MasterModel.cellWidth = (double)getWidth()/MasterModel.HoriCellCount;    
	MasterModel.cellHeight = (double)getHeight()/MasterModel.VertCellCount;
	bufferedScreen = new BufferedImage(getWidth(), getHeight(), 2);
    }
    
    public void init ()
    {
	rescale();
	//Sets cells to correspond with screen size
	Viewer.app = this;
	Controller.app = this;
	FrameTask.app = this;
	//Link applet to all controllers and viewers
	titleViewer = new TitleScreenViewer();
	titleController = new TitleScreenController();
	instructionViewer = new InstructionScreenViewer();
	instructionController = new InstructionScreenController();
	selectionModel = new SelectionScreenModel();
	selectionViewer = new SelectionScreenViewer();
	selectionController = new SelectionScreenController();
	//initialize all screen classes except for BattleScreen, which will be inited by the SelectionScreen
	curScreenViewer = titleViewer;
	curScreenController = titleController;
	//assign current screen to title screen
	setLayout(new GridBagLayout()); 
	curScreenViewer.add();
	//Set up buffered image screen
    } // init method
    
    public void start(){
	frameTimer.scheduleAtFixedRate(frameTask, 0, Math.round(1000/MasterModel.FPS));
    }
    
    public void updateScreen(){ //Checks for update then changes screen (helper)
	if (MasterModel.screenUpdateFlag){
	    curScreenViewer.remove();
	    
	    if (MasterModel.getScreen() == "Title"){
		curScreenViewer = titleViewer;
		curScreenController = titleController;
	    }
	    else if (MasterModel.getScreen() == "Instruction"){
		curScreenViewer = instructionViewer;
		curScreenController = instructionController;
	    }
	    else if (MasterModel.getScreen() == "Selection"){
		curScreenViewer = selectionViewer;
		curScreenController = selectionController;
	    }
	    else if (MasterModel.getScreen() == "Battle"){
		curScreenViewer = battleViewer;
		curScreenController = battleController;
		addKeyListener(battleController);
	    }
	    //Add more conditions
	    
	    MasterModel.screenUpdateFlag = false;
	    curScreenViewer.add();
	}
    }

    public void paint(Graphics g){
    // if (g == null){
    //         System.out.println("null");
    //     }
	g.drawImage(bufferedScreen, 0, 0, this);
	rescale();
	curScreenViewer.draw(bufferedScreen.getGraphics());
	
	//Resize the screen and then draws current screen
    }
    
    public boolean action (Event event, Object o){
	curScreenController.handler(event);
	updateScreen();
	validate();
	repaint();
	return true;
    }
    
} // MainApplet class
