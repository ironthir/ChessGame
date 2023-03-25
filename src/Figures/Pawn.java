package Figures;
import Board.ChessBoard;
import Utilities.Coordinates;
import Board.Tile;
public class Pawn extends Figure {

    public Pawn(Coordinates pos, String owner)
    {
        super(pos, owner);
    }
    public boolean ValidateFigureMovement(Tile endTile, ChessBoard board)
    {
       Coordinates[] posForAttack = {new Coordinates(this.coordinates.horizontal-1, this.coordinates.vertical+1), new Coordinates(this.coordinates.horizontal+1, this.coordinates.vertical+1)};
       for(int i = 0; i < 2; i++)
       {
            if(Coordinates.CompareCoordinates(posForAttack[i], endTile.pos) && endTile.hasFigure)
                return true;
       }
       return endTile.pos.horizontal == this.coordinates.horizontal && endTile.pos.vertical == (this.coordinates.vertical + 1) && !endTile.hasFigure;
    }

}
