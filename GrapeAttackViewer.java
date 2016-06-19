import java.awt.*;

class GrapeAttackViewer extends AttackViewer{
    public void drawArgs(Graphics g, int x, int y, int radius){
	g.setColor(Color.orange);
	g.fillOval(scaleX(x-radius), scaleY(y-radius), scaleX(radius*2), scaleY(radius*2));
    }
}
