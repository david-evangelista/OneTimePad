package pckg1;

public class Key {

	protected String key;
	protected int length;

	/**
	 * default constructor
	 */
	public Key () {	
	}
	
	/**
	 * This generates a key of pseudo-random numbers ranging between 0 and 255, of length "length"
	 * @param length refers to the number of characters
	 */
	public Key (int length) {
		this.length = length;
		char[] array = new char[length];

		for (int i = 0; i < array.length; i++) {
			array[i] = (char) (int)(Math.random()*255 + 1); // generates a pseudo-random number between 0 and 255, stores it into array as character	
		} // for	
		
		this.key = new String(array);
	}

	/**
	 * Getter
	 * @return length of key
	 */
	public int getLength() {
		return length;
	}
	
	public String toString() {
		return key;
	}
	
	/**
	 * Prints out the key
	 * @param length refers to the length of the key (number of characters)
	 */
	public void printKey(int length) {		
		System.out.println("Key: \'"+ key+"\'\n");
	}
	
	


}
