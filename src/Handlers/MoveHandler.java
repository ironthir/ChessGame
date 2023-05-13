package Handlers;

import Board.ChessBoard;
import Enums.InvalidPlaceEnum;
import Enums.MoveResult;
import Exceptions.InvalidPlaceException;
import Figures.Figure;
import Utilities.Coordinates;
import Board.Tile;

public class MoveHandler {

    private ChessBoard board;
    private CheckHandler checkHandler;
    private Figure currentFigure = null;
    private Coordinates destination;
    MoveHandler(ChessBoard board, CheckHandler checkHandler){
        this.board = board;
        this.checkHandler = checkHandler;

    }

    public boolean ValidateSelectedFigure(Coordinates start, String currentPlayer) throws InvalidPlaceException {


        final Figure figureAtLocation = board.GetFigureAtPosition(start);

        if(figureAtLocation == null) throw new InvalidPlaceException(InvalidPlaceEnum.EmptyPlace);

        if(!figureAtLocation.owner.equals(currentPlayer)) throw new InvalidPlaceException(InvalidPlaceEnum.EnemyFigureInPlace);

        this.currentFigure = figureAtLocation;
        return true;

    }

    public boolean ValidateSelectedDestination(Coordinates pos, boolean inCheck) throws InvalidPlaceException
    {

        final Figure figureAtLocation = board.GetFigureAtPosition(pos);
        if(figureAtLocation != null && figureAtLocation.owner.equals(currentFigure.owner)) throw new InvalidPlaceException(InvalidPlaceEnum.AllyFigureInPlace);

        if(!IsTheMoveLegal(pos)) throw new InvalidPlaceException(InvalidPlaceEnum.OutsideRangeOfFigure);

        this.destination = pos;
        return true;
    }

    public MoveResult MakeAMove(){
       return board.UpdateChessMatrix(currentFigure, destination);

    }
    public boolean IsTheMoveLegal(Coordinates end){
        final Tile endTile = board.GetTileAtPosition(end);
       return currentFigure.ValidateFigureMovement(endTile, this.board);
    }

}
