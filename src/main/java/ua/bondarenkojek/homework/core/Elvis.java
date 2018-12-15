package ua.bondarenkojek.homework.core;

public class Elvis {
    public static void main(String[] args) {

        //Test
        //result = 2
        System.out.println(matchResult(2, 0, 2, 0));
        //result = 1
        System.out.println(matchResult(2, 0, 1, 0));
        //result = 0
        System.out.println(matchResult(0, 2, 2, 0));

    }

    public static int matchResult(int firstTeamScore, int secondTeamScore, int firstRate, int secondRate) {
        return (firstTeamScore == firstRate && secondTeamScore == secondRate) ? 2 :
                ((firstTeamScore > secondTeamScore  && firstRate > secondRate) ||
                (firstTeamScore < secondTeamScore  && firstRate < secondRate)) ? 1 : 0;
    }
}
