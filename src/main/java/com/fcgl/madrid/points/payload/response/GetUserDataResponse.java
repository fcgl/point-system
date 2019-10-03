package com.fcgl.madrid.points.payload.response;

public class GetUserDataResponse {
    private Integer totalPoints;
    private Integer tournamentPoints;
    private Integer trophyCount;

    public GetUserDataResponse(Integer totalPoints, Integer tournamentPoints, Integer trophyCount) {
        this.totalPoints = totalPoints;
        this.tournamentPoints = tournamentPoints;
        this.trophyCount = trophyCount;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Integer getTournamentPoints() {
        return tournamentPoints;
    }

    public void setTournamentPoints(Integer tournamentPoints) {
        this.tournamentPoints = tournamentPoints;
    }

    public Integer getTrophyCount() {
        return trophyCount;
    }

    public void setTrophyCount(Integer trophyCount) {
        this.trophyCount = trophyCount;
    }
}
