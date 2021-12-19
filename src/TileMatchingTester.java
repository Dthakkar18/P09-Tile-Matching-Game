//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P09 Tile Matching Game
// Course: CS 300 Fall 2021
//
// Author: Daven Thakkar
// Email: dcthakkar@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: n/a
// Partner Email: n/a
// Partner Lecturer's Name: n/a
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// __n/a_ Write-up states that pair programming is allowed for this assignment.
// __n/a_ We have both read and understand the course Pair Programming Policy.
// __n/a_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: n/a
// Online Sources: n/a
//
///////////////////////////////////////////////////////////////////////////////

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class that tests the Tile, TileListIterator, TileStack, and TileMatchingGame
 * 
 * @author Daven Thakkar
 *
 */
public class TileMatchingTester {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(runAllTests());

  }


  /**
   * Tester method for Tile class
   * 
   * @return true of the tests succeeds and false otherwise
   */
  public static boolean tileEqualsTester() {

    try {
      // Scenario 1: compare tile to object which isn't instance of the class (use Tile and String)
      Tile blueTile = new Tile(Color.BLUE);
      String blueString = "";
      if (blueTile.equals(blueString) == true) {
        return false;
      }

      // Scenario 2: two tile with same color
      Tile anotherBlueTile = new Tile(Color.BLUE);
      if (blueTile.equals(anotherBlueTile) == false) {
        System.out.println("Not same colors");
        return false;
      }

      // Scenario 3: two tile with different color
      Tile blackTile = new Tile(Color.BLACK);
      if (blueTile.equals(blackTile) == true) {
        return false;
      }

      // Scenario 4: compare to null
      Tile notValid = null;
      if (blueTile.equals(notValid) == true) {
        return false;
      }


      // Scenario 5: compare to itself
      Tile itself = blueTile;
      if (blueTile.equals(itself) == false) {
        System.out.println("Not itself");
        return false;
      }
      
      return true;


    } catch (Exception e) {
      return false; // no exception should be thrown
    }

  }

  /**
   * Tester method for the TileListIterator class
   * 
   * @return true of the tests succeeds and false otherwise
   */
  public static boolean tileListIteratorTester() {
    // creating nodes
    Node nodeOne = new Node(new Tile(Color.BLACK));
    Node nodeTwo = new Node(new Tile(Color.BLUE));
    Node nodeThree = new Node(new Tile(Color.ORANGE));

    // linking nodes
    nodeOne.setNext(nodeTwo);
    nodeTwo.setNext(nodeThree);

    // create iterator
    TileListIterator itr = new TileListIterator(nodeOne);

    try {
      if (!(itr.hasNext() == true && itr.next() == nodeOne.getTile())) {
        return false;
      }
    } catch (NoSuchElementException e) {
      System.out.println("Exception should not have been thrown");
      return false;
    }

    try {
      if (!(itr.hasNext() == true && itr.next() == nodeTwo.getTile())) {
        return false;
      }
    } catch (NoSuchElementException e) {
      System.out.println("Exception should not have been thrown");
      return false;
    }

    try {
      if (!(itr.hasNext() == true && itr.next() == nodeThree.getTile())) {
        return false;
      }
    } catch (NoSuchElementException e) {
      System.out.println("Exception should not have been thrown");
      return false;
    }

    try {
      if (itr.hasNext() == true) {
        return false;
      }
    } catch (NoSuchElementException e) {
      System.out.println("Exception caught!");
      return true;
    }

    return true;
  }

  /**
   * Tester method for TileStack class
   * 
   * @return true of the tests succeeds and false otherwise
   */
  public static boolean tileStackTester() {

    TileStack stack = new TileStack();

    Node blackNode = new Node(new Tile(Color.BLACK));
    Node blueNode = new Node(new Tile(Color.BLUE));
    Node orangeNode = new Node(new Tile(Color.ORANGE));

    // check isEmpty on empty stack
    if (stack.isEmpty() == false) {
      return false;
    }

    // check size on empty stack
    if (stack.size() != 0) {
      return false;
    }

    // testing push and peek
    try {
      stack.push(blackNode.getTile());
      if (stack.peek() != blackNode.getTile()) {
        return false;
      }
      stack.push(blueNode.getTile());
      if (stack.peek() != blueNode.getTile()) {
        return false;
      }
      stack.push(orangeNode.getTile());
      if (stack.peek() != orangeNode.getTile()) {
        return false;
      }
    } catch (IllegalArgumentException e) {
      return false; // should not catch exception
    } catch (EmptyStackException e) {
      return false; // should not catch exception
    }

    // check size on not empty stack
    if (stack.size() != 3) {
      return false;
    }

    // check isEmpty on not empty stack
    if (stack.isEmpty() == true) {
      return false;
    }
    
    //checking if able to create an iterator for stack
    try {
      Iterator<Tile> itr = stack.iterator();
    }catch(Exception e) {
      return false; //should not throw an exception 
    }

    // testing pop and peek
    try {
      if (stack.pop() != orangeNode.getTile()) {
        return false;
      }
      if (stack.peek() != blueNode.getTile()) {
        return false;
      }

      if (stack.pop() != blueNode.getTile()) {
        return false;
      }
      if (stack.peek() != blackNode.getTile()) {
        return false;
      }

    } catch (EmptyStackException e) {
      return false; // should not catch
    }
    // testing pop and peek on one element in stack
    try {
      if (stack.pop() != blackNode.getTile()) {
        return false;
      }
      stack.peek();
    } catch (EmptyStackException e) {
      return true; // peek should throw it (might have to check to make sure it is peeks exception)
    }

    // check isEmpty on empty stack that removed all elements
    if (stack.isEmpty() == false) {
      return false;
    }

    // check size on empty stack that removed all elements
    if (stack.size() != 0) {
      return false;
    }

    return true;
  }

  /**
   * Tester method for the TileMatchingGame class
   * 
   * @return true of the tests succeeds and false otherwise
   */
  public static boolean tileMatchingGameTester() {

    int colSize = 3;

    TileMatchingGame game = new TileMatchingGame(colSize);

    if (game.getColumnsNumber() != 3) {
      return false;
    }

    // creating tiles to add
    Tile blackTile = new Tile(Color.BLACK);
    Tile blueTile = new Tile(Color.BLUE);
    Tile orangeTile = new Tile(Color.ORANGE);

    // adding tiles to different columns
    game.dropTile(blackTile, 0);
    game.dropTile(blueTile, 0);
    game.dropTile(orangeTile, 1);

    // expected outputs
    String expected = "0: BLUE BLACK \n1: ORANGE \n2: \n";
    String expectedFirstCol = "BLUE BLACK ";
    String expectedSecCol = "ORANGE ";
    String expectedThirdCol = "";

    // checking if dropTile(), toString() and column() are working properly once tiles added
    if (expectedFirstCol.equals(game.column(0)) == false) {
      return false;
    }

    if (expectedSecCol.equals(game.column(1)) == false) {
      return false;
    }

    if (expectedThirdCol.equals(game.column(2)) == false) {
      return false;
    }

    if (expected.equals(game.toString()) == false) {
      return false;
    }

    // checking if clearColumn() works
    game.clearColumn(0);

    String expectedClearColOne = "";
    String expectedClear = "0: \n1: ORANGE \n2: \n";

    if (expectedClearColOne.equals(game.column(0)) == false) {
      return false;
    }

    if (expectedClear.equals(game.toString()) == false) {
      return false;
    }

    // checking of restartGame() works
    game.restartGame();

    String exptectedRestartCol = "";
    String expectedRestart = "0: \n1: \n2: \n";

    // checking if each column is cleared for a new game
    for (int i = 0; i < colSize; i++) {
      if (game.column(i).equals(exptectedRestartCol) == false) {
        return false;
      }
    }

    if (expectedRestart.equals(game.toString()) == false) {
      return false;
    }

    return true;
  }

  /**
   * Method that runs all the tester methods
   * 
   * @return true of the tests succeeds and false otherwise
   */
  public static boolean runAllTests() {
    if (tileEqualsTester() && tileListIteratorTester() && tileStackTester()
        && tileMatchingGameTester()) {
      return true;
    }
    return false;
  }

}
