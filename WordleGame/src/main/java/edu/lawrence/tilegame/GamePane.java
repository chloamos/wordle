package edu.lawrence.tilegame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class GamePane extends Pane {

    private double lastX, lastY;
    private GameGrid grid;
    private Round round;
    private boolean firstRound;
    private String[] letters = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "Enter", "z", "x", "c", "v", "b", "n", "m", "Delete"};
    private int n = 0;
    private int m = 0;
    private int x, y = 0;
    private String secretWord;
    private Key[] keys = new Key[28];
    private Key pressed;
    private Tile[] tiles;
    private Guess guess1;
    private String guess;
    

    public GamePane() {
        tiles = new Tile[30];
        Round.Init();
        grid = new GameGrid(this);
        round = null;
        firstRound = true;
        guess = grid.toString();
        this.setOnMousePressed(e -> putLetter(e));
        String filename = "words.txt";
        Scanner input = null;
        try {
            input = new Scanner(new File(filename));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        int rand = (int) (Math.random() * 4594) + 1;

        for (int i = 0; i < rand; i++) {
            secretWord = input.next();
        }
        System.out.println(secretWord);

        y = 400;
        for (String key : letters) {
            Key k = new Key(key, x, y);
            keys[n] = k;
            this.getChildren().addAll(k.getShapes());
            n++;
            if (n == 10 || n == 19) {
                y += 40;
                x = 0;
            } else {
                x += 40;
            }
            if (n == 10) {
                x += 17;
            }
            if (n == 20) {
                x += 21;
            }
        }
    }

    public void putLetter(MouseEvent e) {
        lastX = e.getX();
        lastY = e.getY();

        for (Key k : keys) {
            if (k.containsPoint(lastX, lastY)) {
                if (k.getLetter().equals("Enter")) {
                    if(grid.getRow()>5){
                        return;
                    }
                    guess = grid.toString();
                    System.out.println(guess);
                    if (guess.length() == 5) {
                        if (round.isLegal(grid, this)) {
                            //change colors of tiles comparing to secretWord
                            grid.nextRow();
                            round = null;
                            //m=0;
                        } else {
                            for (int p=0; p<5; p++){
                            Cell lastC = grid.getLastCell();
                        if(lastC != null){
                                    Tile t = lastC.getTile();
                                    lastC.releaseTile();
                                    this.getChildren().removeAll(t.getShapes());
                                }
                            }
                        }
                    }
                } else if (k.getLetter().equals("Delete")) {
                    //if (m > 0) {
                        Cell lastC = grid.getLastCell();
                        if(lastC != null){
                        Tile t = lastC.getTile();
                        lastC.releaseTile();
                        this.getChildren().removeAll(t.getShapes());
                    }
//                        grid.removeLetter(tiles[m - 1]);
//                        this.getChildren().remove(tiles[m - 1].getShapes());
                        //m--;
                   // }
                } else {
                    //if (m<5){
                    if(grid.getRow()>5){
                        return;
                    }
                    Tile tile = new Tile(k.getLetter(), x, y);
                    //tiles[m] = tile;
                    if (round == null){
                    round = new Round(grid.firstCell(), grid);}
                    else 
                    {
                        round.addCell(grid.firstCell(), grid);
                    }
                    grid.addLetter(tile);
                    //m++;
                    this.getChildren().addAll(tile.getShapes());
                    }
                //}
            }
        }
    }
    
public Key getPressed(){
    return pressed;
}   

public String getSecretWord() {
        return secretWord;
    }

public void cancelLetter(String letter){
    for(Key k: keys){
            if (k.getLetter().equals(letter)) {
                k.changeToDarkGray();
            }
        }
    }
}
