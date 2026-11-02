import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class KrasserHamster extends Hamster {
	public KrasserHamster(int r, int s, int b, int k, int f){
		super(r, s, b, k, f);
	}
	
	public void goTo(int x, int y){
		int xNow = getSpalte();
		int yNow = getReihe();
		resetDirection();
		rechtsUm();
		walk(y - yNow);
		linksUm();
		walk(x - xNow);
	}
	
	public void resetDirection(){
		int direction = getBlickrichtung();
		switch(direction){
			case 0:
				rechtsUm();
				break;
			case 1:
				break;
			case 2:
				linksUm();
				break;
			case 3:
				linksUm();
				linksUm();
				break;
		}
	}
	
	
	public void setDirection(int direction){
		resetDirection();
		switch(direction){
			case 0:
				linksUm();
				break;
			case 1:
				break;
			case 2:
				rechtsUm();
				break;
			case 3:
				linksUm();
				linksUm();
				break;
		}
		
	}
	
    public void rechtsUm(){
		linksUm();
		linksUm();
		linksUm();
	}
	
	public void walk(int max){
		for (int i = 0; i < max; i++){
			if(vornFrei()){
				vor();
			}
		}
	}
	
	public void walkUntilWall(){
		while(vornFrei()){
			vor();
		}
	}     
	
	public int getLength(){
		resetDirection();
		int length = 1;
		while(vornFrei()){
			length++;
			vor();
		}
		back(length);
		return length;
	}
	
	public int getHeight(){
		resetDirection();
		rechtsUm();
		int height = 1;
		while(vornFrei()){
			height++;
			vor();
		}
		back(height);
		return height;
	}
	
	public void bottomRightCorner(){
		resetDirection();
		rechtsUm();
		walkUntilWall();
		linksUm();
		walkUntilWall();
	}
	
	public int getBinaryCapacity(int length){
		int capacity = 1;
		for(int i = 0; i < length; i++){
			capacity *= 2;
		}
		return capacity;
	} 
	
	public int[] toBinary(int number, int squares){
		int[] inBinary = new int[squares];
		int max = getBinaryCapacity(squares) / 2;
		if(number > max){
			schreib("zu gross");
		}
		for(int i = 0; i < squares; i++, max /= 2){
			if(number - max >= 0){
				number -= max;
				inBinary[i] = 1;
			}
			else{
				inBinary[i] = 0;
			}
		}
		return inBinary;
	}
	
	public String arraytoString(int[] array){
		String result = "";
		for(int number : array){
			result += String.valueOf(number);
		}
		return result;
	}
	
	public void back(int length){
		kehrt();
		walk(length);
		kehrt();
	}	
	public int count(){
		int count = 0;
		while(kornDa()){
			nimm();
			count++;
		}
		for(int i = 0; i < count; i++){
			gib();
		}
		return count;
	}

	public void kehrt(){
		linksUm();
		linksUm();
	}
}
