package com.gurshobit.questiontwo;

import java.util.ArrayList;
import java.util.Scanner;

public class FindPairSum {
    Node treeRoot;
    private final ArrayList<Integer> listOne = new ArrayList<>();

    FindPairSum(){
        treeRoot = null;
    }

    void insertTreeBranch(int data)
    {
        treeRoot = insertBranchNode(treeRoot, data);
    }

    Node insertBranchNode(Node root, int data)
    {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertBranchNode(root.left, data);
        else if (data > root.data)
            root.right = insertBranchNode(root.right, data);

        return root;
    }

    ArrayList<Integer> convertToList(Node treeNode , ArrayList<Integer> arrayList){
        if(treeNode == null){
            return arrayList;
        }
        convertToList(treeNode.left,arrayList);
        arrayList.add(treeNode.data);
        convertToList(treeNode.right,arrayList);
        return arrayList;
    }

    boolean isPairOccurs(int sum){
        ArrayList<Integer> listTwo = convertToList(treeRoot, listOne);
        int startPointer = 0;
        int endPointer = listTwo.size() - 1;
        while(startPointer < endPointer){
            int elementOne = listTwo.get(startPointer);
            int elementTwo = listTwo.get(endPointer);

            if( elementOne + elementTwo  == sum){
                System.out.println("Pair ("+elementOne+","+elementTwo+") has sum of "+sum);
                return true;
            }

            if (elementOne + elementTwo < sum) {
                startPointer++;
            }

            if (elementOne + elementTwo > sum) {
                endPointer --;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        Scanner scannerInput = new Scanner(System.in);
        FindPairSum findPairSum = new FindPairSum();

        findPairSum.insertTreeBranch(40);
        findPairSum.insertTreeBranch(20);
        findPairSum.insertTreeBranch(10);
        findPairSum.insertTreeBranch(30);
        findPairSum.insertTreeBranch(60);
        findPairSum.insertTreeBranch(50);
        findPairSum.insertTreeBranch(70);

        int testCases = 0;
        do{
            System.out.println("Enter number of Test Cases");
            testCases = Integer.parseInt(scannerInput.nextLine());
        } while(testCases == 0);
        int testCasesCounter = testCases;
        int[] testCasesArray = new int[testCasesCounter];

        for(int j = 0; j < testCasesCounter; j++){
            System.out.println("Enter Test Case ("+(j+1)+"):");
            testCasesArray[j] = Integer.parseInt(scannerInput.nextLine());
        }

        for(int k = 0; k < testCasesArray.length; k++) {
            System.out.println("Test Case ("+(k+1)+"): SUM("+testCasesArray[k]+")");
            if(findPairSum.isPairOccurs(testCasesArray[k])){
                System.out.println("Pair Found Successfully");
            } else {
                System.out.println("Pair Not Found having sum " + testCasesArray[k]);
            }
            System.out.println();
        }
    }

}
