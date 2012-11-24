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


    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Match myMatch = (Match) o;

        if (id != null ? !id.equals(myMatch.id) : myMatch.id != null) return false;
        if (matchDate != null ? !matchDate.equals(myMatch.matchDate) : myMatch.matchDate != null) return false;
        if (scoreUser1 != null ? !scoreUser1.equals(myMatch.scoreUser1) : myMatch.scoreUser1 != null) return false;
        if (scoreUser2 != null ? !scoreUser2.equals(myMatch.scoreUser2) : myMatch.scoreUser2 != null) return false;
        if (statusId != null ? !statusId.equals(myMatch.statusId) : myMatch.statusId != null) return false;
        if (user1Id != null ? !user1Id.equals(myMatch.user1Id) : myMatch.user1Id != null) return false;
        if (user2Id != null ? !user2Id.equals(myMatch.user2Id) : myMatch.user2Id != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int myresult = id != null ? id.hashCode() : 0;
        myresult = 31 * myresult + (user1Id != null ? user1Id.hashCode() : 0);
        myresult = 31 * myresult + (user2Id != null ? user2Id.hashCode() : 0);
        myresult = 31 * myresult + (scoreUser1 != null ? scoreUser1.hashCode() : 0);
        myresult = 31 * myresult + (scoreUser2 != null ? scoreUser2.hashCode() : 0);
        myresult = 31 * myresult + (matchDate != null ? matchDate.hashCode() : 0);
        myresult = 31 * myresult + (statusId != null ? statusId.hashCode() : 0);
        return myresult;
    }
}
