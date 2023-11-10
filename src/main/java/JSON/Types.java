package JSON;

import java.util.List;

public class Types {
    private List<JSON.TypeData> types;

    public Types(){

    }
    public Types(List<JSON.TypeData> types) {
        this.types = types;
    }
    public List<JSON.TypeData> getTypes() {
        return types;
    }
}
