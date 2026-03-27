package entities;

public class Piece {

    private StateTictactoe state;
    private int row;
    private int column;

    public Piece(StateTictactoe state, int row, int column) {
        this.state = state;
        this.row = row;
        this.column = column;
    }

    private int getBoardPosition(){
        return (row+1)*(column+1);
    }

    public String printPosition(){
        switch (state) {
            case N:
                return String.valueOf(this.getBoardPosition());
            case X:
                return "X";
            case O:
                return "O";
            default:
                return "?";
        }
    }

    public StateTictactoe getState() {
        return state;
    }

    public void setState(StateTictactoe state) {
        this.state = state;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}