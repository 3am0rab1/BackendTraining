package com.example.demo.Entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "comment_table")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;
    @Column(nullable = false)
    private Long commentNoOfReactions;
    @Column(nullable = false)
    private String commentContent;

    @ManyToOne(optional = false)
    @JoinColumn(name = "username", nullable = false)
    private User commentUser;

    @ManyToOne(optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    private Post commentPost;


    @OneToMany(mappedBy = "replyComment", cascade = CascadeType.ALL)
    private Set<Reply> commentReplies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private Set <CommentReaction> commentReaction = new LinkedHashSet<>();

    public Comment(){

    }

    public Comment(Long commentId, Long commentNoOfReactions, String commentContent, User commentUser, Post commentPost) {
        this.commentId = commentId;
        this.commentNoOfReactions = commentNoOfReactions;
        this.commentContent = commentContent;
        this.commentUser = commentUser;
        this.commentPost = commentPost;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getCommentNoOfReactions() {
        return commentNoOfReactions;
    }

    public void setCommentNoOfReactions(Long commentNoOfReactions) {
        this.commentNoOfReactions = commentNoOfReactions;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public User getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(User commentUser) {
        this.commentUser = commentUser;
    }

    public Post getCommentPost() {
        return commentPost;
    }

    public void setCommentPost(Post commentPost) {
        this.commentPost = commentPost;
    }

    public void setCommentReplies(Set<Reply> commentReplies) {
        this.commentReplies = commentReplies;
    }

    public Set<Reply> getCommentReplies() {
        return commentReplies;
    }

    public Set<CommentReaction> getCommentReaction() {
        return commentReaction;
    }

    public void setCommentReaction(Set<CommentReaction> commentReaction) {
        this.commentReaction = commentReaction;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentNoOfReactions=" + commentNoOfReactions +
                ", commentContent='" + commentContent + '\'' +
                ", commentUser=" + commentUser +
                ", commentPost=" + commentPost +
                '}';
    }
}
