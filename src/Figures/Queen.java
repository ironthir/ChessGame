package Figures;

import Board.ChessBoard;
import Board.Tile;
import Utilities.Coordinates;

public class Queen extends Figure {

    public Queen(Coordinates pos, String owner)
    {
        super(pos, owner);
    }
    public boolean ValidateFigureMovement(Tile endTile, ChessBoard board)
    {
        return true;
    }

}
