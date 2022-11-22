package car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

   private int regNumber;
   private Brand brand;
   private int price;
   private boolean isElectrical;
   private boolean isTaken;
}
