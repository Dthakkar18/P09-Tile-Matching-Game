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

/**
 * This class models a Tile of a specific color
 *
 */
/**
 * @author mouna
 *
 */
public class Tile {
  private Color color; // color of this Tile

  /**
   * Creates a Tile with a specific color
   * 
   * @param color color to be assigned to this tile
   */
  public Tile(Color color) {
    this.color = color;
  }

  /**
   * Gets the color of this tile
   * 
   * @return the color of this tile
   */
  public Color getColor() {
    return color;
  }


  /**
   * Returns a string representation of this tile
   * 
   * @return the color of this tile as a string
   */
  @Override
  public String toString() {
    return color.name();
  }


  /**
   * Checks whether this tile equals to the other object provided as input
   * 
   * @return true if other is a Tile and has the same color as this tile
   */
  @Override
  public boolean equals(Object other) {
    // TODO complete the implementation of this method
    if(other instanceof Tile) {
      if (((Tile) other).getColor().equals(this.color)){
        return true;
      }
    }
    
    return false; // default return statement added to resolve compiler errors
  }
}
