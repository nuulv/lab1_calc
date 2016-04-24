package lab1_calc;


public enum Dzialania {
    DODAWANIE("+"),
    ODEJMOWANIE("-"),
    MNOZENIE("*"),
    DZIELENIE("/");

    private String value;

    Dzialania(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
