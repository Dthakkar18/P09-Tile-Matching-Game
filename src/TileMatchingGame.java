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

/**
 * This class models a tile matching game which consists of a certain number of columns of stacks of
 * tiles
 * 
 * @author Daven Thakkar
 *
 */
public class TileMatchingGame {

  private TileStack[] columns;


  /**
   * Constructor that initializes the columns in array which has empty tile stack in each index
   * position from 0 to length -1
   * 
   * @param columnCount type int that is the number of columns in the array
   */
  public TileMatchingGame(int columnCount) {
    this.columns = new TileStack[columnCount]; // creating slots
    for (int i = 0; i < columnCount; i++) {
      columns[i] = new TileStack(); // filling those slots with TileStacks
    }
  }

  /**
   * Method that clears the column that is given by the index
   * 
   * @param index type int that is the index of the column we use
   */
  public void clearColumn(int index) {
    columns[index] = new TileStack();
  }

  /**
   * Method that returns the colors of the tiles in a given column at the index provided
   * 
   * @param index type int that is the index of the column we use
   * @return a String for the color of the tiles in that column
   */
  public String column(int index) {
    String colorString = "";
    TileStack stack = columns[index];
    Iterator<Tile> itr = stack.iterator();
    while (itr.hasNext()) {
      colorString += itr.next().getColor() + " ";
    }

    return colorString;
  }

  /**
   * Method that adds a Tile to the stack in the column of the given index
   * 
   * @param tile  type Tile which is the tile that we add to a stack
   * @param index type int that is the index of the column which is the stack we use
   */
  public void dropTile(Tile tile, int index) {
    TileStack stack = columns[index];
    stack.push(tile);
  }

  /**
   * Method that returns the number of columns in the game
   * 
   * @return int that is the number of columns in the game
   */
  public int getColumnsNumber() {
    return columns.length;
  }

  /**
   * Method that clears all the columns in the game
   */
  public void restartGame() {
    for (int i = 0; i < columns.length; i++) {
      columns[i] = new TileStack();
    }
  }

  /**
   * Method that returns a String representation of the game
   * 
   * @return a String representation of the game
   */
  public String toString() {
    String str = "";
    for (int i = 0; i < columns.length; i++) {
      String toAdd = "" + String.valueOf(i) + ": " + column(i);
      str += toAdd + "\n";
    }

    return str;
  }


}
