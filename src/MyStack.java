import java.util.Iterator;

/**
 * Created by allancaine on 2015-11-09.
 */
public class MyStack<T extends Comparable<T>> {

    private static class Node<T extends Comparable>{
        T data;
        T min;
        Node<T> next;

        public Node(T data, T min, Node<T> next) {
            this.data = data;
            this.min = min;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public T getMin() {
            return min;
        }

        public Node<T> getNext() {
            return next;
        }
    }

    private Node<T> head;

    public boolean isEmpty(){
        return head == null;
    }

    public T min(){
        if(isEmpty()){
            return null;
        }
        return head.getMin();
    }
    /**

    public void push(T data){
        if(isEmpty()){
            head = new Node(data, data, null);
        }else{
            head= new Node(data, data.compareTo(head.getMin()) == -1 ? data : head.getMin(), head);

        }
    }
     **/

    public void push(T data){
        // Empty case
        if(isEmpty()){
            head = new Node(data, null, null);
            return;
        }

        // At the head?

        if(data.compareTo(head.getData()) == -1){
            head = new Node(data, null, head);
            return;
        }

        Node<T> before = head;
        Node<T> after = head.getNext();

        while(after != null){
            if(data.compareTo(after.getData()) == -1){
                before.next = new Node<>(data, null, after);
                return;
            }
            before = before.getNext();
            after = after.getNext();
        }

        // Must be at the very end

        before.next = new Node<>(data, null, null);

    }

    public T pop(){
        if(isEmpty()){
            return null;
        }
        T cache = head.getData();
        head = head.getNext();
        return cache;
    }

    public T peek(){
        if(isEmpty()){
            return null;
        }
        return head.getData();
    }


    public Iterator<T> getDataIterator(){
        return new Iterator<T>() {

            Node<T> pointer = head;

            @Override
            public boolean hasNext() {
                return pointer.getNext() != null;
            }

            @Override
            public T next() {
                if(pointer == null){
                    return null;
                }
                T cache = pointer.getData();
                pointer = pointer.getNext();
                return cache;
            }
        };
    }

}
