package pckg1;

public class Encrypter {
	protected String cipher;
	
	/**
	 * Default Constructor
	 */
	public Encrypter() {
	}
	
	/**
	 * Parameter Constructor
	 * @param plaintxt holds the plaintext to encrypt
	 * @param key holds the key to use
	 * Each character XOR's the plaintext and the key in order to produce the String
	 * cipher, which holds the encrypted text
	 */
	public Encrypter (String plaintxt, Key key) {
		char[] cipher = new char[key.getLength()];	// character array that will hold the encrypted characters
		
		for (int i = 0; i < key.getLength(); i++)
			cipher[i]= (char) (plaintxt.charAt(i) ^ key.toString().charAt(i)); // XOR the characters at index i
	
		this.cipher = new String(cipher); // converting to string and returning
	}
	
	public String toString() {
		return cipher;
	}

}
