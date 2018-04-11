package com.rjp.shell.model;

/**
 * author : Gimpo create on 2018/4/10 19:51
 * email  : jimbo922@163.com
 */

public class RankModel {
    /**
     * cupIndex : 0
     * draws : 5
     * losses : 5
     * matchesPlayed : 32
     * points : 71
     * rank : 2
     * team : 曼联
     * teamLogo : http://pimg1.126.net/caipiao_info/images/team/25/662.png
     * wins : 22
     */

    private int cupIndex;
    private String draws;
    private String losses;
    private String matchesPlayed;
    private String points;
    private String rank;
    private String team;
    private String teamLogo;
    private String wins;

    public int getCupIndex() {
        return cupIndex;
    }

    public void setCupIndex(int cupIndex) {
        this.cupIndex = cupIndex;
    }

    public String getDraws() {
        return draws;
    }

    public void setDraws(String draws) {
        this.draws = draws;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }

    public String getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(String matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeamLogo() {
        return teamLogo;
    }

    public void setTeamLogo(String teamLogo) {
        this.teamLogo = teamLogo;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }
}
