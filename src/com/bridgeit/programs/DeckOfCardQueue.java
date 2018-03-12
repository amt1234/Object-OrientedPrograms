package com.bridgeit.programs;

public class DeckOfCardQueue {

	private Node front, rear; 
	private int currentSize; // number of items 

	private class Node//linked list
	{ 
		String data;
		Node next;
	} 
	public DeckOfCardQueue()//constructor
	{
		front = null;
		rear = null;
		currentSize = 0;
	}
	public boolean isEmpty()
	{
		return (currentSize == 0);
	}
	public void push(String data)
	{
		Node oldRear = rear;
		rear = new Node();
		rear.data = data;
		rear.next = null;
		if (isEmpty()) 
		{
			front = rear;
		}
		else 
		{
			oldRear.next = rear;
		}
		currentSize++;
		System.out.println(data);
	}
	
	public  String[][] sort(String[][] array) {
		Node temp=front;
		
		int i,j;
		
		for(i=0;i<array.length;i++) {
			for(j=i+1;j<array.length;j++) {
				
			}
		}
		return array;
	}
	
	public  <T extends Comparable> T[][] printBubble(T[][] array)
    {
   	 T temp;
   	 int i,j;
	   	for (i = 0; i < array.length; i++) 
	   	{
			for (j = 0; j < array.length-i-1; j++)
			{
				if((array[i][j].compareTo(array[i][j+1]))>0)
				{
				temp=array[i][j];
				array[i][j]=array[i][j+1];
				array[i][j+1]=temp;
				}
			}
		}
		return array;
	
    }
}
