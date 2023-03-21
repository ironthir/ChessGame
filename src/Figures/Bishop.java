package Figures;

import Utilities.Coordinates;
import Chess.Tile;

public class Bishop extends Figure {

    public Bishop(Coordinates pos, String owner)
    {

        super(pos, owner);
    }
    public boolean ValidateFigureMovement(Tile endTile)
    {
        return true;
    }

}
