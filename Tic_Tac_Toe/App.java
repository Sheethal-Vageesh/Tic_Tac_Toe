import board.Board;
import player.Player;
import game.Game;
import java.util.Scanner;


public class App {
    
    public App(){        
    }
    public static void main(String[] args) throws Exception
    {
        System.out.println("First Project -> Tic Tac Toe");

        Scanner sc=new Scanner(System.in);

        System.out.print("please enter the size of board : ");
        int size=sc.nextInt();        
        Board b=new Board(size,'-');        

        Player[] p=new Player[2];

        System.out.print("Please enter first player name : ");
        String name=sc.nextLine();
        System.out.print("Please enter first player symbol : ");
        char symbol=sc.nextLine().charAt(0);

        p[0]=new Player();
        p[0].setPlayerNameAndSymbol(name,symbol);
        
        System.out.print("Please enter second player name : ");
        name=sc.nextLine();
        System.out.print("Please enter second player symbol : ");
        symbol=sc.nextLine().charAt(0);

        p[1]=new Player();
        p[1].setPlayerNameAndSymbol(name,symbol);

        p[0].getPlayerNameAndSymbol();
        p[1].getPlayerNameAndSymbol();

        b.printBoardConfig();
        Game g=new Game(p,b);
        g.play();
        sc.close();
    }
}
