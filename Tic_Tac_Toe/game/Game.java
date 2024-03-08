package game;

import player.Player;
import board.Board;
import java.util.*;

public class Game
{
  Player[] players;
  Board board;
  int turn;
  int noOfMoves;
  boolean gameOver;
  String zero;
  String cross;
  int size;
  //char[][] matrix;
  public Game(Player[] players,Board board)//,int size,char symbol)
  {
     this.players=players;
     this.board=board;
     this.turn=0;
     this.noOfMoves=0;
     this.gameOver=false;
     this.size=board.size;
    

     StringBuilder z=new StringBuilder();
     StringBuilder c=new StringBuilder();

     for(int i=0;i<size;i++)
     {
        z.append('0');
        c.append('X');
     }

     this.zero=z.toString();
     this.cross=c.toString();

  }

 public void printBoardConfig()
  {
    int sz=size;
    for(int i=0;i<sz;i++)
    {
        for(int j=0;j<sz;j++)
        {
            System.out.print(board.matrix[i][j] +" ");
        }
        System.out.println();
    }
  }

  public int getIndex()
  {
     while(true)
     {
      System.out.println("Player: "+players[turn].getPlayerName() +" give one position");
      Scanner sc=new Scanner(System.in);
      int pos=sc.nextInt()-1;

      int sz=size;

      int row=pos/sz;
      int col=pos%sz;

      if(row<0 || row>=sz || col<0 || col>=sz)
      {
        System.out.println("Invalid position");
        continue;
      }
      if(board.matrix[row][col]!='-')
      {
        System.out.println("position is already occupied");
        continue;
      }
     
      return pos;
     }
  }

  public boolean checkCombination()
  {
    int sz=size;

  // checking rowwise
    for(int i=0;i<sz;i++)
    {
      StringBuilder sb=new StringBuilder();
      for(int j=0;j<sz;j++)
      {
        sb.append(board.matrix[i][j]);
      }
      String pattern=sb.toString();
      if(pattern.equals(zero) || pattern.equals(cross))
        return true;
    }

  // checking column wisw
  for(int i=0;i<sz;i++)
  {
    StringBuilder sb=new StringBuilder();
    for(int j=0;j<sz;j++)
    {
      sb.append(board.matrix[j][i]);
    }
    String pattern=sb.toString();
    if(pattern.equals(zero) || pattern.equals(cross))
       return true;
  }

  //checking for diagonal
  int i=0,j=0;
  StringBuilder sb=new StringBuilder();
  while(i<sz)
  {
    sb.append(board.matrix[i][j]);
    i++;
    j++;
  }
  String pattern=sb.toString();
  if(pattern.equals(zero) || pattern.equals(cross))
     return true;

  //checking for anti diagonal
  i=0;
  j=sz-1;
  sb=new StringBuilder();
  while(i<sz)
  {
    sb.append(board.matrix[i][j]);
    i++;
    j--;
  }
  pattern=sb.toString();
  if(pattern.equals(zero) || pattern.equals(cross))
     return true;

    return false;

  }

  public void play()
  {
    //printBoardConfig();
     int sz=size;

     while(!gameOver)
     {
       noOfMoves++;
       int pos=getIndex();
       int row=pos/sz;
       int col=pos%sz;
 
      board.matrix[row][col]=players[turn].getPlayerSymbol();

      if(noOfMoves>=sz*sz )
      {
        System.out.println("Game draw");
        return;
      }

      if(noOfMoves>=2*sz-1 && checkCombination()==true)
      {
        gameOver=true;
        printBoardConfig();
        System.out.println("Winner is: "+players[turn].getPlayerName());
        return;
      }

      turn=(turn+1)%2;
      printBoardConfig();

     }
     
    }


}