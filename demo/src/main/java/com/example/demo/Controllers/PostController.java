package com.example.demo.Controllers;

import com.example.demo.Entities.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
public class PostController {

    private final PostService postServices;


    @GetMapping("/posts")
    List<Post> getPost() {
        return postServices.findAll();
    }

    @PostMapping("/posts")
    Post newPost(@RequestBody Post newPost) {
        return psotServices.save(newPost);
    }


    @GetMapping("/posts/{postId}")
    Post getPost(@PathVariable Long postId) {

        return psotServices.findByPostId(postId)
                .orElseThrow(() -> new PostNotFoundException(postId));
    }

    @PutMapping("/posts/{postId}")
    Post replacePost(@RequestBody Post newPost, @PathVariable Long postId) {

        return postServices.findByReplyId(postId)
                .map(post -> {
                    return postServices.save(post);
                })
                .orElseGet(() -> {
                    newPost.setPostId(postId);
                    return postServices.save(newPost);
                });
    }

    @DeleteMapping("/posts/{postId}")
    void deleteReply(@PathVariable Long postId) {
    }

}
