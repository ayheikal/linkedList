package data_structuresImplementation;

public class LinkedList {
	static Node head;
	static class Node{
		int data;
		Node next;
		
		 Node(int d) {
			data=d;
			next=null;
		}
		
	}
	/*********************************************/
	public static void insert(LinkedList list , int data) {
		//create anew  node with a data
		Node newNode=new Node(data);
		newNode.next=null;
		//check if its the header or not
		if(list.head==null) {
			list.head=newNode;
			
		}
		else {
			Node last=list.head;
			while(last.next!=null) {
				last=last.next;
			}
			last.next=newNode;
		}
		
	}
	/**************************************************/
	public static boolean isEmpty(LinkedList list) {
		if(list.head==null)return true;
		return false;
	}
	/***************************************************/
	public static int size(LinkedList list) {
		Node current=list.head;
		if(isEmpty(list)) {
			System.out.println("0");
			return 0;
			
		}
		int counter=1;
		while(current.next!=null) {
			counter++;
			current=current.next;
		}
		System.out.println(counter);
		return counter;
		
	}
	/**************************************************/
	public static void deletedbykey(LinkedList list, int key) {
		
		Node curNode=list.head,prev=null;boolean flag=false;
		if(list.head==null) {System.out.println("list already is empty");flag=true;}
		if(curNode!=null&&curNode.data==key) {
			list.head=curNode.next;
			System.out.println(key+ " is found and deleted ");
		}
		while(curNode!=null&&curNode.data!=key) {
			prev=curNode;
			curNode=curNode.next;
		}
		if(curNode!=null) {
			prev.next=curNode.next;
			System.out.println(key+ " is found and deleted ");
			
		}
		if(curNode==null&&flag==false) {
			System.out.println(key+ " is NOT found  ");
		}
		
		
	}
	/************************************************/
	public static void delteHead(LinkedList list) {
		Node current=list.head.next;
		list.head=current;
		
	}
	/*************************************************/
	public static void delteLast(LinkedList list) {
		Node current=list.head;
		while(current.next.next!=null) {
			current=current.next;
		}
		current.next=null;
		
	}
	/*************************************************/
	public static void insertAtHead(LinkedList list,int data) {
		if(isEmpty(list)) {
			list.insert(list, data);
		}
		else {
			Node newNode=new Node(data);
			Node prevhead=list.head;
			head=newNode;
			head.next=prevhead;
		
			
			
		}
	}
	/************************************************/
	public static boolean clear(LinkedList list) {
		if(isEmpty(list)) {
			return false;
		}
		list.head=null;
		
		return true;
		
	}
	/*********************************************************/
	public static void printList(LinkedList list) {
		if(isEmpty(list)) {System.out.println(" its empty");}
		else {
		System.out.println("List: ");
		Node curNode=list.head;
		while(curNode!=null) {
			System.out.println(curNode.data+"    ");
			curNode=curNode.next;
		}
		}
	}
	/*******************************************************/
	public static boolean search(LinkedList list,int data) {
		Node cur=list.head;
		if(isEmpty(list)) {
			System.out.println("List is empty");
			return false;
		}
		while(cur.next!=null) {
			if(cur.data=data) {
				return true;
			}
			cur=cur.next;
		}
		return false;
		
	}
	
	
	public static void main(String...strings) {
		System.out.println("creating linkedList :");
		
		LinkedList list=new LinkedList();
		list.deletedbykey(list, 2);
		list.size(list);
		list.insert(list, 5);
		list.insert(list, 4);
		list.insert(list, 3);
		list.insert(list, 2);
		list.insert(list, 1);
		//search for 2
		System.out.println("searched is :"+ list.search(list, 2));
		//delet head
		list.delteHead(list);
		//insert at head
		list.insertAtHead(list, 200);
		//delete last element 
		list.delteLast(list);
		//check if it's empty or not
		
		System.out.println(list.isEmpty(list));
		//size of list 
		list.size(list);
		//print list elements
		list.printList(list);
		System.out.println("after delete 3");
		list.deletedbykey(list, 3);
		list.printList(list);
		System.out.println( " after delete non found key like 3 ");
		list.deletedbykey(list, 3);
		list.clear(list);
		list.printList(list);
		list.size(list);
	}

}
