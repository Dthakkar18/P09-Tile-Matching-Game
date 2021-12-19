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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A class that acts as an iterator for the tiles
 * 
 * @author Daven Thakkar
 *
 */
public class TileListIterator implements Iterator<Tile> {

  private Node next; // next element in the iteration


  /**
   * Constructor that creates a new iterator to iterate through a list of tiles starting from its head
   * 
   * @param head type Node that is the head of the linked list of tiles
   */
  public TileListIterator(Node head) {
    this.next = head;

  }

  

  /**
   * Method that checks of there is a next element
   * 
   * @return false if next is null and true otherwise
   */
  @Override
  public boolean hasNext() {
    if (next == null) {
      return false;
    }
    return true;
  }

  /**
   * Method that returns the next element
   * 
   * @return the next tile 
   * @throws NoSuchElementExpection of there is no next element
   */
  @Override
  public Tile next() {
    if (hasNext() == false) {
      throw new NoSuchElementException("No next element in the iteration!");
    }
    Node temp = next;
    next = next.getNext();
    return temp.getTile();
  }


}
