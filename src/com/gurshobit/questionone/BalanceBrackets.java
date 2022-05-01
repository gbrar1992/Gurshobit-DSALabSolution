package com.gurshobit.questionone;

import java.util.Scanner;
import java.util.Stack;

public class BalanceBrackets {

    public static boolean isStackBalanced(String inputString){
        Stack<Character> bracketStack = new Stack<>();

        if(inputString == null || inputString.toCharArray().length == 0 ){
            System.out.println("String is empty");
            return false;
        }

        if(inputString.contains("(") || inputString.contains(")") || inputString.contains("{") || inputString.contains("}") || inputString.contains("[") || inputString.contains("]")){
            char[] inputStringArray = inputString.toCharArray();
            for (int i = 0; i < inputStringArray.length; i++) {
                char poppedChar;
                switch (inputStringArray[i]) {
                    case '(':
                    case '{':
                    case '[':
                        bracketStack.push(inputStringArray[i]);
                        break;
                   case ')':
                        if (bracketStack.isEmpty()) {
                           return false;
                        }
                        poppedChar = bracketStack.pop();
                        if (poppedChar == '{' || poppedChar == '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if (bracketStack.isEmpty()) {
                            return false;
                        }
                        poppedChar = bracketStack.pop();
                        if (poppedChar == '(' || poppedChar == '[') {
                            return false;
                        }
                        break;
                    case ']':
                        if (bracketStack.isEmpty()) {
                            return false;
                        }
                        poppedChar = bracketStack.pop();
                        if (poppedChar == '(' || poppedChar == '{') {
                            return false;
                        }
                        break;
                    default:
                        System.out.println("Invalid Characters in string");
                        return false;
                }
            }
        } else {
            System.out.println("Invalid String");
            return false;
        }

        return (bracketStack.isEmpty());
    }

    public static void main(String[] args) {
        Scanner scannerInput = new Scanner(System.in);

        int testCases = 0;

        do{
            System.out.println("Enter number of Test Cases");
            testCases = Integer.parseInt(scannerInput.nextLine());
        } while(testCases == 0);
        int testCasesCounter = testCases;
        String[] testCasesArray = new String[testCasesCounter];

        for(int j = 0; j < testCasesCounter; j++){
            System.out.println("Enter Test Case ("+(j+1)+"):");
            testCasesArray[j] = scannerInput.nextLine();
        }

        for(int k = 0; k < testCasesArray.length; k++) {
            System.out.println("Test Case ("+(k+1)+"): STRING - "+testCasesArray[k]);
            if(isStackBalanced(testCasesArray[k])){
                System.out.println("The entered String has Balanced Brackets");

            } else {
                System.out.println("The entered String do not contain Balanced Brackets");
            }
            System.out.println();
        }
    }
}
