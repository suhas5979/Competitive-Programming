package dataStructuresAndAlgorithms.string;

public class StringReccursion {

	// Runner
	public static void main(String[] args) {

		System.out.println(shiftCharacters("india is my country",'i'));

	}
	
	static String reverseString(String str) {
		if(str.length() == 0) return "";
		String res = reverseString(str.substring(1));
		return res + Character.toString(str.charAt(0));
	}
	static String removeAll(String str,char c) {
		if(str.length() == 0) return "";
		String res = removeAll(str.substring(1), c);
		if(str.charAt(0) == c) return res;
		return str.charAt(0) + res;
	}
	static String shiftCharacters(String str , char c) {
		if(str.length() == 0) return "";
		String res = shiftCharacters(str.substring(1), c);
		if(str.charAt(0) == c) return res + str.charAt(0);
		return str.charAt(0) + res;
	}
	

}
