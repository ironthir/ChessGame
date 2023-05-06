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
        final int[] XOffset = {-2, -1, 1, 2};
        final int[] Yoffset = {1, 2, 2, 1};

        for(int i = 0; i < 4; i++){
             Coordinates curr = new Coordinates(this.coordinates.vertical + Yoffset[i], this.coordinates.horizontal + XOffset[i]);
             if(Coordinates.CompareCoordinates(endTile.pos, curr)) return true;
            curr = new Coordinates(this.coordinates.vertical - Yoffset[i], this.coordinates.horizontal + XOffset[i]);
            if(Coordinates.CompareCoordinates(endTile.pos, curr)) return true;
        }

        return false;
    }

}
