import java.awt.*;

class VortexAttackViewer extends AttackViewer{
    private int spinstate;
    //Alternates between 0 and 1. Used to animate
    public VortexAttackViewer(int s){
	spinstate = s;
    }
    
    public void drawArgs(Graphics g, int x, int y, int r){
	g.setColor(Color.gray);
	g.fillOval(scaleX(x-r), scaleY(y-r), scaleX(r*2), scaleY(r*2));
	g.setColor(Color.black);
	g.drawOval(scaleX(x-2*r/3), scaleY(y-2*r/3), scaleX(r*4/3), scaleY(r*4/3));
	g.drawOval(scaleX(x-r/3), scaleY(y-r/3), scaleX(r*2/3), scaleY(r*2/3));
	g.setColor(Color.gray);
	if (spinstate<=3){
	    g.fillRect(scaleX(x-3*r/4), scaleY(y-r/4), scaleX(3*r/4), scaleY(r/2));
	    g.fillRect(scaleX(x+r/4), scaleY(y-r/4), scaleX(3*r/4), scaleY(r/2));
	}
	else{
	    g.fillRect(scaleX(x-r/4), scaleY(y-3*r/4), scaleX(r/2), scaleY(3*r/4));
	    g.fillRect(scaleX(x-r/4), scaleY(y+r/4), scaleX(r/2), scaleY(3*r/4));
	}
    }
}
