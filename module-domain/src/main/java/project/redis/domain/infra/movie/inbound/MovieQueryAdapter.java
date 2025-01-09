//package project.redis.infrastructure.movie.inbound;
//
//import java.util.List;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import project.redis.application.movie.port.outbound.MovieQueryPort;
//import project.redis.domain.movie.entity.Movie;
//import project.redis.infrastructure.movie.repository.MovieJpaRepository;
//
//@Component
//@RequiredArgsConstructor
//public class MovieQueryAdapter implements MovieQueryPort {
//
//    private final MovieJpaRepository movieJpaRepository;
//
//    @Override
//    public List<Movie> getMovies() {
//        return List.of();
//    }
//}
