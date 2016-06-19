class SlowdownController extends SkillController {
    public void activeProcess(SkillModel skill, CharModel character){
	super.activeProcess(skill, character);
	if (skill.curFrame == skill.getEndFrame()/3){
	    controllers.add(new SlowAttackController(character.posx,character.posy, 80, MasterModel.FPS/2));
	    viewers.add(new SlowAttackViewer());
	}
    } 
}
