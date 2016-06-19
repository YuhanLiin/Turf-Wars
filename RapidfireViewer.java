import java.awt.*;
class RapidfireViewer extends SkillViewer{
    private int frameNum = 0; 
    private final int totalFrame = MasterModel.FPS/10-1;
    public void drawArgs(Graphics g, int x, int y, int radius, int facex, int facey){
	float ratio = (totalFrame-frameNum%totalFrame) / (float)(totalFrame);
	g.setColor(Color.cyan);
	g.fillOval(scaleX(x-Math.round(ratio*radius)), scaleY(y-Math.round(ratio*radius)), scaleX(2*Math.round(ratio*radius)), scaleY(2*Math.round(ratio*radius)));
	frameNum++;
    }
}
