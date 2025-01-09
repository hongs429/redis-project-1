package project.redis.presentation.movie.controller;


import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.redis.application.movie.dto.MovieResponse;
import project.redis.application.movie.port.inbound.MovieQueryUseCase;


@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    public final MovieQueryUseCase movieQueryUseCase;

    @GetMapping
    public ResponseEntity<List<MovieResponse>> getMovie() {
        return ResponseEntity.ok(movieQueryUseCase.getMovies());
    }
}
