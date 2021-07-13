package dataStructuresAndAlgorithms.queue;

import java.util.Stack;

public class QueueUsingTwoStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    void Push(int x)
    {
	   while(!s2.isEmpty()){
	       s1.add(s2.pop());
	   }
	   s1.add(x);
	   while(!s1.isEmpty()){
	       s2.add(s1.pop());
	   }
    }
    int Pop()
    {
	   if(s2.isEmpty())
	    return -1;
	   return s2.pop();
    }

}
