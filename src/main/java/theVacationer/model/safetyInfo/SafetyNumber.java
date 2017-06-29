package theVacationer.model.safetyInfo;

/**
 * Created by Alexander Dmitryukov on 6/29/2017.
 */
public class SafetyNumber {
    String number;
    String description;

    public SafetyNumber(String number, String description) {
        this.number = number;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
