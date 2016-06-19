import java.awt.Graphics;

abstract class AttackViewer extends Viewer{
    public void draw(Graphics g){}
    abstract public void drawArgs(Graphics g, int x, int y, int r);
}
