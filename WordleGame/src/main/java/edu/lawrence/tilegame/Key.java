/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lawrence.tilegame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
/**
 *
 * @author chloe
 */
public class Key {
    private static final double CELL_SIZE = 30.0;
    private Rectangle border;
    private Text text;
    private Tile tile;
    private int row, col;
    private int x, y;


public Key(String letter,int x,int y) {
        this.x = x;
        this.y = y;
        border = new Rectangle(x,y,CELL_SIZE+5*letter.length(),CELL_SIZE);
        border.setStroke(Color.BLACK);
        border.setFill(Color.LIGHTGRAY);
        tile = null;
        border.setArcWidth(5.0);
        border.setArcHeight(5.0);
        text = new Text(x+15,y+20,letter);
    }
    public Shape[] getShapes() { 
        Shape[] shapes = new Shape[2];
        shapes[0]= border;
        shapes[1]= text;
        return shapes; }
    
   public String getLetter(){
       return text.getText();
   }
    
    
//    public Key getKey() {
//        for (int n = 0; n < 28; n++) {
//            Key a;
//            GamePane obj = new GamePane();
//            a = obj.keys[n];
//            if (a != null && a.containsPoint(double x, double y)) {
//                Key k = a;
//                a = null;
//                return k;
//            }
//        }
//        return null;
//    }
    
   public boolean containsPoint(double x,double y) {
        return border.contains(x, y);
    }
   
   public void changeToDarkGray(){
        border.setFill(Color.DARKGRAY);
    }
   
    public void changeToGreen(){
        border.setFill(Color.GREEN);
    }
    
}
