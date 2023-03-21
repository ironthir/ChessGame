package Figures;

import Enums.FigureType;
import Utilities.Coordinates;

public class Queen extends Figure {

    public Queen(Coordinates pos, String owner)
    {
        super(pos, owner);
    }
    public boolean ValidateFigureMovement(Chess.Tile endTile)
    {
        return true;
    }

}
