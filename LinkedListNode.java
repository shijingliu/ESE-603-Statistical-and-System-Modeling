package homework1;

//the basic linked list data structure. It will only allow to add node at the end. 
//the data in linkedlist is CustomerP3, which encapusulate the information of one customer. 
public class LinkedListNode {
	LinkedListNode next = null; 
	CustomerP3 data; 
	
	public LinkedListNode (CustomerP3 d){
		data = d; 
	}
	
	void appendToTail (CustomerP3 d){
		LinkedListNode end = new LinkedListNode (d);  
		LinkedListNode n = this; 
		while(n.next != null){
			n=n.next;
		}
		n.next = end;    
	}  
}

