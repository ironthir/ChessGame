package Figures;

import Board.ChessBoard;
import Board.Tile;
import Utilities.Coordinates;

public class Knight extends Figure {

    public Knight(Coordinates pos, String owner)
    {
        super(pos, owner);
    }
    public boolean ValidateFigureMovement(Tile endTile, ChessBoard board)
    {
        return true;
    }

}
