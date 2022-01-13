package com.example.demo.Controllers;

import com.example.demo.Entities.CommentReaction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommentReactionController {

    private final CommentReactionService commentreactionServices;


    @GetMapping("/commentreactions")
    List<CommentReaction> getCommentReaction() {
        return commentreactionServices.findAll();
    }

    @PostMapping("/commentreactions")
    CommentReaction newCommentReaction(@RequestBody CommentReaction newCommentReaction) {
        return commentreactionServices.save(newCommentReaction);
    }


    @GetMapping("/commentreactions/{commentreactionId}")
    CommentReaction getCommentReaction(@PathVariable String commentreactionId) {

        return commentreactionServices.findByCommentReactionId(commentreactionId)
                .orElseThrow(() -> new CommentReactionNotFoundException(commentreactionId));
    }

    @PutMapping("/commentreactions/{commentreactionId}")
    CommentReaction replaceCommentReaction(@RequestBody CommentReaction newCommentReaction, @PathVariable String commentreactionId) {

        return commentreactionServices.findByCommentReactionId(commentreactionId)
                .map(commentreaction -> {
                    return commentreactionServices.save(commentreaction);
                })
                .orElseGet(() -> {
                    newCommentReaction.setCommentReactionId(commentreactionId);
                    return commentreactionServices.save(newCommentReaction);
                });
    }

    @DeleteMapping("/commentreactions/{commentreactionId}")
    void deleteCommentReaction(@PathVariable String commentreactionId) {
    }

}
