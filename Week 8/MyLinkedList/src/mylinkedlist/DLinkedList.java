package mylinkedlist;
import java.util.ArrayList;
/**
 *by Thomas Gilman
 *
 * A list of Data points with references to its next data point or previous data point
 * can be Incremented through using a Iterator and the data can be manipulated
 */
public class DLinkedList<T> {
    Node head=null; /**This is the First Node in the DLList*/
    Node tail=null; /**This is the Last Node in the DLList*/
    Iterator it; /**This is the DLList's Iterator*/
    DLinkedList(){
       this.it = new Iterator(); 
    }
    /**
     * A point in the DLList that holds the data given to it
     * It has a reference to data behind it and in front of it
     */
    class Node{
        T data;
        Node next = null;
        Node previous = null;
        Node(T d){
            data = d;
        }
    }
    //Points to Nodes in the list
    class Iterator{
        Node n;
        /**
         * Set the Iterator pointing to the next node if next node does not equal null
         * if next node is null it will tell you
         * returns data of node it is pointing at
         */
        T next(){
            if(n.next==null){
                System.out.println("Iterator pointing at null, nothing next\n");
            }
            else{
                n = n.next; //points to the next node
            }
            T tmp = n.data;
            return tmp;
        }
        /**
         * Set the Iterator pointing to the node behind it
         * and then returns its data
         * if there is no previous node, it will tell you and
         * return the data of the node it is pointing at
         */
        T previous(){
            if(n.previous==null){
                System.out.println("Your pointing at the first node, cant move back\n");
            }
            else{
                n = n.previous;
            }
            T tmp = n.data;
            return tmp;
        }
        /**
         * Is there a next node
         * returns false if next node is null
         */
        boolean hasNext(){
            return n.next!=null;
        }
        /**
         * Is there a previous node
         * returns false if previous node is null
         * returns true if there is a previous node
         */
        boolean hasPrevious(){
            return n.previous!=null;
        }
        /**
         * Sets the Iterator just past the tail of the list
         */
        void jumpToTail(){
            n=tail;
        }
        /**
         * Sets the Iterator just past the head of the list
         */
        void jumpToHead(){
            n=head;
        }
    }
    /**
     * Get the data of the data of the item the Iterator is pointing at
     */
    T get(){
        Node NodePointedAt = it.n;
        if(NodePointedAt==null){
            System.out.println("Your Cursor is not pointing at anything");
            return null;
        }
        else
            return NodePointedAt.data;
    }
    /**
     * Returns true if the Iterator can move backwards and it has a previous node
     * returns false if previous node is null
     */
    boolean canRetreat(){
        return it.hasPrevious();
    }
    /**
     * Returns true if the Iterator can move forward and it has a next node
     * returns false if next node is null
     */
    boolean canAdvance(){
        return it.hasNext();
    }
    /**
     * Compare the data of the node pointed at with the passed in data
     * returns true if the data is the same
     * false if the data is different
     */
    boolean compareNode(T data){
        Node NodePointedAt = it.n;
        T comparisonData = data;
        if(NodePointedAt.data==comparisonData)
            return true;
        return false;
    }
    /**
     * Compares the DLLists data
     * if the DLLists are not the same, returns false
     * returns true if DLLists are exactly the same
     */
    boolean compare(DLinkedList DLL2){
        this.it.jumpToHead();//start at first node
        DLL2.it.jumpToHead();
        while(this.it.hasNext()||DLL2.it.hasNext()){//checks each node as long as either list has a next node
            if(DLL2.compareNode(this.it.n.data)==false)
                return false;// the data in the nodes dont match
            else if((this.it.hasNext()==false && DLL2.it.hasNext()==true)||(this.it.hasNext()==true && DLL2.it.hasNext()==false))
                return false;//lists are not same length
            this.it.next();
            DLL2.it.next();
        }
        return true;// all the componenents are the same
    }
    /**
     * Moves Iterator to head Node
     */
    void moveItToStart(){
        this.it.jumpToHead();
    }
    /**
     * Moves Iterator to tail Node
     */
    void moveItToEnd(){
        this.it.jumpToTail();
    }
    /**
     * Returns how many nodes are in the DLList
     */
    void getLength(){
        if(this.tail==null)
            System.out.println("List length is 0");
        else{
            this.it.n=head; //set Iterator to start of the list
            int listLength = 0;
            while(this.it.n!=this.tail){
                listLength+=1;
                this.it.next();
            }
            System.out.println("List length is:"+listLength);
        }
    }
    /**
     * Dumps all the nodes data in output
     */
    void dump(){
        Node newNode = this.head;
        while (newNode!=null){
            System.out.println(newNode.data);
            newNode = newNode.next;
        }
    }
    /**
     * Adds a new node to the end of the DLList
     */
    void append(T data){
        Node newNode = new Node(data);
        if(this.tail == null) //empty list
            this.it.n = this.head = this.tail = newNode;
        else{
            this.tail.next = newNode;
            newNode.previous = this.tail;
            this.tail = newNode;
            this.it.next();
        }
    }
    /**
     * Insert your data item at beginning of list
     */
    void insertFirst(T data){
        this.it.n=head;
        insert(data);
    }
    /**
     * Adds a node where the Iterator is
     * Works if DLList is empty
     */
    void insert(T data){
        if(this.it.n == null)
            append(data);
        else{
            Node newNode = new Node(data);
            Node NodePointedAt = this.it.n; // next node
            Node Previous = NodePointedAt.previous;
            if(Previous == null){//prepending
                newNode.next = NodePointedAt;
                NodePointedAt.previous = newNode;
                this.head = newNode;
            }
            else{//inserting between Nodes
                newNode.next = NodePointedAt;
                NodePointedAt.previous = newNode;
                newNode.previous = Previous;
                Previous.next = newNode;
            }
        }
    }
    /**The Node the Iterator is pointing at, change the data it holds*/
    void changeData(T data){
        if(this.it.n!=null)
            this.it.n.data=data;        
    }
    /**Removes the node the Iterator is ahead of*/
    void erase(){
        Node NodePointedAt = this.it.n;
        if(NodePointedAt == null){//at the end of the list
            Node N = this.tail;
            if(N == null){//is the list empty?
                System.out.println("Your trying to remove from an empty list");
            }
            else{
                Node Previous = N.previous;
                if(Previous == null)//Is there only one item in the list
                    this.head = this.tail = null;
                else{//remove the last Node
                    this.tail = Previous;
                    Previous.next = null;
                }
            }
        }
        else{//Not at the end of the list
            Node newNode = NodePointedAt.previous;
            if(newNode == null){//at the head of the list
                System.out.println("Your Cursor is at the begining of the list");
            }
            else{
                Node Previous = newNode.previous;//Node previous to Node your erasing
                if(Previous == null){//your erasing the head of the list, there is no node before it
                    this.head = NodePointedAt;
                    NodePointedAt.previous = null;
                }
                else{//removing inbetween two nodes
                    Previous.next = NodePointedAt;
                    NodePointedAt.previous = Previous;
                }
            }
        }
    }
    /**
     * Cuts off all nodes after the node pointed at by the Iterator
     * and removes its  connection in the DLList
     * then sets the Node pointed at as the new tail
     */
    void truncate(){
        Node NodePointedAt = this.it.n;
        if(NodePointedAt!=null && it.hasNext()!=false){
            this.tail = NodePointedAt;
            NodePointedAt.next = null;
        }
    }
}