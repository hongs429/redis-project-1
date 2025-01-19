package project.redis.application.screening.port.outbound;

import java.util.List;
import project.redis.domain.screening.Screening;
import project.redis.domain.screening.Screenings;

public interface ScreeningQueryPort {

    List<Screening> getScreenings(ScreeningQueryFilter filter);

    Screenings getScreeningsRedis(ScreeningQueryFilter filter);

//    List<Screening> getScreeningsLocalCache(ScreeningQueryFilter filter);
}
