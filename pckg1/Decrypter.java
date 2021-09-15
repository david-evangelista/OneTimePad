package pckg1;

public class Decrypter {

	protected String plaintxt; // will hold plaintext when decrypted
	
	/**
	 * Default Constructor
	 */
	public Decrypter() {
	}
	
	/**
	 * Parameter Constructor
	 * @param plaintxt will hold the plaintext to decrypt
	 * @param key holds the key to use
	 * Each character XOR's the cipher and the key in order to produce the String
	 * plaintext, which holds the encrypted text
	 */
	public Decrypter (String cipher, Key key) {
		char[] dec_plaintxt = new char[key.getLength()];	// character array that will hold the decrypted characters
		
		for (int i = 0; i < key.getLength(); i++)
			dec_plaintxt[i]= (char) (cipher.charAt(i) ^ key.toString().charAt(i)); // XOR the characters at index i
	
		this.plaintxt = new String(dec_plaintxt); // converting to string and returning
	}
	
	
	
	public String toString() {
		return plaintxt;
	}
	
}
