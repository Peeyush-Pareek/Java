// Java program to demonstrate working of
// interface

import java.io.*;

// A simple interface
interface Inter1 {

	// public, static and final
	final int b = 25;

	// public and abstract
	void show();
}

// A class that implements the interface.
class TestClass implements Inter1 {

	// Implementing the capabilities of
	// interface.
	public void show(){ 
	System.out.println("Implementation in class"); 
	}

	// Driver Code
	public static void main(String[] args)
	{
		TestClass t = new TestClass();
		t.show();
		System.out.println(b);
	}
}
