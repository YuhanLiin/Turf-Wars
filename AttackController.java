import java.awt.Graphics;

class AttackController extends Controller{    
    int posx, posy;
    int radius;
    //Position and radius
    protected int curFrame;
    //Frames passed since attack initiated
    protected int endFrame;
    //Frame on which attack ends
    
    public AttackController(int x, int y, int r, int ef){
	posx = x;
	posy = y;
	radius = r;
	curFrame = 1;
	endFrame = ef;
    }
    
    public boolean frameProcess(){
	//Computes process for each frame of attack and returns whther attack should continue
	//In this case, end when attack reaches end frame
	curFrame++;
	if (curFrame > endFrame){
	    return false;
	}
	return true;
    }

    private boolean checkHit(CharModel character){
	//Checks if target character has been hit. Circle hitbox check
	double dist = Math.sqrt(Math.pow(posx-character.posx, 2) + Math.pow(posy-character.posy, 2));
	return dist < radius + character.radius;
    }
    
    protected void hitEffect (CharModel character){
	//What happens when character is hit. Defaults to death
	character.isAlive = false;
    }
    
    public void hitProcess (CharModel character){
	if (checkHit(character) && !character.invincible){
	    //System.out.println("Gottem");
	    //System.out.println("Boys");
	    hitEffect(character);
	}
    }
    
    

}
