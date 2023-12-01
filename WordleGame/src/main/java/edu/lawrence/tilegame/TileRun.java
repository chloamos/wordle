package edu.lawrence.tilegame;

import java.util.LinkedList;

// A TileRun is a sequence of connected tiles. Runs of tiles in the 
// game must form proper words.
public class TileRun {
    private LinkedList<Cell> cells;
    
    // We make a run by starting from a seed cell, and then expanding 
    // outward from that first cell in either a horizontal or a
    // vertical line
    public TileRun(Cell first) {
        cells = new LinkedList<Cell>();
        cells.add(first);
    }
    
    public int getLength() { return cells.size(); }
    
    public void checkWord(GameGrid grid) { //check the guess to see if true
 //       if ()
//        while(true) {
//            Cell left = grid.getCellLeft(cells.getFirst());
//            if(left != null && left.hasTile()) {
//                cells.addFirst(left);
//            } else
//                break;
//        }
//        while(true) {
//            Cell right = grid.getCellRight(cells.getLast());
//            if(right != null && right.hasTile()) {
//                cells.addLast(right);
//            } else
//                break;
//        } 
    }
    
//    public void expandVertically(WordSlots grid) { //making a run vertically starting from seed tile
//        while(true) {
//            Cell above = grid.getCellAbove(cells.getFirst());
//            if(above != null && above.hasTile()) {
//                cells.addFirst(above);
//            } else
//                break;
//        }
//        while(true) {
//            Cell below = grid.getCellBelow(cells.getLast());
//            if(below != null && below.hasTile()) {
//                cells.addLast(below);
//            } else
//                break;
//        } 
//    }
    
    public String toString() { //give me a string that has all the letters from each individual tile
        StringBuilder builder = new StringBuilder();
        for(Cell c : cells) {
            Tile t = c.getTile();
            builder.append(t.getLetter());
        }
        return builder.toString().toLowerCase();
    }
}
