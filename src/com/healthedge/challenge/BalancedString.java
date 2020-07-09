package com.healthedge.challenge;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// Java program to determine
// whether given expression
// is balanced/ parenthesis
// expression or not.
public class BalancedString {

    private static final char L_BRACKET = '[';
    private static final char R_BRACKET = ']';
    private static final char JOKER = '$';
    private static final int CONSTANT_ONE = 1;
    private static final int CONSTANT_ZERO = 0;
    private static boolean isPrevJoker = false;

    // Function to check if two
    // brackets are matching or not.

    static int isMatching(char a,
                          char b) {
        if ((a == L_BRACKET && b == R_BRACKET)
                || a == JOKER) {
            return CONSTANT_ONE;
        }
        return CONSTANT_ZERO;
    }

    // Recursive function to
    // check if given expression
    // is balanced or not.
    public static int isBalanced(String s,
                                 Deque<Character> element,
                                 int index) {

        // if the deque is empty, string is balanced
        if (index == s.length()) {
            if (element.size() == CONSTANT_ZERO) {
                return CONSTANT_ONE;
            } else {
                return CONSTANT_ZERO;
            }
        }

        char top;
        int result;

        // If the current element is opening bracket,
        // push it to the deque
        if (s.charAt(index) == L_BRACKET) {
            isPrevJoker = false;
            element.push(s.charAt(index));
            return isBalanced(s, element, index + 1);
        }

        // If the current element is closing bracket,
        // look for the match at the top of the deque
        else if (s.charAt(index) == R_BRACKET) {
            if(isPrevJoker){
                if(!element.isEmpty())
                    element.pop();

                element.push(L_BRACKET);
                isPrevJoker = false;

                return CONSTANT_ONE;
            }
            // String is not balanced when there is no matching bracket in deque
            if (element.size() == CONSTANT_ZERO) {
                return CONSTANT_ZERO;
            }
            top = element.peek();
            element.pop();

            if (isMatching(top, s.charAt(index)) == CONSTANT_ZERO) {
                return CONSTANT_ZERO;
            }
            return isBalanced(s, element, index + 1);
        }

        // If the current element is a JOKER, identify the form of the JOKER [ or ]
        else if (s.charAt(index) == JOKER) {
            isPrevJoker = true;
            Deque<Character> temp = new LinkedList<>(element);
            temp.push(s.charAt(index));

            result = isBalanced(s, temp, index + 1);
            if (result == CONSTANT_ONE) {
                return CONSTANT_ONE;
            }else{
                if(!element.isEmpty())
                    element.pop();
            }

            if(!element.isEmpty())
                element.pop();
            return isBalanced(s, element, index + 1);
        }
        return CONSTANT_ONE;
    }

}
