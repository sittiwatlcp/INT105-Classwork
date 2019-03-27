package int105.pseudoenum;

public abstract class PseudoEnum {

    private final String name;
    private final int ordinal;

    protected PseudoEnum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    public final String name() {
        return name;
    }

    public final int ordinal() {
        return ordinal;
    }

    @Override
    public String toString() {
        return name;
    }

    // a method cannot be both abstract and static at the same time
    // public abstract static PseudoEnum[] values();
    // public abstract static PseudoEnum valueOf(String name);
    
}
