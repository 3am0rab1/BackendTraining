package com.example.demo.Controllers;

import com.example.demo.Entities.Reply;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ReplyController {

    private final ReplyService replyServices;


    @GetMapping("/replies")
    List <Reply> getReply() {
        return replyServices.findAll();
    }

    @PostMapping("/replies")
    Reply newReply(@RequestBody Reply newReply) {
        return replyServices.save(newReply);
    }


    @GetMapping("/replies/{replyId}")
    Reply getReply(@PathVariable Long replyId) {

        return replyServices.findByReplyId(replyId)
                .orElseThrow(() -> new ReplyNotFoundException(replyId));
    }

    @PutMapping("/replies/{replyId}")
    Reply replaceReply(@RequestBody Reply newReply, @PathVariable Long replyId) {

        return replyServices.findByReplyId(replyId)
                .map(reply -> {
                    return replyServices.save(reply);
                })
                .orElseGet(() -> {
                    newReply.setReplyId(replyId);
                    return replyServices.save(newReply);
                });
    }

    @DeleteMapping("/replies/{replyId}")
    void deleteReply(@PathVariable Long replyId) {
    }

}
