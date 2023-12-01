package edu.lawrence.tilegame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile {
    private String letter;
    private Rectangle rect;
    private Text text;
    private static Font font = new Font("Arial",25);
    private static final double TILE_SIZE = 45.0;
    private int x, y;
    private Color color;
    
    public Tile(String letter, int x, int y) {
        this.letter = letter;
        this.x = x;
        this.y = y;
        color = Color.WHITE;
        rect = new Rectangle(x*(TILE_SIZE+5),y*(TILE_SIZE+5),TILE_SIZE,TILE_SIZE);
        rect.setFill(Color.WHITE);
        text = new Text(20,20,letter);
        text.setFont(font);
        text.setStroke(Color.BLACK);
    }
    
    public Shape[] getShapes() {
        Shape[] shapes = new Shape[2];
        shapes[0] = rect;
        shapes[1] = text;
        return shapes;
    }
    
    public String getLetter() { return letter; }
    
    public Text getText(){return text; }
    
//    public boolean containsPoint(double x,double y) {
//        return rect.contains(x y);
//    }
    public void changeToYellow(){
        rect.setFill(Color.YELLOW);
        color = Color.YELLOW;
    }
    
    public void changeToGreen(){
        rect.setFill(Color.GREEN);
        color = Color.GREEN;;
    }
    
     public void changeToDarkGray(){
        rect.setFill(Color.DARKGRAY);
        color = Color.DARKGRAY;
    }
     
     public Color getColor(){
         return color;
     }
    
    public void moveTo(double x,double y) {
        rect.setX(x);
        rect.setY(y);
        text.setX(x + 20);
        text.setY(y+25);
    }
    
  
//    public void moveBy(double deltaX, double deltaY) {
//        rect.setX(rect.getX() + deltaX);
//        rect.setY(rect.getY() + deltaY);
//        text.setX(rect.getX() + 20);
//        text.setY(rect.getY() + 25);
//    }
    
//    public boolean tilecontainsPoint(double x,double y) {
//        return rect.contains(x, y);
//    }
}
