package entities;

public class Board {
    
    private int row_size;
    private int column_size;
    private Piece board[][];
    
    public Board(int row_size, int column_size) {
        this.row_size = row_size;
        this.column_size = column_size;
        this.board = new Piece[row_size][column_size]; 
    }

    public void addBoard(Piece piece){
        board[piece.getRow()][piece.getColumn()] = piece;
    }

    public Piece getPiece(int row, int column){
        return board[row][column];
    }

}
