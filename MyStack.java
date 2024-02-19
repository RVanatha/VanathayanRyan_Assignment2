import java.util.*;

public class MyStack<T> implements StackInterface<T>{

	//Attributes
	ArrayList<T> myStack;
	private int capacity;
	private final int DEAFULT_CAPACITY = 50;

	//Constructor that takes the int arguement and sets it to the capacity opf the stack
	public MyStack(int i) {
		myStack = new ArrayList<T>(i);
		capacity = i;
	}
	
	//No arguement Constructor that sets capacity to 50
	public MyStack() {
		myStack = new ArrayList<T>(DEAFULT_CAPACITY);
		capacity = DEAFULT_CAPACITY;
	}
	
	//Methods
	
	//Checks to see if this stack is empty
	@Override
	public boolean isEmpty() {
		
		if(myStack.size() == 0)
			return true;
		
		return false;
	}
	
	//Checks to see if the stack is full
	@Override
	public boolean isFull() {
		
		if(myStack.size() == capacity)
			return true;
		
		return false;
	}

	//Deletes the top value from the stack
	@Override
	public T pop() throws StackUnderflowException {
		
		if(isEmpty())
			throw new StackUnderflowException();
		
		T item_removed = myStack.remove(myStack.size() - 1);
		
		return item_removed;
	}

	//Returns the top value in the stack
	@Override
	public T top() throws StackUnderflowException {
		
		if(myStack.size() == 0)
			throw new StackUnderflowException();
		
		return myStack.get(myStack.size() - 1);
	}

	//Returns the how many values are in the stack
	@Override
	public int size() {
		
		return myStack.size();
	}

	//Adds a value into the stack
	@Override
	public boolean push(T e) throws StackOverflowException{
		
		if(myStack.size() == capacity)
			throw new StackOverflowException();
		
		else if(myStack.isEmpty()) {
			myStack.add(e);
			return true;
		}
		myStack.add(e);
		
		return true;
	}

	//Returns all the values in the stack in string format 
	public String toString() {
	
		StringBuilder str = new StringBuilder();
		
		for(int i = 0; i < myStack.size(); i++) {
			str.append(myStack.get(i));
		}
		
		
		return str.toString();
	}
	
	//Returns all the values in the stack in string format separated by a delimeter 
	@Override
	public String toString(String delimiter) {
		
		StringBuilder str = new StringBuilder();
		
		for(int i = 0; i < myStack.size(); i++) {
			
			str.append(myStack.get(i));
			
			if(i < myStack.size() - 1)
				str.append(delimiter);
		}
		
		return str.toString();
		
	}

	//Fills the stack with the values in the Arraylist 
	@Override
	public void fill(ArrayList<T> list) throws StackOverflowException{
		
		for(int i = 0; i < list.size();i++){
			
			if(myStack.size() == capacity)
				throw new StackOverflowException();
			
			if(myStack.size() == 0)
				myStack.add(list.get(i));
			
			else
				myStack.add(list.get(i));
				
			
		}
		
	}

	
}
