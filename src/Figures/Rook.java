package Figures;

import Utilities.Coordinates;

public class Rook extends Figure {

    public Rook(Coordinates pos, String owner)
    {
        super(pos, owner);
    }
    public boolean ValidateFigureMovement(Chess.Tile endTile)
    {
        return true;
    }

}
