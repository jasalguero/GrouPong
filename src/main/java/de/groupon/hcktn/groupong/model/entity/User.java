package de.groupon.hcktn.groupong.model.entity;

public class User {
    private Integer id;
    private String email;
    private String password;
    private String avatar;
    private Integer score;

    public User() {

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


    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final User myUser = (User) o;

        if (avatar != null ? !avatar.equals(myUser.avatar) : myUser.avatar != null) return false;
        if (email != null ? !email.equals(myUser.email) : myUser.email != null) return false;
        if (id != null ? !id.equals(myUser.id) : myUser.id != null) return false;
        if (password != null ? !password.equals(myUser.password) : myUser.password != null) return false;
        if (score != null ? !score.equals(myUser.score) : myUser.score != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int myresult = id != null ? id.hashCode() : 0;
        myresult = 31 * myresult + (email != null ? email.hashCode() : 0);
        myresult = 31 * myresult + (password != null ? password.hashCode() : 0);
        myresult = 31 * myresult + (avatar != null ? avatar.hashCode() : 0);
        myresult = 31 * myresult + (score != null ? score.hashCode() : 0);
        return myresult;
    }
}
