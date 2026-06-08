package com.madhushree;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Java version: " + System.getProperty("java.version"));

        // Java 16+ feature: record
        record Point(int x, int y) {}
        var p = new Point(3, 4);
        System.out.println(p);

        // Java 21 feature: pattern matching for switch
        Object obj = 42;
        String result = switch (obj) {
            case Integer i -> "Int: " + i;
            case String s -> "String: " + s;
            default -> "Other";
        };
        System.out.println(result);
    }
}