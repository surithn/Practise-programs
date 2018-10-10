package hello;

/**
 * encryption technique
 * 
 * @author kxhb130
 *
 */
public class CeaserCipher {

	/**
	 * E = (x+n) mod 26
	 * 
	 * @param text
	 * @return
	 */
	public static String encrypt(String ceaser, int code) {
		if (ceaser == null || ceaser.isEmpty())
			return ceaser;
		StringBuilder res = new StringBuilder();
		for (char ch: ceaser.toCharArray()) {
			res.append((char)((((int)ch + code + 65)%26) + 65));
		}
		return res.toString();
	}

	/**
	 * D = (x-n)mod26;
	 * @param cipher
	 */
	public static String decrypt(String cipher, int code) {
		if (cipher == null || cipher.isEmpty())
			return cipher;
		StringBuilder sb = new StringBuilder();
		for (char ch: cipher.toCharArray()) 
			sb.append((char)((((int)ch - code + 65)%26)+65));
		return sb.toString();
	}

	public static void main(String[] s) {
		System.out.println(encrypt("ABCDE", 4));
		System.out.println(decrypt("EFGHI", 4));
	}
}
