//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Queue object and methods to alter it
// Course:   CS 300 Spring 2024
//
// Author:   Sam Odell
// Email:    sfodell@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////////// ASSISTANCE/HELP CITATIONS ////////////////////////////
//
//  no help given or received
//
///////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;

/**
 * Queue method to add and remove nodes in a FIFO order.
 * @param <T> generic allowing for any object to be entered in the queue
 */
public class MyQueue<T> implements QueueADT<T> {
  private LinkedNode<T> back;
  private LinkedNode<T> front;
  private int size;


  /**
   * Method returns an ArrayList containing the data of this queue in order
   * @return ArrayList of type T
   */
  public ArrayList<T> getList(){
    ArrayList<T> aList = new ArrayList<>(size);
    LinkedNode<T> tooAdd = front;
    while(tooAdd!=null){
      aList.add(tooAdd.getData());
      tooAdd=tooAdd.getNext();
    }
    return aList;
  }

  /**
   *
   Enforces a maximum size for this queue.
   If the queue is already smaller than the requested size, this method does nothing
   * @param size the maximum number of elements this queue should contain after the method is run
   */
  public void maintainSize(int size){
    int toRemove = this.size-size;
    if(toRemove<=0){
      return;
    }
    for(int i = 0; i<toRemove;i++){
      dequeue();
    }
  }

  /**
   * Creates a string containing all data in the queue. Does not separate the values
   * @return String of all the data
   */
   @Override
  public String toString(){
    String toReturn = "";
    LinkedNode<T> current = front;
    for(int i = 0; i<size; i++){
      toReturn+=current.getData();
      current = current.getNext();
    }
    return toReturn;
  }

  /**
   * Add a new node to the back of the linked list
   * @param value the value to add
   */
  @Override
  public void enqueue(T value) {
    LinkedNode<T> newNode = new LinkedNode<>(value, null);
    if(isEmpty()){
      front = newNode;
      back = newNode;
    }
    else{
      back.setNext(newNode);
      back = newNode;
    }
    size++;
  }

  /**
   * Remove the first element in the linked list
   * @return the data for the removed node
   */
  @Override
  public T dequeue() {
    if(isEmpty()){
      return null;
    }
    LinkedNode<T> remove = front;
    if(size==1){
      front = null;
      return remove.getData();
    }
    front = front.getNext();
    size--;
    return remove.getData();
  }

  /**
   * Method to get the data of the first node
   * @return the data of the first node
   */
  @Override
  public T peek() {
    if(isEmpty()){
      return null;
    }
    return front.getData();
  }

  /**
   * Method to check if the queue is empty. Checks if the front is null
   * @return if front is null
   */
  @Override
  public boolean isEmpty() {
    return front==null;
  }

  /**
   * Method to get the size of the queue
   * @return size
   */
  @Override
  public int size() {
    return size;
  }
}
