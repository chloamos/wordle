/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lawrence.tilegame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import javafx.scene.paint.Color;

/**
 *
 * @author chloe
 */
public class Guess {
     private LinkedList<Cell> cells;
     
     
     public Guess(Cell first){
        cells = new LinkedList<Cell>();
        cells.add(first);
     }
    
     public int getLength() { return cells.size(); }
     
//    public Color checkLetter(String letter, int location){
//        if (secretWord[location].equals(letter))
//            return color;
//        else return null;
//            }
//    private static final int GUESS_LENGTH = 5;
//    private Guess[] guess = new Guess[GUESS_LENGTH];
//    
//     public Guess(GamePane p, double x, double y) {
//        pane = p;
//        bag = new Bag();
//        this.originX = x;
//        this.originY = y;
//        for (int n = 0; n < HAND_SIZE; n++) {
//            tiles[n] = bag.drawTile();
//            tiles[n].moveTo(x + n * 50, y);
//            pane.getChildren().addAll(tiles[n].getShapes());
 //       }
//}
       public String toString() { //give me a string that has all the letters from each individual tile
        StringBuilder builder = new StringBuilder();
        for(Cell c : cells) {
            Tile t = c.getTile();
            builder.append(t.getLetter());
        }
        return builder.toString().toLowerCase();
    }
}
