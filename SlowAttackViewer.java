import java.awt.*;
class SlowAttackViewer extends AttackViewer{
    public void drawArgs(Graphics g, int x, int y, int radius){
	g.setColor(Color.yellow);
	g.fillOval(scaleX(x-radius), scaleY(y-radius), scaleX(radius*2), scaleY(radius*2));
    }
}
