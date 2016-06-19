import java.awt.*;
import java.util.Vector;

class RecoilblastViewer extends SkillViewer{
    public void drawArgs(Graphics g, int x, int y, int r, int facex, int facey){
	int dir[] = {0,1,-1};
	Vector points = new Vector();
	int dist;
	Pair p;
	
	for(int i=0; i<3;i++){
	    for(int j=0; j<3;j++){
		if (dir[i] != 0 && dir[j] != 0){
		    dist = (int)(r/Math.sqrt(2));
		}
		else{
		    dist = r;
		}
		points.add(new Pair(dir[i]*dist+x, dir[j]*dist+y));
	    }
	}
	//Come up with the points upon which the speed lines with start
	
	g.setColor(Color.black);
	for (int i=0; i<points.size(); i++){
	    p = (Pair)(points.get(i));
	    g.drawLine(scaleX(p.x), scaleY(p.y), scaleX(p.x-80*facex), scaleY(p.y-80*facey));
	}
    }
}
