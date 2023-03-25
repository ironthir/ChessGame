package Figures;


import Board.ChessBoard;
import Board.Tile;
import Utilities.Coordinates;

public class King extends Figure {

    public King(Coordinates pos, String owner)
    {
        super(pos, owner);
    }
    public boolean ValidateFigureMovement(Tile endTile, ChessBoard board)
    {
        return true;
    }

}
