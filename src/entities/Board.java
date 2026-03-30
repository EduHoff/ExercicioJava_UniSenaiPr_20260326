package entities;

import java.util.HashSet;
import java.util.Set;

public class Board {
    
    private int row_size;
    private int column_size;
    private Piece board[][];
    private Set<Integer> list_used_positions = new HashSet<>(); 
    
    public Board(int row_size, int column_size) {
        this.row_size = row_size;
        this.column_size = column_size;
        this.board = new Piece[row_size][column_size]; 
    }

    private int[] totMatrixCoordinate(int position){
        int index = position - 1; 
        int row = index / 3;
        int column = index % 3;
        return new int[] {row, column};
    }

    public void addBoard(Piece piece){
        board[piece.getRow()][piece.getColumn()] = piece;
    }

    public Piece getPiece(int row, int column){
        return board[row][column];
    }

    public void placePiece(int position, StateTictactoe player){
        
        if (!list_used_positions.add(position)) {
            throw new IllegalArgumentException("Esta posição já foi utilizada!");
        }

        int[] coords = totMatrixCoordinate(position);
        int row = coords[0];
        int column = coords[1];

        board[row][column].setState(player);   
    }

}
