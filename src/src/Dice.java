public class Dice {
			
	private DiceValue value;
	//constructor
	public Dice() {
		value =  DiceValue.getRandom();
	}
	
	public DiceValue getValue() {
		return value;
	}

	public DiceValue roll() {
		return DiceValue.getRandom();
	}		
	
	public String toString() {
		return value.toString();
	}
}
// test comment//