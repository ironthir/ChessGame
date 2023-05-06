package Figures;

import Board.ChessBoard;
import Utilities.Coordinates;
import Board.Tile;

public class Bishop extends Figure {

    public Bishop(Coordinates pos, String owner)
    {
        super(pos, owner);
    }

    public static boolean ValidateBishopMovement(Tile endTile, ChessBoard board, Figure fig){
        int iteratorY = Math.max(fig.coordinates.vertical - fig.coordinates.horizontal, 0);
        int borderX = Math.max(fig.coordinates.horizontal - fig.coordinates.vertical, 0);

        while(iteratorY < 8 && borderX <8){
            Coordinates curr = new Coordinates(iteratorY, borderX);
            if(board.GetFigureAtPosition(curr).owner == fig.owner) return false;
            if(Coordinates.CompareCoordinates(curr, endTile.pos)) return true;
            iteratorY++;
            borderX++;
        }
        iteratorY = Math.max(fig.coordinates.vertical - fig.coordinates.horizontal, 0) ;
        borderX = Math.max(fig.coordinates.horizontal - fig.coordinates.vertical, fig.coordinates.horizontal) ;
        while(iteratorY < 8 && borderX >=0){
            Coordinates curr = new Coordinates(iteratorY, borderX);
            if(board.GetFigureAtPosition(curr).owner == fig.owner) return false;
            if(Coordinates.CompareCoordinates(curr, endTile.pos)) return true;
            if(Coordinates.CompareCoordinates(new Coordinates(iteratorY, borderX), endTile.pos))
                iteratorY++;
            borderX--;
        }
        return false;
    }
    public boolean ValidateFigureMovement(Tile endTile, ChessBoard board)
    {
        return this.ValidateBishopMovement(endTile, board, this);
    }

}
