package de.groupon.hcktn.groupong.model.entity;

import java.util.Calendar;

public class Match {
    private Integer id;
    private Integer user1Id;
    private Integer user2Id;
    private Integer scoreUser1;
    private Integer scoreUser2;
    private Calendar matchDate;
    private Integer statusId;

    public Match() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(final Integer user1Id) {
        this.user1Id = user1Id;
    }

    public Integer getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(final Integer user2Id) {
        this.user2Id = user2Id;
    }

    public Integer getScoreUser1() {
        return scoreUser1;
    }

    public void setScoreUser1(final Integer scoreUser1) {
        this.scoreUser1 = scoreUser1;
    }

    public Integer getScoreUser2() {
        return scoreUser2;
    }

    public void setScoreUser2(final Integer scoreUser2) {
        this.scoreUser2 = scoreUser2;
    }

    public Calendar getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(final Calendar matchDate) {
        this.matchDate = matchDate;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(final Integer statusId) {
        this.statusId = statusId;
    }
}
