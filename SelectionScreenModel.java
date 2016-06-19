class SelectionScreenModel{
    boolean p1Select = true;
    CharModel characters[] = new CharModel[MasterModel.charCount];
    CharModel characters2[] = new CharModel[MasterModel.charCount];
    int charNum = 0;
    
    public SelectionScreenModel(){
	characters[0] = new SlasherModel();
	characters[1] = new BlasterModel();
	characters2[0] = new SlasherModel();
	characters2[1] = new BlasterModel();
    }
    
    public CharModel getCurChar(){
	return characters[charNum];
    }
}
