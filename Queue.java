
/**
 *
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).
 *
 * @author Henri Feinaj.
 *
 */
import java.util.NoSuchElementException;

public class Queue<T> {

    //Instance variables
    QueueElement<T> head;
    QueueElement<T> tail;


    /**
     * Constructs an empty Queue.
     */
    public Queue() {
        //TODO: Write the Queue constructor
        head = null;
        tail = null;
    }

    /**
     * Returns true if the queue is empty
     */
    public boolean isEmpty() {
        //TODO:  Needs to return true when empty and false otherwise
        return this.head == null;
    }

    /**
     * Returns the element at the head of the queue
     */
    public T peek() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty!");
        }

        return head.getElement(); //DELETE AND CHANGE TO SOMETHING SENSIBLE
    }

    /**
     * Removes the head element of the queue
     */
    public void dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty!");

        }
        head = head.getNext();
        if (isEmpty()) {
            tail = null;
        }
    }

    /**
     * Puts an element on the tail of the queue.
     */
    public void enqueue(T element) {
        //temporary variables
        QueueElement<T> temp2 = null;
        QueueElement<T> temp = new QueueElement(element, temp2);
        //if queue is empty
        if (isEmpty()) {
            this.head = temp;
            this.tail = temp;
        } else {
            tail.setNext(temp);
            tail = temp;

        }
       
    }

    /**
     * Method to print the full contents of the queue in order from head to
     * tail.
     */
    public void print() {
        //Code to print the code is needed here
        if (isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            QueueElement<T> que = this.head;

            while (que != null) { //iterate over queue
                System.out.println(que.getElement() + ",");
                que = que.getNext();
            }
            System.out.println();

        }

    }
}
