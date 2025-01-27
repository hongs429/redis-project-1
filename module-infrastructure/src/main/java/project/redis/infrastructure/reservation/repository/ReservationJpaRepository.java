package project.redis.infrastructure.reservation.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import project.redis.infrastructure.reservation.entity.ReservationJpaEntity;

public interface ReservationJpaRepository extends JpaRepository<ReservationJpaEntity, UUID> {

    @EntityGraph(attributePaths = {
            "screening",
            "screening.movie",
            "screening.movie.genre",
            "screening.cinema"
    })
    List<ReservationJpaEntity> findByUsernameAndScreeningId(String username, UUID screeningId);
}
