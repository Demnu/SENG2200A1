public class MyPolygons {

    private Node start;
    private Node current;
    private int size;

    //Constructor
    MyPolygons() {
        start = new Node();
        start.setNext(start);
        start.setPrev(start);
        current = start;
        size = 0;
    }
    //Preconditions
    //None
    //Postconditions
    //Returns an integer of the amount of stored nodes in the circular linked list
    public int getSize() {
        return size;
    }

    //Preconditions
    //Recieves an object of type Polygon
    //Postconditions
    //Stores the object at the head of the list
    public void prepend(Polygon data) {
        Node temp = new Node();
        temp.setData(data);

        if (start == start.getNext()) {
            temp.setPrev(start);
            temp.setNext(start);
            start.setNext(temp);
            start.setPrev(temp);
        } else {

            temp.setNext(start.getNext());
            temp.setPrev(start);
            temp.getNext().setPrev(temp);
            start.setNext(temp);
        }
        current = start.getNext();
        size++;
    }


    //Preconditions
    //Recieves an object of type Polygon
    //Postconditions
    //Stores the object at the tail of the list
    public void append(Polygon data) {

        Node temp = new Node();
        temp.setData(data);
        if (start == start.getNext()) {
            temp.setPrev(start);
            temp.setNext(start);
            start.setNext(temp);
            start.setPrev(temp);
        }

        else {
            temp.setNext(start);
            temp.setPrev(start.getPrev());
            temp.getPrev().setNext(temp);
            start.setPrev(temp);
        }
        current = start.getNext();
        size++;
    }

    //Preconditions
    //None
    //Postconditions
    //Sets the current node to the next node of the list
    public void next() {
        current = current.getNext();
    }

    //Preconditions
    //None
    //Postconditions
    //Sets the current node to sentinal node
    public void reset() {
        current = start;
    }

    //Preconditions
    //None
    //Postconditions
    //Sets the current node to the previous node of the list
    public void prev() {
        if (current.getPrev() != null) {
            current = current.getPrev();
        } else {
            System.out.println("ERROR! Cannot get the previous node");
        }
    }

    //Preconditions
    //None
    //Postconditions
    //Removes node at the head of the list and returns the data of said node 
    public Polygon take() {

        Node temp = start.getNext();
        start.setNext(temp.getNext());
        start.getNext().setPrev(start);
        size--;

        return temp.getData();
    }


    //Preconditions
    //Recieves an object of type Polygon
    //Postconditions
    //Stores object of type Polygon into the list previous to the current node
    public void insert(Polygon data) {

        Node temp = new Node();
        temp.setData(data);
        temp.setNext(current);
        temp.setPrev(current.getPrev());
        temp.getPrev().setNext(temp);
        temp.getNext().setPrev(temp);
        size++;
    }

    //Preconditions
    //Recieves an object of type Polygon
    //Postconditions
    //Removes current node from list
    public void deleteCurrent() {
        if (current == start) {
            System.out.println("Cannot delete sentinal node");

        } else {
            current.getNext().setPrev(current.getPrev());
            current.getPrev().setNext(current.getNext());
            current = start;
        }
    }

    //Preconditions
    //None
    //Postconditions
    //Removes head node of list
    public void deleteHead() {
        start.getNext().getNext().setPrev(start);
        start.setNext(start.getNext().getNext());

    }

    //Preconditions
    //Recieves object of type Polygon
    //Postconditions
    //Inserts polygon into the correct location depending on it's area size
    public void orderedInsert(Polygon data) {
        current = start.getNext();
        if (current==start) {
            append(data);
        } else {
            while (current.getData() != null) {
                if (current.getData().ComesBefore(data)) {
                    next();
                    if (current == start) {
                        append(data);
                        break;
                    }
                } else {
                    insert(data);
                    break;
                }
            }
        }

    }
}
