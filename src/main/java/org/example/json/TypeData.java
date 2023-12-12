package org.example.json;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TypeData {
    private String type;
    private List<Monster> monsters;

    public TypeData(final String type) {
        this.type = type;
        this.monsters = new ArrayList<>();
    }
}
