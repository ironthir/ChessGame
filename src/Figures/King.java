package Figures;


import Board.ChessBoard;
import Board.Tile;
import Utilities.Coordinates;

public class King extends Figure {

    public King(Coordinates pos, String owner)
    {
        super(pos, owner);
    }

    public static boolean ValidateKingMovement(Tile endTile, ChessBoard board, Figure fig){
        final int[] XOffset = {-1, 0, 1};
        final int[] YOffset = {1, 0, -1};

        for(int i = 0; i < 3; i++){
            for(int j =0; j < 3; j++){
                Coordinates curr = new Coordinates(fig.coordinates.vertical + YOffset[j], fig.coordinates.horizontal + XOffset[i]);
                if(Coordinates.CompareCoordinates(endTile.pos, curr)) return true;
            }
        }
        return false;
    }
    public boolean ValidateFigureMovement(Tile endTile, ChessBoard board)
    {
      return this.ValidateKingMovement(endTile, board, this);
    }

}
