package main.java.adapter;

public class PackageUpgradeAdapter implements BasePackage {

    private SportsPackage sportsPackage = new SportsPackage();

    public PackageUpgradeAdapter() {
        sportsPackage = new SportsPackage();
    }

    @Override
    public int horsePower() {
        return sportsPackage.torque() * 4;
    }
}
