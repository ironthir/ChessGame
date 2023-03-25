package Figures;

import Board.ChessBoard;
import Utilities.Coordinates;
import Board.Tile;

public class Bishop extends Figure {

    public Bishop(Coordinates pos, String owner)
    {
        super(pos, owner);
    }
    public boolean ValidateFigureMovement(Tile endTile, ChessBoard board)
    {
        return true;
    }

}
