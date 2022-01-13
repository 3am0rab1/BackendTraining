package com.example.demo.Controllers;

import com.example.demo.Entities.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommentController {
    
    private final CommentService commentServices;


    @GetMapping("/comments")
    List <Comment> getComments() {
        return commentServices.findAll();
    }

    @PostMapping("/comments")
    Comment newComment(@RequestBody Comment newComment) {
        return commentServices.save(newComment);
    }


    @GetMapping("/comments/{commentId}")
    Comment getComment(@PathVariable Long commentId) {

        return commentServices.findByCommentId(commentId)
                .orElseThrow(() -> new CommentNotFoundException(commentId));
    }

    @PutMapping("/comments/{commentId}")
    Comment replaceComment(@RequestBody Comment newComment, @PathVariable Long commentId) {

        return commentServices.findByCommentId(commentId)
                .map(comment -> {
                    return commentServices.save(comment);
                })
                .orElseGet(() -> {
                    newComment.setCommentId(commentId);
                    return commentServices.save(newComment);
                });
    }

    @DeleteMapping("/comments/{commentId}")
    void deleteComment(@PathVariable Long commentId) {
    }

}
