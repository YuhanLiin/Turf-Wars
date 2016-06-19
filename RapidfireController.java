class RapidfireController extends SkillController{
    public void activeProcess (SkillModel skill, CharModel character)
    {
	super.activeProcess (skill, character);
	if (skill.curFrame == 2)
	{
	    for (int i=0; i<3; i++){
		character.skills[i].curCooldown = 0;
	    }
	    //reset all cooldowns
	}
    }
}
