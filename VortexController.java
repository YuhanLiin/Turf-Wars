class VortexController extends SkillController{
    public void activeProcess(SkillModel skill, CharModel character){
	super.activeProcess(skill, character);
	if (skill.curFrame >= MasterModel.FPS/3){
	    //Move starts at half a second. Uses a one frame hitbox every time
	    controllers.add(new AttackController(character.posx, character.posy, (int)(character.radius*2.5), 2));
	    viewers.add(new VortexAttackViewer(skill.curFrame%7));
	    character.invincible = true;
	}
	if (skill.curFrame >= skill.getEndFrame()){
	    character.invincible = false;
	}
    }
}
