package Figures;

import Utilities.Coordinates;

public class Knight extends Figure {

    public Knight(Coordinates pos, String owner)
    {
        super(pos, owner);
    }
    public boolean ValidateFigureMovement(Chess.Tile endTile)
    {
        return true;
    }

}
