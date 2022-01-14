package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/replyreactions")
public class ReplyReaction {
    private final ReplyReactionService replyreactionServices;


    @GetMapping("/replyreactions")
    List<ReplyReaction> getReplyReaction() {
        return replyreactionServices.findAll();
    }

    @PostMapping("/replyreactions")
    ReplyReaction newReplyReaction(@RequestBody ReplyReaction newReplyReaction) {
        return replyreactionServices.save(newReplyReaction);
    }


    @GetMapping("/replyreactions/{replyreactionId}")
    ReplyReaction getReplyReaction(@PathVariable String replyreactionId) {

        return replyreactionServices.findByReplyReactionId(replyreactionId)
                .orElseThrow(() -> new ReplyReactionNotFoundException(replyreactionId));
    }

    @PutMapping("/replyreactions/{replyreactionId}")
    ReplyReaction replaceReplyReaction(@RequestBody ReplyReaction newReplyReaction, @PathVariable String replyreactionId) {

        return replyreactionServices.findByReplyReactionId(replyreactionId)
                .map(replyreaction -> {
                    return replyreactionServices.save(replyreaction);
                })
                .orElseGet(() -> {
                    newReplyReaction.setReplyReactionId(replyreactionId);
                    return replyreactionServices.save(newReplyReaction);
                });
    }

    @DeleteMapping("/replyreactions/{replyreactionId}")
    void deleteReplyReaction(@PathVariable String replyreactionId) {
    }

}
