//package project.redis.infrastructure.genre.entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import java.util.UUID;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import project.redis.infrastructure.common.BaseJpaEntity;
//
//
//@Entity
//@Builder
//@Table(name = "movie")
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//public class GenreJpaEntity extends BaseJpaEntity {
//    @Id
//    @GeneratedValue(generator = "uuid")
//    @Column(name = "genre_id", columnDefinition = "BINARY(16)")
//    private UUID id;
//
//    @Column(nullable = false)
//    private String name;
//}
