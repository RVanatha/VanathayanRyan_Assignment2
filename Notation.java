import java.util.*;
public class Notation {

	public Notation() {
		
	}

	//This programs converts Infix expression to an postfix expression through using a for loop and examining each character in the expression
	@SuppressWarnings("unchecked")
	public static String convertInfixToPostfix​(String infix) throws InvalidNotationFormatException{
		
		MyStack stack = new MyStack(infix.length());
		
		MyQueue queue = new MyQueue(infix.length());
		
		char[] ar = infix.toCharArray();
		
		try {
			
			for(int i = 0; i < ar.length; i++) 
			{
				if(ar[i] == ' ')
					continue;
				
				if(Character.isDigit(ar[i]))
					queue.enqueue(ar[i]);
				
				else if(ar[i] == '(')
					stack.push(ar[i]);
				
				else if(operator(ar[i])) {
						if(!stack.isEmpty()) {
	
							if(ar[i] == '*' || ar[i] == '/') {
								
								while (stack.top().equals('('))
									
									queue.enqueue(stack.pop());
							} 
							
							else {		
								
								while (stack.top().equals('*') || stack.top().equals('/'))		
									queue.enqueue(stack.pop());
							}
						}
						
						stack.push(ar[i]);
				}
				
				if(ar[i] == ')') {
					
					while(!stack.top().equals('(')) 
						queue.enqueue(stack.pop());
					
					queue.enqueue(stack.pop());
				}
						
			}
			
			while(!stack.isEmpty())
				queue.enqueue(stack.pop());
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return  queue.toString();
	}
	
	//This method evaluates a postfix expression 
	public static String convertPostfixToInfix​(String postfix) throws InvalidNotationFormatException {
		
		MyStack stack = new MyStack(postfix.length());
				
		char[] ar = postfix.toCharArray();
		
		try {
			
			for(int i = 0; i < postfix.length(); i++) {
				
				if(!operator(ar[i]))
					stack.push(ar[i]);
				
				else if(operator(ar[i])) {
			
					String two = (String) stack.pop();		
					String one  = (String) stack.pop();
					
					String str = "(" + one + ar[i] + two + ")";
					
					stack.push(str);
				}						
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return stack.toString();
	}
	
	//This programs converts postfix expression to an infix expression through using a for loop and examining each character in the expression
	public static double evaluatePostfixExpression​(String postfixExpr) throws InvalidNotationFormatException{
		
		MyStack<Double> stack = new MyStack<Double>(postfixExpr.length());
		char[] ar = postfixExpr.toCharArray();

		try {
			
			for(int i = 0; i < postfixExpr.length(); i++) {
				
				if(!operator(ar[i]))
					stack.push((double) ar[i]);
				
				else if(operator(ar[i])) {
					
					double two = stack.pop();
					double one = stack.pop();
					double ans = 0.0;
					
					if(ar[i] =='+')
						ans = one + two;
					
					else if(ar[i] =='-')
						ans = one - two;
					
					else if(ar[i] =='*')
						ans = one * two;
					
					else if(ar[i] =='/')
						ans = one / two;	
					
					stack.push(ans);
				}
					
			}
			
			if(stack.size() >1)
				throw new InvalidNotationFormatException();
			
			return stack.pop();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return 0.0;
	}

	//This class determines whether the character is an operator
	public static boolean operator(char c) {
		
		if(c == '+' || c == '-' || c == '*' || c == '/')
			return true;
		return false;
	}
	
	//This class determines whether the character is an operator
	public static <T> boolean operator(T c) {
		
		if(c.equals('+') || c.equals('-') || c.equals('*') || c.equals('/'))
			return true;
		return false;
	}
	
}
