package xml;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monster {
    private String name;
    @JsonIgnore
    private String type;

    private String habitat;
    private Characteristics characteristics;
}
