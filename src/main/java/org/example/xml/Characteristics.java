package org.example.xml;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Characteristics {
    private String strength;
    private String agility;
    private String resistance;
    private List<String> weaknesses;
}
