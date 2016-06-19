class RecoilblastController extends SkillController
{
    public void activeProcess (SkillModel skill, CharModel character)
    {
	super.activeProcess (skill, character);
	if (skill.curFrame == skill.getEndFrame()/4){
	    controllers.add (new ProjectileController (character.posx + character.facex * 15, character.posy + character.facey * 15, 10, character.facex, character.facey, 25));
	    viewers.add (new GrapeAttackViewer ());
	    character.facex = -character.facex;
	    character.facey = -character.facey;
	    character.canTurn = false;
	    character.canMove = true;
	    character.invincible = true;
	}
	if (skill.curFrame > skill.getEndFrame()/4)
	{
	    character.curSpeed = character.getBaseSpeed () * 6;
	    character.canTurn = false;
	    character.canMove = true;
	}
	if (skill.curFrame == skill.getEndFrame()/2){
	    character.invincible = false;
	}
	if (skill.curFrame >= skill.getEndFrame()){
	    character.curSpeed = character.getBaseSpeed();
	    character.canTurn = true;
	}
    }
}
