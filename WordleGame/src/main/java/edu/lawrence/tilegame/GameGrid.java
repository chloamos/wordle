package edu.lawrence.tilegame;

public class GameGrid {
    private Cell[][] cells;
    private Cell cell;
    private Tile[] tiles;//array of tiles consisting of tiles that you made by typing
    private Tile tile;
    private int currRow = 0;
       
    
    public GameGrid(GamePane pane) {
        cells = new Cell[6][5];
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 5; x++) {
            
                Cell c = new Cell(x, y);
                cells[y][x] = c;
                pane.getChildren().add(c.getShape());
            }
        }
    }

public void addLetter(Tile newTile){
    //where is the next available free space and then put that in the cell
    if(currRow > 5){
        return;
    }
        for (int x = 0; x < 5; x++) {
                Cell cX = cells[currRow][x];
                if (cX.hasTile() == false) {//make sure you can only write on the same line ??
                    cX.claimTile(newTile);
                    //currRow =y;
                    return;
                }
            }
        }
    

    public void removeLetter(Tile newTile) {
        if(currRow > 5){
            return;
    }
        for (int x = 4; x > 0; x--) { 
                Cell c = cells[currRow][x];
                if (c.hasTile()) {
                    c.releaseTile();
                    return;
                }
            }
        }
    public Cell getLastCell(){
        for (int x = 4; x >=0; x--) { 
                Cell c = cells[currRow][x];
            if (c.hasTile()) 
        return c;
    }
        return null;
    }
    

    public String toString() { //give me a string that has all the letters from each individual tile
        StringBuilder builder = new StringBuilder(); //How do I make the string only the word on the line??
            for (int x = 0; x < 5; x++) {
                Cell c = cells[currRow][x];
                if (c.hasTile()) {
                    Tile t = c.getTile();
                    builder.append(t.getLetter());
                }
            }

        return builder.toString().toLowerCase();
    }
    
    public void nextRow(){
        currRow++;
    }
    
    public int getRow() {
        return currRow;
    }
    
    public Cell firstCell() {
        for (int x = 0; x < 5; x++) {
            Cell cX = cells[currRow][x];
            if (cX.hasTile() == false) {
                return cX;
            }
        }
        return null;
    }
    
    public Cell[][] getGameGrid(){
        return cells;
    }
    
    public Cell getCell(int x, int y){
        return cell;
    }
}

