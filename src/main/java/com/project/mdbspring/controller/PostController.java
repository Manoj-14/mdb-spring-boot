package com.project.mdbspring.controller;

import com.project.mdbspring.model.Post;
import com.project.mdbspring.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepo;

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postRepo.findAll();
    }

    @PostMapping("/post")
    public ResponseEntity<?> addPost(@RequestBody Post post){
        postRepo.save(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> deletePost(@PathVariable String id){
        postRepo.deleteById(id);
        return new ResponseEntity<>(postRepo.findAll(),HttpStatus.OK);
    }

    @GetMapping("post/{id}")
    public ResponseEntity<?> getPost(@PathVariable String id){
        return new ResponseEntity<>(postRepo.findById(id),HttpStatus.OK);
    }

}
