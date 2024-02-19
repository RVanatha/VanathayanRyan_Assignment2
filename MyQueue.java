import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface{
	//Attributes
	private int capacity;
	private final int DEAFULT_CAPACITY = 50;
	private ArrayList<T> myQueue;
	
	//Constructor that takes the int arguement and sets it to the capacity opf the queue
	public MyQueue(int i) {
		myQueue = new ArrayList<T>(i);
		capacity = i;
	}
	
	//No arguement Constructor that sets capacity to 50
	public MyQueue() {
		myQueue = new ArrayList<T>(DEAFULT_CAPACITY);
		capacity = DEAFULT_CAPACITY;
	}
	
	//Methods
	//Checks to see if this queue is empty
	@Override
	public boolean isEmpty() {
		
		 if(myQueue.isEmpty())
		 	return true;
		 
		return false;
	}

	//Checks to see if the queue is full
	@Override
	public boolean isFull() {
		
		if(myQueue.size() == capacity)
			return true;
		
		return false;
	}

	//Deletes a value from the queue
	@Override
	public Object dequeue() throws QueueUnderflowException {
		
		if(myQueue.size() == 0)
			throw new QueueUnderflowException();
		
		T item_removed = myQueue.remove(0);
		
		return item_removed;
	}

	//Returns the amount of values in the queue
	@Override
	public int size() {
		
		return myQueue.size();
	}

	//Adds a value to the queue
	@SuppressWarnings("unchecked")
	@Override
	public boolean enqueue(Object e) throws QueueOverflowException {
		
		if(myQueue.size() == capacity)
			throw new QueueOverflowException();
		
		myQueue.add((T) e);
		
		return true;
	}

	//Returns all the values in the queue in string format 
	public String toString() {
		
		StringBuilder str = new StringBuilder();
		
		for(int i = 0; i < myQueue.size(); i++)
			str.append(myQueue.get(i));
		
		return str.toString();
	}

	//Returns all the values in the queue in string format separated by a delimeter 
	@Override
	public String toString(String delimiter) {
		
		StringBuilder str = new StringBuilder();
		
		for(int i = 0; i < myQueue.size(); i++) {
			
			str.append(myQueue.get(i));
			
			if(i < myQueue.size() - 1)
				str.append(delimiter);
		}
		
		return str.toString();
	}

	//Fills the queue with values in the arraylist 
	@Override
	public void fill(ArrayList list) throws QueueOverflowException {
		
		for(int i = 0; i < list.size(); i++){
			
			if(myQueue.size() == capacity)
				throw new QueueOverflowException();
			
			if(myQueue.size() == 0)
				myQueue.add((T)list.get(i));
			else
				myQueue.add((T) list.get(i));
				
			
		}
	
	}

}
