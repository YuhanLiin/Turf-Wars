class DashController extends SkillController{
    public void activeProcess(SkillModel skill, CharModel character){
	super.activeProcess(skill, character);
	if (skill.curFrame > skill.getEndFrame()/3){
	    character.curSpeed = character.getBaseSpeed()*4;
	    character.canTurn = false;
	    character.canMove = true;
	}
	
	if (skill.curFrame >= skill.getEndFrame()){
	    character.curSpeed = character.getBaseSpeed();
	    character.canTurn = true;
	}
    }
}
