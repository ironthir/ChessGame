import java.util.Scanner;
public class Menu {
    public String playerOne, playerTwo;
    private ChessGame game;
    public static void main(String[] args) {
        Menu game = new Menu();
       game.PrintMenu();
    }
    public void PrintMenu(){
        //FileHelper helper = new FileHelper();
        //helper.ReadTextFromFile("src/MediaFiles/Menu.txt");
        System.out.println(" <*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*>\n" +
                " :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                "\n" +
                "                        _____ _\n" +
                "                       / ____| |\n" +
                "                      | |    | |__   ___  ___ ___\n" +
                "                      | |    | '_ \\ / _ \\/ __/ __|\n" +
                "                      | |____| | | |  __/\\__ \\__ \\\n" +
                "                       \\_____|_| |_|\\___||___/___/\n" +
                "\n" +
                "\n" +
                "<*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*>\n" +
                ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                "\n" +
                " :::::::::::::::                                             :::::::::::::::\n" +
                "  [1] START                                                    [0]  EXIT\n" +
                " :::::::::::::::                                             :::::::::::::::");
        GetAndResolveUserChoice();
    }

    public void GetAndResolveUserChoice(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What would you like to do? \n");
        String userChoice;
        boolean valid = false;
        while(!valid){

                userChoice = keyboard.nextLine();
                switch (userChoice){
                    case "1":
                        valid = true;
                        GetPlayerNames();
                        StartGame();
                        break;
                    case "0":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                        break;

                }
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
        this.game = new ChessGame(playerOne, playerTwo);
    }

}