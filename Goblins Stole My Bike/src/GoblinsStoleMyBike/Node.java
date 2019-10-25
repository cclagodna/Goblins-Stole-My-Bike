package GoblinsStoleMyBike;

public class Node {
    
    //Data the node is holding
    private Thing thing;
    //Reference to next node in a list
    private Node next;
    //Reference to previous node in a list
    private Node prev;
    
    //Constructors
    public Node() { this(null, null, null); }
    
    public Node(Thing thing) { this(thing, null, null); }
    
    public Node(Thing thing, Node next) { this(thing, next, null); }
    
    public Node(Thing thing, Node next, Node prev) {
        this.thing = thing;
        this.next = next;
        this.prev = prev;
    }
    //Constructors
    
    //Get and Set
    public Thing getThing() {return this.thing;}
    public void setThing(Thing thing) {this.thing = thing;}
    
    public Node getNext() {return this.next;}
    public void setNext(Node next) {this.next = next;}
    
    public Node getPrev() {return this.prev;}
    public void setPrev(Node prev) {this.prev = prev;}
    //Get and Set
    
}
