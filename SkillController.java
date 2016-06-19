import java.util.Vector;

abstract class SkillController extends Controller{ 
    
    protected Vector controllers;
    protected Vector viewers;
    
    public void setVectors(Vector c, Vector v){
	controllers = c;
	viewers = v;
    }
    
    public void use(SkillModel skill){
	//Runs when a skill is used, activating it
	if (skill.curCooldown == 0){
	    skill.isActive = true;
	    skill.curFrame = 1;
	    skill.curCooldown = skill.getCooldown();
	}
    }
    
    final public void frameProcess(SkillModel skill, CharModel character){
	//Process for skill every frame 
	if (skill.isActive){
	    activeProcess(skill, character);
	}
	skill.lowerCooldown();
    }
    
    public void activeProcess(SkillModel skill, CharModel character){
	//Base Computations when skill is active. Right now just reduces cooldown, increases current frame #, and locks character from acting
	skill.curFrame++;
	character.canAct = false;
	if (skill.curFrame >= skill.getEndFrame()){
	    //Skill is done
	    character.canAct = true;
	    skill.isActive = false;
	}
    }
}
