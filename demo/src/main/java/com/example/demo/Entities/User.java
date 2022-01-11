package com.example.demo.Entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String username;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "postUser", cascade = CascadeType.ALL)
    private Set <Post> userPosts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "commentUser", cascade = CascadeType.ALL)
    private Set <Comment> userComments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "replyUser", cascade = CascadeType.ALL)
    private Set <Reply> userReplies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "firstUser", cascade = CascadeType.ALL)
    private Set <Frenship> frens = new LinkedHashSet<>();

    public User() {
    }

    public User(String username, String name, String email, String password) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<Post> getUserPosts() {
        return userPosts;
    }

    public Set<Comment> getUserComments() {
        return userComments;
    }

    public void setUserReplies(Set<Reply> userReplies) {
        this.userReplies = userReplies;
    }

    public Set<Reply> getUserReplies() {
        return userReplies;
    }

    public void setUserPosts(Set<Post> userPosts) {
        this.userPosts = userPosts;
    }

    public void setUserComments(Set<Comment> userComments) {
        this.userComments = userComments;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Frenship> getFrens() {
        return frens;
    }

    public void setFrens(Set<Frenship> frens) {
        this.frens = frens;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
