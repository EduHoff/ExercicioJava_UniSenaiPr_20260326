package entities;

public class Pieces {

    private StateTictactoe state;
    private int row;
    private int column;

    public Pieces(StateTictactoe state, int row, int column) {
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

}