class GrapeshotController extends SkillController{
    public void activeProcess(SkillModel skill, CharModel character){
	super.activeProcess(skill, character);
	
	if (skill.curFrame == skill.getEndFrame()-1){
	    Pair dir1, dir2; 
	    if (character.facex == 0){
		dir1 = new Pair(1, character.facey);
		dir2 = new Pair(-1, character.facey);
	    }
	    else if (character.facey == 0){
		dir1 = new Pair(character.facex, 1);
		dir2 = new Pair(character.facex, -1);
	    }
	    else{
		dir1 = new Pair(character.facex, 0);
		dir2 = new Pair(0, character.facey);
	    }
	    
	    controllers.add(new ProjectileController(character.posx+character.facex*15,character.posy+character.facey*15, 10, character.facex, character.facey, 35));
	    controllers.add(new ProjectileController(character.posx+dir1.x*15,character.posy+dir1.y*15, 10, dir1.x, dir1.y, 35));
	    controllers.add(new ProjectileController(character.posx+dir2.x*15,character.posy+dir2.y*15, 10, dir2.x, dir2.y, 35));
	    viewers.add(new GrapeAttackViewer());
	    viewers.add(new GrapeAttackViewer());
	    viewers.add(new GrapeAttackViewer());
	}
    }
}
