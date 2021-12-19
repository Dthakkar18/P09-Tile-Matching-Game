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

/**
 * Class that is represents the linked stack of tiles
 * 
 * @author Daven Thakkar
 *
 */
public class TileStack implements Iterable<Tile>, StackADT<Tile> {

  private Node top; // head of the list
  private int size; // keeps track of the number of tiles stored in the stack

  /**
   * Constructor that creates an empty stack of tiles
   */
  public TileStack() {
    this.top = null;
    this.size = 0;
  }

  /**
   * Method that adds to the stack of tiles
   * 
   * @param type Tile that is the tile we push to the stack
   * @throws IllegalArgumentExpection if the element passed is null
   */
  @Override
  public void push(Tile element) {
    // TODO Auto-generated method stub
    if (element == null) {
      throw new IllegalArgumentException("Element provided is null!");

    } else {

      Node addingNode = new Node(element);
      if (size == 0) {
        this.top = addingNode;
      } else {
        addingNode.setNext(this.top);
        this.top = addingNode;
      }
      size++;

    }


  }

  /**
   * Method that removes the top tile from the stack and returns it
   * 
   * @return the tile at the top of the stack
   * @throws EmptyStackException if the stack is empty
   */
  @Override
  public Tile pop() {
    // TODO Auto-generated method stub
    if (size == 0) {
      throw new EmptyStackException();
    } else {
      Node topNode = this.top;
      this.top = top.getNext();
      size--;
      return topNode.getTile();

    }

  }

  /**
   * Method that returns the tile at the top of the stack
   * 
   * @return the tile at the top of the stack
   * @throws EmptyStackException if the stack is empty
   */
  @Override
  public Tile peek() {
    // TODO Auto-generated method stub
    if (size == 0) {
      throw new EmptyStackException();
    } else {
      return top.getTile();
    }

  }

  /**
   * Method that checks if the stack of tiles is empty
   * 
   * @return true of the stack size is zero and false otherwise
   */
  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    if (size == 0) {
      return true;
    } else {
      return false;
    }

  }

  /**
   * Method that returns the size of the stack
   * 
   * @return the size of the stack of tiles
   */
  @Override
  public int size() {
    // TODO Auto-generated method stub
    return this.size;
  }

  /**
   * Method that returns a iterator for the stack
   * 
   * @return an iterator for the stack of tiles
   */
  @Override
  public Iterator<Tile> iterator() {
    // TODO Auto-generated method stub
    TileListIterator itr = new TileListIterator(top);
    return itr;
  }

}
