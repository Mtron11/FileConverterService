package XML;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monster {
    private String name;

    @JsonIgnore
    private String type;

    private String habitat;
    private Characteristics characteristics;
}
