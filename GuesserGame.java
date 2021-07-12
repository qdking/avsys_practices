package com.shangce;
import java.util.Scanner;


class Guesser
{
    int guessNum()
    {
        System.out.println("Guesser puts forth a number");
        Scanner sc = new Scanner(System.in);
        int gnum = sc.nextInt();
        return gnum;
    }
}
class Player
{
    int guessNum(int player_number)
    {
        System.out.println("Player " + player_number + " guess a number");
        Scanner sc = new Scanner(System.in);
        int pnum = sc.nextInt();
        return pnum;
    }
}

class Referee
{
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;
    int counter = 0;

    public int getCounter() {
        return counter;
    }

    void askGuesser()
    {
        Guesser akhil = new Guesser();
        numFromGuesser = akhil.guessNum();
    }

    void askPlayers()
    {
        Player ryan = new Player();
        Player deeps = new Player();
        Player dee = new Player();

        numFromPlayer1 = ryan.guessNum(1);
        numFromPlayer2 = deeps.guessNum(2);
        numFromPlayer3 = dee.guessNum(3);
    }

    void checkNum()
    {
        if(numFromPlayer1 == numFromGuesser)
        {
            System.out.println("Player 1 is the winner");
            counter = 1;
        }
        if(numFromPlayer2 == numFromGuesser)
        {
            System.out.println("Player 2 is the winner");
            counter = 1;
        }
        if
        (numFromPlayer3 == numFromGuesser)
        {
            System.out.println("Player 3 is the winner");
            counter = 1;
        }
        if (counter == 0)
        {
            System.out.println("Nobody has won. Game continues for more guesses.");
        }
        if (counter == 1)
        {
            System.out.println("Game Ended");
        }
    }
}

public class GuesserGame {

    public static void main(String[] args) {
        Referee xavier = new Referee();
        xavier.askGuesser();
        do
        {
            xavier.askPlayers();
            xavier.checkNum();
        }
        while (xavier.getCounter() == 0);

    }
}