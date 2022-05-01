package com.gurshobit.questionone;

import java.util.Scanner;
import java.util.Stack;

public class BalanceBrackets {
    public static Stack<Character> bracketStack = new Stack<>();

    public static boolean isStackBalanced(String inputString){

        if(inputString == null || inputString.toCharArray().length == 0 ){
            System.out.println("String is empty");
            return false;
        }

        if(inputString.contains("(") || inputString.contains(")") || inputString.contains("{") || inputString.contains("}") || inputString.contains("[") || inputString.contains("]")){
            char[] inputStringArray = inputString.toCharArray();
            for (char c : inputStringArray) {
                switch (c) {
                    case '(':
                    case '{':
                    case '[':
                        bracketStack.push(c);
                        break;
                    case ')':
                        if (!bracketStack.isEmpty()) {
                            if (bracketStack.peek() == '(') {
                                bracketStack.pop();
                            }
                        }
                        break;
                    case '}':
                        if (!bracketStack.isEmpty()) {
                            if (bracketStack.peek() == '{') {
                                bracketStack.pop();
                            }
                        }
                        break;
                    case ']':
                        if (!bracketStack.isEmpty()) {
                            if (bracketStack.peek() == '[') {
                                bracketStack.pop();
                            }
                        }
                        break;
                    default:
                        System.out.println("Invalid String");
                        return false;
                }
            }
        } else {
            System.out.println("Invalid String");
            return false;
        }

        return bracketStack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scannerInput = new Scanner(System.in);
        System.out.println("Enter Brackets String");
        String inputStringValue = scannerInput.nextLine();

        if(isStackBalanced(inputStringValue)){
            System.out.println("The entered String has Balanced Brackets");

        } else {
            System.out.println("The entered String do not contain Balanced Brackets");
        }
    }

}
