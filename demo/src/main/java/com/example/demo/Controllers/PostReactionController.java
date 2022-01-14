package com.example.demo.Controllers;

import com.example.demo.Entities.PostReaction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/postreactions")
public class PostReactionController {

    private final PostReactionService postreactionServices;


    @GetMapping("/postreactions")
    List <PostReaction> getPostReaction() {
        return postreactionServices.findAll();
    }

    @PostMapping("/postreactions")
    PostReaction newPostReaction(@RequestBody PostReaction newPostReaction) {
        return postreactionServices.save(newPostReaction);
    }


    @GetMapping("/postreactions/{postreactionId}")
    PostReaction getPostReaction(@PathVariable String postreactionId) {

        return postreactionServices.findByPostReactionId(postreactionId)
                .orElseThrow(() -> new PostReactionNotFoundException(postreactionId));
    }

    @PutMapping("/postreactions/{postreactionId}")
    PostReaction replacePostReaction(@RequestBody PostReaction newPostReaction, @PathVariable String postreactionId) {

        return postreactionServices.findByPostReactionId(postreactionId)
                .map(postreaction -> {
                    return postreactionServices.save(postreaction);
                })
                .orElseGet(() -> {
                    newPostReaction.setPostReactionId(postreactionId);
                    return postreactionServices.save(newPostReaction);
                });
    }

    @DeleteMapping("/postreactions/{postreactionId}")
    void deletePostReaction(@PathVariable String postreactionId) {
    }
}
