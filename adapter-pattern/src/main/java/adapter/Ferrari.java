package main.java.adapter;

public class Ferrari {
    private BasePackage basePackage;

    public Ferrari() { }

    public Ferrari(BasePackage basePackage) {
        this.basePackage = basePackage;
    }

    public int horsePower() {
        return basePackage.horsePower();
    }
}
