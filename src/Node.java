public class Node<T> {
    
    Node<T> prev;
    Node<T> next;
    T data;

    Node()
    {
        prev = null;
        next = null;
        data = null;
    }

    Node (Node<T> prevInput, Node<T> nextInput, T dataInput)
    {
        prev = prevInput;
        next = nextInput;
        data = dataInput;
    }

    public Node<T> getPrev(){
        return prev;
    }

    public Node<T> getNext(){
        return next;
    }

    public T getData()
    {
        
        return data;
    }



    public void setPrev(Node<T> temp){
        prev = temp;
    }

    public void setNext(Node<T> temp){
        next = temp;
    }

    public void setData(T input){
        data = input;
    }


}
