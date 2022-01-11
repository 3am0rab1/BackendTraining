package com.example.demo.Entities;

import javax.persistence.*;

@Entity
@Table(name = "reply_react_table")
public class ReplyReaction {

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(nullable = false)
    private Reply reply;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(nullable = false)
    private User user;

    @Id
    @Lob
    @Column(nullable = false)
    private String reactionId=reply.getReplyId().toString()+user.getUsername();

    public ReplyReaction() {
    }

    public ReplyReaction(Reply reply, User user, String reactionId) {
        this.reply = reply;
        this.user = user;
        this.reactionId = reactionId;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
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
        return "ReplyReaction{" +
                "reply=" + reply +
                ", user=" + user +
                ", reactionId='" + reactionId + '\'' +
                '}';
    }
}
