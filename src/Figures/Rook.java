package Figures;

import Board.ChessBoard;
import Board.Tile;
import Utilities.Coordinates;

public class Rook extends Figure {

    public Rook(Coordinates pos, String owner)
    {
        super(pos, owner);
    }

    public static boolean ValidateRookMovement(Tile endTile, ChessBoard board, Figure fig){
        if(fig.coordinates.vertical != endTile.pos.vertical && fig.coordinates.horizontal != endTile.pos.horizontal) return false;
        if(fig.coordinates.horizontal == endTile.pos.horizontal){
            final boolean directionUp = endTile.pos.vertical > fig.coordinates.vertical;
            int i = fig.coordinates.vertical ;
            while(i != endTile.pos.vertical)
            {

                if(board.GetTileAtPosition(new Coordinates(i, fig.coordinates.horizontal)).hasFigure) return false;

                if(directionUp) i++;
                else i--;
            }
        }
        else{
            final boolean directionRight = endTile.pos.horizontal > fig.coordinates.horizontal;
            int i = fig.coordinates.horizontal;
            while(i != endTile.pos.horizontal)
            {
                if(board.GetTileAtPosition(new Coordinates(fig.coordinates.vertical, i)).hasFigure) return false;

                if(directionRight) i++;
                else i--;
            }

        } return true;
    }
    public boolean ValidateFigureMovement(Tile endTile, ChessBoard board)
    {
        return this.ValidateRookMovement(endTile, board, this);
    }

}
