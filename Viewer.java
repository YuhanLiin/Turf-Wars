import java.applet.*;
import java.awt.*;

abstract class Viewer{
    static MainApplet app;

    abstract public void draw(Graphics g);
    
    protected int write(Graphics g, String string, int lb, int rb, int y, String font, int fontsize, Color color){
	//Writes text that scales with the screen size and is bounded in a specific horizontal range
	//All numbers are provided in cells
	g.setFont(new Font(font, Font.PLAIN, (int)(scaleX(fontsize)*Toolkit.getDefaultToolkit().getScreenResolution() / 72.0))); //Set fontsize based on cell width to fit horizontal boundaries
	g.setColor(color);
	
	int linelen = (int)((rb-lb)/fontsize*1.5);
	int pos = 0;
	int row = 0; //tracks position in string and row count of current line
	String line = ""; // Represents current line
	while(pos < string.length()){ //Loops through the string to print it word by word
	    if (string.charAt(pos) == ' '){ 
		if (line.length() < linelen){
		//Shift the position to the right if space is not at the end of line
		    line += ' ';  
		}
		else{
		//go to next line if space is at the end of line
		    g.drawString(line, scaleX(lb), scaleY(y+row*2)+row*scaleX(fontsize));
		    row++;
		    line = "";
		}
		pos++;
	    }
	    else if (string.charAt(pos) == '\n'){
	    //go to next line when newline is encountered
		g.drawString(line, scaleX(lb), scaleY(y+row*2)+row*scaleX(fontsize));
		line = "";
		row++;
		pos++;
		//System.out.println(pos);
	    }
	    else{
	    //any other case requires the parsing of the next word in the string
		int t = pos;
		while (t < string.length() && string.charAt(t) != ' ' && string.charAt(t) != '\n'){ //Counts to the end of the next word, which is indexed by t (exclusive)
		    t++;
		    //System.out.println(string.charAt(t));
		}
		int len = t-pos;
		// if (line == "" && len > linelen){
		//     //if word is longer than an entire line, just print the part that fits and go on to the next line
		//     line = string.substring(pos, pos+linelen);
		//     g.drawString(line, scaleX(lb), scaleY(y+row*2)+row*scaleX(fontsize));
		//     pos += linelen;
		//     row++;
		//     line = "";
		// }
		if (linelen-line.length() >= len){
		    //if word fits, print it and shift position according to its length
		    line += string.substring(pos, t);
		    pos += len;
		}
		else{
		    // if word does not fit remaining line space, go to next line
		    g.drawString(line, scaleX(lb), scaleY(y+row*2)+row*scaleX(fontsize));
		    row++;
		    line = "";
		}
	    }
	}
	g.drawString(line, scaleX(lb), scaleY(y+row*2)+row*scaleX(fontsize));
	row++;
	return (int)Math.round((scaleY(y+row*2)+row*scaleX(fontsize))/MasterModel.cellHeight);
    }
    
    protected int scaleX(int x){
	return (int)(x*MasterModel.cellWidth);
    } 
    
    protected int scaleY(int y){
	return (int)(y*MasterModel.cellHeight);
    } 
}
