package org.example.inherit;

public class Child extends Parent {
    private String value = "Child";

    public static void main(String[] args) {
        String value = new Child().getValue();
        System.out.println(value);
    }
}
