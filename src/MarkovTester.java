//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Tester Methods for the queue and stack class
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
 * Class to test the method defined in other classes
 */
public class MarkovTester {
  /**
   * method to test the stackAdd method
   * @return true if the method works correctly
   */
  public static boolean testStackAdd(){
    ArrayList<String> test = new ArrayList<>();
    test.add("Stacks");
    test.add("Are");
    test.add("Cool");
    test.add("Lists");
    MyStack<String> stack = new MyStack<>();
    if(!stack.isEmpty()) {
      return false;
    }
    stack.push("Lists");
    stack.push("Cool");
    stack.push("Are");
    stack.push("Stacks");
    ArrayList<String> stackList = stack.getList();

    if(test.size()!=stackList.size()){
      return false;
    }
    for(int i = 0; i<test.size();i++){
      if(!test.get(i).equals(stackList.get(i))){
        return false;
      }
    }
    return true;
  }

  /**
   * method to test the stackRemove method
   * @return true if the stackRemove method works properly
   */
  public static boolean testStackRemove(){
    ArrayList<String> test = new ArrayList<>();
    test.add("Are");
    test.add("Cool");
    test.add("Lists");
    MyStack<String> stack = new MyStack<>();
    if(!stack.isEmpty()) {
      return false;
    }
    stack.push("Lists");
    stack.push("Cool");
    stack.push("Are");
    stack.push("Stacks");
    stack.pop();
    ArrayList<String> stackList = stack.getList();

    if(test.size()!=stackList.size()){
      return false;
    }
    for(int i = 0; i<test.size();i++){
      if(!test.get(i).equals(stackList.get(i))){
        return false;
      }
    }
    return true;
  }

  /**
   * method to test the stackMethod method
   * @return true if the stackShuffle method works properly
   */
  public static boolean testStackShuffle(){
    MyStack<Integer> stack = new MyStack<>();
    stack.push(1);
    stack.push(12);
    stack.push(13);
    stack.push(14);
    stack.push(15);
    stack.shuffle();
    //System.out.println(stack.getList().toString());

    ArrayList<Integer> test = stack.getList();
    if(test.size()!=5){
      return false;
    }
    if(!(test.contains(1)&&test.contains(12)&&test.contains(13)&&test.contains(14)&&
        test.contains(15))){
      return false;
    }
    return true;
  }

  /**
   * method to test the queueAdd method
   * @return true if the queueAdd method works properly
   */
  public static boolean testQueueAdd(){
    ArrayList<Integer> test = new ArrayList<>();
    test.add(1);
    test.add(2);
    test.add(3);
    test.add(4);

    MyQueue<Integer> queue = new MyQueue<>();
    if(!queue.isEmpty()) {
      return false;
    }
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    ArrayList<Integer> queueList = queue.getList();
    //System.out.println(queueList);
    if(test.size()!=queueList.size()){
      return false;
    }
    for(int i = 0; i<test.size();i++){
      if(!test.get(i).equals(queueList.get(i))){
        return false;
      }
    }

    return true;
  }

  /**
   * method to test the queueRemove method
   * @return true if the queueRemove method works properly
   */
  public static boolean testQueueRemove(){
    ArrayList<Integer> test = new ArrayList<>();
    test.add(3);
    test.add(4);
    test.add(5);
    test.add(6);

    MyQueue<Integer> queue = new MyQueue<>();
    if(!queue.isEmpty()) {
      return false;
    }
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);
    queue.enqueue(6);
    queue.dequeue();
    queue.dequeue();
    ArrayList<Integer> queueList = queue.getList();
    //System.out.println(queueList);
    if(test.size()!=queueList.size()){
      return false;
    }
    for(int i = 0; i<test.size();i++){
      if(!test.get(i).equals(queueList.get(i))){
        return false;
      }
    }



    return true;
  }

  /**
   * test the peek method for both stack and queue
   * @return true if the peek method works as intended
   */
  public static boolean testPeek(){
    MyQueue<Integer> queue = new MyQueue<>();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    ArrayList<Integer> testQueue = queue.getList();

    MyStack<String> stack = new MyStack<>();
    stack.push("Lists");
    stack.push("Cool");
    stack.push("Are");
    stack.push("Stacks");
    ArrayList<String> testStack = stack.getList();

    if(queue.peek()!=1 || queue.size()!=4){
      return false;
    }
    if(!stack.peek().equals("Stacks")){
      return false;
    }
    ArrayList<Integer> queueList = queue.getList();
    ArrayList<String> stackList = stack.getList();

    //System.out.println(queueList);
    if(testQueue.size()!=queueList.size()){
      return false;
    }
    for(int i = 0; i<testQueue.size();i++){
      if(!testQueue.get(i).equals(queueList.get(i))){
        return false;
      }
    }

    if(testStack.size()!=stackList.size()){
      return false;
    }
    for(int i = 0; i<testStack.size();i++){
      if(!testStack.get(i).equals(stackList.get(i))){
        return false;
      }
    }

    return true;
  }

  /**
   * main method that runs the tester method
   * @param args unused
   */
  public static void main(String[] args){
    System.out.println("Test stack add "+testStackAdd());
    System.out.println("Test stack removed "+testStackRemove());
    System.out.println("Test stack shuffle "+testStackShuffle());
    System.out.println("Test queue add "+testQueueAdd());
    System.out.println("Test queue remove "+testQueueRemove());
    System.out.println("Test peek "+testPeek());

    MyQueue<Character> q = new MyQueue<>();
    q.enqueue('T');
    q.enqueue('h');
    q.enqueue('i');

    q.peek();
    q.maintainSize(2);
    System.out.println(q.getList());
  }
}
