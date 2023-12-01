package edu.lawrence.tilegame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import javafx.scene.paint.Color;
//Look at guess and tell if it's a real word

public class Round {
//private Cell[][] cells;
    //private boolean attached; //whether or not your play is attached to a play that's already there
    private ArrayList<Cell> cells;//each round object will have its own private copy of both member variables

    
    public Round(Cell cell, GameGrid grid) {
        cells = new ArrayList<Cell>();
        cells.add(cell);
 //       cells = grid.getGameGrid();
        
        //attached = checkForNeighbor(cell,grid);
    }

//    public void setFirstRound() {
//        attached = true;
//    }
    public void addCell(Cell cell,GameGrid grid) {
        //attached = attached || checkForNeighbor(cell,grid); // tries to see if there's a neighbor with a tile not placed this round- boolean turns true- goes to gamegrid
        cells.add(cell);
    }
    
    public boolean isLegal(GameGrid grid, GamePane pane) {

        
        // Third check: expand the play to a run and check the dictionary
        String guess = new String(cells.get(0).getTile().getLetter());
        guess = guess + cells.get(1).getTile().getLetter();
        guess = guess + cells.get(2).getTile().getLetter();
        guess = guess + cells.get(3).getTile().getLetter();
        guess = guess + cells.get(4).getTile().getLetter();
        String word = guess.toString();
        if (!dictionary.contains(word))//checking if the run is in the dictionary
        {
            return false;
        }
        int n = grid.getRow();
             
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                if (pane.getSecretWord().charAt(i) != (cells.get(j).getTile().getLetter()).charAt(0)) {
//                    cells.get(j).getTile().changeToDarkGray();//tile at space j change to dark gray
//                    pane.cancelLetter(cells.get(j).getTile().getLetter());
//                }
//            }
//        }
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (pane.getSecretWord().charAt(i) == (cells.get(j).getTile().getLetter()).charAt(0) && i != j) {
                    cells.get(j).getTile().changeToYellow();//tile at space j call change to yellow ?????
                }
            }
        }
        for (int j = 0; j < 5; j++) {
            if (pane.getSecretWord().charAt(j) == (cells.get(j).getTile().getLetter()).charAt(0)) {
                cells.get(j).getTile().changeToGreen();//tile at space j call changeToGreen method
            }
        }
        
        for (int j = 0; j < 5; j++){
            if (cells.get(j).getTile().getColor() == Color.WHITE){
                cells.get(j).getTile().changeToDarkGray();//tile at space j change to dark gray
                pane.cancelLetter(cells.get(j).getTile().getLetter());
            }
        }
        return true;
    }
    
        //change color of keys
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                if (pane.getSecretWord().charAt(i) != guess.charAt(j)) {
//                    pane.getPressed().changeToDarkGray();
//                }
//            }
//        }
//
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                if (pane.getSecretWord().charAt(i) == guess.charAt(j)) {
//                    pane.getPressed().changeToGreen();
//                }
//            }
//        }

        // Final check: check for words in the perpendicular direction
//        for(Cell c : cells) {
//            run = new TileRun(c);
//            if(sameRow)
//                run.expandVertically(grid);
//            else
//                run.expandHorizontally(grid);
//            if(run.getLength() > 1) {
//                word = run.toString();
//                if(!dictionary.contains(word))
//                    return false;
//            }
//        }
     
//    
//    public void undo(Hand hand) {
//        for(Cell c : cells) {
//            Tile t = c.releaseTile();
//            hand.reclaimTile(t);
//        }
//    }
    //static member variable- there's not a new copy of it in each new round- one copy in separate storage space- anyone in class can use it
    private static Set<String> dictionary;//implementation of dictionary- sets are optimized for searching for things

    public static void Init() { //Initializes any static variables
        dictionary = new TreeSet<String>();
        try {
            Scanner input = new Scanner(new File("words.txt"));
            while (input.hasNext()) {
                String str = input.next();
                dictionary.add(str);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
