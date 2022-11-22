package booking;

import car.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import user.User;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    private UUID id;
    private LocalDateTime localDateTime;
    private Car car;
    private User user;

}
