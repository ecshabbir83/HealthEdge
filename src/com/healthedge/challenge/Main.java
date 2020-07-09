package com.healthedge.challenge;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        Deque<Character> elements = new LinkedList<>();

        if (BalancedString.isBalanced(s, elements, 0) != 0) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }
}
