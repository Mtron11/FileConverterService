package XML;

public class Monster {
    private String name;
    private String habitat;
    private Characteristics characteristics;

    public Monster(String name, String habitat, Characteristics characteristics) {
        this.name = name;
        this.habitat = habitat;
        this.characteristics = characteristics;
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
}
