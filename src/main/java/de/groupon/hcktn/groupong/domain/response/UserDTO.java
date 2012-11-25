package de.groupon.hcktn.groupong.domain.response;

import de.groupon.config.web.annotation.JsonImplicit;

import java.util.ArrayList;
import java.util.List;

@JsonImplicit(UserDTO.class)
public class UserDTO extends BaseDTO {

    private String userName;
    private String password;
    private String email;
    private String avatar;
    private Integer score;
    private String rank;

    private List<Integer> achievements = new ArrayList<Integer>();
    private List<MatchDTO> matches = new ArrayList<MatchDTO>();

    public UserDTO() {

    }

    public UserDTO(Integer id) {
        super(id);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public List<Integer> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Integer> achievements) {
        this.achievements = achievements;
    }

    public List<MatchDTO> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchDTO> matches) {
        this.matches = matches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO)) return false;

        UserDTO userDTO = (UserDTO) o;

        if (achievements != null ? !achievements.equals(userDTO.achievements) : userDTO.achievements != null)
            return false;
        if (avatar != null ? !avatar.equals(userDTO.avatar) : userDTO.avatar != null) return false;
        if (email != null ? !email.equals(userDTO.email) : userDTO.email != null) return false;
        if (matches != null ? !matches.equals(userDTO.matches) : userDTO.matches != null) return false;
        if (password != null ? !password.equals(userDTO.password) : userDTO.password != null) return false;
        if (rank != null ? !rank.equals(userDTO.rank) : userDTO.rank != null) return false;
        if (score != null ? !score.equals(userDTO.score) : userDTO.score != null) return false;
        if (userName != null ? !userName.equals(userDTO.userName) : userDTO.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (achievements != null ? achievements.hashCode() : 0);
        result = 31 * result + (matches != null ? matches.hashCode() : 0);
        return result;
    }
}
