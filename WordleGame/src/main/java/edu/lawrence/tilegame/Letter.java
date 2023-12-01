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
public class Letter {
    
    private Text letter;
    private Rectangle rect;
    private Color color;
    
    public Shape getShape() {return rect;}
    public Color getColor() {return color;}
    public Text getText() {return letter;}
}
