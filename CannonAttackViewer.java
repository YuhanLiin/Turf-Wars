import java.awt.*;

class CannonAttackViewer extends AttackViewer{
    int frameNum = 0;    

    public void drawArgs(Graphics g, int x, int y, int radius){
	int state = (frameNum%16)/3;
	g.setColor(Color.black);
	g.fillOval(scaleX(x-radius), scaleY(y-radius), scaleX(radius*2), scaleY(radius*2));
	g.setColor(Color.white);
	g.drawOval(scaleX(x-(int)(radius*0.2*state)), scaleY(y-(int)(radius*0.2*state)), scaleX((int)(2*radius*0.2*state)), scaleY((int)(2*radius*0.2*state)));
	frameNum ++;
    }
}
