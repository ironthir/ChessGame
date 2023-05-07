package Figures;
import Board.ChessBoard;
import Utilities.Coordinates;
import Board.Tile;
public class Pawn extends Figure {
    private int directionDown;
    public Pawn(Coordinates pos, String owner, int directionDown)
    {
        super(pos, owner);
        this.directionDown = directionDown;
    }

    public boolean ValidateFigureMovement(Tile endTile, ChessBoard board) {
        Coordinates[] posForAttack = {new Coordinates(this.coordinates.vertical+ directionDown , this.coordinates.horizontal - 1), new Coordinates(this.coordinates.vertical +directionDown, this.coordinates.horizontal + 1)};
        for (int i = 0; i < 2; i++) {
            if (Coordinates.CompareCoordinates(posForAttack[i], endTile.pos) && endTile.hasFigure)
                return true;
        }
        return endTile.pos.horizontal == this.coordinates.horizontal && endTile.pos.vertical == (this.coordinates.vertical + directionDown) && !endTile.hasFigure;
    }

}
