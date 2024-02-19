import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class MyStackTest {
	public MyStack<String> stringS;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleS
	public MyStack<Double> doubleS;
	MyStack<Double> doubleQ;
	// STUDENT: add variables as needed for your student tests
	double dQ = 67.8;
	double eQ = 89.0;
	double fQ = 0.0;
	@BeforeEach
	public void setUp() throws Exception {
		stringS = new MyStack<String>(5);
		stringS.push(a);
		stringS.push(b);
		stringS.push(c);
		
		//STUDENT: add setup for doubleS for student tests
		doubleS = new MyStack<Double>();
		doubleS.push(77.9);
		doubleS.push(12.4);
		doubleS.push(90.3);
		
		doubleQ = new MyStack<Double>(5);
		doubleQ.push(12.3);
		doubleQ.push(45.6);
		doubleQ.push(78.9);
		
		
		
		
	}

	@AfterEach
	public void tearDown() throws Exception {
		stringS = null;
		doubleS = null;
	}

	@Test
	public void testIsEmpty() throws StackUnderflowException {
		assertEquals(false,stringS.isEmpty());
		stringS.pop();
		stringS.pop();
		stringS.pop();
		assertEquals(true, stringS.isEmpty());
	}

	@Test
	public void testIsFull() throws StackOverflowException {
		assertEquals(false, stringS.isFull());
		stringS.push(d);
		stringS.push(e);
		assertEquals(true, stringS.isFull());
	}

	@Test
	public void testPop() {
		try {
			assertEquals(c, stringS.pop());
			assertEquals(b, stringS.pop());
			assertEquals(a, stringS.pop());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringS.pop();
			assertTrue(false, "This should have caused an StackUnderflowException");
		}
		catch (StackUnderflowException e){
			assertTrue(true, "This should have caused an StackUnderflowException");
		}
		catch (Exception e){
			assertTrue(false, "This should have caused an StackUnderflowException");
		}
	}

	@Test
	public void testPopStudent() {
		try {
			assertEquals(90.3, doubleS.pop());
			assertEquals(12.4, doubleS.pop());
			assertEquals(77.9, doubleS.pop());
			//Queue is empty, next statement should cause QueueUnderFlowException
			doubleS.pop();
			assertTrue(false, "This should have caused an StackUnderflowException");
		}
		catch (StackUnderflowException e){
			assertTrue(true, "This should have caused an StackUnderflowException");
		}
		catch (Exception e){
			assertTrue(false, "This should have caused an StackUnderflowException");
		}
	}

	@Test
	public void testTop() throws StackUnderflowException, StackOverflowException {
		assertEquals(c, stringS.top());
		stringS.push(d);
		assertEquals(d, stringS.top());
		stringS.pop();
		stringS.pop();
		assertEquals(b, stringS.top());		
	}

	@Test
	public void testSize() throws StackOverflowException, StackUnderflowException {
		assertEquals(3, stringS.size());
		stringS.push(d);
		assertEquals(4, stringS.size());
		stringS.pop();
		stringS.pop();
		assertEquals(2, stringS.size());
	}

	@Test
	public void testPush() {
		try {
			assertEquals(3, stringS.size());
			assertEquals(true, stringS.push(d));
			assertEquals(4, stringS.size());
			assertEquals(true, stringS.push(e));
			assertEquals(5, stringS.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringS.push(f);
			assertTrue(false, "This should have caused an StackOverflowException");
		}
		catch (StackOverflowException e){
			assertTrue(true, "This should have caused an StackOverflowException");
		}
		catch (Exception e){
			assertTrue(false, "This should have caused an StackOverflowException");
		}
	}

	@Test
	public void testPushStudent() {
		try {
			assertEquals(3, doubleQ.size());
			assertEquals(true, doubleQ.push(dQ));
			assertEquals(4, doubleQ.size());
			assertEquals(true, doubleQ.push(eQ));
			assertEquals(5, doubleQ.size());
			//Queue is full, next statement should cause QueueOverFlowException
			
			doubleQ.push(fQ);
			assertTrue(false, "This should have caused an StackOverflowException");
		}
		catch (StackOverflowException e){
			assertTrue(true, "This should have caused an StackOverflowException");
		}
		catch (Exception e){
			assertTrue(false, "This should have caused an StackOverflowException");
		}
	}
	
	@Test
	public void testToString() throws StackOverflowException {
		assertEquals("abc", stringS.toString());
		stringS.push(d);
		assertEquals("abcd", stringS.toString());
		stringS.push(e);
		assertEquals("abcde", stringS.toString());
	}

	@Test
	public void testToStringStudent() throws StackOverflowException {
		assertEquals("12.345.678.9", doubleQ.toString());
		doubleQ.push(dQ);
		assertEquals("12.345.678.967.8", doubleQ.toString());
		doubleQ.push(eQ);
		assertEquals("12.345.678.967.889.0", doubleQ.toString());
	}
	
	
	@Test
	public void testToStringDelimiter() throws StackOverflowException {
		assertEquals("a%b%c", stringS.toString("%"));
		stringS.push(d);
		assertEquals("a&b&c&d", stringS.toString("&"));
		stringS.push(e);
		assertEquals("a/b/c/d/e", stringS.toString("/"));
	}

	@Test
	public void testFill() throws StackOverflowException, StackUnderflowException {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringS = new MyStack<String>(5);
		//fill with an ArrayList
		stringS.fill(fill);
		assertEquals(3,stringS.size());
		assertEquals("carrot", stringS.pop());
		assertEquals("banana", stringS.pop());
		assertEquals("apple", stringS.pop());		
	}

}
