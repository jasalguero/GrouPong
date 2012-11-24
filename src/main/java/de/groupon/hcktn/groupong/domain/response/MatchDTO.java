package de.groupon.hcktn.groupong.domain.response;

import de.groupon.hcktn.groupong.model.entity.Status;

public class MatchDTO {
    private Integer matchId;
    private Integer user1Id;
    private Integer user2Id;
    private Integer scoreUser1;
    private Integer scoreUser2;
    private String date;
    private String status;

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(Integer user1Id) {
        this.user1Id = user1Id;
    }

    public Integer getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(Integer user2Id) {
        this.user2Id = user2Id;
    }

    public Integer getScoreUser1() {
        return scoreUser1;
    }

    public void setScoreUser1(Integer scoreUser1) {
        this.scoreUser1 = scoreUser1;
    }

    public Integer getScoreUser2() {
        return scoreUser2;
    }

    public void setScoreUser2(Integer scoreUser2) {
        this.scoreUser2 = scoreUser2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
