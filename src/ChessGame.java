import Board.ChessBoard;
import Enums.MoveResult;

public class ChessGame {
    public String playerOne, playerTwo;
    ChessBoard board;
    TurnHandler turnHandler;
    private boolean isAlive = true;
    ChessGame(String playerOne, String playerTwo) {
        this.board = new ChessBoard(playerOne, playerTwo);
        this.turnHandler = new TurnHandler(playerOne, playerTwo, board);
        KeepTheGameAlive();
    }

    public void KeepTheGameAlive(){
        while(isAlive){
            MoveResult result = turnHandler.ProcessUserTurn();
            this.isAlive = result != MoveResult.CheckMate;
        }
    }


}
