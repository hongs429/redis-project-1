//package project.redis.infrastructure.movie.entity;
//
//
//import static jakarta.persistence.EnumType.STRING;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import java.time.LocalDate;
//import java.util.UUID;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import project.redis.domain.movie.entity.RatingClassification;
//import project.redis.infrastructure.common.BaseJpaEntity;
//
//@Entity
//@Builder
//@Table(name = "movie")
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//public class MovieJpaEntity extends BaseJpaEntity {
//
//    @Id
//    @GeneratedValue(generator = "uuid")
//    @Column(name = "movie_id", columnDefinition = "BINARY(16)")
//    private UUID id;
//
//    @Column(nullable = false)
//    private String title;
//
//    @Column(nullable = false)
//    @Enumerated(value = STRING)
//    private RatingClassification rating;
//
//    @Column(nullable = false)
//    private LocalDate releaseDate;
//
//    @Column(columnDefinition = "TEXT")
//    private String thumbnailUrl;
//
//    @Column(nullable = false)
//    private int runningMinTime;
//}
