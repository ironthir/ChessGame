import java.util.Scanner;
public class ChessGame {
    public String playerOne, playerTwo;
ChessBoard board;
    public static void main(String[] args) {
        ChessGame game = new ChessGame();
       game.PrintMenu();
    }
    public void PrintMenu(){
        FileHelper helper = new FileHelper();
        helper.ReadTextFromFile("C:\\Personal\\Chess\\src\\MediaFiles\\Menu.txt");
        GetAndResolveUserChoice();

    }

    public void GetAndResolveUserChoice(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What would you like to do? \n");
        int userChoice = keyboard.nextInt();

        switch (userChoice){
            case 1:
                GetPlayerNames();
                StartGame();
                break;
            default:
                throw new Error("Unhandled player choice");

        }
    }

    public void GetPlayerNames() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Name of player one: ");
        this.playerOne =  keyboard.nextLine();

        System.out.println("Name of player two: ");
        this.playerTwo =  keyboard.nextLine();

        while(playerOne.equals(playerTwo))
        {
            System.out.println("Players cannot have the same name! Enter new name: ");
            this.playerTwo =  keyboard.nextLine();
        };

    }

    public void StartGame(){
        this.board = new ChessBoard(playerOne, playerTwo);

    }

}