package main.java.adapter;

public class App {

    public static void main(String... args){
        Ferrari ferrari = new Ferrari(new PackageUpgradeAdapter());

        System.out.println(ferrari.horsePower());
    }
}
