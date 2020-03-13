package ru.ifmo.rain.lebedev.webim.practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    private static final int MAX_VALUE = 20000;

    private static void readAndCount(Scanner scanner, int[] count, int increment) {
        int buffer = -1;
        while (buffer != 0) {
            buffer = scanner.nextInt();
            count[buffer] += increment;
        }
    }

    public static void normalizeCount(int[] count) {
        for (int i = 0; i <= MAX_VALUE; i++) {
            if (count[i] < 0) {
                count[i] *= -1;
            }
        }
    }

    public static ArrayList<Integer> formList(int[] count) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= MAX_VALUE; i++) {
            while (count[i] > 0) {
                result.add(i);
                count[i]--;
            }
        }
        return result;
    }

    private static String outFormat(Integer i) {
        return String.format("%d ", i);
    }

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        int[] count = new int[MAX_VALUE + 1];

        readAndCount(scanner, count, 1);
        readAndCount(scanner, count, -1);

        normalizeCount(count);

        ArrayList<Integer> result = formList(count);

        if (result.isEmpty()) {
            System.out.println(0);
        } else {
            for (Integer i : result) {
                System.out.print(outFormat(i));
            }
        }
    }
}