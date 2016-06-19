class CutController extends SkillController{
    public void activeProcess(SkillModel skill, CharModel character){
	super.activeProcess(skill, character);
	if (skill.curFrame == skill.getEndFrame()/4){
	    controllers.add(new AttackController(character.posx+character.facex*40,character.posy+character.facey*40,30,2));
	    viewers.add(new CutAttackViewer());
	}
    }
}
