class ControlParser{
    int controls[];
    //Control key representation of each index: 0-up, 1-down, 2-left, 3-right, 4-skill0, 5-skill1, 6-skill2, 7-skill3
    static boolean keys[];
    
    public ControlParser(int c[]){
	controls = c;
    }
    
    public Pair moveCommand(){
	// for (int i=0; i<8; i++){
	//     System.out.print(controls[i]);
	// } 
	// System.out.println();
	//Read the key array and return a pair to represent the direction the character is facing based on which keys are pressed
	if (keys[controls[0]] && keys[controls[2]]){
	    //Upper left
	    return new Pair(-1,-1);
	}
	if (keys[controls[0]] && keys[controls[3]]){
	    //Upper right
	    return new Pair(1,-1);
	}
	if (keys[controls[1]] && keys[controls[2]]){
	    //Down left
	    return new Pair(-1,1);
	}
	if (keys[controls[1]] && keys[controls[3]]){
	    //Down right
	    return new Pair(1,1);
	}
	if (keys[controls[0]]){
	    //Up
	    return new Pair(0, -1);
	}
	if (keys[controls[1]]){
	    //Down
	    return new Pair(0, 1);
	}
	if (keys[controls[2]]){
	    //Left
	    return new Pair(-1, 0);
	}
	if (keys[controls[3]]){
	    //Right
	    return new Pair(1, 0);
	}
	//No buttons are pressed. Ignore this case
	return new Pair(0,0);
    }
    
    public int skillCommand(){
	//Read key array and return an int i for which skills[i] should be used.
	for (int i=4; i<=7; i++){
	    if (keys[controls[i]]){
		return i-4;
	    }
	}
	//If no skills are used
	return -1;
    }
}
