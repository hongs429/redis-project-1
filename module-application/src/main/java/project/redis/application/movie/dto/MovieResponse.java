package project.redis.application.movie.dto;


import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {

    private UUID movieId;
    private String title;
    private String rating;
    private LocalDate releaseDate;
    private String thumbnailUrl;
    private int runningTimeMin;
    private String genreName;

    public static MovieResponse of(
            UUID movieId, String title, String rating, LocalDate releaseDate,
            String thumbnailUrl, int runningTimeMin, String genreName) {
        return MovieResponse.builder()
                .movieId(movieId)
                .title(title)
                .rating(rating)
                .releaseDate(releaseDate)
                .thumbnailUrl(thumbnailUrl)
                .runningTimeMin(runningTimeMin)
                .genreName(genreName)
                .build();
    }
}
