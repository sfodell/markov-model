//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    (descriptive title of the program making use of this file)
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
import java.util.Collections;

/**
 * Class to create a stack that adds and removes in a LIFO order
 * @param <T> generic to allow any object to be used
 */
public class MyStack<T> implements StackADT<T> {
  private LinkedNode<T> top;

  /**
   * get returns an ArrayList representation of the stack
   * @return ArrayList containing stack data
   */
  public ArrayList<T> getList(){
    LinkedNode<T> current = top;
    ArrayList<T> aList = new ArrayList<>();
    while(current!=null){
      aList.add(current.getData());
      current = current.getNext();
    }
    return aList;
  }

  /**
   * Method to randomly shuffle the stack
   */
  public void shuffle(){
    ArrayList<T> temp = getList();
    Collections.shuffle(temp);
    while(!isEmpty()){
      pop();
    }
    for(int i = temp.size()-1; i>=0;i--){
      push(temp.get(i));
    }
  }

  /**
   * method to add to the stack. Adds to the "top"
   * @param value the value to add
   */
  @Override
  public void push(T value) {
    LinkedNode<T> temp = top;
    LinkedNode<T> toAdd = new LinkedNode<>(value, temp);
    top = toAdd;
  }

  /**
   * Method to remove from a stack. Removes from the "top"
   * @return the removed node's data
   */
  @Override
  public T pop() {
    if(isEmpty()) {
      return null;
    }
    LinkedNode<T> temp = top;
    top = top.getNext();
    return temp.getData();
  }

  /**
   * method to get the data from the "top" node
   * @return the data from top. Null if the stack is empty
   */
  @Override
  public T peek() {
    if(isEmpty()){
      return null;
    }
    return top.getData();
  }

  /**
   * Checks if the method is empty
   * @return if the top is null
   */
  @Override
  public boolean isEmpty() {
    return top==null;
  }
}
