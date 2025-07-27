package com.example.MovieReviewSystem.Controller;

import com.example.MovieReviewSystem.Service.LikeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/review/{id}")
    public ResponseEntity<String> likeReview(@PathVariable Long id, HttpServletRequest request) {
        likeService.likeReview(id, request);
        return ResponseEntity.ok("Review liked");
    }

    @DeleteMapping("/review/{id}")
    public ResponseEntity<String> unlikeReview(@PathVariable Long id, HttpServletRequest request) {
        likeService.unlikeReview(id, request);
        return ResponseEntity.ok("Review unliked");
    }
    @GetMapping("/review/{id}/count")
    public long countLikes(@PathVariable Long id) {
        return likeService.countLikes(id);
    }
}
