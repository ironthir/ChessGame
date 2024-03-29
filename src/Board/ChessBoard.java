package Board;

import Enums.MoveResult;
import Figures.*;
import Utilities.Coordinates;

public class ChessBoard {

    public Tile[][] chessMatrix = new Tile[8][8];
    public String playerOne, playerTwo;
    private Figure[] killed = new Figure[32];
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    private int numberOfKilled = 0;
    public ChessBoard(String playerOne, String playerTwo){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.InitializeChessBoard();
    }

    public Figure FigureInitializer(int val, Coordinates pos, String owner){

            switch(val){
                case 2:
                case 5:
                    return new Bishop(pos, owner);
                case 1:
                case 6:
                    return new Knight(pos, owner);
                case 0:
                case 7:
                    return new Rook(pos, owner);
                case 3:
                    return new Queen(pos, owner);
                case 4:
                    return new King(pos, owner);
                default:
                    throw new Error("Unhandled figure");
            }


    }
    public void InitializeChessBoard(){
        for(int i = 0; i < 8; i++){
         chessMatrix[i][0] = new Tile(new Coordinates(0, i), FigureInitializer(i, new Coordinates(0, i), playerOne ));
         chessMatrix[i][1] = new Tile(new Coordinates(1, i), new Pawn(new Coordinates(1, i), playerOne, 1));
         chessMatrix[i][7] = new Tile(new Coordinates(7, i),FigureInitializer(i, new Coordinates(7, i), playerTwo));
         chessMatrix[i][6] = new Tile(new Coordinates(6, i), new Pawn(new Coordinates(6, i), playerTwo, -1));
        }
        for(int i = 0; i < 8; i++){
            for(int j = 2; j < 6; j++){
                chessMatrix[i][j] = new Tile(new Coordinates(j, i));
            }
        }
        DrawChessboard();

    }


    public void DrawChessboard(){
        for(int i = 0; i < 8; i ++){
            if(i ==0) System.out.print("  ");
            System.out.printf("%-10s", (char)('A' + i));
        }
        for(int i = 0; i < 8; i++){
            System.out.print("\n" + String.valueOf(1+i) + " ");
            for(int j = 0; j < 8; j++){
                String text = (chessMatrix[j][i].hasFigure ? chessMatrix[j][i].figureInPlace.getClass().getSimpleName() : "*");
                if(chessMatrix[j][i].hasFigure && chessMatrix[j][i].figureInPlace.owner == playerTwo)
                    System.out.printf("\033[0;30m%-10s\033[0m", text);
                else  System.out.printf( "%-10s", text);
            }
        }
        System.out.print("\n");
    }

    public MoveResult UpdateChessMatrix(Figure figure, Coordinates pos)
    {
        final Coordinates prevPos = figure.coordinates;

        if(this.chessMatrix[pos.horizontal][pos.vertical].hasFigure){
            this.numberOfKilled += 1;
            figure.UpdatePosition(pos);
            this.killed[numberOfKilled] = this.GetFigureAtPosition(pos);
            chessMatrix[prevPos.horizontal][prevPos.vertical].UpdateTile();
            chessMatrix[pos.horizontal][pos.vertical].UpdateTile(figure);

            return MoveResult.Killed;
        }
         else {
            figure.UpdatePosition(pos);
            chessMatrix[prevPos.horizontal][prevPos.vertical].UpdateTile();
            chessMatrix[pos.horizontal][pos.vertical].UpdateTile(figure);
            return MoveResult.Moved;

        }

    }

    public Figure GetFigureAtPosition(Coordinates pos)
    {
        return this.chessMatrix[pos.horizontal][pos.vertical].figureInPlace;
    }

    public Tile GetTileAtPosition(Coordinates pos)
    {
        return this.chessMatrix[pos.horizontal][pos.vertical];
    }

    public void RefreshChessboard()
    {

        DrawChessboard();
    }



}
