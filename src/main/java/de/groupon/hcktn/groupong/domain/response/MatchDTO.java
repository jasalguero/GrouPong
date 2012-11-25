package de.groupon.hcktn.groupong.domain.response;

import de.groupon.config.web.annotation.JsonImplicit;

@JsonImplicit(MatchDTO.class)
public class MatchDTO extends BaseDTO {

    private Integer user1Id;
    private Integer user2Id;
    private Integer scoreUser1;
    private Integer scoreUser2;
    private String date;
    private String status;
    private Integer statusId;

    public MatchDTO() {
    }

    public MatchDTO(Integer id) {
        super(id);
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

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatchDTO)) return false;

        MatchDTO matchDTO = (MatchDTO) o;

        if (date != null ? !date.equals(matchDTO.date) : matchDTO.date != null) return false;
        if (scoreUser1 != null ? !scoreUser1.equals(matchDTO.scoreUser1) : matchDTO.scoreUser1 != null) return false;
        if (scoreUser2 != null ? !scoreUser2.equals(matchDTO.scoreUser2) : matchDTO.scoreUser2 != null) return false;
        if (status != null ? !status.equals(matchDTO.status) : matchDTO.status != null) return false;
        if (statusId != null ? !statusId.equals(matchDTO.statusId) : matchDTO.statusId != null) return false;
        if (user1Id != null ? !user1Id.equals(matchDTO.user1Id) : matchDTO.user1Id != null) return false;
        if (user2Id != null ? !user2Id.equals(matchDTO.user2Id) : matchDTO.user2Id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user1Id != null ? user1Id.hashCode() : 0;
        result = 31 * result + (user2Id != null ? user2Id.hashCode() : 0);
        result = 31 * result + (scoreUser1 != null ? scoreUser1.hashCode() : 0);
        result = 31 * result + (scoreUser2 != null ? scoreUser2.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        return result;
    }
}
