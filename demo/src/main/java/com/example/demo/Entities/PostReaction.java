package com.example.demo.Entities;

import javax.persistence.*;

@Entity
@Table(name = "post_react_table")
public class PostReaction {

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(nullable = false)
    private Post post;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(nullable = false)
    private User user;

    @Id
    @Lob
    @Column(nullable = false)
    private String reactionId=post.getPostId().toString()+user.getUsername();

    public PostReaction() {
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getReactionId() {
        return reactionId;
    }

    public void setReactionId(String reactionId) {
        this.reactionId = reactionId;
    }

    @Override
    public String toString() {
        return "PostReaction{" +
                "post=" + post +
                ", user=" + user +
                ", reactionId='" + reactionId + '\'' +
                '}';
    }
}
