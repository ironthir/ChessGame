import Enums.FigureType;

public class ChessBoard {

    public Figure[][] chessMatrix = new Figure[8][8];
    public String playerOne, playerTwo;
    ChessBoard(String playerOne, String playerTwo){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.InitializeChessBoard();
    }

    public FigureType ChooseFigure(int pos){
        if(pos <=4 ) return FigureType.values()[pos];
        else {
            switch(pos){
                case 5:
                    return FigureType.Bishop;
                case 6:
                    return FigureType.Knight;
                case 7:
                    return FigureType.Rook ;
                default:
                    throw new Error("Unhandled figure");
            }

        }
    }
    public void InitializeChessBoard(){
        for(int i = 0; i < 8; i++){
         chessMatrix[i][0] = new Figure(new Coordinates(0, i), ChooseFigure(i), playerOne);
         chessMatrix[i][1] = new Figure(new Coordinates(1, i), FigureType.Pawn, playerOne);
         chessMatrix[i][7] = new Figure(new Coordinates(7, i), ChooseFigure(i), playerTwo);
         chessMatrix[i][6] = new Figure(new Coordinates(6, i), FigureType.Pawn, playerTwo);
        }
        for(int i = 0; i < 8; i++){
            for(int j = 2; j < 6; j++){
                chessMatrix[i][j] = new Figure(new Coordinates(i, j), FigureType.None);
            }
        }
        DrawChessboard();

    }

    public void DrawChessboard(){
    for(int i = 0; i < 8; i++){
        String text = "";
        for(int j = 0; j < 8; j++){
            text+= (chessMatrix[j][i].typeOfFigure != FigureType.None ? chessMatrix[j][i].typeOfFigure : "*") + " ";
        }
        System.out.println(text);
    }
    }



}
