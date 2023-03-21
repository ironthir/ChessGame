package Figures;


import Utilities.Coordinates;

public class King extends Figure {

    public King(Coordinates pos, String owner)
    {
        super(pos, owner);
    }
    public boolean ValidateFigureMovement(Chess.Tile endTile)
    {
        return true;
    }

}
