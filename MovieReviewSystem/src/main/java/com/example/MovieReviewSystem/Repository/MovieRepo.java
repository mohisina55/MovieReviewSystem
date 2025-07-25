package com.example.MovieReviewSystem.Repository;


import com.example.MovieReviewSystem.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie, Long> {
}

