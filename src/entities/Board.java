package entities;

public class Board {
    
    private int row_size;
    private int column_size;

    Pieces board[][] = new Pieces[row_size][column_size];

    public Board(int row_size, int column_size) {
        this.row_size = row_size;
        this.column_size = column_size;
    }
    

    
    
    

}
