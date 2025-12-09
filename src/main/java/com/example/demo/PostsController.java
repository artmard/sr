package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
public class PostsController {
    private final List<Post> posts = new ArrayList<>();

    // curl -X POST http://localhost:5050/post/onlyTitle -d "Prodam garag"
    @PostMapping("/post/onlyTitle")
    public ResponseEntity<Integer> createPost(@RequestBody String title) {
        Post post=new Post(title);
        post.setId(posts.size() - 1);
        posts.add(post);
        return ResponseEntity.ok(posts.size() - 1);
    }

    //    curl -X POST localhost:5050/post -H "Content-type:application/json" -d "{\"title\" : \"Prodam garag\", \"price\" : \"1000000\", \"author\" : \"dada Vasia\", \"message\" : \"garag ochen krutoi\" }
    @PostMapping("/post")
    public ResponseEntity<Integer> createPostWithParameters(@RequestBody Post post) {
        post.setCreateAt(LocalDateTime.now());
        post.setId(posts.size() - 1);
        posts.add(post);
        return ResponseEntity.ok(posts.size() - 1);
    }

    // curl -X GET http://localhost:5050/posts
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getThemes() {
        return ResponseEntity.ok(posts);
    }

    // curl -X GET http://localhost:5050/post/0
    @GetMapping("/post/{id}")
    public ResponseEntity<Post> getPost(@PathVariable int id) {
        if (id < 0 || id > posts.size() - 1) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(posts.get(id));
    }

    // curl -X PUT http://localhost:5050/post/onlyTitle/0 -d "Prodam krutoi garag"
    @PutMapping("/post/onlyTitle/{id}")
    public ResponseEntity<Void> updatePost(@PathVariable String newName, @PathVariable int id) {
        if (id < 0 || id > posts.size() - 1) {
            return ResponseEntity.notFound().build();
        }
        Post post=new Post(newName);
        post.setUpdateAt(LocalDateTime.now());
        posts.set(id, post);
        return ResponseEntity.ok().build();
    }

    //    curl -X PUT localhost:5050/post/0 -H "Content-type:application/json" -d "{\"title\" : \"Prodam garag srochno\", \"price\" : \"500000\", \"message\" : \"garag ochen krutoi, chesno-chesno\" }
    @PutMapping("/post/{id}")
    public ResponseEntity<Integer> updatePostWithParameters(@RequestBody Post post,
                                                            @PathVariable int id) {
        post.setUpdateAt(LocalDateTime.now());
        posts.get(id).setTitle(post.getTitle());
        posts.get(id).setPrice(post.getPrice());
        posts.get(id).setMessage(post.getMessage());
        return ResponseEntity.ok(posts.size() - 1);
    }

    // curl -X DELETE http://localhost:5050/post/0
    @DeleteMapping("/post/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable int id) {
        if (id < 0 || id > posts.size() - 1) {
            return ResponseEntity.notFound().build();
        }
        posts.remove(id);
        return ResponseEntity.ok().build();
    }

    // curl -X DELETE http://localhost:5050/deleteAll
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll() {
        posts.clear();
        return ResponseEntity.ok("TOTAL ELIMINATION CAME");
    }

    // curl -X GET http://localhost:5050/postsCount
    @GetMapping("/postsCount")
    public ResponseEntity<Integer> postCount() {
        return ResponseEntity.ok(posts.size());
    }

    // curl -X GET http://localhost:5050/posts/"dadaVasia"
    @GetMapping("/posts/{username}")
    public ResponseEntity<List<Post>> returnPostsByUsername(@PathVariable String username) {
        List<Post> postsByUsername = new ArrayList<>();
        for (Post post : posts) {
            if (post.getAuthor().equals(username)) {
                postsByUsername.add(post);
            }
        }
        return ResponseEntity.ok(postsByUsername);
    }


}