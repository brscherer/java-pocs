package com.github.diegopacheco.java.code.elegant;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FilterApp {
    public static void main(String[] args) {
        System.out.println("Toll price: for a \"\" = " + simulateTollPrice(""));
        System.out.println("Toll price: for a null = " + simulateTollPrice(null));
        System.out.println("Toll price: for a car = " + simulateTollPrice("car"));
        System.out.println("Toll price: for a motorhome = " + simulateTollPrice("motorhome"));
        System.out.println("Toll price: for a truck = " + simulateTollPrice("truck"));
    }
    private static double simulateTollPrice(String type){

        final Predicate<String> isCar = s -> "car".equals(s);
        final Predicate<String> isMotorhome = s -> "motorhome".equals(s);
        final Predicate<String> isTruck = s -> "truck".equals(s);

        Supplier<Double> carPrice = () -> 6.35;
        Supplier<Double> motorhomePrice = () -> 8.72d;
        Supplier<Double> truckPrice = () -> 12.98d;
        Supplier<Double> defaultPrice = () -> 4.31d;
        Supplier<Double> zeroPrice = () -> 0.0d;

        Function<String,Supplier<Double>> carFunction = (s) -> isCar.test(s) ? carPrice : zeroPrice;
        Function<String,Supplier<Double>> motorhomeFunction = (s) -> isMotorhome.test(s) ? motorhomePrice : zeroPrice;
        Function<String,Supplier<Double>> truckFunction = (s) -> isTruck.test(s) ? truckPrice : zeroPrice;

        double result = carFunction.apply(type).get() + motorhomeFunction.apply(type).get() + truckFunction.apply(type).get();
        return  0d==result ? defaultPrice.get() : result;
    }

}
