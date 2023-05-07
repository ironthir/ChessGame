
import Board.ChessBoard;
import Enums.MoveResult;
import Exceptions.InvalidPlaceException;
import Utilities.Coordinates;

import java.util.Scanner;

public class TurnHandler {

    private static int turnCounter = 0;
    public String playerOne, playerTwo;
    public String currentPlayer;
    private ChessBoard board;
    private MoveHandler moveHandler;
    private CheckHandler checkHandler;

    TurnHandler(String playerOne, String playerTwo, ChessBoard board){
        this.checkHandler = new CheckHandler();
        this.moveHandler = new MoveHandler(board, this.checkHandler);
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.currentPlayer = playerOne;
        this.board = board;

    }



private void GetTheUserToSelectCorrectFigure(){
    String startPlace;
    Coordinates startPlaceComputer = null;

    Scanner keyboard = new Scanner(System.in);
    System.out.print("Which figure would you like to move? \n");
    boolean isValid = false;
    while(!isValid){
        try{
            startPlace = keyboard.nextLine();
            startPlaceComputer = Coordinates.ConvertHumanToComputer(startPlace);
            isValid = this.moveHandler.ValidateSelectedFigure(startPlaceComputer, currentPlayer);

        }catch(InvalidPlaceException e)  {
            System.out.println(e.message);
        }

    }

}
    private boolean GetTheUserToSelectCorrectDestination()
    {
        String desiredPlace;
        Coordinates desiredPlaceComputer = null;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Where would you like to move it?\n");

        boolean isValid = false;
        while(!isValid){
            try{
                desiredPlace = keyboard.nextLine();
                if(desiredPlace.equalsIgnoreCase("cancel")) {
                    System.out.println(desiredPlace);
                return true;
                }
                desiredPlaceComputer =  Coordinates.ConvertHumanToComputer(desiredPlace);
                isValid = moveHandler.ValidateSelectedDestination(desiredPlaceComputer, checkHandler.IsCurrentPlayerChecked(this.currentPlayer));
            }catch(InvalidPlaceException e)  {
                System.out.println(e.message);
            }
        }
        return false;

    }




    public MoveResult ProcessUserTurn(){
        if(this.currentPlayer == playerOne)
            this.currentPlayer = playerTwo;
        else
            this.currentPlayer = playerOne;
        System.out.print("It's " +currentPlayer+"'s turn. \n");
        boolean cancelled = false;
        do{
            GetTheUserToSelectCorrectFigure();
            cancelled= GetTheUserToSelectCorrectDestination();
        }while(cancelled);

        final MoveResult result = moveHandler.MakeAMove();
         board.RefreshChessboard();
         return result;
    }

}
