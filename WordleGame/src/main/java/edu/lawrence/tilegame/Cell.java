package edu.lawrence.tilegame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Cell {
    private static final double CELL_SIZE = 50.0;
    private Rectangle border;
    private Tile tile;
    private int row, col;
    private int x, y;
    
    
    public Cell(int x,int y) {
        this.x = x;
        this.y = y;
        border = new Rectangle(x*(CELL_SIZE+5),y*(CELL_SIZE+5),CELL_SIZE,CELL_SIZE);
        border.setStroke(Color.BLACK);
        border.setFill(Color.WHITE);
        tile = null;
    }
    
    public Shape getShape() { return border; }
    
//    public boolean hasTile() {
//        if (tile != null) 
//         return true;  
//         return true; 
//    }
//    public boolean containsPoint(double x, double y) {
//        return border.contains(x,y);
//    }
//    
    public boolean hasTile() {
        return tile != null;
    }
    
    public void claimTile(Tile t) {
        tile = t;
        tile.moveTo(border.getX() + 2.5, border.getY() + 2.5);
    }
    
    public Tile releaseTile() {
        Tile t = tile;
        tile = null;
        return t;
    }
    
    public Tile getTile() { return tile; }
    public int getRow() { return row; }
    public int getCol() { return col; }
    public int getX() { return x;}
    public int getY() { return y;}
    public void setX(double x) {border.setX(x);}
    public void setY(double y) {border.setY(y);}
}
