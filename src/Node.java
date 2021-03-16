public class Node {

    private Node prev;
    private Node next;
    private Polygon data;

    //Constructor
    Node() {
        prev = null;
        next = null;
        data = null;
    }

    //Constructor
    Node(Node prevInput, Node nextInput, Polygon dataInput) {
        prev = prevInput;
        next = nextInput;
        data = dataInput;
    }

    //Preconditions
    //None
    //Postconditions
    //Returns the object Node Prev
    public Node getPrev() {
        return prev;
    }

    //Preconditions
    //None
    //Postconditions
    //Returns the object Node Next
    public Node getNext() {
        return next;
    }

    //Preconditions
    //None
    //Postconditions
    //Returns the object Polygon data
    public Polygon getData() {
        return data;
    }


    //Preconditions
    //Recieves an object of type Node
    //Postconditions
    //Sets Node prev to the recieved Node
    public void setPrev(Node temp) {
        prev = temp;
    }

    //Preconditions
    //Recieves an object of type Node
    //Postconditions
    //Sets Node next to the recieved Node
    public void setNext(Node temp) {
        next = temp;
    }

    //Preconditions
    //Recieves an object of type Polygon
    //Postconditions
    //Sets Polygon data to the recieved Polygon
    public void setData(Polygon input) {
        data = input;
    }

}
