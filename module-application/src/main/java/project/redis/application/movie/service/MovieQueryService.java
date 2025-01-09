package project.redis.application.movie.service;


import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.redis.application.movie.dto.MovieResponse;
import project.redis.application.movie.port.inbound.MovieQueryUseCase;

@Service
@RequiredArgsConstructor
public class MovieQueryService implements MovieQueryUseCase {

//    private final MovieQueryPort movieQueryPort;

    @Override
    public List<MovieResponse> getMovies() {
//        List<Movie> movies = movieQueryPort.getMovies();

        return List.of();
    }
}
