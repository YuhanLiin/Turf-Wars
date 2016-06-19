import java.awt.*;
class VortexViewer extends SkillViewer{
	private int frameNum = 0; 
	private final int totalFrame = MasterModel.FPS/3-1;
	
	public void drawArgs(Graphics g, int x, int y, int radius, int facex, int facey){
	    if (frameNum < totalFrame){
		float ratio = (totalFrame-frameNum%totalFrame) / (float)(totalFrame);
		g.setColor(Color.gray);
		g.fillOval(scaleX(x-Math.round(ratio*radius)), scaleY(y-Math.round(ratio*radius)), scaleX(2*Math.round(ratio*radius)), scaleY(2*Math.round(ratio*radius)));
	    }
	    
	    if (frameNum >= MasterModel.FPS*4){
		frameNum = 0;
	    }
	    frameNum++;
	}
    
}
