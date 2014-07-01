package others;
//infix to postfix
import java.util.Stack;

public class InfixPostFix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(infixToPostFix("a+b*(c^d-e)^(f+g*h)-i"));

	}
	
	public static String infixToPostFix(String infix){
		Stack<String> s = new Stack<String>();
		s.push(".");
		String postFix = "";
		int i = 0;
		String[] array = infix.split("");
		while(!s.isEmpty() || i < infix.length()){
			if(i < array.length){
				String token = array[i++];
				if(isOperator(token)){
					while(priority(token) < priority(s.peek())){
						postFix += s.pop();
					}
					s.push(token);		
				}
				else if(token.equals("(")){
					s.push(token);
				}
				else if(token.equals(")")){
					while(true){
						String op = s.pop();
						if(op.equals("("))
							break;
						postFix += op;						
					}					      
				}	
				else{ // token is  a variable/operand here
					postFix += token;
				}				
			}
			else{
				postFix += s.pop();
			}
		}
		return postFix;
	}
	
	public static boolean isOperator(String s){
		if(s.equalsIgnoreCase("*") || s.equalsIgnoreCase("+") || s.equalsIgnoreCase("-") || s.equalsIgnoreCase("/") || s.equalsIgnoreCase("^"))
			return true;
		return false;
	}
	
	public static int priority(String op){
		if(op.equals("-"))
			return 1;
		if(op.equals("+"))
			return 2;
		if(op.equals("*"))
			return 3;
		if(op.equals("/"))
			return 4;
		if(op.equals("^"))
			return 5;
		
		return -1;		
	}

}
