package project.redis.domain.screening;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Screenings {
    private List<Screening> screenings = new ArrayList<>();
}
