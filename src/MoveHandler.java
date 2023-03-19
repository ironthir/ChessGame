import Enums.FigureType;

public class MoveHandler {
    private ChessBoard localChessboard;
    private final int INDEX_OF_FINAL_FIELD = 7;
    MoveHandler(ChessBoard board){
        this.localChessboard = board;

    }

    public void MakeAMove(Coordinates start, Coordinates end, Figure figure){
        if(!IsTheMoveInsideBounds(start, end, figure.typeOfFigure)) return;

    }
    public boolean IsTheMoveInsideBounds(Coordinates start, Coordinates end,  FigureType type){
        switch (type){
            case Pawn:
                final int diff = end.horizontal - start.horizontal;
                final boolean directionLeft = diff < 0;

                if((directionLeft && start.horizontal - (-diff) < 0) || (!directionLeft &&   start.horizontal + (-diff) >INDEX_OF_FINAL_FIELD  )){
                    return false;
                }


            default:
                throw new Error("Unspecified type of figure");

        }
    }

}
