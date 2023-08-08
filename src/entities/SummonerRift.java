package entities;

import java.time.LocalDateTime;

public class SummonerRift {
    private LocalDateTime timeStart;
    private String nameTeam1;
    private String nameTeam2;

    public SummonerRift(LocalDateTime timeStart, String nameTeam1, String nameTeam2) {
        this.timeStart = timeStart;
        this.nameTeam1 = nameTeam1;
        this.nameTeam2 = nameTeam2;
    }
}
