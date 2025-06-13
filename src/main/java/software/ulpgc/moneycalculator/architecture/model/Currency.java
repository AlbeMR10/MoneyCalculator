package software.ulpgc.moneycalculator.architecture.model;

public record Currency(String code, String name) {

    @Override
    public String toString() {
        return name + " : (" + code + ")";
    }
}
