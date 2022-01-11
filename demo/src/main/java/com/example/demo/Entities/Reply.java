package com.example.demo.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "reply_table")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long replyId;
    @Column(nullable = false)
    private String replyContent;
    @Column(nullable = false)
    private Long replyNoOfReactions;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "username", nullable = false)
    private User replyUser;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "replyPostId", nullable = false)
    private Post replyPost;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "replyCommentId", nullable = false)
    private Comment replyComment;

    @OneToMany(mappedBy = "reply", cascade = CascadeType.ALL)
    private Set <ReplyReaction> replyReaction = new java.util.LinkedHashSet<>();

    public Reply(){

    }

    public Reply(Long replyId, String replyContent, Long replyNoOfReactions, User replyUser, Post replyPost, Comment replyComment) {
        this.replyId = replyId;
        this.replyContent = replyContent;
        this.replyNoOfReactions = replyNoOfReactions;
        this.replyUser = replyUser;
        this.replyPost = replyPost;
        this.replyComment = replyComment;
    }

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Long getReplyNoOfReactions() {
        return replyNoOfReactions;
    }

    public void setReplyNoOfReactions(Long replyNoOfReactions) {
        this.replyNoOfReactions = replyNoOfReactions;
    }

    public User getReplyUser() {
        return replyUser;
    }

    public void setReplyUser(User replyUser) {
        this.replyUser = replyUser;
    }

    public Post getReplyPost() {
        return replyPost;
    }

    public void setReplyPost(Post replyPost) {
        this.replyPost = replyPost;
    }

    public Comment getReplyComment() {
        return replyComment;
    }

    public void setReplyComment(Comment replyComment) {
        this.replyComment = replyComment;
    }

    public Set<ReplyReaction> getReplyReaction() {
        return replyReaction;
    }

    public void setReplyReaction(Set<ReplyReaction> replyReaction) {
        this.replyReaction = replyReaction;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "replyId=" + replyId +
                ", replyContent='" + replyContent + '\'' +
                ", replyNoOfReactions=" + replyNoOfReactions +
                ", replyUser=" + replyUser +
                ", replyPost=" + replyPost +
                ", replyComment=" + replyComment +
                '}';
    }
}
