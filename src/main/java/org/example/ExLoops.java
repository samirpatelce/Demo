package org.example;

import java.util.ArrayList;

public class ExLoops {
    public static void main(String[] args) {
        double[] numbers = {12.5, 7.8, 3.6, 9.1, 5.4};
        System.out.println("First element: " + numbers[0]);
        System.out.println("Last element: " + numbers[numbers.length - 1]);

        System.out.println("Elements in reverse order:");
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.println(numbers[i]);
        }

        int totalElements = numbers.length;
        System.out.println("Total number of elements: " + totalElements);

        ArrayList<String> a = new ArrayList<String>();
        a.add("Sample");
        a.add("File");
        System.out.println(a.get(1));

        for (String val :a)
        {
            System.out.println(val);
        }
        System.out.println(a.contains("File"));
    }
}
