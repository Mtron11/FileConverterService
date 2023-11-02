package XML;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Monster {
    private String name;
    private String habitat;
    @JsonIgnore
    private String type;
    private Characteristics characteristics;

    public Monster(String name, String habitat,String type, Characteristics characteristics) {
        this.name = name;
        this.habitat = habitat;
        this.characteristics = characteristics;
        this.type=type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public Characteristics getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Characteristics characteristics) {
        this.characteristics = characteristics;
    }

    public String getType() { return type;}

    public void setType(String type){this.type = type;}



}
