import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class BinaryArea extends KrasserHamster{

	private int length;
	private int height;

	public BinaryArea(int r, int s, int b, int k, int f){
		super(r, s, b, k, f);
		this.length = getLength();
		this.height = getHeight();
		
	}
	
	public void writeInBinary(int number){
		bottomRightCorner();
    	int[] binary = toBinary(number, length);
		setDirection(3);
		for(int i = binary.length; i > 1; i -= 1){
			if(binary[i - 1] == 1){
				gib();
			}
			vor();
		}
	}
	
	public int measure(){
		return length * height;
	}
	
	
}

