package Section12;

import java.util.HashSet;
import java.util.Set;

public class MainSet {

    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        System.out.println("Squares size: "+ squares.size() + " cubes size: " + cubes.size());

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union size: " + union.size());

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersection contains");
    }
//    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
//    private static Set<HeavenlyBody> planets = new HashSet<>();
//
//    public static void main(String[] args) {
//        HeavenlyBody temp = new HeavenlyBody("Mercury", 80);
//        solarSystem.put(temp.getName(), temp);
//        planets.add(temp);
//
//        temp = new HeavenlyBody("Venus", 225);
//        solarSystem.put(temp.getName(), temp);
//        planets.add(temp);
//
//        temp = new HeavenlyBody("Earth", 365);
//        solarSystem.put(temp.getName(), temp);
//        planets.add(temp);
//
//        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
//        solarSystem.put(tempMoon.getName(), tempMoon);
//        temp.addMoon(tempMoon);
//
//        System.out.println("Planets");
//        for (HeavenlyBody planet : planets) {
//            System.out.println("\t" + planet.getName());
//        }
//
//        HeavenlyBody body = solarSystem.get("Earth");
//        System.out.println("Moons of " + body.getName());
//        for (HeavenlyBody moon : body.getSatellites()) {
//            System.out.println("\t" + moon.getName());
//        }
//
//        Set<HeavenlyBody> moons = new HashSet<>();
//        for (HeavenlyBody planet : planets) {
//            moons.addAll(planet.getSatellites());
//        }
//        System.out.println("All Moons");
//        for (HeavenlyBody moon : moons) {
//            System.out.println("\t" + moon.getName());
//        }
//    }
}
