package project.redis.application.domain;


import java.time.LocalDate;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Movie {
    UUID movieId;
    String title;
    RatingClassification rating;
    LocalDate releaseDate;
    String thumbnailUrl;
    int runningTime;
    UUID genreId;

    public static Movie generateMovie(
            UUID id, String title,
            RatingClassification rating, LocalDate releaseDate,
            String thumbnailUrl, int runningTime, UUID genreId
    ) {
        return new Movie(id, title, rating, releaseDate, thumbnailUrl, runningTime, genreId);
    }
}
