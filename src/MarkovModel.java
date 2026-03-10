//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Markov Model File
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
import java.util.HashMap;

/**
 * Class predicts next letter in a substring based on letters that follow a substring in a given
 * text
 */
public class MarkovModel {
  private HashMap<String, MyStack<Character>> model;
  private MyQueue<Character> currentQueue;
  private int windowWidth;
  private boolean shuffleStacks;

  /**
   * Constructor for the model
   * @param k the length of the substrings
   * @param shuffle whether it should shuffle or not
   */
  public MarkovModel(int k, boolean shuffle){
    windowWidth = k;
    shuffleStacks = shuffle;
    model = new HashMap<>();
  }

  /**
   * Method to generate text and predict the following letter
   * @param length the length the output should be
   * @param text the text to predict from
   * @return best estimate of words from provided text
   */
  public String generateText(int length, String text){
    String currentState = "";
    String outputString = "";
    Character toAdd;

    while(outputString.length()<length){
      currentState = getCurrentState();
      //System.out.println(currentQueue.getList());
      if(!currentQueue.isEmpty()&&model.containsKey(currentState)){
        //System.out.println("contains");
        if(shuffleStacks){
          model.get(currentState).shuffle();
        }

        toAdd = model.get(currentState).peek();
        //System.out.println(currentQueue.getList());
        outputString += toAdd;
        currentQueue.enqueue(toAdd);
        //System.out.println(currentQueue.getList());
        //System.out.println("reducing to "+windowWidth);
        currentQueue.maintainSize(windowWidth+1);
        //System.out.println(currentQueue.getList());
      }
      else{
        initializeQueue(text);
        outputString+="\n";
      }

    }

    return outputString;
  }

  /**
   * helper method to get the current letters from the queue
   * @return string representation of the current queue
   */
  private String getCurrentState(){
    String currentState = "";
    //System.out.println(currentQueue.getList());
    MyQueue<Character> backup = new MyQueue<>();
    while(!currentQueue.isEmpty()){
      Character ch = currentQueue.dequeue();
      backup.enqueue(ch);
      currentState+=ch;
    }
    while(!backup.isEmpty()){
      currentQueue.enqueue(backup.dequeue());
    }
    //System.out.println(currentQueue.getList());
    return currentState;
  }

  /**
   * Sets the starting point for the queue and text
   * @param text the text used to start generation from
   */
  public void initializeQueue(String text){
    currentQueue = new MyQueue<>();
    for(int i = 0; i<windowWidth;i++){
      currentQueue.enqueue(text.charAt(i));
    }
  }

  /**
   * Method to train from to predict letters following a substring
   * @param text the text to be trained from
   */
  public void processText(String text){
    // Updates OR creates a new stack for the
    // given substring and adds next char to it.
    String sub = "";
    for (int i = 0; i<text.length()-windowWidth; i++){
      sub = text.substring(i,i+windowWidth);
      //System.out.print(sub);
      model.computeIfAbsent(sub, k -> new MyStack<>()).push(text.charAt(i+windowWidth));
      //System.out.print(model.get(sub).getList());
    }

  }
}
