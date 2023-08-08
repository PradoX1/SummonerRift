import service.MatchService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MatchService matchService = new MatchService();
        matchService.setMatch();
        matchService.getChampions();
    }
}
