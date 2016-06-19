import java.awt.Graphics;
abstract class SkillViewer extends Viewer{
    
    public void draw(Graphics g){}
    abstract public void drawArgs(Graphics g, int x, int y, int radius, int facex, int facey);
}
