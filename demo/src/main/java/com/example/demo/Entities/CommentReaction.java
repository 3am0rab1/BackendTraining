package com.example.demo.Entities;

import javax.persistence.*;

@Entity
@Table(name = "comment_react_table")
public class CommentReaction {

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Comment comment;

    @OneToOne(optional = false)
    @JoinColumn(nullable = false)
    private User user;

    @Id
    @Lob
    @Column(nullable = false)
    private String reactionId=comment.getCommentId().toString()+user.getUsername();

    public CommentReaction(Comment comment, User user, String reactionId) {
        this.comment = comment;
        this.user = user;
        this.reactionId = reactionId;
    }

    public CommentReaction() {
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
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
        return "CommentReactions{" +
                "comment=" + comment +
                ", user=" + user +
                ", reactionId='" + reactionId + '\'' +
                '}';
    }
}
