package datastructures.sequential;

import java.util.EmptyStackException;

/** @author Ethan Garcia
 * This class is for the implementation of a stack. This stack is generic and can have any type.
 * It is generated using a linked-list style implementation. This allows the stack to be easily
 * modified. Nodes allow for quick changes in the stack.
 * The inclusion of a head and tail pointer allows for quick retrieval of the last node, which
 * is exceptionally useful for stacks as the last element is often what is accessed. This stack class is used
 * in the program to keep track of brackets (DyckWord), Operators (ToPostfixConverter), and double values (PostFixEvaluator)
 * @param <E>
 */
public class Stack<E> implements LIFOQueue<E>{
    private SNode head;
    private SNode tail;

    /**
     * (default constructor) Creates a stack object with a null head and tail.
     */
    public Stack(){
        head=null;
        tail=null;
    }

    /** Pop is one of the ways we modify a stack. It removes the top object of the stack and returns it.
     * Because we are changing the tail, we need to reassign it. The code goes through and reassigns the tail to the new
     * last element.
     * @throws EmptyStackException() if the stack being referenced is empty
     * @return returns the object at the top of the stack
     */
    @Override
    public E pop() {
        SNode counter = head;
        int sizeBruh = this.size();
        if(isEmpty()){
            throw new EmptyStackException();
        }
        Object toReturn = tail.getData();
        if(sizeBruh==1){
            head=null;
            tail=null;
        }
        else {
            for (int i = 0; i < sizeBruh-2; i++) {
                counter = counter.getNext();
            }
            tail = counter;
            counter.setNext(null);
        }
        return (E) toReturn;
    }

    /** Push is the other way we modify the stack. Push takes the object, puts it into a node, and puts
     * that node as tail, attaching it to the end of the stack.
     *
     * @param element the element to be pushed onto the top of this stack.
     */
    @Override
    public void push(Object element) {
        SNode temp = new SNode(element);
        if(this.isEmpty()) {
            head = temp;
            tail = head;
        }
        else{
            tail.setNext(temp);
            tail = tail.getNext();
        }
    }

    /** Peek is how we look at the top of the stack without removing it. Because there is a tail node, accessing the
     * tail is O(1), rather than the O(n) time it would take to iterate through the entire list.
     *
     * @return the object situated at the tail node (top of the stack)
     */
    @Override
    public E peek() {
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        return (E) tail.getData();
    }

    /** This method obtains the size of the list. We iterate through each node in the list till the pointer node is null.
     *
     * @return an int that represents the node size of the stack.
     */
    @Override
    public int size() {
        int nodecount = 0;
        SNode counter = head;
        if(isEmpty())
            return 0;
        else{
            while(counter!=null){
                nodecount++;
                counter=counter.getNext();
            }
            return nodecount;
        }
    }

    /** Checks if list is empty. The head is the first element, if there is no head, then there cannot be anything else
     * in the list.
     *
     * @return boolean value based on whether or not the head node is null.
     */
    @Override
    public boolean isEmpty() {
        if(head==null)
            return true;
        else
            return false;
    }

    /** prints out all of the nodes in a stack. Used for testing.
     *
     */
    public void printer(){
        SNode counter = head;
        while(counter!=null){
            System.out.println(counter.getData());
            counter=counter.getNext();
        }
    }

    /** Prints out the data values of head and tail nodes. Used for testing.
     *
     */
    public void HeadAndTailElement(){
        System.out.println(this.head.getData());
        System.out.println(this.tail.getData());
    }
}
