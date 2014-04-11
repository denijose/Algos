package Recursion;

public class Palidrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String word = "maayalam";
		if(isPalindrome(word.split(""),1,word.length()))
				System.out.println("the word is a palindrome");
		else
			System.out.println("the word is not a palindrome");

	}

	public static boolean isPalindrome(String[] word, int i, int j){
		if(i>=j)
			return true;
		if(word[i++].equalsIgnoreCase(word[j--]))
			return isPalindrome(word,i,j);
		else
		    return false;

		
	}
}
