public enum Gender {
    MALE("m"),
    FEMALE("f");

    private final String xpathValue;

    Gender(String xpathValue) {
        this.xpathValue = xpathValue;
    }

    public String getXpathValue() {
        return xpathValue;
    }
}