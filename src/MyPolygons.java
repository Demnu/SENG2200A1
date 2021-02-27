public class MyPolygons<T> {

    Node<T> start;
    Node<T> current;

    MyPolygons() {
        start = new Node<T>();
        start.setNext(start);
        start.setPrev(start);
        current = start;
    }

    public void addNext(T data) {
        Node<T> temp = new Node<T>();
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

    }

    public void addPrev(T data) {

        Node<T> temp = new Node<T>();
        temp.setData(data);
        if (start == start.getNext()){
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

    }

    public void next() {
        if (current.getNext() != null) {
            current = current.getNext();
        } else {
            System.out.println("ERROR! Cannot get the next node");
        }
    }

    public void prev() {
        if (current.getPrev() != null) {
            current = current.getPrev();
        } else {
            System.out.println("ERROR! Cannot get the previous node");
        }
    }

    public void add_to_current(T data) {

        Node<T> temp = new Node<T>();
        temp.setData(data);
        temp.setNext(current);
        temp.setPrev(current.getPrev());
        temp.getPrev().setNext(temp);
        temp.getNext().setPrev(temp);
    }

    public void showLinkedList() {
        current = start.getNext();
        while (current != start) {
            System.out.println(current.getData());
            current = current.getNext();
        }
        current = start;

    }

    public LinkedList<T> showNames(){

        current = start.getNext();
        LinkedList<T> names = new LinkedList<T>();
        while (current !=start)
        {
            names.addNext(showCurrent());
            current = current.getNext();
        }
        return names;
    }

    public T showCurrent() {
        return current.getData();
    }

    public void deleteCurrent()
    {
        if (current == start)
        {
            System.out.println("Cannot delete sentinal node");

        }
        else
        {
            current.getNext().setPrev(current.getPrev());
            current.getPrev().setNext(current.getNext());
            current = start;
        }
    }

    public void deleteHead(){
        start.getNext().getNext().setPrev(start);
        start.setNext(start.getNext().getNext());
        
    }

    public void alterCurrent()
    {
        current.getData();
    }
}

