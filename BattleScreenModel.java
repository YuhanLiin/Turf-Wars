class BattleScreenModel{
    CharModel p1CharModel, p2CharModel;
    public final int hudHeight = 100;
    public int winner = 0;
    //Number of winner player. Starts at zero.
    
    public BattleScreenModel (CharModel char1, CharModel char2){
	p1CharModel = char1;
	p2CharModel = char2;
	char1.posx = 50;
	char1.posy = 50+hudHeight;
	char2.posx = MasterModel.HoriCellCount-50;
	char2.posy = MasterModel.VertCellCount-50-hudHeight;
	char1.facex = 1;
	char2.facex = -1;
	char1.facey = 1;
	char1.facey = -1;
    }
}
