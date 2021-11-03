package fr.uge.poo.ducks;

import java.util.ServiceLoader;

public class DuckFarmBetter {

    public static void main(String[] args) {
        ServiceLoader<DuckFactory> loader = ServiceLoader.load(fr.uge.poo.ducks.DuckFactory.class);
        for(DuckFactory duck : loader) {
            System.out.println(duck.withName("Fifi").quack());
            System.out.println(duck.withName("Riri").quack());
            System.out.println(duck.withName("Loulou").quack());
        }
    }

}
