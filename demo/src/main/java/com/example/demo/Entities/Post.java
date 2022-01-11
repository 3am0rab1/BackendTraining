package com.example.demo.Entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "post_table")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;
    @Column(nullable = false)
    private String postTitle;
    @Column(nullable = false)
    private String postContent;
    @Column(nullable = false)
    private Long postNumOfReactions;

    @ManyToOne(optional = false)
    @JoinColumn(name = "username", nullable = false)
    private User postUser;

    @OneToMany(mappedBy = "commentPost", cascade = CascadeType.ALL)
    private Set<Comment> postComment = new LinkedHashSet<>();

    @OneToMany(mappedBy = "replyPost", cascade = CascadeType.ALL)
    private Set<Reply> postReplies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set <PostReaction> postReactions = new LinkedHashSet<>();

    public Post() {
    }

    public Post(Long postId, String postTitle, String postContent, Long postNumOfReactions, User postUser, Set<Comment> postComment) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postNumOfReactions = postNumOfReactions;
        this.postUser = postUser;
        this.postComment = postComment;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Long getPostNumOfReactions() {
        return postNumOfReactions;
    }

    public void setPostNumOfReactions(Long postNumOfReactions) {
        this.postNumOfReactions = postNumOfReactions;
    }

    public User getPostUser() {
        return postUser;
    }

    public void setPostUser(User postUser) {
        this.postUser = postUser;
    }

    public Set<Comment> getPostComment() {
        return postComment;
    }

    public void setPostComment(Set<Comment> postComment) {
        this.postComment = postComment;
    }

    public Set<Reply> getPostReplies() {
        return postReplies;
    }

    public void setPostReplies(Set<Reply> postReplies) {
        this.postReplies = postReplies;
    }

    public Set<PostReaction> getPostReactions() {
        return postReactions;
    }

    public void setPostReactions(Set<PostReaction> postReactions) {
        this.postReactions = postReactions;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                ", postNumOfReactions=" + postNumOfReactions +
                ", postUser=" + postUser +
                ", postComment=" + postComment +
                '}';
    }
}
