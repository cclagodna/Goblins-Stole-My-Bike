package GoblinsStoleMyBike;

public class Inventory {
    /*///
    This class will act as a linked list or array for
        player and shop inventories
    ///*/
    
    //Head node
    private Node head;
    //Max size of inventory. Defaulted to 2^32
    private int maxSize = Integer.MAX_VALUE;
    //Current size of inventory
    private int size = 0;
    
    
    //Constructors
    public Inventory() {this(null, -1, -1);}
    
    public Inventory(Node head) {this(head, -1, -1);}
    
    public Inventory(int maxSize) {this(null, maxSize, -1);}
    
    public Inventory(Node head, int maxSize) {this(head, maxSize, -1);}
    
    public Inventory(Node head, int maxSize, int size) {
        this.head = head;
        if (maxSize > 0) this.maxSize = maxSize;
        if (size >= 0) this.size = size;
    }
    //Constructors
    
    
    
    public void deleteNode(int loc) {
        /*///
        Deletes the node at location 'loc' and bridges the gap
            between the surrounding nodes
        'loc' will start counting at 0, meaning the 'head'
            node will be at the '0th' location
        ///*/
        
        //'Current' node when iterating down list
        Node curr = this.head;
        
        if (getSize() == 0) {
            System.out.printf("List contains no nodes%n");
        }
        else if (loc > getSize()) {
            System.out.printf("Requested index is larger than list size%n");
        }
        else {
            //Iterates through list
            for (int count = 0; count == loc; count++) {
                curr = curr.getNext();
            }
            //Removes node
            remove(curr);
        }
    }
    
    private void remove(Node thisNode) {
        /*///
        Removes 'node' from inventory and bridges gap
        ///*/
        
        if (thisNode.getPrev() != null) {
            //Gets the previous node and sets its 'next' value to thisNodes
            //  'next' value
            thisNode.getPrev().setNext(thisNode.getNext());
        }
        //If prev node is null, or thisNode is the 'head' node
        else {
            thisNode.getNext().setPrev(null);
            this.head = thisNode.getNext();
        }
        
        if (thisNode.getNext() != null) {
            //Gets the next node and sets its 'prev' value to thisNodes
            //  'prev' value
            thisNode.getNext().setPrev(thisNode.getPrev());
        }
        //If next node is null, or 'thisNode' is the last node
        else {
            thisNode.getPrev().setNext(null);
        }
        
        thisNode.setNext(null);
        thisNode.setPrev(null);
        thisNode.setThing(null);
    }
    
    public int calcSize() {
        /*///
        Calculates the current size of the list
        If this.size is not the same as the counted amount,
            will setSize to that new amount
        ///*/
        
        //'Current' node when iterating down list
        Node curr = this.head;
        //Tally of nodes
        int count = 0;
        
        //If there is no head node, return 0
        if (head == null) return count;
        
        do {
            //Counts one more node
            count++;
            //Moves to the next node in the list
            curr = curr.getNext();
        //Iterates over loop until it finds an empty or null node
        } while (curr != null);
        
        if (getSize() != count) setSize(count);
        return count;
    }
    
    
    
    //Get and Set Methods
    public Node getHead() {return this.head;}
    public void setHead(Node head) {
        this.head = head;
        calcSize();
    }
    
    public int getMaxSize() {return this.maxSize;}
    public void setMaxSize(int maxSize) {
        if (maxSize > 0) this.maxSize = maxSize;
    }
    
    public int getSize() {return this.size;}
    //Can only be called through calcSize()
    private void setSize(int size) {this.size = size;}
    //Get and Set Methods
    
}
