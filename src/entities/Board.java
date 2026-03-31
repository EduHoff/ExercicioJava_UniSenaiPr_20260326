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
            throw new IllegalArgumentException("This position has already been used!");
        }

        int[] coords = totMatrixCoordinate(position);
        int row = coords[0];
        int column = coords[1];

        board[row][column].setState(player);   
    }

    private boolean allStatesMatch(Piece p1, Piece p2, Piece p3) {
        StateTictactoe s1 = p1.getState();
        StateTictactoe s2 = p2.getState();
        StateTictactoe s3 = p3.getState();

        return s1 != StateTictactoe.N && s1 == s2 && s2 == s3;
    }

    public GameResult gameResult(){

        for (int i = 0; i < row_size; i++) {
            if (allStatesMatch(board[i][0], board[i][1], board[i][2])) {
                return GameResult.WIN;
            }
        }

        for (int i = 0; i < column_size; i++) {
            if (allStatesMatch(board[0][i], board[1][i], board[2][i])) {
                return GameResult.WIN;
            }
        }

        if (allStatesMatch(board[0][0], board[1][1], board[2][2])) return GameResult.WIN;
        if (allStatesMatch(board[0][2], board[1][1], board[2][0])) return GameResult.WIN;

        if (list_used_positions.size() == 9) {
            return GameResult.DRAW;
        }

        return GameResult.NOTHING;
    }

    

}
