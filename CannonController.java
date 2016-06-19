class CannonController extends SkillController{
    public void activeProcess (SkillModel skill, CharModel character)
    {
	super.activeProcess (skill, character);
	if (skill.curFrame == skill.getEndFrame () / 2)
	{
	    controllers.add (new ProjectileController (character.posx + character.facex * 60, character.posy + character.facey * 60, 60, character.facex, character.facey, 8));
	    viewers.add (new CannonAttackViewer ());
	}
    }
}
