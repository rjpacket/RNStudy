package com.rjp.shell.model;

/**
 * author : Gimpo create on 2018/4/10 19:51
 * email  : jimbo922@163.com
 */

public class PlayerModel {

    /**
     * goalsScored : 24
     * playingCount : 31
     * scorer : 凯恩
     * teamName : 热刺
     */

    private String goalsScored;
    private String playingCount;
    private String scorer;
    private String teamName;

    public String getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(String goalsScored) {
        this.goalsScored = goalsScored;
    }

    public String getPlayingCount() {
        return playingCount;
    }

    public void setPlayingCount(String playingCount) {
        this.playingCount = playingCount;
    }

    public String getScorer() {
        return scorer;
    }

    public void setScorer(String scorer) {
        this.scorer = scorer;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
