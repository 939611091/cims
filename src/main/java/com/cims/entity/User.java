package com.cims.entity;

public class User {
    private Integer id;
    private String username;
    private String photo;

    public User(Integer id, String username, String photo) {
        this.id = id;
        this.username = username;
        this.photo = photo;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
