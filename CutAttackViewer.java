import java.awt.*;

class CutAttackViewer extends AttackViewer{
    public void drawArgs(Graphics g, int x, int y, int radius){
	g.setColor(Color.red);
	g.fillOval(scaleX(x-radius), scaleY(y-radius), scaleX(radius*2), scaleY(radius*2));
    }
}
