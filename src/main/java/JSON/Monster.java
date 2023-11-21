package JSON;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monster {
    private String name;
    private String habitat;
    private Characteristics characteristics;
}
