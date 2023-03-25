package Figures;

import Board.ChessBoard;
import Board.Tile;
import Utilities.Coordinates;

public class Rook extends Figure {

    public Rook(Coordinates pos, String owner)
    {
        super(pos, owner);
    }
    public boolean ValidateFigureMovement(Tile endTile, ChessBoard board)
    {
        if(this.coordinates.vertical != endTile.pos.vertical && this.coordinates.horizontal != endTile.pos.horizontal) return false;
        if(this.coordinates.vertical == endTile.pos.vertical){
            final boolean directionUp = endTile.pos.vertical > this.coordinates.vertical;
            int i = this.coordinates.vertical;
            while(i != endTile.pos.vertical)
            {
                if(board.GetFigureAtPosition(new Coordinates(i, this.coordinates.horizontal)) != null) return false;

                if(directionUp) i++;
                else i--;
            }
        }
       else{
            final boolean directionRight = endTile.pos.horizontal > this.coordinates.horizontal;
            int i = this.coordinates.horizontal;
            while(i != endTile.pos.horizontal)
            {
                if(board.GetFigureAtPosition(new Coordinates(this.coordinates.vertical, i)) != null) return false;

                if(directionRight) i++;
                else i--;
            }

        } return true;
    }

}
