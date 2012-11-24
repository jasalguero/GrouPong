package de.groupon.hcktn.groupong.model.entity;

public class User {
    private Integer id;
    private String email;
    private String password;
    private String avatar;
    private Integer score;

    public User() {

    }

    public User(final Integer id, final  String email, final String password, final String avatar, final Integer score) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.score = score;
    }

    public User(final  String email, final String password, final String avatar, final Integer score) {
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(final String avatar) {
        this.avatar = avatar;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(final Integer score) {
        this.score = score;
    }






}
