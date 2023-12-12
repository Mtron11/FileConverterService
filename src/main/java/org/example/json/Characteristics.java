package org.example.json;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Characteristics {
    private String strength;
    private String agility;
    private String resistance;
    private List<String> weaknesses;
}
