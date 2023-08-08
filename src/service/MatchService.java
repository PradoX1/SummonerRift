package service;

import entities.SummonerRift;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MatchService {
    String name = "";
    String position = "";
    List<String> nameChampionsTeam1 = new ArrayList<>();
    List<String> nameChampionsTeam2 = new ArrayList<>();
    List<String> positionCTeam1 = new ArrayList<>();
    List<String> positionCTeam2 = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public SummonerRift setMatch() {

        System.out.println("Chúng tôi có những team sau:" + "\n" + "SKT,G2,GAM,SE,GEN,JDG.");
        System.out.println("Bạn muốn chọn team 1 là: ");
        String nameTeam1 = scanner.nextLine().toUpperCase();
        System.out.println("Bạn muốn chọn team 2 là:");
        String nameTeam2 = scanner.nextLine().toUpperCase();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Mời bạn nhập thời gian trận đấu bắt đầu: ");
        LocalDateTime timeGame = LocalDateTime.parse(scanner.nextLine(), formatter);
        return new SummonerRift(timeGame, nameTeam1, nameTeam2);
    }

    public void setChampion(List<String>nameC, List<String> positionC,int i, int n) {
        do {
            System.out.print("Nhập tên tướng thứ " + (i+1) +" của team "+n+ ": ");
            name = scanner.next();
            if (nameC.contains(name)) {
                System.out.println("Tên tướng đã tồn tại, vui lòng nhập lại.");
            }
        } while (nameC.contains(name));

        // Nhập vị trí và kiểm tra trùng lặp
        do {
            System.out.print("Nhập vị trí của tướng " + name + ": ");
            position = scanner.next();

            if (positionC.contains(position)) {
                System.out.println("Vị trí đã tồn tại, vui lòng nhập lại.");
            }
        } while (positionC.contains(position));

        // Thêm tướng và vị trí vào danh sách
        nameC.add(name);
        positionC.add(position);
    }

    public void getChampions() {
        int n = 0;
        for (int i = 0; i < 10; i++) {
            if (i<5) {
                n=1;
                this.setChampion(nameChampionsTeam1,positionCTeam1,i,n);
            }else {
                n=2;
                this.setChampion(nameChampionsTeam2,positionCTeam2,i-5,n);
            }
        }
        System.out.println("Đội hình của team 1 là: " + "\n" + nameChampionsTeam1 + "\n" + "Vị trí lần lượt là:" + "\n" + positionCTeam1);
        System.out.println("Đội hình của team 2 là: " + "\n" + nameChampionsTeam2 + "\n" + "Vị trí lần lượt là:" + "\n" + positionCTeam2);
    }

}
