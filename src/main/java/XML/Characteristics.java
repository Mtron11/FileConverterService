package XML;

import java.util.List;

public class Characteristics {
    private String strength;
    private String agility;
    private String resistance;
    private List<String> weaknesses;

    public Characteristics() {
    }

    public Characteristics(String strength, String agility, String resistance, List<String> weaknesses) {
        this.strength = strength;
        this.agility = agility;
        this.resistance = resistance;
        this.weaknesses = weaknesses;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getAgility() {
        return agility;
    }

    public void setAgility(String agility) {
        this.agility = agility;
    }

    public String getResistance() {
        return resistance;
    }

    public void setResistance(String resistance) {
        this.resistance = resistance;
    }

    public List<String> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List<String> weaknesses) {
        this.weaknesses = weaknesses;
    }
}
