package dataStructuresAndAlgorithms.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElementsInQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k)
    {
        Stack<Integer> st = new Stack<>();
        while(k-- >0){
            st.push(q.poll());
        }
        Queue<Integer> temp = new LinkedList<>();
        while(!q.isEmpty()){
            temp.add(q.poll());
        }
        while(!st.isEmpty())
            q.add(st.pop());
        while(!temp.isEmpty())
            q.add(temp.poll());
        return q;
    }

}
